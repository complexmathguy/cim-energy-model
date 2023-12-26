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
 * Projector for LoadStatic as outlined for the CQRS pattern.  All event handling and query handling related to LoadStatic are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadStaticAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadStatic")
@Component("loadStatic-projector")
public class LoadStaticProjector extends LoadStaticEntityProjector {
		
	// core constructor
	public LoadStaticProjector(LoadStaticRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadStaticEvent
     */
    @EventHandler( payloadType=CreateLoadStaticEvent.class )
    public void handle( CreateLoadStaticEvent event) {
	    LOGGER.info("handling CreateLoadStaticEvent - " + event );
	    LoadStatic entity = new LoadStatic();
        entity.setLoadStaticId( event.getLoadStaticId() );
        entity.setEp1( event.getEp1() );
        entity.setEp2( event.getEp2() );
        entity.setEp3( event.getEp3() );
        entity.setEq1( event.getEq1() );
        entity.setEq2( event.getEq2() );
        entity.setEq3( event.getEq3() );
        entity.setKp1( event.getKp1() );
        entity.setKp2( event.getKp2() );
        entity.setKp3( event.getKp3() );
        entity.setKp4( event.getKp4() );
        entity.setKpf( event.getKpf() );
        entity.setKq1( event.getKq1() );
        entity.setKq2( event.getKq2() );
        entity.setKq3( event.getKq3() );
        entity.setKq4( event.getKq4() );
        entity.setKqf( event.getKqf() );
        entity.setStaticLoadModelType( event.getStaticLoadModelType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadStatic( entity );
    }

    /*
     * @param	event UpdateLoadStaticEvent
     */
    @EventHandler( payloadType=UpdateLoadStaticEvent.class )
    public void handle( UpdateLoadStaticEvent event) {
    	LOGGER.info("handling UpdateLoadStaticEvent - " + event );
    	
	    LoadStatic entity = new LoadStatic();
        entity.setLoadStaticId( event.getLoadStaticId() );
        entity.setEp1( event.getEp1() );
        entity.setEp2( event.getEp2() );
        entity.setEp3( event.getEp3() );
        entity.setEq1( event.getEq1() );
        entity.setEq2( event.getEq2() );
        entity.setEq3( event.getEq3() );
        entity.setKp1( event.getKp1() );
        entity.setKp2( event.getKp2() );
        entity.setKp3( event.getKp3() );
        entity.setKp4( event.getKp4() );
        entity.setKpf( event.getKpf() );
        entity.setKq1( event.getKq1() );
        entity.setKq2( event.getKq2() );
        entity.setKq3( event.getKq3() );
        entity.setKq4( event.getKq4() );
        entity.setKqf( event.getKqf() );
        entity.setStaticLoadModelType( event.getStaticLoadModelType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadStatic( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadStatic( entity );        
    }
    
    /*
     * @param	event DeleteLoadStaticEvent
     */
    @EventHandler( payloadType=DeleteLoadStaticEvent.class )
    public void handle( DeleteLoadStaticEvent event) {
    	LOGGER.info("handling DeleteLoadStaticEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadStatic entity = delete( event.getLoadStaticId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadStatic( entity );

    }    




    /**
     * Method to retrieve the LoadStatic via an LoadStaticPrimaryKey.
     * @param 	id Long
     * @return 	LoadStatic
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadStatic handle( FindLoadStaticQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadStaticId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadStatics
     *
     * @param	query	FindAllLoadStaticQuery 
     * @return 	List<LoadStatic> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadStatic> handle( FindAllLoadStaticQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadStatic, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadStatic
	 */
	protected void emitFindLoadStatic( LoadStatic entity ) {
		LOGGER.info("handling emitFindLoadStatic" );
		
	    queryUpdateEmitter.emit(FindLoadStaticQuery.class,
	                            query -> query.getFilter().getLoadStaticId().equals(entity.getLoadStaticId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadStatic
	 * 
	 * @param		entity	LoadStatic
	 */
	protected void emitFindAllLoadStatic( LoadStatic entity ) {
		LOGGER.info("handling emitFindAllLoadStatic" );
		
	    queryUpdateEmitter.emit(FindAllLoadStaticQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadStaticProjector.class.getName());

}
