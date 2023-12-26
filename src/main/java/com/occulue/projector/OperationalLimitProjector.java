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
 * Projector for OperationalLimit as outlined for the CQRS pattern.  All event handling and query handling related to OperationalLimit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OperationalLimitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("operationalLimit")
@Component("operationalLimit-projector")
public class OperationalLimitProjector extends OperationalLimitEntityProjector {
		
	// core constructor
	public OperationalLimitProjector(OperationalLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOperationalLimitEvent
     */
    @EventHandler( payloadType=CreateOperationalLimitEvent.class )
    public void handle( CreateOperationalLimitEvent event) {
	    LOGGER.info("handling CreateOperationalLimitEvent - " + event );
	    OperationalLimit entity = new OperationalLimit();
        entity.setOperationalLimitId( event.getOperationalLimitId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOperationalLimit( entity );
    }

    /*
     * @param	event UpdateOperationalLimitEvent
     */
    @EventHandler( payloadType=UpdateOperationalLimitEvent.class )
    public void handle( UpdateOperationalLimitEvent event) {
    	LOGGER.info("handling UpdateOperationalLimitEvent - " + event );
    	
	    OperationalLimit entity = new OperationalLimit();
        entity.setOperationalLimitId( event.getOperationalLimitId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOperationalLimit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOperationalLimit( entity );        
    }
    
    /*
     * @param	event DeleteOperationalLimitEvent
     */
    @EventHandler( payloadType=DeleteOperationalLimitEvent.class )
    public void handle( DeleteOperationalLimitEvent event) {
    	LOGGER.info("handling DeleteOperationalLimitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OperationalLimit entity = delete( event.getOperationalLimitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOperationalLimit( entity );

    }    




    /**
     * Method to retrieve the OperationalLimit via an OperationalLimitPrimaryKey.
     * @param 	id Long
     * @return 	OperationalLimit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OperationalLimit handle( FindOperationalLimitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOperationalLimitId() );
    }
    
    /**
     * Method to retrieve a collection of all OperationalLimits
     *
     * @param	query	FindAllOperationalLimitQuery 
     * @return 	List<OperationalLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OperationalLimit> handle( FindAllOperationalLimitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOperationalLimit, 
	 * but only if the id matches
	 * 
	 * @param		entity	OperationalLimit
	 */
	protected void emitFindOperationalLimit( OperationalLimit entity ) {
		LOGGER.info("handling emitFindOperationalLimit" );
		
	    queryUpdateEmitter.emit(FindOperationalLimitQuery.class,
	                            query -> query.getFilter().getOperationalLimitId().equals(entity.getOperationalLimitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOperationalLimit
	 * 
	 * @param		entity	OperationalLimit
	 */
	protected void emitFindAllOperationalLimit( OperationalLimit entity ) {
		LOGGER.info("handling emitFindAllOperationalLimit" );
		
	    queryUpdateEmitter.emit(FindAllOperationalLimitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitProjector.class.getName());

}
