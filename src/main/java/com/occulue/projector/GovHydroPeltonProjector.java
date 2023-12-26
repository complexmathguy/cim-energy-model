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
 * Projector for GovHydroPelton as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroPelton are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroPeltonAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroPelton")
@Component("govHydroPelton-projector")
public class GovHydroPeltonProjector extends GovHydroPeltonEntityProjector {
		
	// core constructor
	public GovHydroPeltonProjector(GovHydroPeltonRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroPeltonEvent
     */
    @EventHandler( payloadType=CreateGovHydroPeltonEvent.class )
    public void handle( CreateGovHydroPeltonEvent event) {
	    LOGGER.info("handling CreateGovHydroPeltonEvent - " + event );
	    GovHydroPelton entity = new GovHydroPelton();
        entity.setGovHydroPeltonId( event.getGovHydroPeltonId() );
        entity.setAv0( event.getAv0() );
        entity.setAv1( event.getAv1() );
        entity.setBp( event.getBp() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setH1( event.getH1() );
        entity.setH2( event.getH2() );
        entity.setHn( event.getHn() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setQc0( event.getQc0() );
        entity.setQn( event.getQn() );
        entity.setSimplifiedPelton( event.getSimplifiedPelton() );
        entity.setStaticCompensating( event.getStaticCompensating() );
        entity.setTa( event.getTa() );
        entity.setTs( event.getTs() );
        entity.setTv( event.getTv() );
        entity.setTwnc( event.getTwnc() );
        entity.setTwng( event.getTwng() );
        entity.setTx( event.getTx() );
        entity.setVa( event.getVa() );
        entity.setValvmax( event.getValvmax() );
        entity.setValvmin( event.getValvmin() );
        entity.setVav( event.getVav() );
        entity.setVc( event.getVc() );
        entity.setVcv( event.getVcv() );
        entity.setWaterTunnelSurgeChamberSimulation( event.getWaterTunnelSurgeChamberSimulation() );
        entity.setZsfc( event.getZsfc() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPelton( entity );
    }

    /*
     * @param	event UpdateGovHydroPeltonEvent
     */
    @EventHandler( payloadType=UpdateGovHydroPeltonEvent.class )
    public void handle( UpdateGovHydroPeltonEvent event) {
    	LOGGER.info("handling UpdateGovHydroPeltonEvent - " + event );
    	
	    GovHydroPelton entity = new GovHydroPelton();
        entity.setGovHydroPeltonId( event.getGovHydroPeltonId() );
        entity.setAv0( event.getAv0() );
        entity.setAv1( event.getAv1() );
        entity.setBp( event.getBp() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setH1( event.getH1() );
        entity.setH2( event.getH2() );
        entity.setHn( event.getHn() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setQc0( event.getQc0() );
        entity.setQn( event.getQn() );
        entity.setSimplifiedPelton( event.getSimplifiedPelton() );
        entity.setStaticCompensating( event.getStaticCompensating() );
        entity.setTa( event.getTa() );
        entity.setTs( event.getTs() );
        entity.setTv( event.getTv() );
        entity.setTwnc( event.getTwnc() );
        entity.setTwng( event.getTwng() );
        entity.setTx( event.getTx() );
        entity.setVa( event.getVa() );
        entity.setValvmax( event.getValvmax() );
        entity.setValvmin( event.getValvmin() );
        entity.setVav( event.getVav() );
        entity.setVc( event.getVc() );
        entity.setVcv( event.getVcv() );
        entity.setWaterTunnelSurgeChamberSimulation( event.getWaterTunnelSurgeChamberSimulation() );
        entity.setZsfc( event.getZsfc() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroPelton( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPelton( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroPeltonEvent
     */
    @EventHandler( payloadType=DeleteGovHydroPeltonEvent.class )
    public void handle( DeleteGovHydroPeltonEvent event) {
    	LOGGER.info("handling DeleteGovHydroPeltonEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroPelton entity = delete( event.getGovHydroPeltonId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPelton( entity );

    }    




    /**
     * Method to retrieve the GovHydroPelton via an GovHydroPeltonPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroPelton
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroPelton handle( FindGovHydroPeltonQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroPeltonId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroPeltons
     *
     * @param	query	FindAllGovHydroPeltonQuery 
     * @return 	List<GovHydroPelton> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroPelton> handle( FindAllGovHydroPeltonQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroPelton, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroPelton
	 */
	protected void emitFindGovHydroPelton( GovHydroPelton entity ) {
		LOGGER.info("handling emitFindGovHydroPelton" );
		
	    queryUpdateEmitter.emit(FindGovHydroPeltonQuery.class,
	                            query -> query.getFilter().getGovHydroPeltonId().equals(entity.getGovHydroPeltonId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroPelton
	 * 
	 * @param		entity	GovHydroPelton
	 */
	protected void emitFindAllGovHydroPelton( GovHydroPelton entity ) {
		LOGGER.info("handling emitFindAllGovHydroPelton" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroPeltonQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPeltonProjector.class.getName());

}
