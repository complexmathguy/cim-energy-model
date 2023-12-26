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
 * Projector for DCConverterUnit as outlined for the CQRS pattern.  All event handling and query handling related to DCConverterUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCConverterUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCConverterUnit")
@Component("dCConverterUnit-projector")
public class DCConverterUnitProjector extends DCConverterUnitEntityProjector {
		
	// core constructor
	public DCConverterUnitProjector(DCConverterUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCConverterUnitEvent
     */
    @EventHandler( payloadType=CreateDCConverterUnitEvent.class )
    public void handle( CreateDCConverterUnitEvent event) {
	    LOGGER.info("handling CreateDCConverterUnitEvent - " + event );
	    DCConverterUnit entity = new DCConverterUnit();
        entity.setDCConverterUnitId( event.getDCConverterUnitId() );
        entity.setOperationMode( event.getOperationMode() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCConverterUnit( entity );
    }

    /*
     * @param	event UpdateDCConverterUnitEvent
     */
    @EventHandler( payloadType=UpdateDCConverterUnitEvent.class )
    public void handle( UpdateDCConverterUnitEvent event) {
    	LOGGER.info("handling UpdateDCConverterUnitEvent - " + event );
    	
	    DCConverterUnit entity = new DCConverterUnit();
        entity.setDCConverterUnitId( event.getDCConverterUnitId() );
        entity.setOperationMode( event.getOperationMode() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCConverterUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCConverterUnit( entity );        
    }
    
    /*
     * @param	event DeleteDCConverterUnitEvent
     */
    @EventHandler( payloadType=DeleteDCConverterUnitEvent.class )
    public void handle( DeleteDCConverterUnitEvent event) {
    	LOGGER.info("handling DeleteDCConverterUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCConverterUnit entity = delete( event.getDCConverterUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCConverterUnit( entity );

    }    




    /**
     * Method to retrieve the DCConverterUnit via an DCConverterUnitPrimaryKey.
     * @param 	id Long
     * @return 	DCConverterUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCConverterUnit handle( FindDCConverterUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCConverterUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all DCConverterUnits
     *
     * @param	query	FindAllDCConverterUnitQuery 
     * @return 	List<DCConverterUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCConverterUnit> handle( FindAllDCConverterUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCConverterUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCConverterUnit
	 */
	protected void emitFindDCConverterUnit( DCConverterUnit entity ) {
		LOGGER.info("handling emitFindDCConverterUnit" );
		
	    queryUpdateEmitter.emit(FindDCConverterUnitQuery.class,
	                            query -> query.getFilter().getDCConverterUnitId().equals(entity.getDCConverterUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCConverterUnit
	 * 
	 * @param		entity	DCConverterUnit
	 */
	protected void emitFindAllDCConverterUnit( DCConverterUnit entity ) {
		LOGGER.info("handling emitFindAllDCConverterUnit" );
		
	    queryUpdateEmitter.emit(FindAllDCConverterUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCConverterUnitProjector.class.getName());

}
