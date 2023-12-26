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
 * Projector for ENTSOEOperationalLimitType as outlined for the CQRS pattern.  All event handling and query handling related to ENTSOEOperationalLimitType are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ENTSOEOperationalLimitTypeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("eNTSOEOperationalLimitType")
@Component("eNTSOEOperationalLimitType-projector")
public class ENTSOEOperationalLimitTypeProjector extends ENTSOEOperationalLimitTypeEntityProjector {
		
	// core constructor
	public ENTSOEOperationalLimitTypeProjector(ENTSOEOperationalLimitTypeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateENTSOEOperationalLimitTypeEvent
     */
    @EventHandler( payloadType=CreateENTSOEOperationalLimitTypeEvent.class )
    public void handle( CreateENTSOEOperationalLimitTypeEvent event) {
	    LOGGER.info("handling CreateENTSOEOperationalLimitTypeEvent - " + event );
	    ENTSOEOperationalLimitType entity = new ENTSOEOperationalLimitType();
        entity.setENTSOEOperationalLimitTypeId( event.getENTSOEOperationalLimitTypeId() );
        entity.setLimitType( event.getLimitType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEOperationalLimitType( entity );
    }

    /*
     * @param	event UpdateENTSOEOperationalLimitTypeEvent
     */
    @EventHandler( payloadType=UpdateENTSOEOperationalLimitTypeEvent.class )
    public void handle( UpdateENTSOEOperationalLimitTypeEvent event) {
    	LOGGER.info("handling UpdateENTSOEOperationalLimitTypeEvent - " + event );
    	
	    ENTSOEOperationalLimitType entity = new ENTSOEOperationalLimitType();
        entity.setENTSOEOperationalLimitTypeId( event.getENTSOEOperationalLimitTypeId() );
        entity.setLimitType( event.getLimitType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindENTSOEOperationalLimitType( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEOperationalLimitType( entity );        
    }
    
    /*
     * @param	event DeleteENTSOEOperationalLimitTypeEvent
     */
    @EventHandler( payloadType=DeleteENTSOEOperationalLimitTypeEvent.class )
    public void handle( DeleteENTSOEOperationalLimitTypeEvent event) {
    	LOGGER.info("handling DeleteENTSOEOperationalLimitTypeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ENTSOEOperationalLimitType entity = delete( event.getENTSOEOperationalLimitTypeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEOperationalLimitType( entity );

    }    




    /**
     * Method to retrieve the ENTSOEOperationalLimitType via an ENTSOEOperationalLimitTypePrimaryKey.
     * @param 	id Long
     * @return 	ENTSOEOperationalLimitType
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ENTSOEOperationalLimitType handle( FindENTSOEOperationalLimitTypeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getENTSOEOperationalLimitTypeId() );
    }
    
    /**
     * Method to retrieve a collection of all ENTSOEOperationalLimitTypes
     *
     * @param	query	FindAllENTSOEOperationalLimitTypeQuery 
     * @return 	List<ENTSOEOperationalLimitType> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ENTSOEOperationalLimitType> handle( FindAllENTSOEOperationalLimitTypeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindENTSOEOperationalLimitType, 
	 * but only if the id matches
	 * 
	 * @param		entity	ENTSOEOperationalLimitType
	 */
	protected void emitFindENTSOEOperationalLimitType( ENTSOEOperationalLimitType entity ) {
		LOGGER.info("handling emitFindENTSOEOperationalLimitType" );
		
	    queryUpdateEmitter.emit(FindENTSOEOperationalLimitTypeQuery.class,
	                            query -> query.getFilter().getENTSOEOperationalLimitTypeId().equals(entity.getENTSOEOperationalLimitTypeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllENTSOEOperationalLimitType
	 * 
	 * @param		entity	ENTSOEOperationalLimitType
	 */
	protected void emitFindAllENTSOEOperationalLimitType( ENTSOEOperationalLimitType entity ) {
		LOGGER.info("handling emitFindAllENTSOEOperationalLimitType" );
		
	    queryUpdateEmitter.emit(FindAllENTSOEOperationalLimitTypeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEOperationalLimitTypeProjector.class.getName());

}
