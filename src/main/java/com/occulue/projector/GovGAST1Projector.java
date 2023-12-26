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
 * Projector for GovGAST1 as outlined for the CQRS pattern.  All event handling and query handling related to GovGAST1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovGAST1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govGAST1")
@Component("govGAST1-projector")
public class GovGAST1Projector extends GovGAST1EntityProjector {
		
	// core constructor
	public GovGAST1Projector(GovGAST1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovGAST1Event
     */
    @EventHandler( payloadType=CreateGovGAST1Event.class )
    public void handle( CreateGovGAST1Event event) {
	    LOGGER.info("handling CreateGovGAST1Event - " + event );
	    GovGAST1 entity = new GovGAST1();
        entity.setGovGAST1Id( event.getGovGAST1Id() );
        entity.setA( event.getA() );
        entity.setB( event.getB() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
        entity.setFidle( event.getFidle() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setKa( event.getKa() );
        entity.setKt( event.getKt() );
        entity.setLmax( event.getLmax() );
        entity.setLoadinc( event.getLoadinc() );
        entity.setLtrate( event.getLtrate() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setR( event.getR() );
        entity.setRmax( event.getRmax() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setTltr( event.getTltr() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST1( entity );
    }

    /*
     * @param	event UpdateGovGAST1Event
     */
    @EventHandler( payloadType=UpdateGovGAST1Event.class )
    public void handle( UpdateGovGAST1Event event) {
    	LOGGER.info("handling UpdateGovGAST1Event - " + event );
    	
	    GovGAST1 entity = new GovGAST1();
        entity.setGovGAST1Id( event.getGovGAST1Id() );
        entity.setA( event.getA() );
        entity.setB( event.getB() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
        entity.setFidle( event.getFidle() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setKa( event.getKa() );
        entity.setKt( event.getKt() );
        entity.setLmax( event.getLmax() );
        entity.setLoadinc( event.getLoadinc() );
        entity.setLtrate( event.getLtrate() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setR( event.getR() );
        entity.setRmax( event.getRmax() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setTltr( event.getTltr() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovGAST1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST1( entity );        
    }
    
    /*
     * @param	event DeleteGovGAST1Event
     */
    @EventHandler( payloadType=DeleteGovGAST1Event.class )
    public void handle( DeleteGovGAST1Event event) {
    	LOGGER.info("handling DeleteGovGAST1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovGAST1 entity = delete( event.getGovGAST1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST1( entity );

    }    




    /**
     * Method to retrieve the GovGAST1 via an GovGAST1PrimaryKey.
     * @param 	id Long
     * @return 	GovGAST1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovGAST1 handle( FindGovGAST1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovGAST1Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovGAST1s
     *
     * @param	query	FindAllGovGAST1Query 
     * @return 	List<GovGAST1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovGAST1> handle( FindAllGovGAST1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovGAST1, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovGAST1
	 */
	protected void emitFindGovGAST1( GovGAST1 entity ) {
		LOGGER.info("handling emitFindGovGAST1" );
		
	    queryUpdateEmitter.emit(FindGovGAST1Query.class,
	                            query -> query.getFilter().getGovGAST1Id().equals(entity.getGovGAST1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovGAST1
	 * 
	 * @param		entity	GovGAST1
	 */
	protected void emitFindAllGovGAST1( GovGAST1 entity ) {
		LOGGER.info("handling emitFindAllGovGAST1" );
		
	    queryUpdateEmitter.emit(FindAllGovGAST1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovGAST1Projector.class.getName());

}
