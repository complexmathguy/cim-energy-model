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
 * Projector for WindGenTurbineType3bIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindGenTurbineType3bIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGenTurbineType3bIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGenTurbineType3bIEC")
@Component("windGenTurbineType3bIEC-projector")
public class WindGenTurbineType3bIECProjector extends WindGenTurbineType3bIECEntityProjector {
		
	// core constructor
	public WindGenTurbineType3bIECProjector(WindGenTurbineType3bIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGenTurbineType3bIECEvent
     */
    @EventHandler( payloadType=CreateWindGenTurbineType3bIECEvent.class )
    public void handle( CreateWindGenTurbineType3bIECEvent event) {
	    LOGGER.info("handling CreateWindGenTurbineType3bIECEvent - " + event );
	    WindGenTurbineType3bIEC entity = new WindGenTurbineType3bIEC();
        entity.setWindGenTurbineType3bIECId( event.getWindGenTurbineType3bIECId() );
        entity.setFducw( event.getFducw() );
        entity.setMwtcwp( event.getMwtcwp() );
        entity.setTg( event.getTg() );
        entity.setTwo( event.getTwo() );
        entity.setXs( event.getXs() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3bIEC( entity );
    }

    /*
     * @param	event UpdateWindGenTurbineType3bIECEvent
     */
    @EventHandler( payloadType=UpdateWindGenTurbineType3bIECEvent.class )
    public void handle( UpdateWindGenTurbineType3bIECEvent event) {
    	LOGGER.info("handling UpdateWindGenTurbineType3bIECEvent - " + event );
    	
	    WindGenTurbineType3bIEC entity = new WindGenTurbineType3bIEC();
        entity.setWindGenTurbineType3bIECId( event.getWindGenTurbineType3bIECId() );
        entity.setFducw( event.getFducw() );
        entity.setMwtcwp( event.getMwtcwp() );
        entity.setTg( event.getTg() );
        entity.setTwo( event.getTwo() );
        entity.setXs( event.getXs() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGenTurbineType3bIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3bIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindGenTurbineType3bIECEvent
     */
    @EventHandler( payloadType=DeleteWindGenTurbineType3bIECEvent.class )
    public void handle( DeleteWindGenTurbineType3bIECEvent event) {
    	LOGGER.info("handling DeleteWindGenTurbineType3bIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGenTurbineType3bIEC entity = delete( event.getWindGenTurbineType3bIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3bIEC( entity );

    }    




    /**
     * Method to retrieve the WindGenTurbineType3bIEC via an WindGenTurbineType3bIECPrimaryKey.
     * @param 	id Long
     * @return 	WindGenTurbineType3bIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGenTurbineType3bIEC handle( FindWindGenTurbineType3bIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGenTurbineType3bIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType3bIECs
     *
     * @param	query	FindAllWindGenTurbineType3bIECQuery 
     * @return 	List<WindGenTurbineType3bIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGenTurbineType3bIEC> handle( FindAllWindGenTurbineType3bIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGenTurbineType3bIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGenTurbineType3bIEC
	 */
	protected void emitFindWindGenTurbineType3bIEC( WindGenTurbineType3bIEC entity ) {
		LOGGER.info("handling emitFindWindGenTurbineType3bIEC" );
		
	    queryUpdateEmitter.emit(FindWindGenTurbineType3bIECQuery.class,
	                            query -> query.getFilter().getWindGenTurbineType3bIECId().equals(entity.getWindGenTurbineType3bIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGenTurbineType3bIEC
	 * 
	 * @param		entity	WindGenTurbineType3bIEC
	 */
	protected void emitFindAllWindGenTurbineType3bIEC( WindGenTurbineType3bIEC entity ) {
		LOGGER.info("handling emitFindAllWindGenTurbineType3bIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindGenTurbineType3bIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3bIECProjector.class.getName());

}
