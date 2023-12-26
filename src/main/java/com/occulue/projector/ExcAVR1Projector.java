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
 * Projector for ExcAVR1 as outlined for the CQRS pattern.  All event handling and query handling related to ExcAVR1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAVR1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAVR1")
@Component("excAVR1-projector")
public class ExcAVR1Projector extends ExcAVR1EntityProjector {
		
	// core constructor
	public ExcAVR1Projector(ExcAVR1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAVR1Event
     */
    @EventHandler( payloadType=CreateExcAVR1Event.class )
    public void handle( CreateExcAVR1Event event) {
	    LOGGER.info("handling CreateExcAVR1Event - " + event );
	    ExcAVR1 entity = new ExcAVR1();
        entity.setExcAVR1Id( event.getExcAVR1Id() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setKf( event.getKf() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR1( entity );
    }

    /*
     * @param	event UpdateExcAVR1Event
     */
    @EventHandler( payloadType=UpdateExcAVR1Event.class )
    public void handle( UpdateExcAVR1Event event) {
    	LOGGER.info("handling UpdateExcAVR1Event - " + event );
    	
	    ExcAVR1 entity = new ExcAVR1();
        entity.setExcAVR1Id( event.getExcAVR1Id() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setKf( event.getKf() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAVR1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR1( entity );        
    }
    
    /*
     * @param	event DeleteExcAVR1Event
     */
    @EventHandler( payloadType=DeleteExcAVR1Event.class )
    public void handle( DeleteExcAVR1Event event) {
    	LOGGER.info("handling DeleteExcAVR1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAVR1 entity = delete( event.getExcAVR1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR1( entity );

    }    




    /**
     * Method to retrieve the ExcAVR1 via an ExcAVR1PrimaryKey.
     * @param 	id Long
     * @return 	ExcAVR1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAVR1 handle( FindExcAVR1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAVR1Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR1s
     *
     * @param	query	FindAllExcAVR1Query 
     * @return 	List<ExcAVR1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAVR1> handle( FindAllExcAVR1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAVR1, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAVR1
	 */
	protected void emitFindExcAVR1( ExcAVR1 entity ) {
		LOGGER.info("handling emitFindExcAVR1" );
		
	    queryUpdateEmitter.emit(FindExcAVR1Query.class,
	                            query -> query.getFilter().getExcAVR1Id().equals(entity.getExcAVR1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAVR1
	 * 
	 * @param		entity	ExcAVR1
	 */
	protected void emitFindAllExcAVR1( ExcAVR1 entity ) {
		LOGGER.info("handling emitFindAllExcAVR1" );
		
	    queryUpdateEmitter.emit(FindAllExcAVR1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR1Projector.class.getName());

}
