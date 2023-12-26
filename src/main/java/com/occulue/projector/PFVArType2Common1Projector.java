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
 * Projector for PFVArType2Common1 as outlined for the CQRS pattern.  All event handling and query handling related to PFVArType2Common1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArType2Common1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArType2Common1")
@Component("pFVArType2Common1-projector")
public class PFVArType2Common1Projector extends PFVArType2Common1EntityProjector {
		
	// core constructor
	public PFVArType2Common1Projector(PFVArType2Common1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArType2Common1Event
     */
    @EventHandler( payloadType=CreatePFVArType2Common1Event.class )
    public void handle( CreatePFVArType2Common1Event event) {
	    LOGGER.info("handling CreatePFVArType2Common1Event - " + event );
	    PFVArType2Common1 entity = new PFVArType2Common1();
        entity.setPFVArType2Common1Id( event.getPFVArType2Common1Id() );
        entity.setJ( event.getJ() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMax( event.getMax() );
        entity.setRef( event.getRef() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2Common1( entity );
    }

    /*
     * @param	event UpdatePFVArType2Common1Event
     */
    @EventHandler( payloadType=UpdatePFVArType2Common1Event.class )
    public void handle( UpdatePFVArType2Common1Event event) {
    	LOGGER.info("handling UpdatePFVArType2Common1Event - " + event );
    	
	    PFVArType2Common1 entity = new PFVArType2Common1();
        entity.setPFVArType2Common1Id( event.getPFVArType2Common1Id() );
        entity.setJ( event.getJ() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMax( event.getMax() );
        entity.setRef( event.getRef() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArType2Common1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2Common1( entity );        
    }
    
    /*
     * @param	event DeletePFVArType2Common1Event
     */
    @EventHandler( payloadType=DeletePFVArType2Common1Event.class )
    public void handle( DeletePFVArType2Common1Event event) {
    	LOGGER.info("handling DeletePFVArType2Common1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArType2Common1 entity = delete( event.getPFVArType2Common1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2Common1( entity );

    }    




    /**
     * Method to retrieve the PFVArType2Common1 via an PFVArType2Common1PrimaryKey.
     * @param 	id Long
     * @return 	PFVArType2Common1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArType2Common1 handle( FindPFVArType2Common1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArType2Common1Id() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArType2Common1s
     *
     * @param	query	FindAllPFVArType2Common1Query 
     * @return 	List<PFVArType2Common1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArType2Common1> handle( FindAllPFVArType2Common1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArType2Common1, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArType2Common1
	 */
	protected void emitFindPFVArType2Common1( PFVArType2Common1 entity ) {
		LOGGER.info("handling emitFindPFVArType2Common1" );
		
	    queryUpdateEmitter.emit(FindPFVArType2Common1Query.class,
	                            query -> query.getFilter().getPFVArType2Common1Id().equals(entity.getPFVArType2Common1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArType2Common1
	 * 
	 * @param		entity	PFVArType2Common1
	 */
	protected void emitFindAllPFVArType2Common1( PFVArType2Common1 entity ) {
		LOGGER.info("handling emitFindAllPFVArType2Common1" );
		
	    queryUpdateEmitter.emit(FindAllPFVArType2Common1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2Common1Projector.class.getName());

}
