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
 * Projector for OverexcLimIEEE as outlined for the CQRS pattern.  All event handling and query handling related to OverexcLimIEEE are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OverexcLimIEEEAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("overexcLimIEEE")
@Component("overexcLimIEEE-projector")
public class OverexcLimIEEEProjector extends OverexcLimIEEEEntityProjector {
		
	// core constructor
	public OverexcLimIEEEProjector(OverexcLimIEEERepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOverexcLimIEEEEvent
     */
    @EventHandler( payloadType=CreateOverexcLimIEEEEvent.class )
    public void handle( CreateOverexcLimIEEEEvent event) {
	    LOGGER.info("handling CreateOverexcLimIEEEEvent - " + event );
	    OverexcLimIEEE entity = new OverexcLimIEEE();
        entity.setOverexcLimIEEEId( event.getOverexcLimIEEEId() );
        entity.setHyst( event.getHyst() );
        entity.setIfdlim( event.getIfdlim() );
        entity.setIfdmax( event.getIfdmax() );
        entity.setItfpu( event.getItfpu() );
        entity.setKcd( event.getKcd() );
        entity.setKramp( event.getKramp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimIEEE( entity );
    }

    /*
     * @param	event UpdateOverexcLimIEEEEvent
     */
    @EventHandler( payloadType=UpdateOverexcLimIEEEEvent.class )
    public void handle( UpdateOverexcLimIEEEEvent event) {
    	LOGGER.info("handling UpdateOverexcLimIEEEEvent - " + event );
    	
	    OverexcLimIEEE entity = new OverexcLimIEEE();
        entity.setOverexcLimIEEEId( event.getOverexcLimIEEEId() );
        entity.setHyst( event.getHyst() );
        entity.setIfdlim( event.getIfdlim() );
        entity.setIfdmax( event.getIfdmax() );
        entity.setItfpu( event.getItfpu() );
        entity.setKcd( event.getKcd() );
        entity.setKramp( event.getKramp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOverexcLimIEEE( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimIEEE( entity );        
    }
    
    /*
     * @param	event DeleteOverexcLimIEEEEvent
     */
    @EventHandler( payloadType=DeleteOverexcLimIEEEEvent.class )
    public void handle( DeleteOverexcLimIEEEEvent event) {
    	LOGGER.info("handling DeleteOverexcLimIEEEEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OverexcLimIEEE entity = delete( event.getOverexcLimIEEEId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimIEEE( entity );

    }    




    /**
     * Method to retrieve the OverexcLimIEEE via an OverexcLimIEEEPrimaryKey.
     * @param 	id Long
     * @return 	OverexcLimIEEE
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OverexcLimIEEE handle( FindOverexcLimIEEEQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOverexcLimIEEEId() );
    }
    
    /**
     * Method to retrieve a collection of all OverexcLimIEEEs
     *
     * @param	query	FindAllOverexcLimIEEEQuery 
     * @return 	List<OverexcLimIEEE> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OverexcLimIEEE> handle( FindAllOverexcLimIEEEQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOverexcLimIEEE, 
	 * but only if the id matches
	 * 
	 * @param		entity	OverexcLimIEEE
	 */
	protected void emitFindOverexcLimIEEE( OverexcLimIEEE entity ) {
		LOGGER.info("handling emitFindOverexcLimIEEE" );
		
	    queryUpdateEmitter.emit(FindOverexcLimIEEEQuery.class,
	                            query -> query.getFilter().getOverexcLimIEEEId().equals(entity.getOverexcLimIEEEId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOverexcLimIEEE
	 * 
	 * @param		entity	OverexcLimIEEE
	 */
	protected void emitFindAllOverexcLimIEEE( OverexcLimIEEE entity ) {
		LOGGER.info("handling emitFindAllOverexcLimIEEE" );
		
	    queryUpdateEmitter.emit(FindAllOverexcLimIEEEQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimIEEEProjector.class.getName());

}
