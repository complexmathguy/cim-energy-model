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
 * Projector for ExcAVR4 as outlined for the CQRS pattern.  All event handling and query handling related to ExcAVR4 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAVR4Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAVR4")
@Component("excAVR4-projector")
public class ExcAVR4Projector extends ExcAVR4EntityProjector {
		
	// core constructor
	public ExcAVR4Projector(ExcAVR4Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAVR4Event
     */
    @EventHandler( payloadType=CreateExcAVR4Event.class )
    public void handle( CreateExcAVR4Event event) {
	    LOGGER.info("handling CreateExcAVR4Event - " + event );
	    ExcAVR4 entity = new ExcAVR4();
        entity.setExcAVR4Id( event.getExcAVR4Id() );
        entity.setImul( event.getImul() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKif( event.getKif() );
        entity.setT1( event.getT1() );
        entity.setT1if( event.getT1if() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTif( event.getTif() );
        entity.setVfmn( event.getVfmn() );
        entity.setVfmx( event.getVfmx() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR4( entity );
    }

    /*
     * @param	event UpdateExcAVR4Event
     */
    @EventHandler( payloadType=UpdateExcAVR4Event.class )
    public void handle( UpdateExcAVR4Event event) {
    	LOGGER.info("handling UpdateExcAVR4Event - " + event );
    	
	    ExcAVR4 entity = new ExcAVR4();
        entity.setExcAVR4Id( event.getExcAVR4Id() );
        entity.setImul( event.getImul() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKif( event.getKif() );
        entity.setT1( event.getT1() );
        entity.setT1if( event.getT1if() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTif( event.getTif() );
        entity.setVfmn( event.getVfmn() );
        entity.setVfmx( event.getVfmx() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAVR4( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR4( entity );        
    }
    
    /*
     * @param	event DeleteExcAVR4Event
     */
    @EventHandler( payloadType=DeleteExcAVR4Event.class )
    public void handle( DeleteExcAVR4Event event) {
    	LOGGER.info("handling DeleteExcAVR4Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAVR4 entity = delete( event.getExcAVR4Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR4( entity );

    }    




    /**
     * Method to retrieve the ExcAVR4 via an ExcAVR4PrimaryKey.
     * @param 	id Long
     * @return 	ExcAVR4
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAVR4 handle( FindExcAVR4Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAVR4Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR4s
     *
     * @param	query	FindAllExcAVR4Query 
     * @return 	List<ExcAVR4> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAVR4> handle( FindAllExcAVR4Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAVR4, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAVR4
	 */
	protected void emitFindExcAVR4( ExcAVR4 entity ) {
		LOGGER.info("handling emitFindExcAVR4" );
		
	    queryUpdateEmitter.emit(FindExcAVR4Query.class,
	                            query -> query.getFilter().getExcAVR4Id().equals(entity.getExcAVR4Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAVR4
	 * 
	 * @param		entity	ExcAVR4
	 */
	protected void emitFindAllExcAVR4( ExcAVR4 entity ) {
		LOGGER.info("handling emitFindAllExcAVR4" );
		
	    queryUpdateEmitter.emit(FindAllExcAVR4Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR4Projector.class.getName());

}
