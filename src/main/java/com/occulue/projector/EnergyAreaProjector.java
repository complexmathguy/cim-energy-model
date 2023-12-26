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
 * Projector for EnergyArea as outlined for the CQRS pattern.  All event handling and query handling related to EnergyArea are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EnergyAreaAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("energyArea")
@Component("energyArea-projector")
public class EnergyAreaProjector extends EnergyAreaEntityProjector {
		
	// core constructor
	public EnergyAreaProjector(EnergyAreaRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEnergyAreaEvent
     */
    @EventHandler( payloadType=CreateEnergyAreaEvent.class )
    public void handle( CreateEnergyAreaEvent event) {
	    LOGGER.info("handling CreateEnergyAreaEvent - " + event );
	    EnergyArea entity = new EnergyArea();
        entity.setEnergyAreaId( event.getEnergyAreaId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergyArea( entity );
    }

    /*
     * @param	event UpdateEnergyAreaEvent
     */
    @EventHandler( payloadType=UpdateEnergyAreaEvent.class )
    public void handle( UpdateEnergyAreaEvent event) {
    	LOGGER.info("handling UpdateEnergyAreaEvent - " + event );
    	
	    EnergyArea entity = new EnergyArea();
        entity.setEnergyAreaId( event.getEnergyAreaId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEnergyArea( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergyArea( entity );        
    }
    
    /*
     * @param	event DeleteEnergyAreaEvent
     */
    @EventHandler( payloadType=DeleteEnergyAreaEvent.class )
    public void handle( DeleteEnergyAreaEvent event) {
    	LOGGER.info("handling DeleteEnergyAreaEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EnergyArea entity = delete( event.getEnergyAreaId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergyArea( entity );

    }    




    /**
     * Method to retrieve the EnergyArea via an EnergyAreaPrimaryKey.
     * @param 	id Long
     * @return 	EnergyArea
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EnergyArea handle( FindEnergyAreaQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEnergyAreaId() );
    }
    
    /**
     * Method to retrieve a collection of all EnergyAreas
     *
     * @param	query	FindAllEnergyAreaQuery 
     * @return 	List<EnergyArea> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EnergyArea> handle( FindAllEnergyAreaQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEnergyArea, 
	 * but only if the id matches
	 * 
	 * @param		entity	EnergyArea
	 */
	protected void emitFindEnergyArea( EnergyArea entity ) {
		LOGGER.info("handling emitFindEnergyArea" );
		
	    queryUpdateEmitter.emit(FindEnergyAreaQuery.class,
	                            query -> query.getFilter().getEnergyAreaId().equals(entity.getEnergyAreaId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEnergyArea
	 * 
	 * @param		entity	EnergyArea
	 */
	protected void emitFindAllEnergyArea( EnergyArea entity ) {
		LOGGER.info("handling emitFindAllEnergyArea" );
		
	    queryUpdateEmitter.emit(FindAllEnergyAreaQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EnergyAreaProjector.class.getName());

}
