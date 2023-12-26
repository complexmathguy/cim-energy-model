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
 * Projector for Ground as outlined for the CQRS pattern.  All event handling and query handling related to Ground are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GroundAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("ground")
@Component("ground-projector")
public class GroundProjector extends GroundEntityProjector {
		
	// core constructor
	public GroundProjector(GroundRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGroundEvent
     */
    @EventHandler( payloadType=CreateGroundEvent.class )
    public void handle( CreateGroundEvent event) {
	    LOGGER.info("handling CreateGroundEvent - " + event );
	    Ground entity = new Ground();
        entity.setGroundId( event.getGroundId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGround( entity );
    }

    /*
     * @param	event UpdateGroundEvent
     */
    @EventHandler( payloadType=UpdateGroundEvent.class )
    public void handle( UpdateGroundEvent event) {
    	LOGGER.info("handling UpdateGroundEvent - " + event );
    	
	    Ground entity = new Ground();
        entity.setGroundId( event.getGroundId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGround( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGround( entity );        
    }
    
    /*
     * @param	event DeleteGroundEvent
     */
    @EventHandler( payloadType=DeleteGroundEvent.class )
    public void handle( DeleteGroundEvent event) {
    	LOGGER.info("handling DeleteGroundEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Ground entity = delete( event.getGroundId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGround( entity );

    }    




    /**
     * Method to retrieve the Ground via an GroundPrimaryKey.
     * @param 	id Long
     * @return 	Ground
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Ground handle( FindGroundQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGroundId() );
    }
    
    /**
     * Method to retrieve a collection of all Grounds
     *
     * @param	query	FindAllGroundQuery 
     * @return 	List<Ground> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Ground> handle( FindAllGroundQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGround, 
	 * but only if the id matches
	 * 
	 * @param		entity	Ground
	 */
	protected void emitFindGround( Ground entity ) {
		LOGGER.info("handling emitFindGround" );
		
	    queryUpdateEmitter.emit(FindGroundQuery.class,
	                            query -> query.getFilter().getGroundId().equals(entity.getGroundId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGround
	 * 
	 * @param		entity	Ground
	 */
	protected void emitFindAllGround( Ground entity ) {
		LOGGER.info("handling emitFindAllGround" );
		
	    queryUpdateEmitter.emit(FindAllGroundQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GroundProjector.class.getName());

}
