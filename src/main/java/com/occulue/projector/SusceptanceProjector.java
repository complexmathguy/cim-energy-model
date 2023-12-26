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
 * Projector for Susceptance as outlined for the CQRS pattern.  All event handling and query handling related to Susceptance are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SusceptanceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("susceptance")
@Component("susceptance-projector")
public class SusceptanceProjector extends SusceptanceEntityProjector {
		
	// core constructor
	public SusceptanceProjector(SusceptanceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSusceptanceEvent
     */
    @EventHandler( payloadType=CreateSusceptanceEvent.class )
    public void handle( CreateSusceptanceEvent event) {
	    LOGGER.info("handling CreateSusceptanceEvent - " + event );
	    Susceptance entity = new Susceptance();
        entity.setSusceptanceId( event.getSusceptanceId() );
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
        emitFindAllSusceptance( entity );
    }

    /*
     * @param	event UpdateSusceptanceEvent
     */
    @EventHandler( payloadType=UpdateSusceptanceEvent.class )
    public void handle( UpdateSusceptanceEvent event) {
    	LOGGER.info("handling UpdateSusceptanceEvent - " + event );
    	
	    Susceptance entity = new Susceptance();
        entity.setSusceptanceId( event.getSusceptanceId() );
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
        emitFindSusceptance( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSusceptance( entity );        
    }
    
    /*
     * @param	event DeleteSusceptanceEvent
     */
    @EventHandler( payloadType=DeleteSusceptanceEvent.class )
    public void handle( DeleteSusceptanceEvent event) {
    	LOGGER.info("handling DeleteSusceptanceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Susceptance entity = delete( event.getSusceptanceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSusceptance( entity );

    }    




    /**
     * Method to retrieve the Susceptance via an SusceptancePrimaryKey.
     * @param 	id Long
     * @return 	Susceptance
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Susceptance handle( FindSusceptanceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSusceptanceId() );
    }
    
    /**
     * Method to retrieve a collection of all Susceptances
     *
     * @param	query	FindAllSusceptanceQuery 
     * @return 	List<Susceptance> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Susceptance> handle( FindAllSusceptanceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSusceptance, 
	 * but only if the id matches
	 * 
	 * @param		entity	Susceptance
	 */
	protected void emitFindSusceptance( Susceptance entity ) {
		LOGGER.info("handling emitFindSusceptance" );
		
	    queryUpdateEmitter.emit(FindSusceptanceQuery.class,
	                            query -> query.getFilter().getSusceptanceId().equals(entity.getSusceptanceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSusceptance
	 * 
	 * @param		entity	Susceptance
	 */
	protected void emitFindAllSusceptance( Susceptance entity ) {
		LOGGER.info("handling emitFindAllSusceptance" );
		
	    queryUpdateEmitter.emit(FindAllSusceptanceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SusceptanceProjector.class.getName());

}
