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
 * Projector for NuclearGeneratingUnit as outlined for the CQRS pattern.  All event handling and query handling related to NuclearGeneratingUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by NuclearGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("nuclearGeneratingUnit")
@Component("nuclearGeneratingUnit-projector")
public class NuclearGeneratingUnitProjector extends NuclearGeneratingUnitEntityProjector {
		
	// core constructor
	public NuclearGeneratingUnitProjector(NuclearGeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateNuclearGeneratingUnitEvent
     */
    @EventHandler( payloadType=CreateNuclearGeneratingUnitEvent.class )
    public void handle( CreateNuclearGeneratingUnitEvent event) {
	    LOGGER.info("handling CreateNuclearGeneratingUnitEvent - " + event );
	    NuclearGeneratingUnit entity = new NuclearGeneratingUnit();
        entity.setNuclearGeneratingUnitId( event.getNuclearGeneratingUnitId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNuclearGeneratingUnit( entity );
    }

    /*
     * @param	event UpdateNuclearGeneratingUnitEvent
     */
    @EventHandler( payloadType=UpdateNuclearGeneratingUnitEvent.class )
    public void handle( UpdateNuclearGeneratingUnitEvent event) {
    	LOGGER.info("handling UpdateNuclearGeneratingUnitEvent - " + event );
    	
	    NuclearGeneratingUnit entity = new NuclearGeneratingUnit();
        entity.setNuclearGeneratingUnitId( event.getNuclearGeneratingUnitId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindNuclearGeneratingUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNuclearGeneratingUnit( entity );        
    }
    
    /*
     * @param	event DeleteNuclearGeneratingUnitEvent
     */
    @EventHandler( payloadType=DeleteNuclearGeneratingUnitEvent.class )
    public void handle( DeleteNuclearGeneratingUnitEvent event) {
    	LOGGER.info("handling DeleteNuclearGeneratingUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	NuclearGeneratingUnit entity = delete( event.getNuclearGeneratingUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNuclearGeneratingUnit( entity );

    }    




    /**
     * Method to retrieve the NuclearGeneratingUnit via an NuclearGeneratingUnitPrimaryKey.
     * @param 	id Long
     * @return 	NuclearGeneratingUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public NuclearGeneratingUnit handle( FindNuclearGeneratingUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getNuclearGeneratingUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all NuclearGeneratingUnits
     *
     * @param	query	FindAllNuclearGeneratingUnitQuery 
     * @return 	List<NuclearGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<NuclearGeneratingUnit> handle( FindAllNuclearGeneratingUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindNuclearGeneratingUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	NuclearGeneratingUnit
	 */
	protected void emitFindNuclearGeneratingUnit( NuclearGeneratingUnit entity ) {
		LOGGER.info("handling emitFindNuclearGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindNuclearGeneratingUnitQuery.class,
	                            query -> query.getFilter().getNuclearGeneratingUnitId().equals(entity.getNuclearGeneratingUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllNuclearGeneratingUnit
	 * 
	 * @param		entity	NuclearGeneratingUnit
	 */
	protected void emitFindAllNuclearGeneratingUnit( NuclearGeneratingUnit entity ) {
		LOGGER.info("handling emitFindAllNuclearGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindAllNuclearGeneratingUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(NuclearGeneratingUnitProjector.class.getName());

}
