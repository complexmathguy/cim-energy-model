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
 * Projector for WindContQIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindContQIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindContQIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windContQIEC")
@Component("windContQIEC-projector")
public class WindContQIECProjector extends WindContQIECEntityProjector {
		
	// core constructor
	public WindContQIECProjector(WindContQIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindContQIECEvent
     */
    @EventHandler( payloadType=CreateWindContQIECEvent.class )
    public void handle( CreateWindContQIECEvent event) {
	    LOGGER.info("handling CreateWindContQIECEvent - " + event );
	    WindContQIEC entity = new WindContQIEC();
        entity.setWindContQIECId( event.getWindContQIECId() );
        entity.setIqh1( event.getIqh1() );
        entity.setIqmax( event.getIqmax() );
        entity.setIqmin( event.getIqmin() );
        entity.setIqpost( event.getIqpost() );
        entity.setKiq( event.getKiq() );
        entity.setKiu( event.getKiu() );
        entity.setKpq( event.getKpq() );
        entity.setKpu( event.getKpu() );
        entity.setKqv( event.getKqv() );
        entity.setQmax( event.getQmax() );
        entity.setQmin( event.getQmin() );
        entity.setRdroop( event.getRdroop() );
        entity.setTiq( event.getTiq() );
        entity.setTpfilt( event.getTpfilt() );
        entity.setTpost( event.getTpost() );
        entity.setTqord( event.getTqord() );
        entity.setTufilt( event.getTufilt() );
        entity.setUdb1( event.getUdb1() );
        entity.setUdb2( event.getUdb2() );
        entity.setUmax( event.getUmax() );
        entity.setUmin( event.getUmin() );
        entity.setUqdip( event.getUqdip() );
        entity.setUref0( event.getUref0() );
        entity.setWindLVRTQcontrolModesType( event.getWindLVRTQcontrolModesType() );
        entity.setWindQcontrolModesType( event.getWindQcontrolModesType() );
        entity.setXdroop( event.getXdroop() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContQIEC( entity );
    }

    /*
     * @param	event UpdateWindContQIECEvent
     */
    @EventHandler( payloadType=UpdateWindContQIECEvent.class )
    public void handle( UpdateWindContQIECEvent event) {
    	LOGGER.info("handling UpdateWindContQIECEvent - " + event );
    	
	    WindContQIEC entity = new WindContQIEC();
        entity.setWindContQIECId( event.getWindContQIECId() );
        entity.setIqh1( event.getIqh1() );
        entity.setIqmax( event.getIqmax() );
        entity.setIqmin( event.getIqmin() );
        entity.setIqpost( event.getIqpost() );
        entity.setKiq( event.getKiq() );
        entity.setKiu( event.getKiu() );
        entity.setKpq( event.getKpq() );
        entity.setKpu( event.getKpu() );
        entity.setKqv( event.getKqv() );
        entity.setQmax( event.getQmax() );
        entity.setQmin( event.getQmin() );
        entity.setRdroop( event.getRdroop() );
        entity.setTiq( event.getTiq() );
        entity.setTpfilt( event.getTpfilt() );
        entity.setTpost( event.getTpost() );
        entity.setTqord( event.getTqord() );
        entity.setTufilt( event.getTufilt() );
        entity.setUdb1( event.getUdb1() );
        entity.setUdb2( event.getUdb2() );
        entity.setUmax( event.getUmax() );
        entity.setUmin( event.getUmin() );
        entity.setUqdip( event.getUqdip() );
        entity.setUref0( event.getUref0() );
        entity.setWindLVRTQcontrolModesType( event.getWindLVRTQcontrolModesType() );
        entity.setWindQcontrolModesType( event.getWindQcontrolModesType() );
        entity.setXdroop( event.getXdroop() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindContQIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContQIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindContQIECEvent
     */
    @EventHandler( payloadType=DeleteWindContQIECEvent.class )
    public void handle( DeleteWindContQIECEvent event) {
    	LOGGER.info("handling DeleteWindContQIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindContQIEC entity = delete( event.getWindContQIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContQIEC( entity );

    }    




    /**
     * Method to retrieve the WindContQIEC via an WindContQIECPrimaryKey.
     * @param 	id Long
     * @return 	WindContQIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindContQIEC handle( FindWindContQIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindContQIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindContQIECs
     *
     * @param	query	FindAllWindContQIECQuery 
     * @return 	List<WindContQIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindContQIEC> handle( FindAllWindContQIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindContQIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindContQIEC
	 */
	protected void emitFindWindContQIEC( WindContQIEC entity ) {
		LOGGER.info("handling emitFindWindContQIEC" );
		
	    queryUpdateEmitter.emit(FindWindContQIECQuery.class,
	                            query -> query.getFilter().getWindContQIECId().equals(entity.getWindContQIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindContQIEC
	 * 
	 * @param		entity	WindContQIEC
	 */
	protected void emitFindAllWindContQIEC( WindContQIEC entity ) {
		LOGGER.info("handling emitFindAllWindContQIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindContQIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindContQIECProjector.class.getName());

}
