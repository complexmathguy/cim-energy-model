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
 * Projector for PhaseTapChangerTable as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChangerTable are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerTableAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChangerTable")
@Component("phaseTapChangerTable-projector")
public class PhaseTapChangerTableProjector extends PhaseTapChangerTableEntityProjector {
		
	// core constructor
	public PhaseTapChangerTableProjector(PhaseTapChangerTableRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerTableEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerTableEvent.class )
    public void handle( CreatePhaseTapChangerTableEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerTableEvent - " + event );
	    PhaseTapChangerTable entity = new PhaseTapChangerTable();
        entity.setPhaseTapChangerTableId( event.getPhaseTapChangerTableId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTable( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerTableEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerTableEvent.class )
    public void handle( UpdatePhaseTapChangerTableEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerTableEvent - " + event );
    	
	    PhaseTapChangerTable entity = new PhaseTapChangerTable();
        entity.setPhaseTapChangerTableId( event.getPhaseTapChangerTableId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChangerTable( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTable( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerTableEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerTableEvent.class )
    public void handle( DeletePhaseTapChangerTableEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerTableEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChangerTable entity = delete( event.getPhaseTapChangerTableId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTable( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChangerTable via an PhaseTapChangerTablePrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChangerTable
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChangerTable handle( FindPhaseTapChangerTableQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerTableId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerTables
     *
     * @param	query	FindAllPhaseTapChangerTableQuery 
     * @return 	List<PhaseTapChangerTable> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChangerTable> handle( FindAllPhaseTapChangerTableQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChangerTable, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChangerTable
	 */
	protected void emitFindPhaseTapChangerTable( PhaseTapChangerTable entity ) {
		LOGGER.info("handling emitFindPhaseTapChangerTable" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerTableQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerTableId().equals(entity.getPhaseTapChangerTableId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChangerTable
	 * 
	 * @param		entity	PhaseTapChangerTable
	 */
	protected void emitFindAllPhaseTapChangerTable( PhaseTapChangerTable entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChangerTable" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerTableQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerTableProjector.class.getName());

}
