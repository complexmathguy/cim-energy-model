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
 * Projector for PhaseTapChangerAsymmetrical as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChangerAsymmetrical are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerAsymmetricalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChangerAsymmetrical")
@Component("phaseTapChangerAsymmetrical-projector")
public class PhaseTapChangerAsymmetricalProjector extends PhaseTapChangerAsymmetricalEntityProjector {
		
	// core constructor
	public PhaseTapChangerAsymmetricalProjector(PhaseTapChangerAsymmetricalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerAsymmetricalEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerAsymmetricalEvent.class )
    public void handle( CreatePhaseTapChangerAsymmetricalEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerAsymmetricalEvent - " + event );
	    PhaseTapChangerAsymmetrical entity = new PhaseTapChangerAsymmetrical();
        entity.setPhaseTapChangerAsymmetricalId( event.getPhaseTapChangerAsymmetricalId() );
        entity.setWindingConnectionAngle( event.getWindingConnectionAngle() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerAsymmetrical( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerAsymmetricalEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerAsymmetricalEvent.class )
    public void handle( UpdatePhaseTapChangerAsymmetricalEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerAsymmetricalEvent - " + event );
    	
	    PhaseTapChangerAsymmetrical entity = new PhaseTapChangerAsymmetrical();
        entity.setPhaseTapChangerAsymmetricalId( event.getPhaseTapChangerAsymmetricalId() );
        entity.setWindingConnectionAngle( event.getWindingConnectionAngle() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChangerAsymmetrical( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerAsymmetrical( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerAsymmetricalEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerAsymmetricalEvent.class )
    public void handle( DeletePhaseTapChangerAsymmetricalEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerAsymmetricalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChangerAsymmetrical entity = delete( event.getPhaseTapChangerAsymmetricalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerAsymmetrical( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChangerAsymmetrical via an PhaseTapChangerAsymmetricalPrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChangerAsymmetrical
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChangerAsymmetrical handle( FindPhaseTapChangerAsymmetricalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerAsymmetricalId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerAsymmetricals
     *
     * @param	query	FindAllPhaseTapChangerAsymmetricalQuery 
     * @return 	List<PhaseTapChangerAsymmetrical> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChangerAsymmetrical> handle( FindAllPhaseTapChangerAsymmetricalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChangerAsymmetrical, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChangerAsymmetrical
	 */
	protected void emitFindPhaseTapChangerAsymmetrical( PhaseTapChangerAsymmetrical entity ) {
		LOGGER.info("handling emitFindPhaseTapChangerAsymmetrical" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerAsymmetricalQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerAsymmetricalId().equals(entity.getPhaseTapChangerAsymmetricalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChangerAsymmetrical
	 * 
	 * @param		entity	PhaseTapChangerAsymmetrical
	 */
	protected void emitFindAllPhaseTapChangerAsymmetrical( PhaseTapChangerAsymmetrical entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChangerAsymmetrical" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerAsymmetricalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerAsymmetricalProjector.class.getName());

}
