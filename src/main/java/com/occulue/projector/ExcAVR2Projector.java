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
 * Projector for ExcAVR2 as outlined for the CQRS pattern.  All event handling and query handling related to ExcAVR2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAVR2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAVR2")
@Component("excAVR2-projector")
public class ExcAVR2Projector extends ExcAVR2EntityProjector {
		
	// core constructor
	public ExcAVR2Projector(ExcAVR2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAVR2Event
     */
    @EventHandler( payloadType=CreateExcAVR2Event.class )
    public void handle( CreateExcAVR2Event event) {
	    LOGGER.info("handling CreateExcAVR2Event - " + event );
	    ExcAVR2 entity = new ExcAVR2();
        entity.setExcAVR2Id( event.getExcAVR2Id() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setKf( event.getKf() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTe( event.getTe() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR2( entity );
    }

    /*
     * @param	event UpdateExcAVR2Event
     */
    @EventHandler( payloadType=UpdateExcAVR2Event.class )
    public void handle( UpdateExcAVR2Event event) {
    	LOGGER.info("handling UpdateExcAVR2Event - " + event );
    	
	    ExcAVR2 entity = new ExcAVR2();
        entity.setExcAVR2Id( event.getExcAVR2Id() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setKf( event.getKf() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTe( event.getTe() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAVR2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR2( entity );        
    }
    
    /*
     * @param	event DeleteExcAVR2Event
     */
    @EventHandler( payloadType=DeleteExcAVR2Event.class )
    public void handle( DeleteExcAVR2Event event) {
    	LOGGER.info("handling DeleteExcAVR2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAVR2 entity = delete( event.getExcAVR2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR2( entity );

    }    




    /**
     * Method to retrieve the ExcAVR2 via an ExcAVR2PrimaryKey.
     * @param 	id Long
     * @return 	ExcAVR2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAVR2 handle( FindExcAVR2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAVR2Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR2s
     *
     * @param	query	FindAllExcAVR2Query 
     * @return 	List<ExcAVR2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAVR2> handle( FindAllExcAVR2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAVR2, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAVR2
	 */
	protected void emitFindExcAVR2( ExcAVR2 entity ) {
		LOGGER.info("handling emitFindExcAVR2" );
		
	    queryUpdateEmitter.emit(FindExcAVR2Query.class,
	                            query -> query.getFilter().getExcAVR2Id().equals(entity.getExcAVR2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAVR2
	 * 
	 * @param		entity	ExcAVR2
	 */
	protected void emitFindAllExcAVR2( ExcAVR2 entity ) {
		LOGGER.info("handling emitFindAllExcAVR2" );
		
	    queryUpdateEmitter.emit(FindAllExcAVR2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR2Projector.class.getName());

}
