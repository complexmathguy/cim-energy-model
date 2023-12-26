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
 * Projector for GenICompensationForGenJ as outlined for the CQRS pattern.  All event handling and query handling related to GenICompensationForGenJ are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GenICompensationForGenJAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("genICompensationForGenJ")
@Component("genICompensationForGenJ-projector")
public class GenICompensationForGenJProjector extends GenICompensationForGenJEntityProjector {
		
	// core constructor
	public GenICompensationForGenJProjector(GenICompensationForGenJRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGenICompensationForGenJEvent
     */
    @EventHandler( payloadType=CreateGenICompensationForGenJEvent.class )
    public void handle( CreateGenICompensationForGenJEvent event) {
	    LOGGER.info("handling CreateGenICompensationForGenJEvent - " + event );
	    GenICompensationForGenJ entity = new GenICompensationForGenJ();
        entity.setGenICompensationForGenJId( event.getGenICompensationForGenJId() );
        entity.setRcij( event.getRcij() );
        entity.setXcij( event.getXcij() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGenICompensationForGenJ( entity );
    }

    /*
     * @param	event UpdateGenICompensationForGenJEvent
     */
    @EventHandler( payloadType=UpdateGenICompensationForGenJEvent.class )
    public void handle( UpdateGenICompensationForGenJEvent event) {
    	LOGGER.info("handling UpdateGenICompensationForGenJEvent - " + event );
    	
	    GenICompensationForGenJ entity = new GenICompensationForGenJ();
        entity.setGenICompensationForGenJId( event.getGenICompensationForGenJId() );
        entity.setRcij( event.getRcij() );
        entity.setXcij( event.getXcij() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGenICompensationForGenJ( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGenICompensationForGenJ( entity );        
    }
    
    /*
     * @param	event DeleteGenICompensationForGenJEvent
     */
    @EventHandler( payloadType=DeleteGenICompensationForGenJEvent.class )
    public void handle( DeleteGenICompensationForGenJEvent event) {
    	LOGGER.info("handling DeleteGenICompensationForGenJEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GenICompensationForGenJ entity = delete( event.getGenICompensationForGenJId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGenICompensationForGenJ( entity );

    }    




    /**
     * Method to retrieve the GenICompensationForGenJ via an GenICompensationForGenJPrimaryKey.
     * @param 	id Long
     * @return 	GenICompensationForGenJ
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GenICompensationForGenJ handle( FindGenICompensationForGenJQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGenICompensationForGenJId() );
    }
    
    /**
     * Method to retrieve a collection of all GenICompensationForGenJs
     *
     * @param	query	FindAllGenICompensationForGenJQuery 
     * @return 	List<GenICompensationForGenJ> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GenICompensationForGenJ> handle( FindAllGenICompensationForGenJQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGenICompensationForGenJ, 
	 * but only if the id matches
	 * 
	 * @param		entity	GenICompensationForGenJ
	 */
	protected void emitFindGenICompensationForGenJ( GenICompensationForGenJ entity ) {
		LOGGER.info("handling emitFindGenICompensationForGenJ" );
		
	    queryUpdateEmitter.emit(FindGenICompensationForGenJQuery.class,
	                            query -> query.getFilter().getGenICompensationForGenJId().equals(entity.getGenICompensationForGenJId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGenICompensationForGenJ
	 * 
	 * @param		entity	GenICompensationForGenJ
	 */
	protected void emitFindAllGenICompensationForGenJ( GenICompensationForGenJ entity ) {
		LOGGER.info("handling emitFindAllGenICompensationForGenJ" );
		
	    queryUpdateEmitter.emit(FindAllGenICompensationForGenJQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GenICompensationForGenJProjector.class.getName());

}
