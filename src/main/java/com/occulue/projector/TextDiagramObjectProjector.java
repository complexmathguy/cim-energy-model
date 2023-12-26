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
 * Projector for TextDiagramObject as outlined for the CQRS pattern.  All event handling and query handling related to TextDiagramObject are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TextDiagramObjectAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("textDiagramObject")
@Component("textDiagramObject-projector")
public class TextDiagramObjectProjector extends TextDiagramObjectEntityProjector {
		
	// core constructor
	public TextDiagramObjectProjector(TextDiagramObjectRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTextDiagramObjectEvent
     */
    @EventHandler( payloadType=CreateTextDiagramObjectEvent.class )
    public void handle( CreateTextDiagramObjectEvent event) {
	    LOGGER.info("handling CreateTextDiagramObjectEvent - " + event );
	    TextDiagramObject entity = new TextDiagramObject();
        entity.setTextDiagramObjectId( event.getTextDiagramObjectId() );
        entity.setText( event.getText() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTextDiagramObject( entity );
    }

    /*
     * @param	event UpdateTextDiagramObjectEvent
     */
    @EventHandler( payloadType=UpdateTextDiagramObjectEvent.class )
    public void handle( UpdateTextDiagramObjectEvent event) {
    	LOGGER.info("handling UpdateTextDiagramObjectEvent - " + event );
    	
	    TextDiagramObject entity = new TextDiagramObject();
        entity.setTextDiagramObjectId( event.getTextDiagramObjectId() );
        entity.setText( event.getText() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTextDiagramObject( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTextDiagramObject( entity );        
    }
    
    /*
     * @param	event DeleteTextDiagramObjectEvent
     */
    @EventHandler( payloadType=DeleteTextDiagramObjectEvent.class )
    public void handle( DeleteTextDiagramObjectEvent event) {
    	LOGGER.info("handling DeleteTextDiagramObjectEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TextDiagramObject entity = delete( event.getTextDiagramObjectId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTextDiagramObject( entity );

    }    




    /**
     * Method to retrieve the TextDiagramObject via an TextDiagramObjectPrimaryKey.
     * @param 	id Long
     * @return 	TextDiagramObject
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TextDiagramObject handle( FindTextDiagramObjectQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTextDiagramObjectId() );
    }
    
    /**
     * Method to retrieve a collection of all TextDiagramObjects
     *
     * @param	query	FindAllTextDiagramObjectQuery 
     * @return 	List<TextDiagramObject> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TextDiagramObject> handle( FindAllTextDiagramObjectQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTextDiagramObject, 
	 * but only if the id matches
	 * 
	 * @param		entity	TextDiagramObject
	 */
	protected void emitFindTextDiagramObject( TextDiagramObject entity ) {
		LOGGER.info("handling emitFindTextDiagramObject" );
		
	    queryUpdateEmitter.emit(FindTextDiagramObjectQuery.class,
	                            query -> query.getFilter().getTextDiagramObjectId().equals(entity.getTextDiagramObjectId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTextDiagramObject
	 * 
	 * @param		entity	TextDiagramObject
	 */
	protected void emitFindAllTextDiagramObject( TextDiagramObject entity ) {
		LOGGER.info("handling emitFindAllTextDiagramObject" );
		
	    queryUpdateEmitter.emit(FindAllTextDiagramObjectQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TextDiagramObjectProjector.class.getName());

}
