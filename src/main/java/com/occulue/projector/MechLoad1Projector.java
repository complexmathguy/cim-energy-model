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
 * Projector for MechLoad1 as outlined for the CQRS pattern.  All event handling and query handling related to MechLoad1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MechLoad1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("mechLoad1")
@Component("mechLoad1-projector")
public class MechLoad1Projector extends MechLoad1EntityProjector {
		
	// core constructor
	public MechLoad1Projector(MechLoad1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMechLoad1Event
     */
    @EventHandler( payloadType=CreateMechLoad1Event.class )
    public void handle( CreateMechLoad1Event event) {
	    LOGGER.info("handling CreateMechLoad1Event - " + event );
	    MechLoad1 entity = new MechLoad1();
        entity.setMechLoad1Id( event.getMechLoad1Id() );
        entity.setA( event.getA() );
        entity.setB( event.getB() );
        entity.setD( event.getD() );
        entity.setE( event.getE() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMechLoad1( entity );
    }

    /*
     * @param	event UpdateMechLoad1Event
     */
    @EventHandler( payloadType=UpdateMechLoad1Event.class )
    public void handle( UpdateMechLoad1Event event) {
    	LOGGER.info("handling UpdateMechLoad1Event - " + event );
    	
	    MechLoad1 entity = new MechLoad1();
        entity.setMechLoad1Id( event.getMechLoad1Id() );
        entity.setA( event.getA() );
        entity.setB( event.getB() );
        entity.setD( event.getD() );
        entity.setE( event.getE() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMechLoad1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMechLoad1( entity );        
    }
    
    /*
     * @param	event DeleteMechLoad1Event
     */
    @EventHandler( payloadType=DeleteMechLoad1Event.class )
    public void handle( DeleteMechLoad1Event event) {
    	LOGGER.info("handling DeleteMechLoad1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MechLoad1 entity = delete( event.getMechLoad1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMechLoad1( entity );

    }    




    /**
     * Method to retrieve the MechLoad1 via an MechLoad1PrimaryKey.
     * @param 	id Long
     * @return 	MechLoad1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MechLoad1 handle( FindMechLoad1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMechLoad1Id() );
    }
    
    /**
     * Method to retrieve a collection of all MechLoad1s
     *
     * @param	query	FindAllMechLoad1Query 
     * @return 	List<MechLoad1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MechLoad1> handle( FindAllMechLoad1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMechLoad1, 
	 * but only if the id matches
	 * 
	 * @param		entity	MechLoad1
	 */
	protected void emitFindMechLoad1( MechLoad1 entity ) {
		LOGGER.info("handling emitFindMechLoad1" );
		
	    queryUpdateEmitter.emit(FindMechLoad1Query.class,
	                            query -> query.getFilter().getMechLoad1Id().equals(entity.getMechLoad1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMechLoad1
	 * 
	 * @param		entity	MechLoad1
	 */
	protected void emitFindAllMechLoad1( MechLoad1 entity ) {
		LOGGER.info("handling emitFindAllMechLoad1" );
		
	    queryUpdateEmitter.emit(FindAllMechLoad1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MechLoad1Projector.class.getName());

}
