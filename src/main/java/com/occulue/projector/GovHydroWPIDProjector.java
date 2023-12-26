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
 * Projector for GovHydroWPID as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroWPID are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroWPIDAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroWPID")
@Component("govHydroWPID-projector")
public class GovHydroWPIDProjector extends GovHydroWPIDEntityProjector {
		
	// core constructor
	public GovHydroWPIDProjector(GovHydroWPIDRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroWPIDEvent
     */
    @EventHandler( payloadType=CreateGovHydroWPIDEvent.class )
    public void handle( CreateGovHydroWPIDEvent event) {
	    LOGGER.info("handling CreateGovHydroWPIDEvent - " + event );
	    GovHydroWPID entity = new GovHydroWPID();
        entity.setGovHydroWPIDId( event.getGovHydroWPIDId() );
        entity.setD( event.getD() );
        entity.setGatmax( event.getGatmax() );
        entity.setGatmin( event.getGatmin() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setKd( event.getKd() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setReg( event.getReg() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTreg( event.getTreg() );
        entity.setTw( event.getTw() );
        entity.setVelmax( event.getVelmax() );
        entity.setVelmin( event.getVelmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroWPID( entity );
    }

    /*
     * @param	event UpdateGovHydroWPIDEvent
     */
    @EventHandler( payloadType=UpdateGovHydroWPIDEvent.class )
    public void handle( UpdateGovHydroWPIDEvent event) {
    	LOGGER.info("handling UpdateGovHydroWPIDEvent - " + event );
    	
	    GovHydroWPID entity = new GovHydroWPID();
        entity.setGovHydroWPIDId( event.getGovHydroWPIDId() );
        entity.setD( event.getD() );
        entity.setGatmax( event.getGatmax() );
        entity.setGatmin( event.getGatmin() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setKd( event.getKd() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setReg( event.getReg() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTreg( event.getTreg() );
        entity.setTw( event.getTw() );
        entity.setVelmax( event.getVelmax() );
        entity.setVelmin( event.getVelmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroWPID( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroWPID( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroWPIDEvent
     */
    @EventHandler( payloadType=DeleteGovHydroWPIDEvent.class )
    public void handle( DeleteGovHydroWPIDEvent event) {
    	LOGGER.info("handling DeleteGovHydroWPIDEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroWPID entity = delete( event.getGovHydroWPIDId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroWPID( entity );

    }    




    /**
     * Method to retrieve the GovHydroWPID via an GovHydroWPIDPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroWPID
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroWPID handle( FindGovHydroWPIDQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroWPIDId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroWPIDs
     *
     * @param	query	FindAllGovHydroWPIDQuery 
     * @return 	List<GovHydroWPID> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroWPID> handle( FindAllGovHydroWPIDQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroWPID, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroWPID
	 */
	protected void emitFindGovHydroWPID( GovHydroWPID entity ) {
		LOGGER.info("handling emitFindGovHydroWPID" );
		
	    queryUpdateEmitter.emit(FindGovHydroWPIDQuery.class,
	                            query -> query.getFilter().getGovHydroWPIDId().equals(entity.getGovHydroWPIDId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroWPID
	 * 
	 * @param		entity	GovHydroWPID
	 */
	protected void emitFindAllGovHydroWPID( GovHydroWPID entity ) {
		LOGGER.info("handling emitFindAllGovHydroWPID" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroWPIDQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroWPIDProjector.class.getName());

}
