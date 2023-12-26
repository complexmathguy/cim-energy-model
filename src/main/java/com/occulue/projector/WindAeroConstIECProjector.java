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
 * Projector for WindAeroConstIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindAeroConstIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindAeroConstIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windAeroConstIEC")
@Component("windAeroConstIEC-projector")
public class WindAeroConstIECProjector extends WindAeroConstIECEntityProjector {
		
	// core constructor
	public WindAeroConstIECProjector(WindAeroConstIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindAeroConstIECEvent
     */
    @EventHandler( payloadType=CreateWindAeroConstIECEvent.class )
    public void handle( CreateWindAeroConstIECEvent event) {
	    LOGGER.info("handling CreateWindAeroConstIECEvent - " + event );
	    WindAeroConstIEC entity = new WindAeroConstIEC();
        entity.setWindAeroConstIECId( event.getWindAeroConstIECId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindAeroConstIEC( entity );
    }

    /*
     * @param	event UpdateWindAeroConstIECEvent
     */
    @EventHandler( payloadType=UpdateWindAeroConstIECEvent.class )
    public void handle( UpdateWindAeroConstIECEvent event) {
    	LOGGER.info("handling UpdateWindAeroConstIECEvent - " + event );
    	
	    WindAeroConstIEC entity = new WindAeroConstIEC();
        entity.setWindAeroConstIECId( event.getWindAeroConstIECId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindAeroConstIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindAeroConstIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindAeroConstIECEvent
     */
    @EventHandler( payloadType=DeleteWindAeroConstIECEvent.class )
    public void handle( DeleteWindAeroConstIECEvent event) {
    	LOGGER.info("handling DeleteWindAeroConstIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindAeroConstIEC entity = delete( event.getWindAeroConstIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindAeroConstIEC( entity );

    }    




    /**
     * Method to retrieve the WindAeroConstIEC via an WindAeroConstIECPrimaryKey.
     * @param 	id Long
     * @return 	WindAeroConstIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindAeroConstIEC handle( FindWindAeroConstIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindAeroConstIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindAeroConstIECs
     *
     * @param	query	FindAllWindAeroConstIECQuery 
     * @return 	List<WindAeroConstIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindAeroConstIEC> handle( FindAllWindAeroConstIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindAeroConstIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindAeroConstIEC
	 */
	protected void emitFindWindAeroConstIEC( WindAeroConstIEC entity ) {
		LOGGER.info("handling emitFindWindAeroConstIEC" );
		
	    queryUpdateEmitter.emit(FindWindAeroConstIECQuery.class,
	                            query -> query.getFilter().getWindAeroConstIECId().equals(entity.getWindAeroConstIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindAeroConstIEC
	 * 
	 * @param		entity	WindAeroConstIEC
	 */
	protected void emitFindAllWindAeroConstIEC( WindAeroConstIEC entity ) {
		LOGGER.info("handling emitFindAllWindAeroConstIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindAeroConstIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindAeroConstIECProjector.class.getName());

}
