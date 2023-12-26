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
 * Projector for OperationalLimitType as outlined for the CQRS pattern.  All event handling and query handling related to OperationalLimitType are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OperationalLimitTypeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("operationalLimitType")
@Component("operationalLimitType-projector")
public class OperationalLimitTypeProjector extends OperationalLimitTypeEntityProjector {
		
	// core constructor
	public OperationalLimitTypeProjector(OperationalLimitTypeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOperationalLimitTypeEvent
     */
    @EventHandler( payloadType=CreateOperationalLimitTypeEvent.class )
    public void handle( CreateOperationalLimitTypeEvent event) {
	    LOGGER.info("handling CreateOperationalLimitTypeEvent - " + event );
	    OperationalLimitType entity = new OperationalLimitType();
        entity.setOperationalLimitTypeId( event.getOperationalLimitTypeId() );
        entity.setAcceptableDuration( event.getAcceptableDuration() );
        entity.setDirection( event.getDirection() );
        entity.setLimitType( event.getLimitType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOperationalLimitType( entity );
    }

    /*
     * @param	event UpdateOperationalLimitTypeEvent
     */
    @EventHandler( payloadType=UpdateOperationalLimitTypeEvent.class )
    public void handle( UpdateOperationalLimitTypeEvent event) {
    	LOGGER.info("handling UpdateOperationalLimitTypeEvent - " + event );
    	
	    OperationalLimitType entity = new OperationalLimitType();
        entity.setOperationalLimitTypeId( event.getOperationalLimitTypeId() );
        entity.setAcceptableDuration( event.getAcceptableDuration() );
        entity.setDirection( event.getDirection() );
        entity.setLimitType( event.getLimitType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOperationalLimitType( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOperationalLimitType( entity );        
    }
    
    /*
     * @param	event DeleteOperationalLimitTypeEvent
     */
    @EventHandler( payloadType=DeleteOperationalLimitTypeEvent.class )
    public void handle( DeleteOperationalLimitTypeEvent event) {
    	LOGGER.info("handling DeleteOperationalLimitTypeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OperationalLimitType entity = delete( event.getOperationalLimitTypeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOperationalLimitType( entity );

    }    




    /**
     * Method to retrieve the OperationalLimitType via an OperationalLimitTypePrimaryKey.
     * @param 	id Long
     * @return 	OperationalLimitType
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OperationalLimitType handle( FindOperationalLimitTypeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOperationalLimitTypeId() );
    }
    
    /**
     * Method to retrieve a collection of all OperationalLimitTypes
     *
     * @param	query	FindAllOperationalLimitTypeQuery 
     * @return 	List<OperationalLimitType> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OperationalLimitType> handle( FindAllOperationalLimitTypeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOperationalLimitType, 
	 * but only if the id matches
	 * 
	 * @param		entity	OperationalLimitType
	 */
	protected void emitFindOperationalLimitType( OperationalLimitType entity ) {
		LOGGER.info("handling emitFindOperationalLimitType" );
		
	    queryUpdateEmitter.emit(FindOperationalLimitTypeQuery.class,
	                            query -> query.getFilter().getOperationalLimitTypeId().equals(entity.getOperationalLimitTypeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOperationalLimitType
	 * 
	 * @param		entity	OperationalLimitType
	 */
	protected void emitFindAllOperationalLimitType( OperationalLimitType entity ) {
		LOGGER.info("handling emitFindAllOperationalLimitType" );
		
	    queryUpdateEmitter.emit(FindAllOperationalLimitTypeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitTypeProjector.class.getName());

}
