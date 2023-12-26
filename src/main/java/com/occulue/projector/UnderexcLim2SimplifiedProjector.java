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
 * Projector for UnderexcLim2Simplified as outlined for the CQRS pattern.  All event handling and query handling related to UnderexcLim2Simplified are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnderexcLim2SimplifiedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("underexcLim2Simplified")
@Component("underexcLim2Simplified-projector")
public class UnderexcLim2SimplifiedProjector extends UnderexcLim2SimplifiedEntityProjector {
		
	// core constructor
	public UnderexcLim2SimplifiedProjector(UnderexcLim2SimplifiedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnderexcLim2SimplifiedEvent
     */
    @EventHandler( payloadType=CreateUnderexcLim2SimplifiedEvent.class )
    public void handle( CreateUnderexcLim2SimplifiedEvent event) {
	    LOGGER.info("handling CreateUnderexcLim2SimplifiedEvent - " + event );
	    UnderexcLim2Simplified entity = new UnderexcLim2Simplified();
        entity.setUnderexcLim2SimplifiedId( event.getUnderexcLim2SimplifiedId() );
        entity.setKui( event.getKui() );
        entity.setP0( event.getP0() );
        entity.setP1( event.getP1() );
        entity.setQ0( event.getQ0() );
        entity.setQ1( event.getQ1() );
        entity.setVuimax( event.getVuimax() );
        entity.setVuimin( event.getVuimin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLim2Simplified( entity );
    }

    /*
     * @param	event UpdateUnderexcLim2SimplifiedEvent
     */
    @EventHandler( payloadType=UpdateUnderexcLim2SimplifiedEvent.class )
    public void handle( UpdateUnderexcLim2SimplifiedEvent event) {
    	LOGGER.info("handling UpdateUnderexcLim2SimplifiedEvent - " + event );
    	
	    UnderexcLim2Simplified entity = new UnderexcLim2Simplified();
        entity.setUnderexcLim2SimplifiedId( event.getUnderexcLim2SimplifiedId() );
        entity.setKui( event.getKui() );
        entity.setP0( event.getP0() );
        entity.setP1( event.getP1() );
        entity.setQ0( event.getQ0() );
        entity.setQ1( event.getQ1() );
        entity.setVuimax( event.getVuimax() );
        entity.setVuimin( event.getVuimin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnderexcLim2Simplified( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLim2Simplified( entity );        
    }
    
    /*
     * @param	event DeleteUnderexcLim2SimplifiedEvent
     */
    @EventHandler( payloadType=DeleteUnderexcLim2SimplifiedEvent.class )
    public void handle( DeleteUnderexcLim2SimplifiedEvent event) {
    	LOGGER.info("handling DeleteUnderexcLim2SimplifiedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	UnderexcLim2Simplified entity = delete( event.getUnderexcLim2SimplifiedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLim2Simplified( entity );

    }    




    /**
     * Method to retrieve the UnderexcLim2Simplified via an UnderexcLim2SimplifiedPrimaryKey.
     * @param 	id Long
     * @return 	UnderexcLim2Simplified
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public UnderexcLim2Simplified handle( FindUnderexcLim2SimplifiedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnderexcLim2SimplifiedId() );
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLim2Simplifieds
     *
     * @param	query	FindAllUnderexcLim2SimplifiedQuery 
     * @return 	List<UnderexcLim2Simplified> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<UnderexcLim2Simplified> handle( FindAllUnderexcLim2SimplifiedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnderexcLim2Simplified, 
	 * but only if the id matches
	 * 
	 * @param		entity	UnderexcLim2Simplified
	 */
	protected void emitFindUnderexcLim2Simplified( UnderexcLim2Simplified entity ) {
		LOGGER.info("handling emitFindUnderexcLim2Simplified" );
		
	    queryUpdateEmitter.emit(FindUnderexcLim2SimplifiedQuery.class,
	                            query -> query.getFilter().getUnderexcLim2SimplifiedId().equals(entity.getUnderexcLim2SimplifiedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnderexcLim2Simplified
	 * 
	 * @param		entity	UnderexcLim2Simplified
	 */
	protected void emitFindAllUnderexcLim2Simplified( UnderexcLim2Simplified entity ) {
		LOGGER.info("handling emitFindAllUnderexcLim2Simplified" );
		
	    queryUpdateEmitter.emit(FindAllUnderexcLim2SimplifiedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLim2SimplifiedProjector.class.getName());

}
