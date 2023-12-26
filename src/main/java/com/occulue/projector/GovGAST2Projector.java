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
 * Projector for GovGAST2 as outlined for the CQRS pattern.  All event handling and query handling related to GovGAST2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovGAST2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govGAST2")
@Component("govGAST2-projector")
public class GovGAST2Projector extends GovGAST2EntityProjector {
		
	// core constructor
	public GovGAST2Projector(GovGAST2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovGAST2Event
     */
    @EventHandler( payloadType=CreateGovGAST2Event.class )
    public void handle( CreateGovGAST2Event event) {
	    LOGGER.info("handling CreateGovGAST2Event - " + event );
	    GovGAST2 entity = new GovGAST2();
        entity.setGovGAST2Id( event.getGovGAST2Id() );
        entity.setA( event.getA() );
        entity.setAf1( event.getAf1() );
        entity.setAf2( event.getAf2() );
        entity.setB( event.getB() );
        entity.setBf1( event.getBf1() );
        entity.setBf2( event.getBf2() );
        entity.setC( event.getC() );
        entity.setCf2( event.getCf2() );
        entity.setEcr( event.getEcr() );
        entity.setEtd( event.getEtd() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setK5( event.getK5() );
        entity.setK6( event.getK6() );
        entity.setKf( event.getKf() );
        entity.setMwbase( event.getMwbase() );
        entity.setT( event.getT() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setTc( event.getTc() );
        entity.setTcd( event.getTcd() );
        entity.setTf( event.getTf() );
        entity.setTmax( event.getTmax() );
        entity.setTmin( event.getTmin() );
        entity.setTr( event.getTr() );
        entity.setTrate( event.getTrate() );
        entity.setTt( event.getTt() );
        entity.setW( event.getW() );
        entity.setX( event.getX() );
        entity.setY( event.getY() );
        entity.setZ( event.getZ() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST2( entity );
    }

    /*
     * @param	event UpdateGovGAST2Event
     */
    @EventHandler( payloadType=UpdateGovGAST2Event.class )
    public void handle( UpdateGovGAST2Event event) {
    	LOGGER.info("handling UpdateGovGAST2Event - " + event );
    	
	    GovGAST2 entity = new GovGAST2();
        entity.setGovGAST2Id( event.getGovGAST2Id() );
        entity.setA( event.getA() );
        entity.setAf1( event.getAf1() );
        entity.setAf2( event.getAf2() );
        entity.setB( event.getB() );
        entity.setBf1( event.getBf1() );
        entity.setBf2( event.getBf2() );
        entity.setC( event.getC() );
        entity.setCf2( event.getCf2() );
        entity.setEcr( event.getEcr() );
        entity.setEtd( event.getEtd() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setK5( event.getK5() );
        entity.setK6( event.getK6() );
        entity.setKf( event.getKf() );
        entity.setMwbase( event.getMwbase() );
        entity.setT( event.getT() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setTc( event.getTc() );
        entity.setTcd( event.getTcd() );
        entity.setTf( event.getTf() );
        entity.setTmax( event.getTmax() );
        entity.setTmin( event.getTmin() );
        entity.setTr( event.getTr() );
        entity.setTrate( event.getTrate() );
        entity.setTt( event.getTt() );
        entity.setW( event.getW() );
        entity.setX( event.getX() );
        entity.setY( event.getY() );
        entity.setZ( event.getZ() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovGAST2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST2( entity );        
    }
    
    /*
     * @param	event DeleteGovGAST2Event
     */
    @EventHandler( payloadType=DeleteGovGAST2Event.class )
    public void handle( DeleteGovGAST2Event event) {
    	LOGGER.info("handling DeleteGovGAST2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovGAST2 entity = delete( event.getGovGAST2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGAST2( entity );

    }    




    /**
     * Method to retrieve the GovGAST2 via an GovGAST2PrimaryKey.
     * @param 	id Long
     * @return 	GovGAST2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovGAST2 handle( FindGovGAST2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovGAST2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovGAST2s
     *
     * @param	query	FindAllGovGAST2Query 
     * @return 	List<GovGAST2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovGAST2> handle( FindAllGovGAST2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovGAST2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovGAST2
	 */
	protected void emitFindGovGAST2( GovGAST2 entity ) {
		LOGGER.info("handling emitFindGovGAST2" );
		
	    queryUpdateEmitter.emit(FindGovGAST2Query.class,
	                            query -> query.getFilter().getGovGAST2Id().equals(entity.getGovGAST2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovGAST2
	 * 
	 * @param		entity	GovGAST2
	 */
	protected void emitFindAllGovGAST2( GovGAST2 entity ) {
		LOGGER.info("handling emitFindAllGovGAST2" );
		
	    queryUpdateEmitter.emit(FindAllGovGAST2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovGAST2Projector.class.getName());

}
