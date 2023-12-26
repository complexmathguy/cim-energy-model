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
 * Projector for GeneratingUnit as outlined for the CQRS pattern.  All event handling and query handling related to GeneratingUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("generatingUnit")
@Component("generatingUnit-projector")
public class GeneratingUnitProjector extends GeneratingUnitEntityProjector {
		
	// core constructor
	public GeneratingUnitProjector(GeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGeneratingUnitEvent
     */
    @EventHandler( payloadType=CreateGeneratingUnitEvent.class )
    public void handle( CreateGeneratingUnitEvent event) {
	    LOGGER.info("handling CreateGeneratingUnitEvent - " + event );
	    GeneratingUnit entity = new GeneratingUnit();
        entity.setGeneratingUnitId( event.getGeneratingUnitId() );
        entity.setGenControlSource( event.getGenControlSource() );
        entity.setGovernorSCD( event.getGovernorSCD() );
        entity.setInitialP( event.getInitialP() );
        entity.setLongPF( event.getLongPF() );
        entity.setMaximumAllowableSpinningReserve( event.getMaximumAllowableSpinningReserve() );
        entity.setMaxOperatingP( event.getMaxOperatingP() );
        entity.setMinOperatingP( event.getMinOperatingP() );
        entity.setNominalP( event.getNominalP() );
        entity.setRatedGrossMaxP( event.getRatedGrossMaxP() );
        entity.setRatedGrossMinP( event.getRatedGrossMinP() );
        entity.setRatedNetMaxP( event.getRatedNetMaxP() );
        entity.setShortPF( event.getShortPF() );
        entity.setStartupCost( event.getStartupCost() );
        entity.setTotalEfficiency( event.getTotalEfficiency() );
        entity.setVariableCost( event.getVariableCost() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeneratingUnit( entity );
    }

    /*
     * @param	event UpdateGeneratingUnitEvent
     */
    @EventHandler( payloadType=UpdateGeneratingUnitEvent.class )
    public void handle( UpdateGeneratingUnitEvent event) {
    	LOGGER.info("handling UpdateGeneratingUnitEvent - " + event );
    	
	    GeneratingUnit entity = new GeneratingUnit();
        entity.setGeneratingUnitId( event.getGeneratingUnitId() );
        entity.setGenControlSource( event.getGenControlSource() );
        entity.setGovernorSCD( event.getGovernorSCD() );
        entity.setInitialP( event.getInitialP() );
        entity.setLongPF( event.getLongPF() );
        entity.setMaximumAllowableSpinningReserve( event.getMaximumAllowableSpinningReserve() );
        entity.setMaxOperatingP( event.getMaxOperatingP() );
        entity.setMinOperatingP( event.getMinOperatingP() );
        entity.setNominalP( event.getNominalP() );
        entity.setRatedGrossMaxP( event.getRatedGrossMaxP() );
        entity.setRatedGrossMinP( event.getRatedGrossMinP() );
        entity.setRatedNetMaxP( event.getRatedNetMaxP() );
        entity.setShortPF( event.getShortPF() );
        entity.setStartupCost( event.getStartupCost() );
        entity.setTotalEfficiency( event.getTotalEfficiency() );
        entity.setVariableCost( event.getVariableCost() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGeneratingUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeneratingUnit( entity );        
    }
    
    /*
     * @param	event DeleteGeneratingUnitEvent
     */
    @EventHandler( payloadType=DeleteGeneratingUnitEvent.class )
    public void handle( DeleteGeneratingUnitEvent event) {
    	LOGGER.info("handling DeleteGeneratingUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GeneratingUnit entity = delete( event.getGeneratingUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeneratingUnit( entity );

    }    




    /**
     * Method to retrieve the GeneratingUnit via an GeneratingUnitPrimaryKey.
     * @param 	id Long
     * @return 	GeneratingUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GeneratingUnit handle( FindGeneratingUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGeneratingUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all GeneratingUnits
     *
     * @param	query	FindAllGeneratingUnitQuery 
     * @return 	List<GeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GeneratingUnit> handle( FindAllGeneratingUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGeneratingUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	GeneratingUnit
	 */
	protected void emitFindGeneratingUnit( GeneratingUnit entity ) {
		LOGGER.info("handling emitFindGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindGeneratingUnitQuery.class,
	                            query -> query.getFilter().getGeneratingUnitId().equals(entity.getGeneratingUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGeneratingUnit
	 * 
	 * @param		entity	GeneratingUnit
	 */
	protected void emitFindAllGeneratingUnit( GeneratingUnit entity ) {
		LOGGER.info("handling emitFindAllGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindAllGeneratingUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GeneratingUnitProjector.class.getName());

}
