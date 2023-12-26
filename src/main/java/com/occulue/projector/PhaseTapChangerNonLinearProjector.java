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
 * Projector for PhaseTapChangerNonLinear as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChangerNonLinear are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerNonLinearAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChangerNonLinear")
@Component("phaseTapChangerNonLinear-projector")
public class PhaseTapChangerNonLinearProjector extends PhaseTapChangerNonLinearEntityProjector {
		
	// core constructor
	public PhaseTapChangerNonLinearProjector(PhaseTapChangerNonLinearRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerNonLinearEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerNonLinearEvent.class )
    public void handle( CreatePhaseTapChangerNonLinearEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerNonLinearEvent - " + event );
	    PhaseTapChangerNonLinear entity = new PhaseTapChangerNonLinear();
        entity.setPhaseTapChangerNonLinearId( event.getPhaseTapChangerNonLinearId() );
        entity.setVoltageStepIncrement( event.getVoltageStepIncrement() );
        entity.setXMax( event.getXMax() );
        entity.setXMin( event.getXMin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerNonLinear( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerNonLinearEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerNonLinearEvent.class )
    public void handle( UpdatePhaseTapChangerNonLinearEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerNonLinearEvent - " + event );
    	
	    PhaseTapChangerNonLinear entity = new PhaseTapChangerNonLinear();
        entity.setPhaseTapChangerNonLinearId( event.getPhaseTapChangerNonLinearId() );
        entity.setVoltageStepIncrement( event.getVoltageStepIncrement() );
        entity.setXMax( event.getXMax() );
        entity.setXMin( event.getXMin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChangerNonLinear( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerNonLinear( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerNonLinearEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerNonLinearEvent.class )
    public void handle( DeletePhaseTapChangerNonLinearEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerNonLinearEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChangerNonLinear entity = delete( event.getPhaseTapChangerNonLinearId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerNonLinear( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChangerNonLinear via an PhaseTapChangerNonLinearPrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChangerNonLinear
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChangerNonLinear handle( FindPhaseTapChangerNonLinearQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerNonLinearId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerNonLinears
     *
     * @param	query	FindAllPhaseTapChangerNonLinearQuery 
     * @return 	List<PhaseTapChangerNonLinear> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChangerNonLinear> handle( FindAllPhaseTapChangerNonLinearQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChangerNonLinear, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChangerNonLinear
	 */
	protected void emitFindPhaseTapChangerNonLinear( PhaseTapChangerNonLinear entity ) {
		LOGGER.info("handling emitFindPhaseTapChangerNonLinear" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerNonLinearQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerNonLinearId().equals(entity.getPhaseTapChangerNonLinearId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChangerNonLinear
	 * 
	 * @param		entity	PhaseTapChangerNonLinear
	 */
	protected void emitFindAllPhaseTapChangerNonLinear( PhaseTapChangerNonLinear entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChangerNonLinear" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerNonLinearQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerNonLinearProjector.class.getName());

}
