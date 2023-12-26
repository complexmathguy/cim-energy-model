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
 * Projector for WindTurbineType4aIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindTurbineType4aIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindTurbineType4aIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windTurbineType4aIEC")
@Component("windTurbineType4aIEC-projector")
public class WindTurbineType4aIECProjector extends WindTurbineType4aIECEntityProjector {
		
	// core constructor
	public WindTurbineType4aIECProjector(WindTurbineType4aIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindTurbineType4aIECEvent
     */
    @EventHandler( payloadType=CreateWindTurbineType4aIECEvent.class )
    public void handle( CreateWindTurbineType4aIECEvent event) {
	    LOGGER.info("handling CreateWindTurbineType4aIECEvent - " + event );
	    WindTurbineType4aIEC entity = new WindTurbineType4aIEC();
        entity.setWindTurbineType4aIECId( event.getWindTurbineType4aIECId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType4aIEC( entity );
    }

    /*
     * @param	event UpdateWindTurbineType4aIECEvent
     */
    @EventHandler( payloadType=UpdateWindTurbineType4aIECEvent.class )
    public void handle( UpdateWindTurbineType4aIECEvent event) {
    	LOGGER.info("handling UpdateWindTurbineType4aIECEvent - " + event );
    	
	    WindTurbineType4aIEC entity = new WindTurbineType4aIEC();
        entity.setWindTurbineType4aIECId( event.getWindTurbineType4aIECId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindTurbineType4aIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType4aIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindTurbineType4aIECEvent
     */
    @EventHandler( payloadType=DeleteWindTurbineType4aIECEvent.class )
    public void handle( DeleteWindTurbineType4aIECEvent event) {
    	LOGGER.info("handling DeleteWindTurbineType4aIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindTurbineType4aIEC entity = delete( event.getWindTurbineType4aIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType4aIEC( entity );

    }    




    /**
     * Method to retrieve the WindTurbineType4aIEC via an WindTurbineType4aIECPrimaryKey.
     * @param 	id Long
     * @return 	WindTurbineType4aIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindTurbineType4aIEC handle( FindWindTurbineType4aIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindTurbineType4aIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType4aIECs
     *
     * @param	query	FindAllWindTurbineType4aIECQuery 
     * @return 	List<WindTurbineType4aIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindTurbineType4aIEC> handle( FindAllWindTurbineType4aIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindTurbineType4aIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindTurbineType4aIEC
	 */
	protected void emitFindWindTurbineType4aIEC( WindTurbineType4aIEC entity ) {
		LOGGER.info("handling emitFindWindTurbineType4aIEC" );
		
	    queryUpdateEmitter.emit(FindWindTurbineType4aIECQuery.class,
	                            query -> query.getFilter().getWindTurbineType4aIECId().equals(entity.getWindTurbineType4aIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindTurbineType4aIEC
	 * 
	 * @param		entity	WindTurbineType4aIEC
	 */
	protected void emitFindAllWindTurbineType4aIEC( WindTurbineType4aIEC entity ) {
		LOGGER.info("handling emitFindAllWindTurbineType4aIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindTurbineType4aIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType4aIECProjector.class.getName());

}
