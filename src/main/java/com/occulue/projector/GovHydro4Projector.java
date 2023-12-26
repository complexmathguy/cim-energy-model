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
 * Projector for GovHydro4 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydro4 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydro4Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydro4")
@Component("govHydro4-projector")
public class GovHydro4Projector extends GovHydro4EntityProjector {
		
	// core constructor
	public GovHydro4Projector(GovHydro4Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydro4Event
     */
    @EventHandler( payloadType=CreateGovHydro4Event.class )
    public void handle( CreateGovHydro4Event event) {
	    LOGGER.info("handling CreateGovHydro4Event - " + event );
	    GovHydro4 entity = new GovHydro4();
        entity.setGovHydro4Id( event.getGovHydro4Id() );
        entity.setAt( event.getAt() );
        entity.setBgv0( event.getBgv0() );
        entity.setBgv1( event.getBgv1() );
        entity.setBgv2( event.getBgv2() );
        entity.setBgv3( event.getBgv3() );
        entity.setBgv4( event.getBgv4() );
        entity.setBgv5( event.getBgv5() );
        entity.setBmax( event.getBmax() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setDturb( event.getDturb() );
        entity.setEps( event.getEps() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGv0( event.getGv0() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setHdam( event.getHdam() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv0( event.getPgv0() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setQn1( event.getQn1() );
        entity.setRperm( event.getRperm() );
        entity.setRtemp( event.getRtemp() );
        entity.setTblade( event.getTblade() );
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
        emitFindAllGovHydro4( entity );
    }

    /*
     * @param	event UpdateGovHydro4Event
     */
    @EventHandler( payloadType=UpdateGovHydro4Event.class )
    public void handle( UpdateGovHydro4Event event) {
    	LOGGER.info("handling UpdateGovHydro4Event - " + event );
    	
	    GovHydro4 entity = new GovHydro4();
        entity.setGovHydro4Id( event.getGovHydro4Id() );
        entity.setAt( event.getAt() );
        entity.setBgv0( event.getBgv0() );
        entity.setBgv1( event.getBgv1() );
        entity.setBgv2( event.getBgv2() );
        entity.setBgv3( event.getBgv3() );
        entity.setBgv4( event.getBgv4() );
        entity.setBgv5( event.getBgv5() );
        entity.setBmax( event.getBmax() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setDturb( event.getDturb() );
        entity.setEps( event.getEps() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGv0( event.getGv0() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setHdam( event.getHdam() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv0( event.getPgv0() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setQn1( event.getQn1() );
        entity.setRperm( event.getRperm() );
        entity.setRtemp( event.getRtemp() );
        entity.setTblade( event.getTblade() );
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
        emitFindGovHydro4( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro4( entity );        
    }
    
    /*
     * @param	event DeleteGovHydro4Event
     */
    @EventHandler( payloadType=DeleteGovHydro4Event.class )
    public void handle( DeleteGovHydro4Event event) {
    	LOGGER.info("handling DeleteGovHydro4Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydro4 entity = delete( event.getGovHydro4Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro4( entity );

    }    




    /**
     * Method to retrieve the GovHydro4 via an GovHydro4PrimaryKey.
     * @param 	id Long
     * @return 	GovHydro4
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydro4 handle( FindGovHydro4Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydro4Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydro4s
     *
     * @param	query	FindAllGovHydro4Query 
     * @return 	List<GovHydro4> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydro4> handle( FindAllGovHydro4Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydro4, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydro4
	 */
	protected void emitFindGovHydro4( GovHydro4 entity ) {
		LOGGER.info("handling emitFindGovHydro4" );
		
	    queryUpdateEmitter.emit(FindGovHydro4Query.class,
	                            query -> query.getFilter().getGovHydro4Id().equals(entity.getGovHydro4Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydro4
	 * 
	 * @param		entity	GovHydro4
	 */
	protected void emitFindAllGovHydro4( GovHydro4 entity ) {
		LOGGER.info("handling emitFindAllGovHydro4" );
		
	    queryUpdateEmitter.emit(FindAllGovHydro4Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydro4Projector.class.getName());

}
