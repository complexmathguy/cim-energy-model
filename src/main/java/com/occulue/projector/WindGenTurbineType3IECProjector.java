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
 * Projector for WindGenTurbineType3IEC as outlined for the CQRS pattern.  All event handling and query handling related to WindGenTurbineType3IEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGenTurbineType3IECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGenTurbineType3IEC")
@Component("windGenTurbineType3IEC-projector")
public class WindGenTurbineType3IECProjector extends WindGenTurbineType3IECEntityProjector {
		
	// core constructor
	public WindGenTurbineType3IECProjector(WindGenTurbineType3IECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGenTurbineType3IECEvent
     */
    @EventHandler( payloadType=CreateWindGenTurbineType3IECEvent.class )
    public void handle( CreateWindGenTurbineType3IECEvent event) {
	    LOGGER.info("handling CreateWindGenTurbineType3IECEvent - " + event );
	    WindGenTurbineType3IEC entity = new WindGenTurbineType3IEC();
        entity.setWindGenTurbineType3IECId( event.getWindGenTurbineType3IECId() );
        entity.setDipmax( event.getDipmax() );
        entity.setDiqmax( event.getDiqmax() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3IEC( entity );
    }

    /*
     * @param	event UpdateWindGenTurbineType3IECEvent
     */
    @EventHandler( payloadType=UpdateWindGenTurbineType3IECEvent.class )
    public void handle( UpdateWindGenTurbineType3IECEvent event) {
    	LOGGER.info("handling UpdateWindGenTurbineType3IECEvent - " + event );
    	
	    WindGenTurbineType3IEC entity = new WindGenTurbineType3IEC();
        entity.setWindGenTurbineType3IECId( event.getWindGenTurbineType3IECId() );
        entity.setDipmax( event.getDipmax() );
        entity.setDiqmax( event.getDiqmax() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGenTurbineType3IEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3IEC( entity );        
    }
    
    /*
     * @param	event DeleteWindGenTurbineType3IECEvent
     */
    @EventHandler( payloadType=DeleteWindGenTurbineType3IECEvent.class )
    public void handle( DeleteWindGenTurbineType3IECEvent event) {
    	LOGGER.info("handling DeleteWindGenTurbineType3IECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGenTurbineType3IEC entity = delete( event.getWindGenTurbineType3IECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3IEC( entity );

    }    




    /**
     * Method to retrieve the WindGenTurbineType3IEC via an WindGenTurbineType3IECPrimaryKey.
     * @param 	id Long
     * @return 	WindGenTurbineType3IEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGenTurbineType3IEC handle( FindWindGenTurbineType3IECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGenTurbineType3IECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType3IECs
     *
     * @param	query	FindAllWindGenTurbineType3IECQuery 
     * @return 	List<WindGenTurbineType3IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGenTurbineType3IEC> handle( FindAllWindGenTurbineType3IECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGenTurbineType3IEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGenTurbineType3IEC
	 */
	protected void emitFindWindGenTurbineType3IEC( WindGenTurbineType3IEC entity ) {
		LOGGER.info("handling emitFindWindGenTurbineType3IEC" );
		
	    queryUpdateEmitter.emit(FindWindGenTurbineType3IECQuery.class,
	                            query -> query.getFilter().getWindGenTurbineType3IECId().equals(entity.getWindGenTurbineType3IECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGenTurbineType3IEC
	 * 
	 * @param		entity	WindGenTurbineType3IEC
	 */
	protected void emitFindAllWindGenTurbineType3IEC( WindGenTurbineType3IEC entity ) {
		LOGGER.info("handling emitFindAllWindGenTurbineType3IEC" );
		
	    queryUpdateEmitter.emit(FindAllWindGenTurbineType3IECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3IECProjector.class.getName());

}
