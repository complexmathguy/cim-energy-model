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
 * Projector for GovGAST as outlined for the CQRS pattern.  All event handling and query handling related to GovGAST are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovGASTAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govGAST")
@Component("govGAST-projector")
public class GovGASTProjector extends GovGASTEntityProjector {
		
	// core constructor
	public GovGASTProjector(GovGASTRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovGASTEvent
     */
    @EventHandler( payloadType=CreateGovGASTEvent.class )
    public void handle( CreateGovGASTEvent event) {
	    LOGGER.info("handling CreateGovGASTEvent - " + event );
	    GovGAST entity = new GovGAST();
        entity.setGovGASTId( event.getGovGASTId() );
        entity.setAt( event.getAt() );
        entity.setDturb( event.getDturb() );
        entity.setKt( event.getKt() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST( entity );
    }

    /*
     * @param	event UpdateGovGASTEvent
     */
    @EventHandler( payloadType=UpdateGovGASTEvent.class )
    public void handle( UpdateGovGASTEvent event) {
    	LOGGER.info("handling UpdateGovGASTEvent - " + event );
    	
	    GovGAST entity = new GovGAST();
        entity.setGovGASTId( event.getGovGASTId() );
        entity.setAt( event.getAt() );
        entity.setDturb( event.getDturb() );
        entity.setKt( event.getKt() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovGAST( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST( entity );        
    }
    
    /*
     * @param	event DeleteGovGASTEvent
     */
    @EventHandler( payloadType=DeleteGovGASTEvent.class )
    public void handle( DeleteGovGASTEvent event) {
    	LOGGER.info("handling DeleteGovGASTEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovGAST entity = delete( event.getGovGASTId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST( entity );

    }    




    /**
     * Method to retrieve the GovGAST via an GovGASTPrimaryKey.
     * @param 	id Long
     * @return 	GovGAST
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovGAST handle( FindGovGASTQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovGASTId() );
    }
    
    /**
     * Method to retrieve a collection of all GovGASTs
     *
     * @param	query	FindAllGovGASTQuery 
     * @return 	List<GovGAST> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovGAST> handle( FindAllGovGASTQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovGAST, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovGAST
	 */
	protected void emitFindGovGAST( GovGAST entity ) {
		LOGGER.info("handling emitFindGovGAST" );
		
	    queryUpdateEmitter.emit(FindGovGASTQuery.class,
	                            query -> query.getFilter().getGovGASTId().equals(entity.getGovGASTId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovGAST
	 * 
	 * @param		entity	GovGAST
	 */
	protected void emitFindAllGovGAST( GovGAST entity ) {
		LOGGER.info("handling emitFindAllGovGAST" );
		
	    queryUpdateEmitter.emit(FindAllGovGASTQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovGASTProjector.class.getName());

}
