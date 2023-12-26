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
 * Projector for Inductance as outlined for the CQRS pattern.  All event handling and query handling related to Inductance are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by InductanceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("inductance")
@Component("inductance-projector")
public class InductanceProjector extends InductanceEntityProjector {
		
	// core constructor
	public InductanceProjector(InductanceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateInductanceEvent
     */
    @EventHandler( payloadType=CreateInductanceEvent.class )
    public void handle( CreateInductanceEvent event) {
	    LOGGER.info("handling CreateInductanceEvent - " + event );
	    Inductance entity = new Inductance();
        entity.setInductanceId( event.getInductanceId() );
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
        emitFindAllInductance( entity );
    }

    /*
     * @param	event UpdateInductanceEvent
     */
    @EventHandler( payloadType=UpdateInductanceEvent.class )
    public void handle( UpdateInductanceEvent event) {
    	LOGGER.info("handling UpdateInductanceEvent - " + event );
    	
	    Inductance entity = new Inductance();
        entity.setInductanceId( event.getInductanceId() );
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
        emitFindInductance( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllInductance( entity );        
    }
    
    /*
     * @param	event DeleteInductanceEvent
     */
    @EventHandler( payloadType=DeleteInductanceEvent.class )
    public void handle( DeleteInductanceEvent event) {
    	LOGGER.info("handling DeleteInductanceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Inductance entity = delete( event.getInductanceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllInductance( entity );

    }    




    /**
     * Method to retrieve the Inductance via an InductancePrimaryKey.
     * @param 	id Long
     * @return 	Inductance
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Inductance handle( FindInductanceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getInductanceId() );
    }
    
    /**
     * Method to retrieve a collection of all Inductances
     *
     * @param	query	FindAllInductanceQuery 
     * @return 	List<Inductance> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Inductance> handle( FindAllInductanceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindInductance, 
	 * but only if the id matches
	 * 
	 * @param		entity	Inductance
	 */
	protected void emitFindInductance( Inductance entity ) {
		LOGGER.info("handling emitFindInductance" );
		
	    queryUpdateEmitter.emit(FindInductanceQuery.class,
	                            query -> query.getFilter().getInductanceId().equals(entity.getInductanceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllInductance
	 * 
	 * @param		entity	Inductance
	 */
	protected void emitFindAllInductance( Inductance entity ) {
		LOGGER.info("handling emitFindAllInductance" );
		
	    queryUpdateEmitter.emit(FindAllInductanceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(InductanceProjector.class.getName());

}
