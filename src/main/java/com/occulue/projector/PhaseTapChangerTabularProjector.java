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
 * Projector for PhaseTapChangerTabular as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChangerTabular are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerTabularAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChangerTabular")
@Component("phaseTapChangerTabular-projector")
public class PhaseTapChangerTabularProjector extends PhaseTapChangerTabularEntityProjector {
		
	// core constructor
	public PhaseTapChangerTabularProjector(PhaseTapChangerTabularRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerTabularEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerTabularEvent.class )
    public void handle( CreatePhaseTapChangerTabularEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerTabularEvent - " + event );
	    PhaseTapChangerTabular entity = new PhaseTapChangerTabular();
        entity.setPhaseTapChangerTabularId( event.getPhaseTapChangerTabularId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTabular( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerTabularEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerTabularEvent.class )
    public void handle( UpdatePhaseTapChangerTabularEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerTabularEvent - " + event );
    	
	    PhaseTapChangerTabular entity = new PhaseTapChangerTabular();
        entity.setPhaseTapChangerTabularId( event.getPhaseTapChangerTabularId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChangerTabular( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTabular( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerTabularEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerTabularEvent.class )
    public void handle( DeletePhaseTapChangerTabularEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerTabularEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChangerTabular entity = delete( event.getPhaseTapChangerTabularId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTabular( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChangerTabular via an PhaseTapChangerTabularPrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChangerTabular
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChangerTabular handle( FindPhaseTapChangerTabularQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerTabularId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerTabulars
     *
     * @param	query	FindAllPhaseTapChangerTabularQuery 
     * @return 	List<PhaseTapChangerTabular> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChangerTabular> handle( FindAllPhaseTapChangerTabularQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChangerTabular, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChangerTabular
	 */
	protected void emitFindPhaseTapChangerTabular( PhaseTapChangerTabular entity ) {
		LOGGER.info("handling emitFindPhaseTapChangerTabular" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerTabularQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerTabularId().equals(entity.getPhaseTapChangerTabularId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChangerTabular
	 * 
	 * @param		entity	PhaseTapChangerTabular
	 */
	protected void emitFindAllPhaseTapChangerTabular( PhaseTapChangerTabular entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChangerTabular" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerTabularQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerTabularProjector.class.getName());

}
