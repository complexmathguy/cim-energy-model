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
 * Projector for WindGenTurbineType1IEC as outlined for the CQRS pattern.  All event handling and query handling related to WindGenTurbineType1IEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGenTurbineType1IECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGenTurbineType1IEC")
@Component("windGenTurbineType1IEC-projector")
public class WindGenTurbineType1IECProjector extends WindGenTurbineType1IECEntityProjector {
		
	// core constructor
	public WindGenTurbineType1IECProjector(WindGenTurbineType1IECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGenTurbineType1IECEvent
     */
    @EventHandler( payloadType=CreateWindGenTurbineType1IECEvent.class )
    public void handle( CreateWindGenTurbineType1IECEvent event) {
	    LOGGER.info("handling CreateWindGenTurbineType1IECEvent - " + event );
	    WindGenTurbineType1IEC entity = new WindGenTurbineType1IEC();
        entity.setWindGenTurbineType1IECId( event.getWindGenTurbineType1IECId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType1IEC( entity );
    }

    /*
     * @param	event UpdateWindGenTurbineType1IECEvent
     */
    @EventHandler( payloadType=UpdateWindGenTurbineType1IECEvent.class )
    public void handle( UpdateWindGenTurbineType1IECEvent event) {
    	LOGGER.info("handling UpdateWindGenTurbineType1IECEvent - " + event );
    	
	    WindGenTurbineType1IEC entity = new WindGenTurbineType1IEC();
        entity.setWindGenTurbineType1IECId( event.getWindGenTurbineType1IECId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGenTurbineType1IEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType1IEC( entity );        
    }
    
    /*
     * @param	event DeleteWindGenTurbineType1IECEvent
     */
    @EventHandler( payloadType=DeleteWindGenTurbineType1IECEvent.class )
    public void handle( DeleteWindGenTurbineType1IECEvent event) {
    	LOGGER.info("handling DeleteWindGenTurbineType1IECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGenTurbineType1IEC entity = delete( event.getWindGenTurbineType1IECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType1IEC( entity );

    }    




    /**
     * Method to retrieve the WindGenTurbineType1IEC via an WindGenTurbineType1IECPrimaryKey.
     * @param 	id Long
     * @return 	WindGenTurbineType1IEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGenTurbineType1IEC handle( FindWindGenTurbineType1IECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGenTurbineType1IECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType1IECs
     *
     * @param	query	FindAllWindGenTurbineType1IECQuery 
     * @return 	List<WindGenTurbineType1IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGenTurbineType1IEC> handle( FindAllWindGenTurbineType1IECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGenTurbineType1IEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGenTurbineType1IEC
	 */
	protected void emitFindWindGenTurbineType1IEC( WindGenTurbineType1IEC entity ) {
		LOGGER.info("handling emitFindWindGenTurbineType1IEC" );
		
	    queryUpdateEmitter.emit(FindWindGenTurbineType1IECQuery.class,
	                            query -> query.getFilter().getWindGenTurbineType1IECId().equals(entity.getWindGenTurbineType1IECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGenTurbineType1IEC
	 * 
	 * @param		entity	WindGenTurbineType1IEC
	 */
	protected void emitFindAllWindGenTurbineType1IEC( WindGenTurbineType1IEC entity ) {
		LOGGER.info("handling emitFindAllWindGenTurbineType1IEC" );
		
	    queryUpdateEmitter.emit(FindAllWindGenTurbineType1IECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType1IECProjector.class.getName());

}
