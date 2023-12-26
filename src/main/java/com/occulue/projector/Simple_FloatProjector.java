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
 * Projector for Simple_Float as outlined for the CQRS pattern.  All event handling and query handling related to Simple_Float are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Simple_FloatAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("simple_Float")
@Component("simple_Float-projector")
public class Simple_FloatProjector extends Simple_FloatEntityProjector {
		
	// core constructor
	public Simple_FloatProjector(Simple_FloatRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSimple_FloatEvent
     */
    @EventHandler( payloadType=CreateSimple_FloatEvent.class )
    public void handle( CreateSimple_FloatEvent event) {
	    LOGGER.info("handling CreateSimple_FloatEvent - " + event );
	    Simple_Float entity = new Simple_Float();
        entity.setSimple_FloatId( event.getSimple_FloatId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSimple_Float( entity );
    }

    /*
     * @param	event UpdateSimple_FloatEvent
     */
    @EventHandler( payloadType=UpdateSimple_FloatEvent.class )
    public void handle( UpdateSimple_FloatEvent event) {
    	LOGGER.info("handling UpdateSimple_FloatEvent - " + event );
    	
	    Simple_Float entity = new Simple_Float();
        entity.setSimple_FloatId( event.getSimple_FloatId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSimple_Float( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSimple_Float( entity );        
    }
    
    /*
     * @param	event DeleteSimple_FloatEvent
     */
    @EventHandler( payloadType=DeleteSimple_FloatEvent.class )
    public void handle( DeleteSimple_FloatEvent event) {
    	LOGGER.info("handling DeleteSimple_FloatEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Simple_Float entity = delete( event.getSimple_FloatId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSimple_Float( entity );

    }    




    /**
     * Method to retrieve the Simple_Float via an Simple_FloatPrimaryKey.
     * @param 	id Long
     * @return 	Simple_Float
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Simple_Float handle( FindSimple_FloatQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSimple_FloatId() );
    }
    
    /**
     * Method to retrieve a collection of all Simple_Floats
     *
     * @param	query	FindAllSimple_FloatQuery 
     * @return 	List<Simple_Float> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Simple_Float> handle( FindAllSimple_FloatQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSimple_Float, 
	 * but only if the id matches
	 * 
	 * @param		entity	Simple_Float
	 */
	protected void emitFindSimple_Float( Simple_Float entity ) {
		LOGGER.info("handling emitFindSimple_Float" );
		
	    queryUpdateEmitter.emit(FindSimple_FloatQuery.class,
	                            query -> query.getFilter().getSimple_FloatId().equals(entity.getSimple_FloatId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSimple_Float
	 * 
	 * @param		entity	Simple_Float
	 */
	protected void emitFindAllSimple_Float( Simple_Float entity ) {
		LOGGER.info("handling emitFindAllSimple_Float" );
		
	    queryUpdateEmitter.emit(FindAllSimple_FloatQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Simple_FloatProjector.class.getName());

}
