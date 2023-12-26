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
 * Projector for SwitchIt as outlined for the CQRS pattern.  All event handling and query handling related to SwitchIt are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SwitchItAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("switchIt")
@Component("switchIt-projector")
public class SwitchItProjector extends SwitchItEntityProjector {
		
	// core constructor
	public SwitchItProjector(SwitchItRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSwitchItEvent
     */
    @EventHandler( payloadType=CreateSwitchItEvent.class )
    public void handle( CreateSwitchItEvent event) {
	    LOGGER.info("handling CreateSwitchItEvent - " + event );
	    SwitchIt entity = new SwitchIt();
        entity.setSwitchItId( event.getSwitchItId() );
        entity.setOpen( event.getOpen() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchIt( entity );
    }

    /*
     * @param	event UpdateSwitchItEvent
     */
    @EventHandler( payloadType=UpdateSwitchItEvent.class )
    public void handle( UpdateSwitchItEvent event) {
    	LOGGER.info("handling UpdateSwitchItEvent - " + event );
    	
	    SwitchIt entity = new SwitchIt();
        entity.setSwitchItId( event.getSwitchItId() );
        entity.setOpen( event.getOpen() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSwitchIt( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchIt( entity );        
    }
    
    /*
     * @param	event DeleteSwitchItEvent
     */
    @EventHandler( payloadType=DeleteSwitchItEvent.class )
    public void handle( DeleteSwitchItEvent event) {
    	LOGGER.info("handling DeleteSwitchItEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SwitchIt entity = delete( event.getSwitchItId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchIt( entity );

    }    




    /**
     * Method to retrieve the SwitchIt via an SwitchItPrimaryKey.
     * @param 	id Long
     * @return 	SwitchIt
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SwitchIt handle( FindSwitchItQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSwitchItId() );
    }
    
    /**
     * Method to retrieve a collection of all SwitchIts
     *
     * @param	query	FindAllSwitchItQuery 
     * @return 	List<SwitchIt> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SwitchIt> handle( FindAllSwitchItQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSwitchIt, 
	 * but only if the id matches
	 * 
	 * @param		entity	SwitchIt
	 */
	protected void emitFindSwitchIt( SwitchIt entity ) {
		LOGGER.info("handling emitFindSwitchIt" );
		
	    queryUpdateEmitter.emit(FindSwitchItQuery.class,
	                            query -> query.getFilter().getSwitchItId().equals(entity.getSwitchItId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSwitchIt
	 * 
	 * @param		entity	SwitchIt
	 */
	protected void emitFindAllSwitchIt( SwitchIt entity ) {
		LOGGER.info("handling emitFindAllSwitchIt" );
		
	    queryUpdateEmitter.emit(FindAllSwitchItQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SwitchItProjector.class.getName());

}
