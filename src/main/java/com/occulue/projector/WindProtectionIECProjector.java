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
 * Projector for WindProtectionIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindProtectionIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindProtectionIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windProtectionIEC")
@Component("windProtectionIEC-projector")
public class WindProtectionIECProjector extends WindProtectionIECEntityProjector {
		
	// core constructor
	public WindProtectionIECProjector(WindProtectionIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindProtectionIECEvent
     */
    @EventHandler( payloadType=CreateWindProtectionIECEvent.class )
    public void handle( CreateWindProtectionIECEvent event) {
	    LOGGER.info("handling CreateWindProtectionIECEvent - " + event );
	    WindProtectionIEC entity = new WindProtectionIEC();
        entity.setWindProtectionIECId( event.getWindProtectionIECId() );
        entity.setFover( event.getFover() );
        entity.setFunder( event.getFunder() );
        entity.setTfover( event.getTfover() );
        entity.setTfunder( event.getTfunder() );
        entity.setTuover( event.getTuover() );
        entity.setTuunder( event.getTuunder() );
        entity.setUover( event.getUover() );
        entity.setUunder( event.getUunder() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindProtectionIEC( entity );
    }

    /*
     * @param	event UpdateWindProtectionIECEvent
     */
    @EventHandler( payloadType=UpdateWindProtectionIECEvent.class )
    public void handle( UpdateWindProtectionIECEvent event) {
    	LOGGER.info("handling UpdateWindProtectionIECEvent - " + event );
    	
	    WindProtectionIEC entity = new WindProtectionIEC();
        entity.setWindProtectionIECId( event.getWindProtectionIECId() );
        entity.setFover( event.getFover() );
        entity.setFunder( event.getFunder() );
        entity.setTfover( event.getTfover() );
        entity.setTfunder( event.getTfunder() );
        entity.setTuover( event.getTuover() );
        entity.setTuunder( event.getTuunder() );
        entity.setUover( event.getUover() );
        entity.setUunder( event.getUunder() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindProtectionIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindProtectionIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindProtectionIECEvent
     */
    @EventHandler( payloadType=DeleteWindProtectionIECEvent.class )
    public void handle( DeleteWindProtectionIECEvent event) {
    	LOGGER.info("handling DeleteWindProtectionIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindProtectionIEC entity = delete( event.getWindProtectionIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindProtectionIEC( entity );

    }    




    /**
     * Method to retrieve the WindProtectionIEC via an WindProtectionIECPrimaryKey.
     * @param 	id Long
     * @return 	WindProtectionIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindProtectionIEC handle( FindWindProtectionIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindProtectionIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindProtectionIECs
     *
     * @param	query	FindAllWindProtectionIECQuery 
     * @return 	List<WindProtectionIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindProtectionIEC> handle( FindAllWindProtectionIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindProtectionIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindProtectionIEC
	 */
	protected void emitFindWindProtectionIEC( WindProtectionIEC entity ) {
		LOGGER.info("handling emitFindWindProtectionIEC" );
		
	    queryUpdateEmitter.emit(FindWindProtectionIECQuery.class,
	                            query -> query.getFilter().getWindProtectionIECId().equals(entity.getWindProtectionIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindProtectionIEC
	 * 
	 * @param		entity	WindProtectionIEC
	 */
	protected void emitFindAllWindProtectionIEC( WindProtectionIEC entity ) {
		LOGGER.info("handling emitFindAllWindProtectionIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindProtectionIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindProtectionIECProjector.class.getName());

}
