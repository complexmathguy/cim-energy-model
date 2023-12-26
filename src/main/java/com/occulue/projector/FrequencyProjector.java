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
 * Projector for Frequency as outlined for the CQRS pattern.  All event handling and query handling related to Frequency are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by FrequencyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("frequency")
@Component("frequency-projector")
public class FrequencyProjector extends FrequencyEntityProjector {
		
	// core constructor
	public FrequencyProjector(FrequencyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateFrequencyEvent
     */
    @EventHandler( payloadType=CreateFrequencyEvent.class )
    public void handle( CreateFrequencyEvent event) {
	    LOGGER.info("handling CreateFrequencyEvent - " + event );
	    Frequency entity = new Frequency();
        entity.setFrequencyId( event.getFrequencyId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFrequency( entity );
    }

    /*
     * @param	event UpdateFrequencyEvent
     */
    @EventHandler( payloadType=UpdateFrequencyEvent.class )
    public void handle( UpdateFrequencyEvent event) {
    	LOGGER.info("handling UpdateFrequencyEvent - " + event );
    	
	    Frequency entity = new Frequency();
        entity.setFrequencyId( event.getFrequencyId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindFrequency( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFrequency( entity );        
    }
    
    /*
     * @param	event DeleteFrequencyEvent
     */
    @EventHandler( payloadType=DeleteFrequencyEvent.class )
    public void handle( DeleteFrequencyEvent event) {
    	LOGGER.info("handling DeleteFrequencyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Frequency entity = delete( event.getFrequencyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFrequency( entity );

    }    




    /**
     * Method to retrieve the Frequency via an FrequencyPrimaryKey.
     * @param 	id Long
     * @return 	Frequency
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Frequency handle( FindFrequencyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getFrequencyId() );
    }
    
    /**
     * Method to retrieve a collection of all Frequencys
     *
     * @param	query	FindAllFrequencyQuery 
     * @return 	List<Frequency> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Frequency> handle( FindAllFrequencyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindFrequency, 
	 * but only if the id matches
	 * 
	 * @param		entity	Frequency
	 */
	protected void emitFindFrequency( Frequency entity ) {
		LOGGER.info("handling emitFindFrequency" );
		
	    queryUpdateEmitter.emit(FindFrequencyQuery.class,
	                            query -> query.getFilter().getFrequencyId().equals(entity.getFrequencyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllFrequency
	 * 
	 * @param		entity	Frequency
	 */
	protected void emitFindAllFrequency( Frequency entity ) {
		LOGGER.info("handling emitFindAllFrequency" );
		
	    queryUpdateEmitter.emit(FindAllFrequencyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(FrequencyProjector.class.getName());

}
