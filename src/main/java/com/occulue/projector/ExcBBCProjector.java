/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.projector;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for ExcBBC as outlined for the CQRS pattern.  All event handling and query handling related to ExcBBC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcBBCAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excBBC")
@Component("excBBC-projector")
public class ExcBBCProjector extends ExcBBCEntityProjector {
		
	// core constructor
	public ExcBBCProjector(ExcBBCRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcBBCEvent
     */
    @EventHandler( payloadType=CreateExcBBCEvent.class )
    public void handle( CreateExcBBCEvent event) {
	    LOGGER.info("handling CreateExcBBCEvent - " + event );
	    ExcBBC entity = new ExcBBC();
        entity.setExcBBCId( event.getExcBBCId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setK( event.getK() );
        entity.setSwitchIt( event.getSwitchIt() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXe( event.getXe() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcBBC( entity );
    }

    /*
     * @param	event UpdateExcBBCEvent
     */
    @EventHandler( payloadType=UpdateExcBBCEvent.class )
    public void handle( UpdateExcBBCEvent event) {
    	LOGGER.info("handling UpdateExcBBCEvent - " + event );
    	
	    ExcBBC entity = new ExcBBC();
        entity.setExcBBCId( event.getExcBBCId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setK( event.getK() );
        entity.setSwitchIt( event.getSwitchIt() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXe( event.getXe() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcBBC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcBBC( entity );        
    }
    
    /*
     * @param	event DeleteExcBBCEvent
     */
    @EventHandler( payloadType=DeleteExcBBCEvent.class )
    public void handle( DeleteExcBBCEvent event) {
    	LOGGER.info("handling DeleteExcBBCEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcBBC entity = delete( event.getExcBBCId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcBBC( entity );

    }    




    /**
     * Method to retrieve the ExcBBC via an ExcBBCPrimaryKey.
     * @param 	id Long
     * @return 	ExcBBC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcBBC handle( FindExcBBCQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcBBCId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcBBCs
     *
     * @param	query	FindAllExcBBCQuery 
     * @return 	List<ExcBBC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcBBC> handle( FindAllExcBBCQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcBBC, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcBBC
	 */
	protected void emitFindExcBBC( ExcBBC entity ) {
		LOGGER.info("handling emitFindExcBBC" );
		
	    queryUpdateEmitter.emit(FindExcBBCQuery.class,
	                            query -> query.getFilter().getExcBBCId().equals(entity.getExcBBCId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcBBC
	 * 
	 * @param		entity	ExcBBC
	 */
	protected void emitFindAllExcBBC( ExcBBC entity ) {
		LOGGER.info("handling emitFindAllExcBBC" );
		
	    queryUpdateEmitter.emit(FindAllExcBBCQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcBBCProjector.class.getName());

}
