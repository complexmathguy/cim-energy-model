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
 * Projector for TransformerEnd as outlined for the CQRS pattern.  All event handling and query handling related to TransformerEnd are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TransformerEndAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("transformerEnd")
@Component("transformerEnd-projector")
public class TransformerEndProjector extends TransformerEndEntityProjector {
		
	// core constructor
	public TransformerEndProjector(TransformerEndRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTransformerEndEvent
     */
    @EventHandler( payloadType=CreateTransformerEndEvent.class )
    public void handle( CreateTransformerEndEvent event) {
	    LOGGER.info("handling CreateTransformerEndEvent - " + event );
	    TransformerEnd entity = new TransformerEnd();
        entity.setTransformerEndId( event.getTransformerEndId() );
        entity.setEndNumber( event.getEndNumber() );
        entity.setGrounded( event.getGrounded() );
        entity.setRground( event.getRground() );
        entity.setXground( event.getXground() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTransformerEnd( entity );
    }

    /*
     * @param	event UpdateTransformerEndEvent
     */
    @EventHandler( payloadType=UpdateTransformerEndEvent.class )
    public void handle( UpdateTransformerEndEvent event) {
    	LOGGER.info("handling UpdateTransformerEndEvent - " + event );
    	
	    TransformerEnd entity = new TransformerEnd();
        entity.setTransformerEndId( event.getTransformerEndId() );
        entity.setEndNumber( event.getEndNumber() );
        entity.setGrounded( event.getGrounded() );
        entity.setRground( event.getRground() );
        entity.setXground( event.getXground() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTransformerEnd( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTransformerEnd( entity );        
    }
    
    /*
     * @param	event DeleteTransformerEndEvent
     */
    @EventHandler( payloadType=DeleteTransformerEndEvent.class )
    public void handle( DeleteTransformerEndEvent event) {
    	LOGGER.info("handling DeleteTransformerEndEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TransformerEnd entity = delete( event.getTransformerEndId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTransformerEnd( entity );

    }    




    /**
     * Method to retrieve the TransformerEnd via an TransformerEndPrimaryKey.
     * @param 	id Long
     * @return 	TransformerEnd
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TransformerEnd handle( FindTransformerEndQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTransformerEndId() );
    }
    
    /**
     * Method to retrieve a collection of all TransformerEnds
     *
     * @param	query	FindAllTransformerEndQuery 
     * @return 	List<TransformerEnd> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TransformerEnd> handle( FindAllTransformerEndQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTransformerEnd, 
	 * but only if the id matches
	 * 
	 * @param		entity	TransformerEnd
	 */
	protected void emitFindTransformerEnd( TransformerEnd entity ) {
		LOGGER.info("handling emitFindTransformerEnd" );
		
	    queryUpdateEmitter.emit(FindTransformerEndQuery.class,
	                            query -> query.getFilter().getTransformerEndId().equals(entity.getTransformerEndId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTransformerEnd
	 * 
	 * @param		entity	TransformerEnd
	 */
	protected void emitFindAllTransformerEnd( TransformerEnd entity ) {
		LOGGER.info("handling emitFindAllTransformerEnd" );
		
	    queryUpdateEmitter.emit(FindAllTransformerEndQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TransformerEndProjector.class.getName());

}
