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
 * Projector for DCShunt as outlined for the CQRS pattern.  All event handling and query handling related to DCShunt are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCShuntAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCShunt")
@Component("dCShunt-projector")
public class DCShuntProjector extends DCShuntEntityProjector {
		
	// core constructor
	public DCShuntProjector(DCShuntRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCShuntEvent
     */
    @EventHandler( payloadType=CreateDCShuntEvent.class )
    public void handle( CreateDCShuntEvent event) {
	    LOGGER.info("handling CreateDCShuntEvent - " + event );
	    DCShunt entity = new DCShunt();
        entity.setDCShuntId( event.getDCShuntId() );
        entity.setCapacitance( event.getCapacitance() );
        entity.setRatedUdc( event.getRatedUdc() );
        entity.setResistance( event.getResistance() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCShunt( entity );
    }

    /*
     * @param	event UpdateDCShuntEvent
     */
    @EventHandler( payloadType=UpdateDCShuntEvent.class )
    public void handle( UpdateDCShuntEvent event) {
    	LOGGER.info("handling UpdateDCShuntEvent - " + event );
    	
	    DCShunt entity = new DCShunt();
        entity.setDCShuntId( event.getDCShuntId() );
        entity.setCapacitance( event.getCapacitance() );
        entity.setRatedUdc( event.getRatedUdc() );
        entity.setResistance( event.getResistance() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCShunt( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCShunt( entity );        
    }
    
    /*
     * @param	event DeleteDCShuntEvent
     */
    @EventHandler( payloadType=DeleteDCShuntEvent.class )
    public void handle( DeleteDCShuntEvent event) {
    	LOGGER.info("handling DeleteDCShuntEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCShunt entity = delete( event.getDCShuntId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCShunt( entity );

    }    




    /**
     * Method to retrieve the DCShunt via an DCShuntPrimaryKey.
     * @param 	id Long
     * @return 	DCShunt
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCShunt handle( FindDCShuntQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCShuntId() );
    }
    
    /**
     * Method to retrieve a collection of all DCShunts
     *
     * @param	query	FindAllDCShuntQuery 
     * @return 	List<DCShunt> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCShunt> handle( FindAllDCShuntQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCShunt, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCShunt
	 */
	protected void emitFindDCShunt( DCShunt entity ) {
		LOGGER.info("handling emitFindDCShunt" );
		
	    queryUpdateEmitter.emit(FindDCShuntQuery.class,
	                            query -> query.getFilter().getDCShuntId().equals(entity.getDCShuntId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCShunt
	 * 
	 * @param		entity	DCShunt
	 */
	protected void emitFindAllDCShunt( DCShunt entity ) {
		LOGGER.info("handling emitFindAllDCShunt" );
		
	    queryUpdateEmitter.emit(FindAllDCShuntQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCShuntProjector.class.getName());

}
