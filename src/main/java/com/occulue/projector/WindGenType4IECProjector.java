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
 * Projector for WindGenType4IEC as outlined for the CQRS pattern.  All event handling and query handling related to WindGenType4IEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGenType4IECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGenType4IEC")
@Component("windGenType4IEC-projector")
public class WindGenType4IECProjector extends WindGenType4IECEntityProjector {
		
	// core constructor
	public WindGenType4IECProjector(WindGenType4IECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGenType4IECEvent
     */
    @EventHandler( payloadType=CreateWindGenType4IECEvent.class )
    public void handle( CreateWindGenType4IECEvent event) {
	    LOGGER.info("handling CreateWindGenType4IECEvent - " + event );
	    WindGenType4IEC entity = new WindGenType4IEC();
        entity.setWindGenType4IECId( event.getWindGenType4IECId() );
        entity.setDipmax( event.getDipmax() );
        entity.setDiqmax( event.getDiqmax() );
        entity.setDiqmin( event.getDiqmin() );
        entity.setTg( event.getTg() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenType4IEC( entity );
    }

    /*
     * @param	event UpdateWindGenType4IECEvent
     */
    @EventHandler( payloadType=UpdateWindGenType4IECEvent.class )
    public void handle( UpdateWindGenType4IECEvent event) {
    	LOGGER.info("handling UpdateWindGenType4IECEvent - " + event );
    	
	    WindGenType4IEC entity = new WindGenType4IEC();
        entity.setWindGenType4IECId( event.getWindGenType4IECId() );
        entity.setDipmax( event.getDipmax() );
        entity.setDiqmax( event.getDiqmax() );
        entity.setDiqmin( event.getDiqmin() );
        entity.setTg( event.getTg() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGenType4IEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenType4IEC( entity );        
    }
    
    /*
     * @param	event DeleteWindGenType4IECEvent
     */
    @EventHandler( payloadType=DeleteWindGenType4IECEvent.class )
    public void handle( DeleteWindGenType4IECEvent event) {
    	LOGGER.info("handling DeleteWindGenType4IECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGenType4IEC entity = delete( event.getWindGenType4IECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenType4IEC( entity );

    }    




    /**
     * Method to retrieve the WindGenType4IEC via an WindGenType4IECPrimaryKey.
     * @param 	id Long
     * @return 	WindGenType4IEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGenType4IEC handle( FindWindGenType4IECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGenType4IECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGenType4IECs
     *
     * @param	query	FindAllWindGenType4IECQuery 
     * @return 	List<WindGenType4IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGenType4IEC> handle( FindAllWindGenType4IECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGenType4IEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGenType4IEC
	 */
	protected void emitFindWindGenType4IEC( WindGenType4IEC entity ) {
		LOGGER.info("handling emitFindWindGenType4IEC" );
		
	    queryUpdateEmitter.emit(FindWindGenType4IECQuery.class,
	                            query -> query.getFilter().getWindGenType4IECId().equals(entity.getWindGenType4IECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGenType4IEC
	 * 
	 * @param		entity	WindGenType4IEC
	 */
	protected void emitFindAllWindGenType4IEC( WindGenType4IEC entity ) {
		LOGGER.info("handling emitFindAllWindGenType4IEC" );
		
	    queryUpdateEmitter.emit(FindAllWindGenType4IECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGenType4IECProjector.class.getName());

}
