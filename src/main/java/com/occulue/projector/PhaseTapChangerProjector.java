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
 * Projector for PhaseTapChanger as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChanger are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChanger")
@Component("phaseTapChanger-projector")
public class PhaseTapChangerProjector extends PhaseTapChangerEntityProjector {
		
	// core constructor
	public PhaseTapChangerProjector(PhaseTapChangerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerEvent.class )
    public void handle( CreatePhaseTapChangerEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerEvent - " + event );
	    PhaseTapChanger entity = new PhaseTapChanger();
        entity.setPhaseTapChangerId( event.getPhaseTapChangerId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChanger( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerEvent.class )
    public void handle( UpdatePhaseTapChangerEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerEvent - " + event );
    	
	    PhaseTapChanger entity = new PhaseTapChanger();
        entity.setPhaseTapChangerId( event.getPhaseTapChangerId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChanger( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChanger( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerEvent.class )
    public void handle( DeletePhaseTapChangerEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChanger entity = delete( event.getPhaseTapChangerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChanger( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChanger via an PhaseTapChangerPrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChanger
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChanger handle( FindPhaseTapChangerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangers
     *
     * @param	query	FindAllPhaseTapChangerQuery 
     * @return 	List<PhaseTapChanger> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChanger> handle( FindAllPhaseTapChangerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChanger, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChanger
	 */
	protected void emitFindPhaseTapChanger( PhaseTapChanger entity ) {
		LOGGER.info("handling emitFindPhaseTapChanger" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerId().equals(entity.getPhaseTapChangerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChanger
	 * 
	 * @param		entity	PhaseTapChanger
	 */
	protected void emitFindAllPhaseTapChanger( PhaseTapChanger entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChanger" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerProjector.class.getName());

}
