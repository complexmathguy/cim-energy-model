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
 * Projector for WindTurbineType3or4IEC as outlined for the CQRS pattern.  All event handling and query handling related to WindTurbineType3or4IEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindTurbineType3or4IECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windTurbineType3or4IEC")
@Component("windTurbineType3or4IEC-projector")
public class WindTurbineType3or4IECProjector extends WindTurbineType3or4IECEntityProjector {
		
	// core constructor
	public WindTurbineType3or4IECProjector(WindTurbineType3or4IECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindTurbineType3or4IECEvent
     */
    @EventHandler( payloadType=CreateWindTurbineType3or4IECEvent.class )
    public void handle( CreateWindTurbineType3or4IECEvent event) {
	    LOGGER.info("handling CreateWindTurbineType3or4IECEvent - " + event );
	    WindTurbineType3or4IEC entity = new WindTurbineType3or4IEC();
        entity.setWindTurbineType3or4IECId( event.getWindTurbineType3or4IECId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType3or4IEC( entity );
    }

    /*
     * @param	event UpdateWindTurbineType3or4IECEvent
     */
    @EventHandler( payloadType=UpdateWindTurbineType3or4IECEvent.class )
    public void handle( UpdateWindTurbineType3or4IECEvent event) {
    	LOGGER.info("handling UpdateWindTurbineType3or4IECEvent - " + event );
    	
	    WindTurbineType3or4IEC entity = new WindTurbineType3or4IEC();
        entity.setWindTurbineType3or4IECId( event.getWindTurbineType3or4IECId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindTurbineType3or4IEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType3or4IEC( entity );        
    }
    
    /*
     * @param	event DeleteWindTurbineType3or4IECEvent
     */
    @EventHandler( payloadType=DeleteWindTurbineType3or4IECEvent.class )
    public void handle( DeleteWindTurbineType3or4IECEvent event) {
    	LOGGER.info("handling DeleteWindTurbineType3or4IECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindTurbineType3or4IEC entity = delete( event.getWindTurbineType3or4IECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType3or4IEC( entity );

    }    




    /**
     * Method to retrieve the WindTurbineType3or4IEC via an WindTurbineType3or4IECPrimaryKey.
     * @param 	id Long
     * @return 	WindTurbineType3or4IEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindTurbineType3or4IEC handle( FindWindTurbineType3or4IECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindTurbineType3or4IECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType3or4IECs
     *
     * @param	query	FindAllWindTurbineType3or4IECQuery 
     * @return 	List<WindTurbineType3or4IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindTurbineType3or4IEC> handle( FindAllWindTurbineType3or4IECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindTurbineType3or4IEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindTurbineType3or4IEC
	 */
	protected void emitFindWindTurbineType3or4IEC( WindTurbineType3or4IEC entity ) {
		LOGGER.info("handling emitFindWindTurbineType3or4IEC" );
		
	    queryUpdateEmitter.emit(FindWindTurbineType3or4IECQuery.class,
	                            query -> query.getFilter().getWindTurbineType3or4IECId().equals(entity.getWindTurbineType3or4IECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindTurbineType3or4IEC
	 * 
	 * @param		entity	WindTurbineType3or4IEC
	 */
	protected void emitFindAllWindTurbineType3or4IEC( WindTurbineType3or4IEC entity ) {
		LOGGER.info("handling emitFindAllWindTurbineType3or4IEC" );
		
	    queryUpdateEmitter.emit(FindAllWindTurbineType3or4IECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType3or4IECProjector.class.getName());

}
