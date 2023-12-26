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
 * Projector for WindContPType3IEC as outlined for the CQRS pattern.  All event handling and query handling related to WindContPType3IEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindContPType3IECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windContPType3IEC")
@Component("windContPType3IEC-projector")
public class WindContPType3IECProjector extends WindContPType3IECEntityProjector {
		
	// core constructor
	public WindContPType3IECProjector(WindContPType3IECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindContPType3IECEvent
     */
    @EventHandler( payloadType=CreateWindContPType3IECEvent.class )
    public void handle( CreateWindContPType3IECEvent event) {
	    LOGGER.info("handling CreateWindContPType3IECEvent - " + event );
	    WindContPType3IEC entity = new WindContPType3IEC();
        entity.setWindContPType3IECId( event.getWindContPType3IECId() );
        entity.setDpmax( event.getDpmax() );
        entity.setDtrisemaxlvrt( event.getDtrisemaxlvrt() );
        entity.setKdtd( event.getKdtd() );
        entity.setKip( event.getKip() );
        entity.setKpp( event.getKpp() );
        entity.setMplvrt( event.getMplvrt() );
        entity.setOmegaoffset( event.getOmegaoffset() );
        entity.setPdtdmax( event.getPdtdmax() );
        entity.setRramp( event.getRramp() );
        entity.setTdvs( event.getTdvs() );
        entity.setTemin( event.getTemin() );
        entity.setTomegafilt( event.getTomegafilt() );
        entity.setTpfilt( event.getTpfilt() );
        entity.setTpord( event.getTpord() );
        entity.setTufilt( event.getTufilt() );
        entity.setTuscale( event.getTuscale() );
        entity.setTwref( event.getTwref() );
        entity.setUdvs( event.getUdvs() );
        entity.setUpdip( event.getUpdip() );
        entity.setWdtd( event.getWdtd() );
        entity.setZeta( event.getZeta() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContPType3IEC( entity );
    }

    /*
     * @param	event UpdateWindContPType3IECEvent
     */
    @EventHandler( payloadType=UpdateWindContPType3IECEvent.class )
    public void handle( UpdateWindContPType3IECEvent event) {
    	LOGGER.info("handling UpdateWindContPType3IECEvent - " + event );
    	
	    WindContPType3IEC entity = new WindContPType3IEC();
        entity.setWindContPType3IECId( event.getWindContPType3IECId() );
        entity.setDpmax( event.getDpmax() );
        entity.setDtrisemaxlvrt( event.getDtrisemaxlvrt() );
        entity.setKdtd( event.getKdtd() );
        entity.setKip( event.getKip() );
        entity.setKpp( event.getKpp() );
        entity.setMplvrt( event.getMplvrt() );
        entity.setOmegaoffset( event.getOmegaoffset() );
        entity.setPdtdmax( event.getPdtdmax() );
        entity.setRramp( event.getRramp() );
        entity.setTdvs( event.getTdvs() );
        entity.setTemin( event.getTemin() );
        entity.setTomegafilt( event.getTomegafilt() );
        entity.setTpfilt( event.getTpfilt() );
        entity.setTpord( event.getTpord() );
        entity.setTufilt( event.getTufilt() );
        entity.setTuscale( event.getTuscale() );
        entity.setTwref( event.getTwref() );
        entity.setUdvs( event.getUdvs() );
        entity.setUpdip( event.getUpdip() );
        entity.setWdtd( event.getWdtd() );
        entity.setZeta( event.getZeta() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindContPType3IEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContPType3IEC( entity );        
    }
    
    /*
     * @param	event DeleteWindContPType3IECEvent
     */
    @EventHandler( payloadType=DeleteWindContPType3IECEvent.class )
    public void handle( DeleteWindContPType3IECEvent event) {
    	LOGGER.info("handling DeleteWindContPType3IECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindContPType3IEC entity = delete( event.getWindContPType3IECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContPType3IEC( entity );

    }    




    /**
     * Method to retrieve the WindContPType3IEC via an WindContPType3IECPrimaryKey.
     * @param 	id Long
     * @return 	WindContPType3IEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindContPType3IEC handle( FindWindContPType3IECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindContPType3IECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindContPType3IECs
     *
     * @param	query	FindAllWindContPType3IECQuery 
     * @return 	List<WindContPType3IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindContPType3IEC> handle( FindAllWindContPType3IECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindContPType3IEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindContPType3IEC
	 */
	protected void emitFindWindContPType3IEC( WindContPType3IEC entity ) {
		LOGGER.info("handling emitFindWindContPType3IEC" );
		
	    queryUpdateEmitter.emit(FindWindContPType3IECQuery.class,
	                            query -> query.getFilter().getWindContPType3IECId().equals(entity.getWindContPType3IECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindContPType3IEC
	 * 
	 * @param		entity	WindContPType3IEC
	 */
	protected void emitFindAllWindContPType3IEC( WindContPType3IEC entity ) {
		LOGGER.info("handling emitFindAllWindContPType3IEC" );
		
	    queryUpdateEmitter.emit(FindAllWindContPType3IECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindContPType3IECProjector.class.getName());

}
