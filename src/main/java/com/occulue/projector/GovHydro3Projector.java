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
 * Projector for GovHydro3 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydro3 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydro3Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydro3")
@Component("govHydro3-projector")
public class GovHydro3Projector extends GovHydro3EntityProjector {
		
	// core constructor
	public GovHydro3Projector(GovHydro3Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydro3Event
     */
    @EventHandler( payloadType=CreateGovHydro3Event.class )
    public void handle( CreateGovHydro3Event event) {
	    LOGGER.info("handling CreateGovHydro3Event - " + event );
	    GovHydro3 entity = new GovHydro3();
        entity.setGovHydro3Id( event.getGovHydro3Id() );
        entity.setAt( event.getAt() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setDturb( event.getDturb() );
        entity.setEps( event.getEps() );
        entity.setGovernorControl( event.getGovernorControl() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setH0( event.getH0() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setQnl( event.getQnl() );
        entity.setRelec( event.getRelec() );
        entity.setRgate( event.getRgate() );
        entity.setTd( event.getTd() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
        entity.setTt( event.getTt() );
        entity.setTw( event.getTw() );
        entity.setVelcl( event.getVelcl() );
        entity.setVelop( event.getVelop() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro3( entity );
    }

    /*
     * @param	event UpdateGovHydro3Event
     */
    @EventHandler( payloadType=UpdateGovHydro3Event.class )
    public void handle( UpdateGovHydro3Event event) {
    	LOGGER.info("handling UpdateGovHydro3Event - " + event );
    	
	    GovHydro3 entity = new GovHydro3();
        entity.setGovHydro3Id( event.getGovHydro3Id() );
        entity.setAt( event.getAt() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setDturb( event.getDturb() );
        entity.setEps( event.getEps() );
        entity.setGovernorControl( event.getGovernorControl() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setH0( event.getH0() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setQnl( event.getQnl() );
        entity.setRelec( event.getRelec() );
        entity.setRgate( event.getRgate() );
        entity.setTd( event.getTd() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
        entity.setTt( event.getTt() );
        entity.setTw( event.getTw() );
        entity.setVelcl( event.getVelcl() );
        entity.setVelop( event.getVelop() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydro3( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro3( entity );        
    }
    
    /*
     * @param	event DeleteGovHydro3Event
     */
    @EventHandler( payloadType=DeleteGovHydro3Event.class )
    public void handle( DeleteGovHydro3Event event) {
    	LOGGER.info("handling DeleteGovHydro3Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydro3 entity = delete( event.getGovHydro3Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro3( entity );

    }    




    /**
     * Method to retrieve the GovHydro3 via an GovHydro3PrimaryKey.
     * @param 	id Long
     * @return 	GovHydro3
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydro3 handle( FindGovHydro3Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydro3Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydro3s
     *
     * @param	query	FindAllGovHydro3Query 
     * @return 	List<GovHydro3> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydro3> handle( FindAllGovHydro3Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydro3, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydro3
	 */
	protected void emitFindGovHydro3( GovHydro3 entity ) {
		LOGGER.info("handling emitFindGovHydro3" );
		
	    queryUpdateEmitter.emit(FindGovHydro3Query.class,
	                            query -> query.getFilter().getGovHydro3Id().equals(entity.getGovHydro3Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydro3
	 * 
	 * @param		entity	GovHydro3
	 */
	protected void emitFindAllGovHydro3( GovHydro3 entity ) {
		LOGGER.info("handling emitFindAllGovHydro3" );
		
	    queryUpdateEmitter.emit(FindAllGovHydro3Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydro3Projector.class.getName());

}
