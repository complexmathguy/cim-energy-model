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
 * Projector for WindPitchContEmulIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindPitchContEmulIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindPitchContEmulIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windPitchContEmulIEC")
@Component("windPitchContEmulIEC-projector")
public class WindPitchContEmulIECProjector extends WindPitchContEmulIECEntityProjector {
		
	// core constructor
	public WindPitchContEmulIECProjector(WindPitchContEmulIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindPitchContEmulIECEvent
     */
    @EventHandler( payloadType=CreateWindPitchContEmulIECEvent.class )
    public void handle( CreateWindPitchContEmulIECEvent event) {
	    LOGGER.info("handling CreateWindPitchContEmulIECEvent - " + event );
	    WindPitchContEmulIEC entity = new WindPitchContEmulIEC();
        entity.setWindPitchContEmulIECId( event.getWindPitchContEmulIECId() );
        entity.setKdroop( event.getKdroop() );
        entity.setKipce( event.getKipce() );
        entity.setKomegaaero( event.getKomegaaero() );
        entity.setKppce( event.getKppce() );
        entity.setOmegaref( event.getOmegaref() );
        entity.setPimax( event.getPimax() );
        entity.setPimin( event.getPimin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setTpe( event.getTpe() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPitchContEmulIEC( entity );
    }

    /*
     * @param	event UpdateWindPitchContEmulIECEvent
     */
    @EventHandler( payloadType=UpdateWindPitchContEmulIECEvent.class )
    public void handle( UpdateWindPitchContEmulIECEvent event) {
    	LOGGER.info("handling UpdateWindPitchContEmulIECEvent - " + event );
    	
	    WindPitchContEmulIEC entity = new WindPitchContEmulIEC();
        entity.setWindPitchContEmulIECId( event.getWindPitchContEmulIECId() );
        entity.setKdroop( event.getKdroop() );
        entity.setKipce( event.getKipce() );
        entity.setKomegaaero( event.getKomegaaero() );
        entity.setKppce( event.getKppce() );
        entity.setOmegaref( event.getOmegaref() );
        entity.setPimax( event.getPimax() );
        entity.setPimin( event.getPimin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setTpe( event.getTpe() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindPitchContEmulIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPitchContEmulIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindPitchContEmulIECEvent
     */
    @EventHandler( payloadType=DeleteWindPitchContEmulIECEvent.class )
    public void handle( DeleteWindPitchContEmulIECEvent event) {
    	LOGGER.info("handling DeleteWindPitchContEmulIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindPitchContEmulIEC entity = delete( event.getWindPitchContEmulIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPitchContEmulIEC( entity );

    }    




    /**
     * Method to retrieve the WindPitchContEmulIEC via an WindPitchContEmulIECPrimaryKey.
     * @param 	id Long
     * @return 	WindPitchContEmulIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindPitchContEmulIEC handle( FindWindPitchContEmulIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindPitchContEmulIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindPitchContEmulIECs
     *
     * @param	query	FindAllWindPitchContEmulIECQuery 
     * @return 	List<WindPitchContEmulIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindPitchContEmulIEC> handle( FindAllWindPitchContEmulIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindPitchContEmulIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindPitchContEmulIEC
	 */
	protected void emitFindWindPitchContEmulIEC( WindPitchContEmulIEC entity ) {
		LOGGER.info("handling emitFindWindPitchContEmulIEC" );
		
	    queryUpdateEmitter.emit(FindWindPitchContEmulIECQuery.class,
	                            query -> query.getFilter().getWindPitchContEmulIECId().equals(entity.getWindPitchContEmulIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindPitchContEmulIEC
	 * 
	 * @param		entity	WindPitchContEmulIEC
	 */
	protected void emitFindAllWindPitchContEmulIEC( WindPitchContEmulIEC entity ) {
		LOGGER.info("handling emitFindAllWindPitchContEmulIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindPitchContEmulIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindPitchContEmulIECProjector.class.getName());

}
