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
 * Projector for Line as outlined for the CQRS pattern.  All event handling and query handling related to Line are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LineAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("line")
@Component("line-projector")
public class LineProjector extends LineEntityProjector {
		
	// core constructor
	public LineProjector(LineRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLineEvent
     */
    @EventHandler( payloadType=CreateLineEvent.class )
    public void handle( CreateLineEvent event) {
	    LOGGER.info("handling CreateLineEvent - " + event );
	    Line entity = new Line();
        entity.setLineId( event.getLineId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLine( entity );
    }

    /*
     * @param	event UpdateLineEvent
     */
    @EventHandler( payloadType=UpdateLineEvent.class )
    public void handle( UpdateLineEvent event) {
    	LOGGER.info("handling UpdateLineEvent - " + event );
    	
	    Line entity = new Line();
        entity.setLineId( event.getLineId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLine( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLine( entity );        
    }
    
    /*
     * @param	event DeleteLineEvent
     */
    @EventHandler( payloadType=DeleteLineEvent.class )
    public void handle( DeleteLineEvent event) {
    	LOGGER.info("handling DeleteLineEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Line entity = delete( event.getLineId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLine( entity );

    }    




    /**
     * Method to retrieve the Line via an LinePrimaryKey.
     * @param 	id Long
     * @return 	Line
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Line handle( FindLineQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLineId() );
    }
    
    /**
     * Method to retrieve a collection of all Lines
     *
     * @param	query	FindAllLineQuery 
     * @return 	List<Line> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Line> handle( FindAllLineQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLine, 
	 * but only if the id matches
	 * 
	 * @param		entity	Line
	 */
	protected void emitFindLine( Line entity ) {
		LOGGER.info("handling emitFindLine" );
		
	    queryUpdateEmitter.emit(FindLineQuery.class,
	                            query -> query.getFilter().getLineId().equals(entity.getLineId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLine
	 * 
	 * @param		entity	Line
	 */
	protected void emitFindAllLine( Line entity ) {
		LOGGER.info("handling emitFindAllLine" );
		
	    queryUpdateEmitter.emit(FindAllLineQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LineProjector.class.getName());

}
