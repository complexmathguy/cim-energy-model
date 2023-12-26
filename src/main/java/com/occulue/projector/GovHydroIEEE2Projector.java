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
 * Projector for GovHydroIEEE2 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroIEEE2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroIEEE2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroIEEE2")
@Component("govHydroIEEE2-projector")
public class GovHydroIEEE2Projector extends GovHydroIEEE2EntityProjector {
		
	// core constructor
	public GovHydroIEEE2Projector(GovHydroIEEE2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroIEEE2Event
     */
    @EventHandler( payloadType=CreateGovHydroIEEE2Event.class )
    public void handle( CreateGovHydroIEEE2Event event) {
	    LOGGER.info("handling CreateGovHydroIEEE2Event - " + event );
	    GovHydroIEEE2 entity = new GovHydroIEEE2();
        entity.setGovHydroIEEE2Id( event.getGovHydroIEEE2Id() );
        entity.setAturb( event.getAturb() );
        entity.setBturb( event.getBturb() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setKturb( event.getKturb() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setRperm( event.getRperm() );
        entity.setRtemp( event.getRtemp() );
        entity.setTg( event.getTg() );
        entity.setTp( event.getTp() );
        entity.setTr( event.getTr() );
        entity.setTw( event.getTw() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroIEEE2( entity );
    }

    /*
     * @param	event UpdateGovHydroIEEE2Event
     */
    @EventHandler( payloadType=UpdateGovHydroIEEE2Event.class )
    public void handle( UpdateGovHydroIEEE2Event event) {
    	LOGGER.info("handling UpdateGovHydroIEEE2Event - " + event );
    	
	    GovHydroIEEE2 entity = new GovHydroIEEE2();
        entity.setGovHydroIEEE2Id( event.getGovHydroIEEE2Id() );
        entity.setAturb( event.getAturb() );
        entity.setBturb( event.getBturb() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setKturb( event.getKturb() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setRperm( event.getRperm() );
        entity.setRtemp( event.getRtemp() );
        entity.setTg( event.getTg() );
        entity.setTp( event.getTp() );
        entity.setTr( event.getTr() );
        entity.setTw( event.getTw() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroIEEE2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroIEEE2( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroIEEE2Event
     */
    @EventHandler( payloadType=DeleteGovHydroIEEE2Event.class )
    public void handle( DeleteGovHydroIEEE2Event event) {
    	LOGGER.info("handling DeleteGovHydroIEEE2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroIEEE2 entity = delete( event.getGovHydroIEEE2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroIEEE2( entity );

    }    




    /**
     * Method to retrieve the GovHydroIEEE2 via an GovHydroIEEE2PrimaryKey.
     * @param 	id Long
     * @return 	GovHydroIEEE2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroIEEE2 handle( FindGovHydroIEEE2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroIEEE2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroIEEE2s
     *
     * @param	query	FindAllGovHydroIEEE2Query 
     * @return 	List<GovHydroIEEE2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroIEEE2> handle( FindAllGovHydroIEEE2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroIEEE2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroIEEE2
	 */
	protected void emitFindGovHydroIEEE2( GovHydroIEEE2 entity ) {
		LOGGER.info("handling emitFindGovHydroIEEE2" );
		
	    queryUpdateEmitter.emit(FindGovHydroIEEE2Query.class,
	                            query -> query.getFilter().getGovHydroIEEE2Id().equals(entity.getGovHydroIEEE2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroIEEE2
	 * 
	 * @param		entity	GovHydroIEEE2
	 */
	protected void emitFindAllGovHydroIEEE2( GovHydroIEEE2 entity ) {
		LOGGER.info("handling emitFindAllGovHydroIEEE2" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroIEEE2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroIEEE2Projector.class.getName());

}
