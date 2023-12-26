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
 * Projector for Resistance as outlined for the CQRS pattern.  All event handling and query handling related to Resistance are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ResistanceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("resistance")
@Component("resistance-projector")
public class ResistanceProjector extends ResistanceEntityProjector {
		
	// core constructor
	public ResistanceProjector(ResistanceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateResistanceEvent
     */
    @EventHandler( payloadType=CreateResistanceEvent.class )
    public void handle( CreateResistanceEvent event) {
	    LOGGER.info("handling CreateResistanceEvent - " + event );
	    Resistance entity = new Resistance();
        entity.setResistanceId( event.getResistanceId() );
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
        emitFindAllResistance( entity );
    }

    /*
     * @param	event UpdateResistanceEvent
     */
    @EventHandler( payloadType=UpdateResistanceEvent.class )
    public void handle( UpdateResistanceEvent event) {
    	LOGGER.info("handling UpdateResistanceEvent - " + event );
    	
	    Resistance entity = new Resistance();
        entity.setResistanceId( event.getResistanceId() );
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
        emitFindResistance( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllResistance( entity );        
    }
    
    /*
     * @param	event DeleteResistanceEvent
     */
    @EventHandler( payloadType=DeleteResistanceEvent.class )
    public void handle( DeleteResistanceEvent event) {
    	LOGGER.info("handling DeleteResistanceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Resistance entity = delete( event.getResistanceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllResistance( entity );

    }    




    /**
     * Method to retrieve the Resistance via an ResistancePrimaryKey.
     * @param 	id Long
     * @return 	Resistance
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Resistance handle( FindResistanceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getResistanceId() );
    }
    
    /**
     * Method to retrieve a collection of all Resistances
     *
     * @param	query	FindAllResistanceQuery 
     * @return 	List<Resistance> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Resistance> handle( FindAllResistanceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindResistance, 
	 * but only if the id matches
	 * 
	 * @param		entity	Resistance
	 */
	protected void emitFindResistance( Resistance entity ) {
		LOGGER.info("handling emitFindResistance" );
		
	    queryUpdateEmitter.emit(FindResistanceQuery.class,
	                            query -> query.getFilter().getResistanceId().equals(entity.getResistanceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllResistance
	 * 
	 * @param		entity	Resistance
	 */
	protected void emitFindAllResistance( Resistance entity ) {
		LOGGER.info("handling emitFindAllResistance" );
		
	    queryUpdateEmitter.emit(FindAllResistanceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ResistanceProjector.class.getName());

}
