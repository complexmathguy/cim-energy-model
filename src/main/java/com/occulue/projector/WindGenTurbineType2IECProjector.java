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
 * Projector for WindGenTurbineType2IEC as outlined for the CQRS pattern.  All event handling and query handling related to WindGenTurbineType2IEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGenTurbineType2IECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGenTurbineType2IEC")
@Component("windGenTurbineType2IEC-projector")
public class WindGenTurbineType2IECProjector extends WindGenTurbineType2IECEntityProjector {
		
	// core constructor
	public WindGenTurbineType2IECProjector(WindGenTurbineType2IECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGenTurbineType2IECEvent
     */
    @EventHandler( payloadType=CreateWindGenTurbineType2IECEvent.class )
    public void handle( CreateWindGenTurbineType2IECEvent event) {
	    LOGGER.info("handling CreateWindGenTurbineType2IECEvent - " + event );
	    WindGenTurbineType2IEC entity = new WindGenTurbineType2IEC();
        entity.setWindGenTurbineType2IECId( event.getWindGenTurbineType2IECId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType2IEC( entity );
    }

    /*
     * @param	event UpdateWindGenTurbineType2IECEvent
     */
    @EventHandler( payloadType=UpdateWindGenTurbineType2IECEvent.class )
    public void handle( UpdateWindGenTurbineType2IECEvent event) {
    	LOGGER.info("handling UpdateWindGenTurbineType2IECEvent - " + event );
    	
	    WindGenTurbineType2IEC entity = new WindGenTurbineType2IEC();
        entity.setWindGenTurbineType2IECId( event.getWindGenTurbineType2IECId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGenTurbineType2IEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType2IEC( entity );        
    }
    
    /*
     * @param	event DeleteWindGenTurbineType2IECEvent
     */
    @EventHandler( payloadType=DeleteWindGenTurbineType2IECEvent.class )
    public void handle( DeleteWindGenTurbineType2IECEvent event) {
    	LOGGER.info("handling DeleteWindGenTurbineType2IECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGenTurbineType2IEC entity = delete( event.getWindGenTurbineType2IECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType2IEC( entity );

    }    




    /**
     * Method to retrieve the WindGenTurbineType2IEC via an WindGenTurbineType2IECPrimaryKey.
     * @param 	id Long
     * @return 	WindGenTurbineType2IEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGenTurbineType2IEC handle( FindWindGenTurbineType2IECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGenTurbineType2IECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType2IECs
     *
     * @param	query	FindAllWindGenTurbineType2IECQuery 
     * @return 	List<WindGenTurbineType2IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGenTurbineType2IEC> handle( FindAllWindGenTurbineType2IECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGenTurbineType2IEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGenTurbineType2IEC
	 */
	protected void emitFindWindGenTurbineType2IEC( WindGenTurbineType2IEC entity ) {
		LOGGER.info("handling emitFindWindGenTurbineType2IEC" );
		
	    queryUpdateEmitter.emit(FindWindGenTurbineType2IECQuery.class,
	                            query -> query.getFilter().getWindGenTurbineType2IECId().equals(entity.getWindGenTurbineType2IECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGenTurbineType2IEC
	 * 
	 * @param		entity	WindGenTurbineType2IEC
	 */
	protected void emitFindAllWindGenTurbineType2IEC( WindGenTurbineType2IEC entity ) {
		LOGGER.info("handling emitFindAllWindGenTurbineType2IEC" );
		
	    queryUpdateEmitter.emit(FindAllWindGenTurbineType2IECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType2IECProjector.class.getName());

}
