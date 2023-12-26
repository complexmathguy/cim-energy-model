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
 * Projector for GovSteam1 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteam1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteam1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteam1")
@Component("govSteam1-projector")
public class GovSteam1Projector extends GovSteam1EntityProjector {
		
	// core constructor
	public GovSteam1Projector(GovSteam1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteam1Event
     */
    @EventHandler( payloadType=CreateGovSteam1Event.class )
    public void handle( CreateGovSteam1Event event) {
	    LOGGER.info("handling CreateGovSteam1Event - " + event );
	    GovSteam1 entity = new GovSteam1();
        entity.setGovSteam1Id( event.getGovSteam1Id() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setK5( event.getK5() );
        entity.setK6( event.getK6() );
        entity.setK7( event.getK7() );
        entity.setK8( event.getK8() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setSdb1( event.getSdb1() );
        entity.setSdb2( event.getSdb2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
        entity.setValve( event.getValve() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam1( entity );
    }

    /*
     * @param	event UpdateGovSteam1Event
     */
    @EventHandler( payloadType=UpdateGovSteam1Event.class )
    public void handle( UpdateGovSteam1Event event) {
    	LOGGER.info("handling UpdateGovSteam1Event - " + event );
    	
	    GovSteam1 entity = new GovSteam1();
        entity.setGovSteam1Id( event.getGovSteam1Id() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setK5( event.getK5() );
        entity.setK6( event.getK6() );
        entity.setK7( event.getK7() );
        entity.setK8( event.getK8() );
        entity.setMwbase( event.getMwbase() );
        entity.setPgv1( event.getPgv1() );
        entity.setPgv2( event.getPgv2() );
        entity.setPgv3( event.getPgv3() );
        entity.setPgv4( event.getPgv4() );
        entity.setPgv5( event.getPgv5() );
        entity.setPgv6( event.getPgv6() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setSdb1( event.getSdb1() );
        entity.setSdb2( event.getSdb2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
        entity.setValve( event.getValve() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteam1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam1( entity );        
    }
    
    /*
     * @param	event DeleteGovSteam1Event
     */
    @EventHandler( payloadType=DeleteGovSteam1Event.class )
    public void handle( DeleteGovSteam1Event event) {
    	LOGGER.info("handling DeleteGovSteam1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteam1 entity = delete( event.getGovSteam1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam1( entity );

    }    




    /**
     * Method to retrieve the GovSteam1 via an GovSteam1PrimaryKey.
     * @param 	id Long
     * @return 	GovSteam1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteam1 handle( FindGovSteam1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteam1Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteam1s
     *
     * @param	query	FindAllGovSteam1Query 
     * @return 	List<GovSteam1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteam1> handle( FindAllGovSteam1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteam1, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteam1
	 */
	protected void emitFindGovSteam1( GovSteam1 entity ) {
		LOGGER.info("handling emitFindGovSteam1" );
		
	    queryUpdateEmitter.emit(FindGovSteam1Query.class,
	                            query -> query.getFilter().getGovSteam1Id().equals(entity.getGovSteam1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteam1
	 * 
	 * @param		entity	GovSteam1
	 */
	protected void emitFindAllGovSteam1( GovSteam1 entity ) {
		LOGGER.info("handling emitFindAllGovSteam1" );
		
	    queryUpdateEmitter.emit(FindAllGovSteam1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteam1Projector.class.getName());

}
