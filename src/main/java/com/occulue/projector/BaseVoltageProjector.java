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
 * Projector for BaseVoltage as outlined for the CQRS pattern.  All event handling and query handling related to BaseVoltage are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BaseVoltageAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("baseVoltage")
@Component("baseVoltage-projector")
public class BaseVoltageProjector extends BaseVoltageEntityProjector {
		
	// core constructor
	public BaseVoltageProjector(BaseVoltageRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBaseVoltageEvent
     */
    @EventHandler( payloadType=CreateBaseVoltageEvent.class )
    public void handle( CreateBaseVoltageEvent event) {
	    LOGGER.info("handling CreateBaseVoltageEvent - " + event );
	    BaseVoltage entity = new BaseVoltage();
        entity.setBaseVoltageId( event.getBaseVoltageId() );
        entity.setNominalVoltage( event.getNominalVoltage() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBaseVoltage( entity );
    }

    /*
     * @param	event UpdateBaseVoltageEvent
     */
    @EventHandler( payloadType=UpdateBaseVoltageEvent.class )
    public void handle( UpdateBaseVoltageEvent event) {
    	LOGGER.info("handling UpdateBaseVoltageEvent - " + event );
    	
	    BaseVoltage entity = new BaseVoltage();
        entity.setBaseVoltageId( event.getBaseVoltageId() );
        entity.setNominalVoltage( event.getNominalVoltage() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBaseVoltage( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBaseVoltage( entity );        
    }
    
    /*
     * @param	event DeleteBaseVoltageEvent
     */
    @EventHandler( payloadType=DeleteBaseVoltageEvent.class )
    public void handle( DeleteBaseVoltageEvent event) {
    	LOGGER.info("handling DeleteBaseVoltageEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	BaseVoltage entity = delete( event.getBaseVoltageId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBaseVoltage( entity );

    }    




    /**
     * Method to retrieve the BaseVoltage via an BaseVoltagePrimaryKey.
     * @param 	id Long
     * @return 	BaseVoltage
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public BaseVoltage handle( FindBaseVoltageQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBaseVoltageId() );
    }
    
    /**
     * Method to retrieve a collection of all BaseVoltages
     *
     * @param	query	FindAllBaseVoltageQuery 
     * @return 	List<BaseVoltage> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<BaseVoltage> handle( FindAllBaseVoltageQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBaseVoltage, 
	 * but only if the id matches
	 * 
	 * @param		entity	BaseVoltage
	 */
	protected void emitFindBaseVoltage( BaseVoltage entity ) {
		LOGGER.info("handling emitFindBaseVoltage" );
		
	    queryUpdateEmitter.emit(FindBaseVoltageQuery.class,
	                            query -> query.getFilter().getBaseVoltageId().equals(entity.getBaseVoltageId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBaseVoltage
	 * 
	 * @param		entity	BaseVoltage
	 */
	protected void emitFindAllBaseVoltage( BaseVoltage entity ) {
		LOGGER.info("handling emitFindAllBaseVoltage" );
		
	    queryUpdateEmitter.emit(FindAllBaseVoltageQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BaseVoltageProjector.class.getName());

}
