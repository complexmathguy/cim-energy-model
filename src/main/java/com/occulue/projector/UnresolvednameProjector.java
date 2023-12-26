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
 * Projector for Unresolvedname as outlined for the CQRS pattern.  All event handling and query handling related to Unresolvedname are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnresolvednameAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("unresolvedname")
@Component("unresolvedname-projector")
public class UnresolvednameProjector extends UnresolvednameEntityProjector {
		
	// core constructor
	public UnresolvednameProjector(UnresolvednameRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnresolvednameEvent
     */
    @EventHandler( payloadType=CreateUnresolvednameEvent.class )
    public void handle( CreateUnresolvednameEvent event) {
	    LOGGER.info("handling CreateUnresolvednameEvent - " + event );
	    Unresolvedname entity = new Unresolvedname();
        entity.setUnresolvednameId( event.getUnresolvednameId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnresolvedname( entity );
    }

    /*
     * @param	event UpdateUnresolvednameEvent
     */
    @EventHandler( payloadType=UpdateUnresolvednameEvent.class )
    public void handle( UpdateUnresolvednameEvent event) {
    	LOGGER.info("handling UpdateUnresolvednameEvent - " + event );
    	
	    Unresolvedname entity = new Unresolvedname();
        entity.setUnresolvednameId( event.getUnresolvednameId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnresolvedname( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnresolvedname( entity );        
    }
    
    /*
     * @param	event DeleteUnresolvednameEvent
     */
    @EventHandler( payloadType=DeleteUnresolvednameEvent.class )
    public void handle( DeleteUnresolvednameEvent event) {
    	LOGGER.info("handling DeleteUnresolvednameEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Unresolvedname entity = delete( event.getUnresolvednameId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnresolvedname( entity );

    }    




    /**
     * Method to retrieve the Unresolvedname via an UnresolvednamePrimaryKey.
     * @param 	id Long
     * @return 	Unresolvedname
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Unresolvedname handle( FindUnresolvednameQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnresolvednameId() );
    }
    
    /**
     * Method to retrieve a collection of all Unresolvednames
     *
     * @param	query	FindAllUnresolvednameQuery 
     * @return 	List<Unresolvedname> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Unresolvedname> handle( FindAllUnresolvednameQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnresolvedname, 
	 * but only if the id matches
	 * 
	 * @param		entity	Unresolvedname
	 */
	protected void emitFindUnresolvedname( Unresolvedname entity ) {
		LOGGER.info("handling emitFindUnresolvedname" );
		
	    queryUpdateEmitter.emit(FindUnresolvednameQuery.class,
	                            query -> query.getFilter().getUnresolvednameId().equals(entity.getUnresolvednameId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnresolvedname
	 * 
	 * @param		entity	Unresolvedname
	 */
	protected void emitFindAllUnresolvedname( Unresolvedname entity ) {
		LOGGER.info("handling emitFindAllUnresolvedname" );
		
	    queryUpdateEmitter.emit(FindAllUnresolvednameQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnresolvednameProjector.class.getName());

}
