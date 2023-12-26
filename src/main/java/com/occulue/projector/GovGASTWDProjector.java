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
 * Projector for GovGASTWD as outlined for the CQRS pattern.  All event handling and query handling related to GovGASTWD are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovGASTWDAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govGASTWD")
@Component("govGASTWD-projector")
public class GovGASTWDProjector extends GovGASTWDEntityProjector {
		
	// core constructor
	public GovGASTWDProjector(GovGASTWDRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovGASTWDEvent
     */
    @EventHandler( payloadType=CreateGovGASTWDEvent.class )
    public void handle( CreateGovGASTWDEvent event) {
	    LOGGER.info("handling CreateGovGASTWDEvent - " + event );
	    GovGASTWD entity = new GovGASTWD();
        entity.setGovGASTWDId( event.getGovGASTWDId() );
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
        entity.setKd( event.getKd() );
        entity.setKdroop( event.getKdroop() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setT( event.getT() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setTc( event.getTc() );
        entity.setTcd( event.getTcd() );
        entity.setTd( event.getTd() );
        entity.setTf( event.getTf() );
        entity.setTmax( event.getTmax() );
        entity.setTmin( event.getTmin() );
        entity.setTr( event.getTr() );
        entity.setTrate( event.getTrate() );
        entity.setTt( event.getTt() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGASTWD( entity );
    }

    /*
     * @param	event UpdateGovGASTWDEvent
     */
    @EventHandler( payloadType=UpdateGovGASTWDEvent.class )
    public void handle( UpdateGovGASTWDEvent event) {
    	LOGGER.info("handling UpdateGovGASTWDEvent - " + event );
    	
	    GovGASTWD entity = new GovGASTWD();
        entity.setGovGASTWDId( event.getGovGASTWDId() );
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
        entity.setKd( event.getKd() );
        entity.setKdroop( event.getKdroop() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setT( event.getT() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setTc( event.getTc() );
        entity.setTcd( event.getTcd() );
        entity.setTd( event.getTd() );
        entity.setTf( event.getTf() );
        entity.setTmax( event.getTmax() );
        entity.setTmin( event.getTmin() );
        entity.setTr( event.getTr() );
        entity.setTrate( event.getTrate() );
        entity.setTt( event.getTt() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovGASTWD( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGASTWD( entity );        
    }
    
    /*
     * @param	event DeleteGovGASTWDEvent
     */
    @EventHandler( payloadType=DeleteGovGASTWDEvent.class )
    public void handle( DeleteGovGASTWDEvent event) {
    	LOGGER.info("handling DeleteGovGASTWDEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovGASTWD entity = delete( event.getGovGASTWDId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovGASTWD( entity );

    }    




    /**
     * Method to retrieve the GovGASTWD via an GovGASTWDPrimaryKey.
     * @param 	id Long
     * @return 	GovGASTWD
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovGASTWD handle( FindGovGASTWDQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovGASTWDId() );
    }
    
    /**
     * Method to retrieve a collection of all GovGASTWDs
     *
     * @param	query	FindAllGovGASTWDQuery 
     * @return 	List<GovGASTWD> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovGASTWD> handle( FindAllGovGASTWDQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovGASTWD, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovGASTWD
	 */
	protected void emitFindGovGASTWD( GovGASTWD entity ) {
		LOGGER.info("handling emitFindGovGASTWD" );
		
	    queryUpdateEmitter.emit(FindGovGASTWDQuery.class,
	                            query -> query.getFilter().getGovGASTWDId().equals(entity.getGovGASTWDId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovGASTWD
	 * 
	 * @param		entity	GovGASTWD
	 */
	protected void emitFindAllGovGASTWD( GovGASTWD entity ) {
		LOGGER.info("handling emitFindAllGovGASTWD" );
		
	    queryUpdateEmitter.emit(FindAllGovGASTWDQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovGASTWDProjector.class.getName());

}
