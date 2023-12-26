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
 * Projector for InductancePerLength as outlined for the CQRS pattern.  All event handling and query handling related to InductancePerLength are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by InductancePerLengthAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("inductancePerLength")
@Component("inductancePerLength-projector")
public class InductancePerLengthProjector extends InductancePerLengthEntityProjector {
		
	// core constructor
	public InductancePerLengthProjector(InductancePerLengthRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateInductancePerLengthEvent
     */
    @EventHandler( payloadType=CreateInductancePerLengthEvent.class )
    public void handle( CreateInductancePerLengthEvent event) {
	    LOGGER.info("handling CreateInductancePerLengthEvent - " + event );
	    InductancePerLength entity = new InductancePerLength();
        entity.setInductancePerLengthId( event.getInductancePerLengthId() );
        entity.setDenominatorMultiplier( event.getDenominatorMultiplier() );
        entity.setDenominatorUnit( event.getDenominatorUnit() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllInductancePerLength( entity );
    }

    /*
     * @param	event UpdateInductancePerLengthEvent
     */
    @EventHandler( payloadType=UpdateInductancePerLengthEvent.class )
    public void handle( UpdateInductancePerLengthEvent event) {
    	LOGGER.info("handling UpdateInductancePerLengthEvent - " + event );
    	
	    InductancePerLength entity = new InductancePerLength();
        entity.setInductancePerLengthId( event.getInductancePerLengthId() );
        entity.setDenominatorMultiplier( event.getDenominatorMultiplier() );
        entity.setDenominatorUnit( event.getDenominatorUnit() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindInductancePerLength( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllInductancePerLength( entity );        
    }
    
    /*
     * @param	event DeleteInductancePerLengthEvent
     */
    @EventHandler( payloadType=DeleteInductancePerLengthEvent.class )
    public void handle( DeleteInductancePerLengthEvent event) {
    	LOGGER.info("handling DeleteInductancePerLengthEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	InductancePerLength entity = delete( event.getInductancePerLengthId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllInductancePerLength( entity );

    }    




    /**
     * Method to retrieve the InductancePerLength via an InductancePerLengthPrimaryKey.
     * @param 	id Long
     * @return 	InductancePerLength
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public InductancePerLength handle( FindInductancePerLengthQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getInductancePerLengthId() );
    }
    
    /**
     * Method to retrieve a collection of all InductancePerLengths
     *
     * @param	query	FindAllInductancePerLengthQuery 
     * @return 	List<InductancePerLength> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<InductancePerLength> handle( FindAllInductancePerLengthQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindInductancePerLength, 
	 * but only if the id matches
	 * 
	 * @param		entity	InductancePerLength
	 */
	protected void emitFindInductancePerLength( InductancePerLength entity ) {
		LOGGER.info("handling emitFindInductancePerLength" );
		
	    queryUpdateEmitter.emit(FindInductancePerLengthQuery.class,
	                            query -> query.getFilter().getInductancePerLengthId().equals(entity.getInductancePerLengthId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllInductancePerLength
	 * 
	 * @param		entity	InductancePerLength
	 */
	protected void emitFindAllInductancePerLength( InductancePerLength entity ) {
		LOGGER.info("handling emitFindAllInductancePerLength" );
		
	    queryUpdateEmitter.emit(FindAllInductancePerLengthQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(InductancePerLengthProjector.class.getName());

}
