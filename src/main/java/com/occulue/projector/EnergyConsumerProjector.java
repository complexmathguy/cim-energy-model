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
 * Projector for EnergyConsumer as outlined for the CQRS pattern.  All event handling and query handling related to EnergyConsumer are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EnergyConsumerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("energyConsumer")
@Component("energyConsumer-projector")
public class EnergyConsumerProjector extends EnergyConsumerEntityProjector {
		
	// core constructor
	public EnergyConsumerProjector(EnergyConsumerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEnergyConsumerEvent
     */
    @EventHandler( payloadType=CreateEnergyConsumerEvent.class )
    public void handle( CreateEnergyConsumerEvent event) {
	    LOGGER.info("handling CreateEnergyConsumerEvent - " + event );
	    EnergyConsumer entity = new EnergyConsumer();
        entity.setEnergyConsumerId( event.getEnergyConsumerId() );
        entity.setPfixed( event.getPfixed() );
        entity.setPfixedPct( event.getPfixedPct() );
        entity.setQfixed( event.getQfixed() );
        entity.setQfixedPct( event.getQfixedPct() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergyConsumer( entity );
    }

    /*
     * @param	event UpdateEnergyConsumerEvent
     */
    @EventHandler( payloadType=UpdateEnergyConsumerEvent.class )
    public void handle( UpdateEnergyConsumerEvent event) {
    	LOGGER.info("handling UpdateEnergyConsumerEvent - " + event );
    	
	    EnergyConsumer entity = new EnergyConsumer();
        entity.setEnergyConsumerId( event.getEnergyConsumerId() );
        entity.setPfixed( event.getPfixed() );
        entity.setPfixedPct( event.getPfixedPct() );
        entity.setQfixed( event.getQfixed() );
        entity.setQfixedPct( event.getQfixedPct() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEnergyConsumer( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergyConsumer( entity );        
    }
    
    /*
     * @param	event DeleteEnergyConsumerEvent
     */
    @EventHandler( payloadType=DeleteEnergyConsumerEvent.class )
    public void handle( DeleteEnergyConsumerEvent event) {
    	LOGGER.info("handling DeleteEnergyConsumerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EnergyConsumer entity = delete( event.getEnergyConsumerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergyConsumer( entity );

    }    




    /**
     * Method to retrieve the EnergyConsumer via an EnergyConsumerPrimaryKey.
     * @param 	id Long
     * @return 	EnergyConsumer
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EnergyConsumer handle( FindEnergyConsumerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEnergyConsumerId() );
    }
    
    /**
     * Method to retrieve a collection of all EnergyConsumers
     *
     * @param	query	FindAllEnergyConsumerQuery 
     * @return 	List<EnergyConsumer> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EnergyConsumer> handle( FindAllEnergyConsumerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEnergyConsumer, 
	 * but only if the id matches
	 * 
	 * @param		entity	EnergyConsumer
	 */
	protected void emitFindEnergyConsumer( EnergyConsumer entity ) {
		LOGGER.info("handling emitFindEnergyConsumer" );
		
	    queryUpdateEmitter.emit(FindEnergyConsumerQuery.class,
	                            query -> query.getFilter().getEnergyConsumerId().equals(entity.getEnergyConsumerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEnergyConsumer
	 * 
	 * @param		entity	EnergyConsumer
	 */
	protected void emitFindAllEnergyConsumer( EnergyConsumer entity ) {
		LOGGER.info("handling emitFindAllEnergyConsumer" );
		
	    queryUpdateEmitter.emit(FindAllEnergyConsumerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EnergyConsumerProjector.class.getName());

}
