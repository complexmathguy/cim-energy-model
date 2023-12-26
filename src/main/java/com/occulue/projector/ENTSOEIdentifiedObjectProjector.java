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
 * Projector for ENTSOEIdentifiedObject as outlined for the CQRS pattern.  All event handling and query handling related to ENTSOEIdentifiedObject are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ENTSOEIdentifiedObjectAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("eNTSOEIdentifiedObject")
@Component("eNTSOEIdentifiedObject-projector")
public class ENTSOEIdentifiedObjectProjector extends ENTSOEIdentifiedObjectEntityProjector {
		
	// core constructor
	public ENTSOEIdentifiedObjectProjector(ENTSOEIdentifiedObjectRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateENTSOEIdentifiedObjectEvent
     */
    @EventHandler( payloadType=CreateENTSOEIdentifiedObjectEvent.class )
    public void handle( CreateENTSOEIdentifiedObjectEvent event) {
	    LOGGER.info("handling CreateENTSOEIdentifiedObjectEvent - " + event );
	    ENTSOEIdentifiedObject entity = new ENTSOEIdentifiedObject();
        entity.setENTSOEIdentifiedObjectId( event.getENTSOEIdentifiedObjectId() );
        entity.setEnergyIdentCodeEic( event.getEnergyIdentCodeEic() );
        entity.setShortName( event.getShortName() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEIdentifiedObject( entity );
    }

    /*
     * @param	event UpdateENTSOEIdentifiedObjectEvent
     */
    @EventHandler( payloadType=UpdateENTSOEIdentifiedObjectEvent.class )
    public void handle( UpdateENTSOEIdentifiedObjectEvent event) {
    	LOGGER.info("handling UpdateENTSOEIdentifiedObjectEvent - " + event );
    	
	    ENTSOEIdentifiedObject entity = new ENTSOEIdentifiedObject();
        entity.setENTSOEIdentifiedObjectId( event.getENTSOEIdentifiedObjectId() );
        entity.setEnergyIdentCodeEic( event.getEnergyIdentCodeEic() );
        entity.setShortName( event.getShortName() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindENTSOEIdentifiedObject( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEIdentifiedObject( entity );        
    }
    
    /*
     * @param	event DeleteENTSOEIdentifiedObjectEvent
     */
    @EventHandler( payloadType=DeleteENTSOEIdentifiedObjectEvent.class )
    public void handle( DeleteENTSOEIdentifiedObjectEvent event) {
    	LOGGER.info("handling DeleteENTSOEIdentifiedObjectEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ENTSOEIdentifiedObject entity = delete( event.getENTSOEIdentifiedObjectId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEIdentifiedObject( entity );

    }    




    /**
     * Method to retrieve the ENTSOEIdentifiedObject via an ENTSOEIdentifiedObjectPrimaryKey.
     * @param 	id Long
     * @return 	ENTSOEIdentifiedObject
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ENTSOEIdentifiedObject handle( FindENTSOEIdentifiedObjectQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getENTSOEIdentifiedObjectId() );
    }
    
    /**
     * Method to retrieve a collection of all ENTSOEIdentifiedObjects
     *
     * @param	query	FindAllENTSOEIdentifiedObjectQuery 
     * @return 	List<ENTSOEIdentifiedObject> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ENTSOEIdentifiedObject> handle( FindAllENTSOEIdentifiedObjectQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindENTSOEIdentifiedObject, 
	 * but only if the id matches
	 * 
	 * @param		entity	ENTSOEIdentifiedObject
	 */
	protected void emitFindENTSOEIdentifiedObject( ENTSOEIdentifiedObject entity ) {
		LOGGER.info("handling emitFindENTSOEIdentifiedObject" );
		
	    queryUpdateEmitter.emit(FindENTSOEIdentifiedObjectQuery.class,
	                            query -> query.getFilter().getENTSOEIdentifiedObjectId().equals(entity.getENTSOEIdentifiedObjectId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllENTSOEIdentifiedObject
	 * 
	 * @param		entity	ENTSOEIdentifiedObject
	 */
	protected void emitFindAllENTSOEIdentifiedObject( ENTSOEIdentifiedObject entity ) {
		LOGGER.info("handling emitFindAllENTSOEIdentifiedObject" );
		
	    queryUpdateEmitter.emit(FindAllENTSOEIdentifiedObjectQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEIdentifiedObjectProjector.class.getName());

}
