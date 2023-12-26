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
 * Projector for GovGAST4 as outlined for the CQRS pattern.  All event handling and query handling related to GovGAST4 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovGAST4Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govGAST4")
@Component("govGAST4-projector")
public class GovGAST4Projector extends GovGAST4EntityProjector {
		
	// core constructor
	public GovGAST4Projector(GovGAST4Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovGAST4Event
     */
    @EventHandler( payloadType=CreateGovGAST4Event.class )
    public void handle( CreateGovGAST4Event event) {
	    LOGGER.info("handling CreateGovGAST4Event - " + event );
	    GovGAST4 entity = new GovGAST4();
        entity.setGovGAST4Id( event.getGovGAST4Id() );
        entity.setBp( event.getBp() );
        entity.setKtm( event.getKtm() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setRymn( event.getRymn() );
        entity.setRymx( event.getRymx() );
        entity.setTa( event.getTa() );
        entity.setTc( event.getTc() );
        entity.setTcm( event.getTcm() );
        entity.setTm( event.getTm() );
        entity.setTv( event.getTv() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST4( entity );
    }

    /*
     * @param	event UpdateGovGAST4Event
     */
    @EventHandler( payloadType=UpdateGovGAST4Event.class )
    public void handle( UpdateGovGAST4Event event) {
    	LOGGER.info("handling UpdateGovGAST4Event - " + event );
    	
	    GovGAST4 entity = new GovGAST4();
        entity.setGovGAST4Id( event.getGovGAST4Id() );
        entity.setBp( event.getBp() );
        entity.setKtm( event.getKtm() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setRymn( event.getRymn() );
        entity.setRymx( event.getRymx() );
        entity.setTa( event.getTa() );
        entity.setTc( event.getTc() );
        entity.setTcm( event.getTcm() );
        entity.setTm( event.getTm() );
        entity.setTv( event.getTv() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovGAST4( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST4( entity );        
    }
    
    /*
     * @param	event DeleteGovGAST4Event
     */
    @EventHandler( payloadType=DeleteGovGAST4Event.class )
    public void handle( DeleteGovGAST4Event event) {
    	LOGGER.info("handling DeleteGovGAST4Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovGAST4 entity = delete( event.getGovGAST4Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST4( entity );

    }    




    /**
     * Method to retrieve the GovGAST4 via an GovGAST4PrimaryKey.
     * @param 	id Long
     * @return 	GovGAST4
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovGAST4 handle( FindGovGAST4Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovGAST4Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovGAST4s
     *
     * @param	query	FindAllGovGAST4Query 
     * @return 	List<GovGAST4> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovGAST4> handle( FindAllGovGAST4Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovGAST4, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovGAST4
	 */
	protected void emitFindGovGAST4( GovGAST4 entity ) {
		LOGGER.info("handling emitFindGovGAST4" );
		
	    queryUpdateEmitter.emit(FindGovGAST4Query.class,
	                            query -> query.getFilter().getGovGAST4Id().equals(entity.getGovGAST4Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovGAST4
	 * 
	 * @param		entity	GovGAST4
	 */
	protected void emitFindAllGovGAST4( GovGAST4 entity ) {
		LOGGER.info("handling emitFindAllGovGAST4" );
		
	    queryUpdateEmitter.emit(FindAllGovGAST4Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovGAST4Projector.class.getName());

}
