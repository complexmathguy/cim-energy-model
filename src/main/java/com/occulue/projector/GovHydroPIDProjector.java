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
 * Projector for GovHydroPID as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroPID are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroPIDAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroPID")
@Component("govHydroPID-projector")
public class GovHydroPIDProjector extends GovHydroPIDEntityProjector {
		
	// core constructor
	public GovHydroPIDProjector(GovHydroPIDRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroPIDEvent
     */
    @EventHandler( payloadType=CreateGovHydroPIDEvent.class )
    public void handle( CreateGovHydroPIDEvent event) {
	    LOGGER.info("handling CreateGovHydroPIDEvent - " + event );
	    GovHydroPID entity = new GovHydroPID();
        entity.setGovHydroPIDId( event.getGovHydroPIDId() );
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
        entity.setInputSignal( event.getInputSignal() );
        entity.setKd( event.getKd() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setR( event.getR() );
        entity.setTd( event.getTd() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
        entity.setTt( event.getTt() );
        entity.setTturb( event.getTturb() );
        entity.setVelcl( event.getVelcl() );
        entity.setVelop( event.getVelop() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPID( entity );
    }

    /*
     * @param	event UpdateGovHydroPIDEvent
     */
    @EventHandler( payloadType=UpdateGovHydroPIDEvent.class )
    public void handle( UpdateGovHydroPIDEvent event) {
    	LOGGER.info("handling UpdateGovHydroPIDEvent - " + event );
    	
	    GovHydroPID entity = new GovHydroPID();
        entity.setGovHydroPIDId( event.getGovHydroPIDId() );
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
        entity.setInputSignal( event.getInputSignal() );
        entity.setKd( event.getKd() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setR( event.getR() );
        entity.setTd( event.getTd() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
        entity.setTt( event.getTt() );
        entity.setTturb( event.getTturb() );
        entity.setVelcl( event.getVelcl() );
        entity.setVelop( event.getVelop() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroPID( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPID( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroPIDEvent
     */
    @EventHandler( payloadType=DeleteGovHydroPIDEvent.class )
    public void handle( DeleteGovHydroPIDEvent event) {
    	LOGGER.info("handling DeleteGovHydroPIDEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroPID entity = delete( event.getGovHydroPIDId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPID( entity );

    }    




    /**
     * Method to retrieve the GovHydroPID via an GovHydroPIDPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroPID
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroPID handle( FindGovHydroPIDQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroPIDId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroPIDs
     *
     * @param	query	FindAllGovHydroPIDQuery 
     * @return 	List<GovHydroPID> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroPID> handle( FindAllGovHydroPIDQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroPID, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroPID
	 */
	protected void emitFindGovHydroPID( GovHydroPID entity ) {
		LOGGER.info("handling emitFindGovHydroPID" );
		
	    queryUpdateEmitter.emit(FindGovHydroPIDQuery.class,
	                            query -> query.getFilter().getGovHydroPIDId().equals(entity.getGovHydroPIDId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroPID
	 * 
	 * @param		entity	GovHydroPID
	 */
	protected void emitFindAllGovHydroPID( GovHydroPID entity ) {
		LOGGER.info("handling emitFindAllGovHydroPID" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroPIDQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPIDProjector.class.getName());

}
