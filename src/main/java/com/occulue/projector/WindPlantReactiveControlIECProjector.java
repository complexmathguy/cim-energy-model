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
 * Projector for WindPlantReactiveControlIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindPlantReactiveControlIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindPlantReactiveControlIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windPlantReactiveControlIEC")
@Component("windPlantReactiveControlIEC-projector")
public class WindPlantReactiveControlIECProjector extends WindPlantReactiveControlIECEntityProjector {
		
	// core constructor
	public WindPlantReactiveControlIECProjector(WindPlantReactiveControlIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindPlantReactiveControlIECEvent
     */
    @EventHandler( payloadType=CreateWindPlantReactiveControlIECEvent.class )
    public void handle( CreateWindPlantReactiveControlIECEvent event) {
	    LOGGER.info("handling CreateWindPlantReactiveControlIECEvent - " + event );
	    WindPlantReactiveControlIEC entity = new WindPlantReactiveControlIEC();
        entity.setWindPlantReactiveControlIECId( event.getWindPlantReactiveControlIECId() );
        entity.setKiwpx( event.getKiwpx() );
        entity.setKpwpx( event.getKpwpx() );
        entity.setKwpqu( event.getKwpqu() );
        entity.setMwppf( event.getMwppf() );
        entity.setMwpu( event.getMwpu() );
        entity.setTwppfilt( event.getTwppfilt() );
        entity.setTwpqfilt( event.getTwpqfilt() );
        entity.setTwpufilt( event.getTwpufilt() );
        entity.setTxft( event.getTxft() );
        entity.setTxfv( event.getTxfv() );
        entity.setUwpqdip( event.getUwpqdip() );
        entity.setXrefmax( event.getXrefmax() );
        entity.setXrefmin( event.getXrefmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantReactiveControlIEC( entity );
    }

    /*
     * @param	event UpdateWindPlantReactiveControlIECEvent
     */
    @EventHandler( payloadType=UpdateWindPlantReactiveControlIECEvent.class )
    public void handle( UpdateWindPlantReactiveControlIECEvent event) {
    	LOGGER.info("handling UpdateWindPlantReactiveControlIECEvent - " + event );
    	
	    WindPlantReactiveControlIEC entity = new WindPlantReactiveControlIEC();
        entity.setWindPlantReactiveControlIECId( event.getWindPlantReactiveControlIECId() );
        entity.setKiwpx( event.getKiwpx() );
        entity.setKpwpx( event.getKpwpx() );
        entity.setKwpqu( event.getKwpqu() );
        entity.setMwppf( event.getMwppf() );
        entity.setMwpu( event.getMwpu() );
        entity.setTwppfilt( event.getTwppfilt() );
        entity.setTwpqfilt( event.getTwpqfilt() );
        entity.setTwpufilt( event.getTwpufilt() );
        entity.setTxft( event.getTxft() );
        entity.setTxfv( event.getTxfv() );
        entity.setUwpqdip( event.getUwpqdip() );
        entity.setXrefmax( event.getXrefmax() );
        entity.setXrefmin( event.getXrefmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindPlantReactiveControlIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantReactiveControlIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindPlantReactiveControlIECEvent
     */
    @EventHandler( payloadType=DeleteWindPlantReactiveControlIECEvent.class )
    public void handle( DeleteWindPlantReactiveControlIECEvent event) {
    	LOGGER.info("handling DeleteWindPlantReactiveControlIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindPlantReactiveControlIEC entity = delete( event.getWindPlantReactiveControlIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantReactiveControlIEC( entity );

    }    




    /**
     * Method to retrieve the WindPlantReactiveControlIEC via an WindPlantReactiveControlIECPrimaryKey.
     * @param 	id Long
     * @return 	WindPlantReactiveControlIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindPlantReactiveControlIEC handle( FindWindPlantReactiveControlIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindPlantReactiveControlIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindPlantReactiveControlIECs
     *
     * @param	query	FindAllWindPlantReactiveControlIECQuery 
     * @return 	List<WindPlantReactiveControlIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindPlantReactiveControlIEC> handle( FindAllWindPlantReactiveControlIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindPlantReactiveControlIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindPlantReactiveControlIEC
	 */
	protected void emitFindWindPlantReactiveControlIEC( WindPlantReactiveControlIEC entity ) {
		LOGGER.info("handling emitFindWindPlantReactiveControlIEC" );
		
	    queryUpdateEmitter.emit(FindWindPlantReactiveControlIECQuery.class,
	                            query -> query.getFilter().getWindPlantReactiveControlIECId().equals(entity.getWindPlantReactiveControlIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindPlantReactiveControlIEC
	 * 
	 * @param		entity	WindPlantReactiveControlIEC
	 */
	protected void emitFindAllWindPlantReactiveControlIEC( WindPlantReactiveControlIEC entity ) {
		LOGGER.info("handling emitFindAllWindPlantReactiveControlIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindPlantReactiveControlIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindPlantReactiveControlIECProjector.class.getName());

}
