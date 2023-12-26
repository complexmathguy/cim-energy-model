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
 * Projector for ExcIEEEST5B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST5B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST5BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST5B")
@Component("excIEEEST5B-projector")
public class ExcIEEEST5BProjector extends ExcIEEEST5BEntityProjector {
		
	// core constructor
	public ExcIEEEST5BProjector(ExcIEEEST5BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST5BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST5BEvent.class )
    public void handle( CreateExcIEEEST5BEvent event) {
	    LOGGER.info("handling CreateExcIEEEST5BEvent - " + event );
	    ExcIEEEST5B entity = new ExcIEEEST5B();
        entity.setExcIEEEST5BId( event.getExcIEEEST5BId() );
        entity.setKc( event.getKc() );
        entity.setKr( event.getKr() );
        entity.setT1( event.getT1() );
        entity.setTb1( event.getTb1() );
        entity.setTb2( event.getTb2() );
        entity.setTc1( event.getTc1() );
        entity.setTc2( event.getTc2() );
        entity.setTob1( event.getTob1() );
        entity.setTob2( event.getTob2() );
        entity.setToc1( event.getToc1() );
        entity.setToc2( event.getToc2() );
        entity.setTub1( event.getTub1() );
        entity.setTub2( event.getTub2() );
        entity.setTuc1( event.getTuc1() );
        entity.setTuc2( event.getTuc2() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST5B( entity );
    }

    /*
     * @param	event UpdateExcIEEEST5BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST5BEvent.class )
    public void handle( UpdateExcIEEEST5BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST5BEvent - " + event );
    	
	    ExcIEEEST5B entity = new ExcIEEEST5B();
        entity.setExcIEEEST5BId( event.getExcIEEEST5BId() );
        entity.setKc( event.getKc() );
        entity.setKr( event.getKr() );
        entity.setT1( event.getT1() );
        entity.setTb1( event.getTb1() );
        entity.setTb2( event.getTb2() );
        entity.setTc1( event.getTc1() );
        entity.setTc2( event.getTc2() );
        entity.setTob1( event.getTob1() );
        entity.setTob2( event.getTob2() );
        entity.setToc1( event.getToc1() );
        entity.setToc2( event.getToc2() );
        entity.setTub1( event.getTub1() );
        entity.setTub2( event.getTub2() );
        entity.setTuc1( event.getTuc1() );
        entity.setTuc2( event.getTuc2() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST5B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST5B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST5BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST5BEvent.class )
    public void handle( DeleteExcIEEEST5BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST5BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST5B entity = delete( event.getExcIEEEST5BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST5B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST5B via an ExcIEEEST5BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST5B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST5B handle( FindExcIEEEST5BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST5BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST5Bs
     *
     * @param	query	FindAllExcIEEEST5BQuery 
     * @return 	List<ExcIEEEST5B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST5B> handle( FindAllExcIEEEST5BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST5B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST5B
	 */
	protected void emitFindExcIEEEST5B( ExcIEEEST5B entity ) {
		LOGGER.info("handling emitFindExcIEEEST5B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST5BQuery.class,
	                            query -> query.getFilter().getExcIEEEST5BId().equals(entity.getExcIEEEST5BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST5B
	 * 
	 * @param		entity	ExcIEEEST5B
	 */
	protected void emitFindAllExcIEEEST5B( ExcIEEEST5B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST5B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST5BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST5BProjector.class.getName());

}
