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
 * Projector for ExcAVR7 as outlined for the CQRS pattern.  All event handling and query handling related to ExcAVR7 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAVR7Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAVR7")
@Component("excAVR7-projector")
public class ExcAVR7Projector extends ExcAVR7EntityProjector {
		
	// core constructor
	public ExcAVR7Projector(ExcAVR7Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAVR7Event
     */
    @EventHandler( payloadType=CreateExcAVR7Event.class )
    public void handle( CreateExcAVR7Event event) {
	    LOGGER.info("handling CreateExcAVR7Event - " + event );
	    ExcAVR7 entity = new ExcAVR7();
        entity.setExcAVR7Id( event.getExcAVR7Id() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setA6( event.getA6() );
        entity.setK1( event.getK1() );
        entity.setK3( event.getK3() );
        entity.setK5( event.getK5() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setVmax1( event.getVmax1() );
        entity.setVmax3( event.getVmax3() );
        entity.setVmax5( event.getVmax5() );
        entity.setVmin1( event.getVmin1() );
        entity.setVmin3( event.getVmin3() );
        entity.setVmin5( event.getVmin5() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR7( entity );
    }

    /*
     * @param	event UpdateExcAVR7Event
     */
    @EventHandler( payloadType=UpdateExcAVR7Event.class )
    public void handle( UpdateExcAVR7Event event) {
    	LOGGER.info("handling UpdateExcAVR7Event - " + event );
    	
	    ExcAVR7 entity = new ExcAVR7();
        entity.setExcAVR7Id( event.getExcAVR7Id() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setA6( event.getA6() );
        entity.setK1( event.getK1() );
        entity.setK3( event.getK3() );
        entity.setK5( event.getK5() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setVmax1( event.getVmax1() );
        entity.setVmax3( event.getVmax3() );
        entity.setVmax5( event.getVmax5() );
        entity.setVmin1( event.getVmin1() );
        entity.setVmin3( event.getVmin3() );
        entity.setVmin5( event.getVmin5() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAVR7( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR7( entity );        
    }
    
    /*
     * @param	event DeleteExcAVR7Event
     */
    @EventHandler( payloadType=DeleteExcAVR7Event.class )
    public void handle( DeleteExcAVR7Event event) {
    	LOGGER.info("handling DeleteExcAVR7Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAVR7 entity = delete( event.getExcAVR7Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR7( entity );

    }    




    /**
     * Method to retrieve the ExcAVR7 via an ExcAVR7PrimaryKey.
     * @param 	id Long
     * @return 	ExcAVR7
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAVR7 handle( FindExcAVR7Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAVR7Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR7s
     *
     * @param	query	FindAllExcAVR7Query 
     * @return 	List<ExcAVR7> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAVR7> handle( FindAllExcAVR7Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAVR7, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAVR7
	 */
	protected void emitFindExcAVR7( ExcAVR7 entity ) {
		LOGGER.info("handling emitFindExcAVR7" );
		
	    queryUpdateEmitter.emit(FindExcAVR7Query.class,
	                            query -> query.getFilter().getExcAVR7Id().equals(entity.getExcAVR7Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAVR7
	 * 
	 * @param		entity	ExcAVR7
	 */
	protected void emitFindAllExcAVR7( ExcAVR7 entity ) {
		LOGGER.info("handling emitFindAllExcAVR7" );
		
	    queryUpdateEmitter.emit(FindAllExcAVR7Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR7Projector.class.getName());

}
