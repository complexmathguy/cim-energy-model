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
 * Projector for WindContCurrLimIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindContCurrLimIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindContCurrLimIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windContCurrLimIEC")
@Component("windContCurrLimIEC-projector")
public class WindContCurrLimIECProjector extends WindContCurrLimIECEntityProjector {
		
	// core constructor
	public WindContCurrLimIECProjector(WindContCurrLimIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindContCurrLimIECEvent
     */
    @EventHandler( payloadType=CreateWindContCurrLimIECEvent.class )
    public void handle( CreateWindContCurrLimIECEvent event) {
	    LOGGER.info("handling CreateWindContCurrLimIECEvent - " + event );
	    WindContCurrLimIEC entity = new WindContCurrLimIEC();
        entity.setWindContCurrLimIECId( event.getWindContCurrLimIECId() );
        entity.setImax( event.getImax() );
        entity.setImaxdip( event.getImaxdip() );
        entity.setMdfslim( event.getMdfslim() );
        entity.setMqpri( event.getMqpri() );
        entity.setTufilt( event.getTufilt() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContCurrLimIEC( entity );
    }

    /*
     * @param	event UpdateWindContCurrLimIECEvent
     */
    @EventHandler( payloadType=UpdateWindContCurrLimIECEvent.class )
    public void handle( UpdateWindContCurrLimIECEvent event) {
    	LOGGER.info("handling UpdateWindContCurrLimIECEvent - " + event );
    	
	    WindContCurrLimIEC entity = new WindContCurrLimIEC();
        entity.setWindContCurrLimIECId( event.getWindContCurrLimIECId() );
        entity.setImax( event.getImax() );
        entity.setImaxdip( event.getImaxdip() );
        entity.setMdfslim( event.getMdfslim() );
        entity.setMqpri( event.getMqpri() );
        entity.setTufilt( event.getTufilt() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindContCurrLimIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContCurrLimIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindContCurrLimIECEvent
     */
    @EventHandler( payloadType=DeleteWindContCurrLimIECEvent.class )
    public void handle( DeleteWindContCurrLimIECEvent event) {
    	LOGGER.info("handling DeleteWindContCurrLimIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindContCurrLimIEC entity = delete( event.getWindContCurrLimIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContCurrLimIEC( entity );

    }    




    /**
     * Method to retrieve the WindContCurrLimIEC via an WindContCurrLimIECPrimaryKey.
     * @param 	id Long
     * @return 	WindContCurrLimIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindContCurrLimIEC handle( FindWindContCurrLimIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindContCurrLimIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindContCurrLimIECs
     *
     * @param	query	FindAllWindContCurrLimIECQuery 
     * @return 	List<WindContCurrLimIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindContCurrLimIEC> handle( FindAllWindContCurrLimIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindContCurrLimIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindContCurrLimIEC
	 */
	protected void emitFindWindContCurrLimIEC( WindContCurrLimIEC entity ) {
		LOGGER.info("handling emitFindWindContCurrLimIEC" );
		
	    queryUpdateEmitter.emit(FindWindContCurrLimIECQuery.class,
	                            query -> query.getFilter().getWindContCurrLimIECId().equals(entity.getWindContCurrLimIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindContCurrLimIEC
	 * 
	 * @param		entity	WindContCurrLimIEC
	 */
	protected void emitFindAllWindContCurrLimIEC( WindContCurrLimIEC entity ) {
		LOGGER.info("handling emitFindAllWindContCurrLimIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindContCurrLimIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindContCurrLimIECProjector.class.getName());

}
