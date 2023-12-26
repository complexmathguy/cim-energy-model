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
 * Projector for GovHydroFrancis as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroFrancis are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroFrancisAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroFrancis")
@Component("govHydroFrancis-projector")
public class GovHydroFrancisProjector extends GovHydroFrancisEntityProjector {
		
	// core constructor
	public GovHydroFrancisProjector(GovHydroFrancisRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroFrancisEvent
     */
    @EventHandler( payloadType=CreateGovHydroFrancisEvent.class )
    public void handle( CreateGovHydroFrancisEvent event) {
	    LOGGER.info("handling CreateGovHydroFrancisEvent - " + event );
	    GovHydroFrancis entity = new GovHydroFrancis();
        entity.setGovHydroFrancisId( event.getGovHydroFrancisId() );
        entity.setAm( event.getAm() );
        entity.setAv0( event.getAv0() );
        entity.setAv1( event.getAv1() );
        entity.setBp( event.getBp() );
        entity.setDb1( event.getDb1() );
        entity.setEtamax( event.getEtamax() );
        entity.setGovernorControl( event.getGovernorControl() );
        entity.setH1( event.getH1() );
        entity.setH2( event.getH2() );
        entity.setHn( event.getHn() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKt( event.getKt() );
        entity.setQc0( event.getQc0() );
        entity.setQn( event.getQn() );
        entity.setTa( event.getTa() );
        entity.setTd( event.getTd() );
        entity.setTs( event.getTs() );
        entity.setTwnc( event.getTwnc() );
        entity.setTwng( event.getTwng() );
        entity.setTx( event.getTx() );
        entity.setVa( event.getVa() );
        entity.setValvmax( event.getValvmax() );
        entity.setValvmin( event.getValvmin() );
        entity.setVc( event.getVc() );
        entity.setWaterTunnelSurgeChamberSimulation( event.getWaterTunnelSurgeChamberSimulation() );
        entity.setZsfc( event.getZsfc() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroFrancis( entity );
    }

    /*
     * @param	event UpdateGovHydroFrancisEvent
     */
    @EventHandler( payloadType=UpdateGovHydroFrancisEvent.class )
    public void handle( UpdateGovHydroFrancisEvent event) {
    	LOGGER.info("handling UpdateGovHydroFrancisEvent - " + event );
    	
	    GovHydroFrancis entity = new GovHydroFrancis();
        entity.setGovHydroFrancisId( event.getGovHydroFrancisId() );
        entity.setAm( event.getAm() );
        entity.setAv0( event.getAv0() );
        entity.setAv1( event.getAv1() );
        entity.setBp( event.getBp() );
        entity.setDb1( event.getDb1() );
        entity.setEtamax( event.getEtamax() );
        entity.setGovernorControl( event.getGovernorControl() );
        entity.setH1( event.getH1() );
        entity.setH2( event.getH2() );
        entity.setHn( event.getHn() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKt( event.getKt() );
        entity.setQc0( event.getQc0() );
        entity.setQn( event.getQn() );
        entity.setTa( event.getTa() );
        entity.setTd( event.getTd() );
        entity.setTs( event.getTs() );
        entity.setTwnc( event.getTwnc() );
        entity.setTwng( event.getTwng() );
        entity.setTx( event.getTx() );
        entity.setVa( event.getVa() );
        entity.setValvmax( event.getValvmax() );
        entity.setValvmin( event.getValvmin() );
        entity.setVc( event.getVc() );
        entity.setWaterTunnelSurgeChamberSimulation( event.getWaterTunnelSurgeChamberSimulation() );
        entity.setZsfc( event.getZsfc() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroFrancis( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroFrancis( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroFrancisEvent
     */
    @EventHandler( payloadType=DeleteGovHydroFrancisEvent.class )
    public void handle( DeleteGovHydroFrancisEvent event) {
    	LOGGER.info("handling DeleteGovHydroFrancisEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroFrancis entity = delete( event.getGovHydroFrancisId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroFrancis( entity );

    }    




    /**
     * Method to retrieve the GovHydroFrancis via an GovHydroFrancisPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroFrancis
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroFrancis handle( FindGovHydroFrancisQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroFrancisId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroFranciss
     *
     * @param	query	FindAllGovHydroFrancisQuery 
     * @return 	List<GovHydroFrancis> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroFrancis> handle( FindAllGovHydroFrancisQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroFrancis, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroFrancis
	 */
	protected void emitFindGovHydroFrancis( GovHydroFrancis entity ) {
		LOGGER.info("handling emitFindGovHydroFrancis" );
		
	    queryUpdateEmitter.emit(FindGovHydroFrancisQuery.class,
	                            query -> query.getFilter().getGovHydroFrancisId().equals(entity.getGovHydroFrancisId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroFrancis
	 * 
	 * @param		entity	GovHydroFrancis
	 */
	protected void emitFindAllGovHydroFrancis( GovHydroFrancis entity ) {
		LOGGER.info("handling emitFindAllGovHydroFrancis" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroFrancisQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroFrancisProjector.class.getName());

}
