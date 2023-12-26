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
 * Projector for GovHydro2 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydro2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydro2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydro2")
@Component("govHydro2-projector")
public class GovHydro2Projector extends GovHydro2EntityProjector {
		
	// core constructor
	public GovHydro2Projector(GovHydro2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydro2Event
     */
    @EventHandler( payloadType=CreateGovHydro2Event.class )
    public void handle( CreateGovHydro2Event event) {
	    LOGGER.info("handling CreateGovHydro2Event - " + event );
	    GovHydro2 entity = new GovHydro2();
        entity.setGovHydro2Id( event.getGovHydro2Id() );
        entity.setAturb( event.getAturb() );
        entity.setBturb( event.getBturb() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
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
        emitFindAllGovHydro2( entity );
    }

    /*
     * @param	event UpdateGovHydro2Event
     */
    @EventHandler( payloadType=UpdateGovHydro2Event.class )
    public void handle( UpdateGovHydro2Event event) {
    	LOGGER.info("handling UpdateGovHydro2Event - " + event );
    	
	    GovHydro2 entity = new GovHydro2();
        entity.setGovHydro2Id( event.getGovHydro2Id() );
        entity.setAturb( event.getAturb() );
        entity.setBturb( event.getBturb() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
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
        emitFindGovHydro2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro2( entity );        
    }
    
    /*
     * @param	event DeleteGovHydro2Event
     */
    @EventHandler( payloadType=DeleteGovHydro2Event.class )
    public void handle( DeleteGovHydro2Event event) {
    	LOGGER.info("handling DeleteGovHydro2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydro2 entity = delete( event.getGovHydro2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro2( entity );

    }    




    /**
     * Method to retrieve the GovHydro2 via an GovHydro2PrimaryKey.
     * @param 	id Long
     * @return 	GovHydro2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydro2 handle( FindGovHydro2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydro2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydro2s
     *
     * @param	query	FindAllGovHydro2Query 
     * @return 	List<GovHydro2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydro2> handle( FindAllGovHydro2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydro2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydro2
	 */
	protected void emitFindGovHydro2( GovHydro2 entity ) {
		LOGGER.info("handling emitFindGovHydro2" );
		
	    queryUpdateEmitter.emit(FindGovHydro2Query.class,
	                            query -> query.getFilter().getGovHydro2Id().equals(entity.getGovHydro2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydro2
	 * 
	 * @param		entity	GovHydro2
	 */
	protected void emitFindAllGovHydro2( GovHydro2 entity ) {
		LOGGER.info("handling emitFindAllGovHydro2" );
		
	    queryUpdateEmitter.emit(FindAllGovHydro2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydro2Projector.class.getName());

}
