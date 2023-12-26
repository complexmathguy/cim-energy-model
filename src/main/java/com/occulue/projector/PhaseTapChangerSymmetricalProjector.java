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
 * Projector for PhaseTapChangerSymmetrical as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChangerSymmetrical are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerSymmetricalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChangerSymmetrical")
@Component("phaseTapChangerSymmetrical-projector")
public class PhaseTapChangerSymmetricalProjector extends PhaseTapChangerSymmetricalEntityProjector {
		
	// core constructor
	public PhaseTapChangerSymmetricalProjector(PhaseTapChangerSymmetricalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerSymmetricalEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerSymmetricalEvent.class )
    public void handle( CreatePhaseTapChangerSymmetricalEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerSymmetricalEvent - " + event );
	    PhaseTapChangerSymmetrical entity = new PhaseTapChangerSymmetrical();
        entity.setPhaseTapChangerSymmetricalId( event.getPhaseTapChangerSymmetricalId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerSymmetrical( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerSymmetricalEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerSymmetricalEvent.class )
    public void handle( UpdatePhaseTapChangerSymmetricalEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerSymmetricalEvent - " + event );
    	
	    PhaseTapChangerSymmetrical entity = new PhaseTapChangerSymmetrical();
        entity.setPhaseTapChangerSymmetricalId( event.getPhaseTapChangerSymmetricalId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChangerSymmetrical( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerSymmetrical( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerSymmetricalEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerSymmetricalEvent.class )
    public void handle( DeletePhaseTapChangerSymmetricalEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerSymmetricalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChangerSymmetrical entity = delete( event.getPhaseTapChangerSymmetricalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerSymmetrical( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChangerSymmetrical via an PhaseTapChangerSymmetricalPrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChangerSymmetrical
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChangerSymmetrical handle( FindPhaseTapChangerSymmetricalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerSymmetricalId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerSymmetricals
     *
     * @param	query	FindAllPhaseTapChangerSymmetricalQuery 
     * @return 	List<PhaseTapChangerSymmetrical> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChangerSymmetrical> handle( FindAllPhaseTapChangerSymmetricalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChangerSymmetrical, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChangerSymmetrical
	 */
	protected void emitFindPhaseTapChangerSymmetrical( PhaseTapChangerSymmetrical entity ) {
		LOGGER.info("handling emitFindPhaseTapChangerSymmetrical" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerSymmetricalQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerSymmetricalId().equals(entity.getPhaseTapChangerSymmetricalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChangerSymmetrical
	 * 
	 * @param		entity	PhaseTapChangerSymmetrical
	 */
	protected void emitFindAllPhaseTapChangerSymmetrical( PhaseTapChangerSymmetrical entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChangerSymmetrical" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerSymmetricalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerSymmetricalProjector.class.getName());

}
