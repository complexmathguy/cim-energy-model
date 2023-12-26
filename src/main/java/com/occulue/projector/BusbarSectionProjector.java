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
 * Projector for BusbarSection as outlined for the CQRS pattern.  All event handling and query handling related to BusbarSection are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BusbarSectionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("busbarSection")
@Component("busbarSection-projector")
public class BusbarSectionProjector extends BusbarSectionEntityProjector {
		
	// core constructor
	public BusbarSectionProjector(BusbarSectionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBusbarSectionEvent
     */
    @EventHandler( payloadType=CreateBusbarSectionEvent.class )
    public void handle( CreateBusbarSectionEvent event) {
	    LOGGER.info("handling CreateBusbarSectionEvent - " + event );
	    BusbarSection entity = new BusbarSection();
        entity.setBusbarSectionId( event.getBusbarSectionId() );
        entity.setIpMax( event.getIpMax() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBusbarSection( entity );
    }

    /*
     * @param	event UpdateBusbarSectionEvent
     */
    @EventHandler( payloadType=UpdateBusbarSectionEvent.class )
    public void handle( UpdateBusbarSectionEvent event) {
    	LOGGER.info("handling UpdateBusbarSectionEvent - " + event );
    	
	    BusbarSection entity = new BusbarSection();
        entity.setBusbarSectionId( event.getBusbarSectionId() );
        entity.setIpMax( event.getIpMax() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBusbarSection( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBusbarSection( entity );        
    }
    
    /*
     * @param	event DeleteBusbarSectionEvent
     */
    @EventHandler( payloadType=DeleteBusbarSectionEvent.class )
    public void handle( DeleteBusbarSectionEvent event) {
    	LOGGER.info("handling DeleteBusbarSectionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	BusbarSection entity = delete( event.getBusbarSectionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBusbarSection( entity );

    }    




    /**
     * Method to retrieve the BusbarSection via an BusbarSectionPrimaryKey.
     * @param 	id Long
     * @return 	BusbarSection
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public BusbarSection handle( FindBusbarSectionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBusbarSectionId() );
    }
    
    /**
     * Method to retrieve a collection of all BusbarSections
     *
     * @param	query	FindAllBusbarSectionQuery 
     * @return 	List<BusbarSection> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<BusbarSection> handle( FindAllBusbarSectionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBusbarSection, 
	 * but only if the id matches
	 * 
	 * @param		entity	BusbarSection
	 */
	protected void emitFindBusbarSection( BusbarSection entity ) {
		LOGGER.info("handling emitFindBusbarSection" );
		
	    queryUpdateEmitter.emit(FindBusbarSectionQuery.class,
	                            query -> query.getFilter().getBusbarSectionId().equals(entity.getBusbarSectionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBusbarSection
	 * 
	 * @param		entity	BusbarSection
	 */
	protected void emitFindAllBusbarSection( BusbarSection entity ) {
		LOGGER.info("handling emitFindAllBusbarSection" );
		
	    queryUpdateEmitter.emit(FindAllBusbarSectionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BusbarSectionProjector.class.getName());

}
