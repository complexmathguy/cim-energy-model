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
 * Projector for IdentifiedObject as outlined for the CQRS pattern.  All event handling and query handling related to IdentifiedObject are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by IdentifiedObjectAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("identifiedObject")
@Component("identifiedObject-projector")
public class IdentifiedObjectProjector extends IdentifiedObjectEntityProjector {
		
	// core constructor
	public IdentifiedObjectProjector(IdentifiedObjectRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateIdentifiedObjectEvent
     */
    @EventHandler( payloadType=CreateIdentifiedObjectEvent.class )
    public void handle( CreateIdentifiedObjectEvent event) {
	    LOGGER.info("handling CreateIdentifiedObjectEvent - " + event );
	    IdentifiedObject entity = new IdentifiedObject();
        entity.setIdentifiedObjectId( event.getIdentifiedObjectId() );
        entity.setDescription( event.getDescription() );
        entity.setEnergyIdentCodeEic( event.getEnergyIdentCodeEic() );
        entity.setMRID( event.getMRID() );
        entity.setName( event.getName() );
        entity.setShortName( event.getShortName() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllIdentifiedObject( entity );
    }

    /*
     * @param	event UpdateIdentifiedObjectEvent
     */
    @EventHandler( payloadType=UpdateIdentifiedObjectEvent.class )
    public void handle( UpdateIdentifiedObjectEvent event) {
    	LOGGER.info("handling UpdateIdentifiedObjectEvent - " + event );
    	
	    IdentifiedObject entity = new IdentifiedObject();
        entity.setIdentifiedObjectId( event.getIdentifiedObjectId() );
        entity.setDescription( event.getDescription() );
        entity.setEnergyIdentCodeEic( event.getEnergyIdentCodeEic() );
        entity.setMRID( event.getMRID() );
        entity.setName( event.getName() );
        entity.setShortName( event.getShortName() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindIdentifiedObject( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllIdentifiedObject( entity );        
    }
    
    /*
     * @param	event DeleteIdentifiedObjectEvent
     */
    @EventHandler( payloadType=DeleteIdentifiedObjectEvent.class )
    public void handle( DeleteIdentifiedObjectEvent event) {
    	LOGGER.info("handling DeleteIdentifiedObjectEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	IdentifiedObject entity = delete( event.getIdentifiedObjectId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllIdentifiedObject( entity );

    }    




    /**
     * Method to retrieve the IdentifiedObject via an IdentifiedObjectPrimaryKey.
     * @param 	id Long
     * @return 	IdentifiedObject
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public IdentifiedObject handle( FindIdentifiedObjectQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getIdentifiedObjectId() );
    }
    
    /**
     * Method to retrieve a collection of all IdentifiedObjects
     *
     * @param	query	FindAllIdentifiedObjectQuery 
     * @return 	List<IdentifiedObject> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<IdentifiedObject> handle( FindAllIdentifiedObjectQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindIdentifiedObject, 
	 * but only if the id matches
	 * 
	 * @param		entity	IdentifiedObject
	 */
	protected void emitFindIdentifiedObject( IdentifiedObject entity ) {
		LOGGER.info("handling emitFindIdentifiedObject" );
		
	    queryUpdateEmitter.emit(FindIdentifiedObjectQuery.class,
	                            query -> query.getFilter().getIdentifiedObjectId().equals(entity.getIdentifiedObjectId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllIdentifiedObject
	 * 
	 * @param		entity	IdentifiedObject
	 */
	protected void emitFindAllIdentifiedObject( IdentifiedObject entity ) {
		LOGGER.info("handling emitFindAllIdentifiedObject" );
		
	    queryUpdateEmitter.emit(FindAllIdentifiedObjectQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(IdentifiedObjectProjector.class.getName());

}
