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
 * Projector for ExcAVR3 as outlined for the CQRS pattern.  All event handling and query handling related to ExcAVR3 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAVR3Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAVR3")
@Component("excAVR3-projector")
public class ExcAVR3Projector extends ExcAVR3EntityProjector {
		
	// core constructor
	public ExcAVR3Projector(ExcAVR3Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAVR3Event
     */
    @EventHandler( payloadType=CreateExcAVR3Event.class )
    public void handle( CreateExcAVR3Event event) {
	    LOGGER.info("handling CreateExcAVR3Event - " + event );
	    ExcAVR3 entity = new ExcAVR3();
        entity.setExcAVR3Id( event.getExcAVR3Id() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTe( event.getTe() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR3( entity );
    }

    /*
     * @param	event UpdateExcAVR3Event
     */
    @EventHandler( payloadType=UpdateExcAVR3Event.class )
    public void handle( UpdateExcAVR3Event event) {
    	LOGGER.info("handling UpdateExcAVR3Event - " + event );
    	
	    ExcAVR3 entity = new ExcAVR3();
        entity.setExcAVR3Id( event.getExcAVR3Id() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTe( event.getTe() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAVR3( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR3( entity );        
    }
    
    /*
     * @param	event DeleteExcAVR3Event
     */
    @EventHandler( payloadType=DeleteExcAVR3Event.class )
    public void handle( DeleteExcAVR3Event event) {
    	LOGGER.info("handling DeleteExcAVR3Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAVR3 entity = delete( event.getExcAVR3Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR3( entity );

    }    




    /**
     * Method to retrieve the ExcAVR3 via an ExcAVR3PrimaryKey.
     * @param 	id Long
     * @return 	ExcAVR3
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAVR3 handle( FindExcAVR3Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAVR3Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR3s
     *
     * @param	query	FindAllExcAVR3Query 
     * @return 	List<ExcAVR3> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAVR3> handle( FindAllExcAVR3Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAVR3, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAVR3
	 */
	protected void emitFindExcAVR3( ExcAVR3 entity ) {
		LOGGER.info("handling emitFindExcAVR3" );
		
	    queryUpdateEmitter.emit(FindExcAVR3Query.class,
	                            query -> query.getFilter().getExcAVR3Id().equals(entity.getExcAVR3Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAVR3
	 * 
	 * @param		entity	ExcAVR3
	 */
	protected void emitFindAllExcAVR3( ExcAVR3 entity ) {
		LOGGER.info("handling emitFindAllExcAVR3" );
		
	    queryUpdateEmitter.emit(FindAllExcAVR3Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR3Projector.class.getName());

}
