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
 * Projector for UnderexcLimIEEE1 as outlined for the CQRS pattern.  All event handling and query handling related to UnderexcLimIEEE1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnderexcLimIEEE1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("underexcLimIEEE1")
@Component("underexcLimIEEE1-projector")
public class UnderexcLimIEEE1Projector extends UnderexcLimIEEE1EntityProjector {
		
	// core constructor
	public UnderexcLimIEEE1Projector(UnderexcLimIEEE1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnderexcLimIEEE1Event
     */
    @EventHandler( payloadType=CreateUnderexcLimIEEE1Event.class )
    public void handle( CreateUnderexcLimIEEE1Event event) {
	    LOGGER.info("handling CreateUnderexcLimIEEE1Event - " + event );
	    UnderexcLimIEEE1 entity = new UnderexcLimIEEE1();
        entity.setUnderexcLimIEEE1Id( event.getUnderexcLimIEEE1Id() );
        entity.setKuc( event.getKuc() );
        entity.setKuf( event.getKuf() );
        entity.setKui( event.getKui() );
        entity.setKul( event.getKul() );
        entity.setKur( event.getKur() );
        entity.setTu1( event.getTu1() );
        entity.setTu2( event.getTu2() );
        entity.setTu3( event.getTu3() );
        entity.setTu4( event.getTu4() );
        entity.setVucmax( event.getVucmax() );
        entity.setVuimax( event.getVuimax() );
        entity.setVuimin( event.getVuimin() );
        entity.setVulmax( event.getVulmax() );
        entity.setVulmin( event.getVulmin() );
        entity.setVurmax( event.getVurmax() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimIEEE1( entity );
    }

    /*
     * @param	event UpdateUnderexcLimIEEE1Event
     */
    @EventHandler( payloadType=UpdateUnderexcLimIEEE1Event.class )
    public void handle( UpdateUnderexcLimIEEE1Event event) {
    	LOGGER.info("handling UpdateUnderexcLimIEEE1Event - " + event );
    	
	    UnderexcLimIEEE1 entity = new UnderexcLimIEEE1();
        entity.setUnderexcLimIEEE1Id( event.getUnderexcLimIEEE1Id() );
        entity.setKuc( event.getKuc() );
        entity.setKuf( event.getKuf() );
        entity.setKui( event.getKui() );
        entity.setKul( event.getKul() );
        entity.setKur( event.getKur() );
        entity.setTu1( event.getTu1() );
        entity.setTu2( event.getTu2() );
        entity.setTu3( event.getTu3() );
        entity.setTu4( event.getTu4() );
        entity.setVucmax( event.getVucmax() );
        entity.setVuimax( event.getVuimax() );
        entity.setVuimin( event.getVuimin() );
        entity.setVulmax( event.getVulmax() );
        entity.setVulmin( event.getVulmin() );
        entity.setVurmax( event.getVurmax() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnderexcLimIEEE1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimIEEE1( entity );        
    }
    
    /*
     * @param	event DeleteUnderexcLimIEEE1Event
     */
    @EventHandler( payloadType=DeleteUnderexcLimIEEE1Event.class )
    public void handle( DeleteUnderexcLimIEEE1Event event) {
    	LOGGER.info("handling DeleteUnderexcLimIEEE1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	UnderexcLimIEEE1 entity = delete( event.getUnderexcLimIEEE1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimIEEE1( entity );

    }    




    /**
     * Method to retrieve the UnderexcLimIEEE1 via an UnderexcLimIEEE1PrimaryKey.
     * @param 	id Long
     * @return 	UnderexcLimIEEE1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public UnderexcLimIEEE1 handle( FindUnderexcLimIEEE1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnderexcLimIEEE1Id() );
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimIEEE1s
     *
     * @param	query	FindAllUnderexcLimIEEE1Query 
     * @return 	List<UnderexcLimIEEE1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<UnderexcLimIEEE1> handle( FindAllUnderexcLimIEEE1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnderexcLimIEEE1, 
	 * but only if the id matches
	 * 
	 * @param		entity	UnderexcLimIEEE1
	 */
	protected void emitFindUnderexcLimIEEE1( UnderexcLimIEEE1 entity ) {
		LOGGER.info("handling emitFindUnderexcLimIEEE1" );
		
	    queryUpdateEmitter.emit(FindUnderexcLimIEEE1Query.class,
	                            query -> query.getFilter().getUnderexcLimIEEE1Id().equals(entity.getUnderexcLimIEEE1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnderexcLimIEEE1
	 * 
	 * @param		entity	UnderexcLimIEEE1
	 */
	protected void emitFindAllUnderexcLimIEEE1( UnderexcLimIEEE1 entity ) {
		LOGGER.info("handling emitFindAllUnderexcLimIEEE1" );
		
	    queryUpdateEmitter.emit(FindAllUnderexcLimIEEE1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimIEEE1Projector.class.getName());

}
