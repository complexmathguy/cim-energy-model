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
 * Projector for ACDCConverter as outlined for the CQRS pattern.  All event handling and query handling related to ACDCConverter are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ACDCConverterAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("aCDCConverter")
@Component("aCDCConverter-projector")
public class ACDCConverterProjector extends ACDCConverterEntityProjector {
		
	// core constructor
	public ACDCConverterProjector(ACDCConverterRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateACDCConverterEvent
     */
    @EventHandler( payloadType=CreateACDCConverterEvent.class )
    public void handle( CreateACDCConverterEvent event) {
	    LOGGER.info("handling CreateACDCConverterEvent - " + event );
	    ACDCConverter entity = new ACDCConverter();
        entity.setACDCConverterId( event.getACDCConverterId() );
        entity.setBaseS( event.getBaseS() );
        entity.setIdleLoss( event.getIdleLoss() );
        entity.setMaxUdc( event.getMaxUdc() );
        entity.setMinUdc( event.getMinUdc() );
        entity.setNumberOfValves( event.getNumberOfValves() );
        entity.setRatedUdc( event.getRatedUdc() );
        entity.setResistiveLoss( event.getResistiveLoss() );
        entity.setSwitchingLoss( event.getSwitchingLoss() );
        entity.setValveU0( event.getValveU0() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCConverter( entity );
    }

    /*
     * @param	event UpdateACDCConverterEvent
     */
    @EventHandler( payloadType=UpdateACDCConverterEvent.class )
    public void handle( UpdateACDCConverterEvent event) {
    	LOGGER.info("handling UpdateACDCConverterEvent - " + event );
    	
	    ACDCConverter entity = new ACDCConverter();
        entity.setACDCConverterId( event.getACDCConverterId() );
        entity.setBaseS( event.getBaseS() );
        entity.setIdleLoss( event.getIdleLoss() );
        entity.setMaxUdc( event.getMaxUdc() );
        entity.setMinUdc( event.getMinUdc() );
        entity.setNumberOfValves( event.getNumberOfValves() );
        entity.setRatedUdc( event.getRatedUdc() );
        entity.setResistiveLoss( event.getResistiveLoss() );
        entity.setSwitchingLoss( event.getSwitchingLoss() );
        entity.setValveU0( event.getValveU0() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindACDCConverter( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCConverter( entity );        
    }
    
    /*
     * @param	event DeleteACDCConverterEvent
     */
    @EventHandler( payloadType=DeleteACDCConverterEvent.class )
    public void handle( DeleteACDCConverterEvent event) {
    	LOGGER.info("handling DeleteACDCConverterEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ACDCConverter entity = delete( event.getACDCConverterId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCConverter( entity );

    }    




    /**
     * Method to retrieve the ACDCConverter via an ACDCConverterPrimaryKey.
     * @param 	id Long
     * @return 	ACDCConverter
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ACDCConverter handle( FindACDCConverterQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getACDCConverterId() );
    }
    
    /**
     * Method to retrieve a collection of all ACDCConverters
     *
     * @param	query	FindAllACDCConverterQuery 
     * @return 	List<ACDCConverter> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ACDCConverter> handle( FindAllACDCConverterQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindACDCConverter, 
	 * but only if the id matches
	 * 
	 * @param		entity	ACDCConverter
	 */
	protected void emitFindACDCConverter( ACDCConverter entity ) {
		LOGGER.info("handling emitFindACDCConverter" );
		
	    queryUpdateEmitter.emit(FindACDCConverterQuery.class,
	                            query -> query.getFilter().getACDCConverterId().equals(entity.getACDCConverterId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllACDCConverter
	 * 
	 * @param		entity	ACDCConverter
	 */
	protected void emitFindAllACDCConverter( ACDCConverter entity ) {
		LOGGER.info("handling emitFindAllACDCConverter" );
		
	    queryUpdateEmitter.emit(FindAllACDCConverterQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ACDCConverterProjector.class.getName());

}
