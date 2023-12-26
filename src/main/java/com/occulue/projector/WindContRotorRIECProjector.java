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
 * Projector for WindContRotorRIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindContRotorRIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindContRotorRIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windContRotorRIEC")
@Component("windContRotorRIEC-projector")
public class WindContRotorRIECProjector extends WindContRotorRIECEntityProjector {
		
	// core constructor
	public WindContRotorRIECProjector(WindContRotorRIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindContRotorRIECEvent
     */
    @EventHandler( payloadType=CreateWindContRotorRIECEvent.class )
    public void handle( CreateWindContRotorRIECEvent event) {
	    LOGGER.info("handling CreateWindContRotorRIECEvent - " + event );
	    WindContRotorRIEC entity = new WindContRotorRIEC();
        entity.setWindContRotorRIECId( event.getWindContRotorRIECId() );
        entity.setKirr( event.getKirr() );
        entity.setKomegafilt( event.getKomegafilt() );
        entity.setKpfilt( event.getKpfilt() );
        entity.setKprr( event.getKprr() );
        entity.setRmax( event.getRmax() );
        entity.setRmin( event.getRmin() );
        entity.setTomegafilt( event.getTomegafilt() );
        entity.setTpfilt( event.getTpfilt() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContRotorRIEC( entity );
    }

    /*
     * @param	event UpdateWindContRotorRIECEvent
     */
    @EventHandler( payloadType=UpdateWindContRotorRIECEvent.class )
    public void handle( UpdateWindContRotorRIECEvent event) {
    	LOGGER.info("handling UpdateWindContRotorRIECEvent - " + event );
    	
	    WindContRotorRIEC entity = new WindContRotorRIEC();
        entity.setWindContRotorRIECId( event.getWindContRotorRIECId() );
        entity.setKirr( event.getKirr() );
        entity.setKomegafilt( event.getKomegafilt() );
        entity.setKpfilt( event.getKpfilt() );
        entity.setKprr( event.getKprr() );
        entity.setRmax( event.getRmax() );
        entity.setRmin( event.getRmin() );
        entity.setTomegafilt( event.getTomegafilt() );
        entity.setTpfilt( event.getTpfilt() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindContRotorRIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContRotorRIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindContRotorRIECEvent
     */
    @EventHandler( payloadType=DeleteWindContRotorRIECEvent.class )
    public void handle( DeleteWindContRotorRIECEvent event) {
    	LOGGER.info("handling DeleteWindContRotorRIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindContRotorRIEC entity = delete( event.getWindContRotorRIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContRotorRIEC( entity );

    }    




    /**
     * Method to retrieve the WindContRotorRIEC via an WindContRotorRIECPrimaryKey.
     * @param 	id Long
     * @return 	WindContRotorRIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindContRotorRIEC handle( FindWindContRotorRIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindContRotorRIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindContRotorRIECs
     *
     * @param	query	FindAllWindContRotorRIECQuery 
     * @return 	List<WindContRotorRIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindContRotorRIEC> handle( FindAllWindContRotorRIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindContRotorRIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindContRotorRIEC
	 */
	protected void emitFindWindContRotorRIEC( WindContRotorRIEC entity ) {
		LOGGER.info("handling emitFindWindContRotorRIEC" );
		
	    queryUpdateEmitter.emit(FindWindContRotorRIECQuery.class,
	                            query -> query.getFilter().getWindContRotorRIECId().equals(entity.getWindContRotorRIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindContRotorRIEC
	 * 
	 * @param		entity	WindContRotorRIEC
	 */
	protected void emitFindAllWindContRotorRIEC( WindContRotorRIEC entity ) {
		LOGGER.info("handling emitFindAllWindContRotorRIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindContRotorRIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindContRotorRIECProjector.class.getName());

}
