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
 * Projector for GovGAST3 as outlined for the CQRS pattern.  All event handling and query handling related to GovGAST3 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovGAST3Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govGAST3")
@Component("govGAST3-projector")
public class GovGAST3Projector extends GovGAST3EntityProjector {
		
	// core constructor
	public GovGAST3Projector(GovGAST3Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovGAST3Event
     */
    @EventHandler( payloadType=CreateGovGAST3Event.class )
    public void handle( CreateGovGAST3Event event) {
	    LOGGER.info("handling CreateGovGAST3Event - " + event );
	    GovGAST3 entity = new GovGAST3();
        entity.setGovGAST3Id( event.getGovGAST3Id() );
        entity.setBca( event.getBca() );
        entity.setBp( event.getBp() );
        entity.setDtc( event.getDtc() );
        entity.setKa( event.getKa() );
        entity.setKac( event.getKac() );
        entity.setKca( event.getKca() );
        entity.setKsi( event.getKsi() );
        entity.setKy( event.getKy() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setRcmn( event.getRcmn() );
        entity.setRcmx( event.getRcmx() );
        entity.setTac( event.getTac() );
        entity.setTc( event.getTc() );
        entity.setTd( event.getTd() );
        entity.setTfen( event.getTfen() );
        entity.setTg( event.getTg() );
        entity.setTsi( event.getTsi() );
        entity.setTt( event.getTt() );
        entity.setTtc( event.getTtc() );
        entity.setTy( event.getTy() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST3( entity );
    }

    /*
     * @param	event UpdateGovGAST3Event
     */
    @EventHandler( payloadType=UpdateGovGAST3Event.class )
    public void handle( UpdateGovGAST3Event event) {
    	LOGGER.info("handling UpdateGovGAST3Event - " + event );
    	
	    GovGAST3 entity = new GovGAST3();
        entity.setGovGAST3Id( event.getGovGAST3Id() );
        entity.setBca( event.getBca() );
        entity.setBp( event.getBp() );
        entity.setDtc( event.getDtc() );
        entity.setKa( event.getKa() );
        entity.setKac( event.getKac() );
        entity.setKca( event.getKca() );
        entity.setKsi( event.getKsi() );
        entity.setKy( event.getKy() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setRcmn( event.getRcmn() );
        entity.setRcmx( event.getRcmx() );
        entity.setTac( event.getTac() );
        entity.setTc( event.getTc() );
        entity.setTd( event.getTd() );
        entity.setTfen( event.getTfen() );
        entity.setTg( event.getTg() );
        entity.setTsi( event.getTsi() );
        entity.setTt( event.getTt() );
        entity.setTtc( event.getTtc() );
        entity.setTy( event.getTy() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovGAST3( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST3( entity );        
    }
    
    /*
     * @param	event DeleteGovGAST3Event
     */
    @EventHandler( payloadType=DeleteGovGAST3Event.class )
    public void handle( DeleteGovGAST3Event event) {
    	LOGGER.info("handling DeleteGovGAST3Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovGAST3 entity = delete( event.getGovGAST3Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST3( entity );

    }    




    /**
     * Method to retrieve the GovGAST3 via an GovGAST3PrimaryKey.
     * @param 	id Long
     * @return 	GovGAST3
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovGAST3 handle( FindGovGAST3Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovGAST3Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovGAST3s
     *
     * @param	query	FindAllGovGAST3Query 
     * @return 	List<GovGAST3> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovGAST3> handle( FindAllGovGAST3Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovGAST3, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovGAST3
	 */
	protected void emitFindGovGAST3( GovGAST3 entity ) {
		LOGGER.info("handling emitFindGovGAST3" );
		
	    queryUpdateEmitter.emit(FindGovGAST3Query.class,
	                            query -> query.getFilter().getGovGAST3Id().equals(entity.getGovGAST3Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovGAST3
	 * 
	 * @param		entity	GovGAST3
	 */
	protected void emitFindAllGovGAST3( GovGAST3 entity ) {
		LOGGER.info("handling emitFindAllGovGAST3" );
		
	    queryUpdateEmitter.emit(FindAllGovGAST3Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovGAST3Projector.class.getName());

}
