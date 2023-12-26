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
 * Projector for GovHydroR as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroR are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroRAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroR")
@Component("govHydroR-projector")
public class GovHydroRProjector extends GovHydroREntityProjector {
		
	// core constructor
	public GovHydroRProjector(GovHydroRRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroREvent
     */
    @EventHandler( payloadType=CreateGovHydroREvent.class )
    public void handle( CreateGovHydroREvent event) {
	    LOGGER.info("handling CreateGovHydroREvent - " + event );
	    GovHydroR entity = new GovHydroR();
        entity.setGovHydroRId( event.getGovHydroRId() );
        entity.setAt( event.getAt() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setDturb( event.getDturb() );
        entity.setEps( event.getEps() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setH0( event.getH0() );
        entity.setInputSignal( event.getInputSignal() );
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
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setTd( event.getTd() );
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
        emitFindAllGovHydroR( entity );
    }

    /*
     * @param	event UpdateGovHydroREvent
     */
    @EventHandler( payloadType=UpdateGovHydroREvent.class )
    public void handle( UpdateGovHydroREvent event) {
    	LOGGER.info("handling UpdateGovHydroREvent - " + event );
    	
	    GovHydroR entity = new GovHydroR();
        entity.setGovHydroRId( event.getGovHydroRId() );
        entity.setAt( event.getAt() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setDturb( event.getDturb() );
        entity.setEps( event.getEps() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setH0( event.getH0() );
        entity.setInputSignal( event.getInputSignal() );
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
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setTd( event.getTd() );
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
        emitFindGovHydroR( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroR( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroREvent
     */
    @EventHandler( payloadType=DeleteGovHydroREvent.class )
    public void handle( DeleteGovHydroREvent event) {
    	LOGGER.info("handling DeleteGovHydroREvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroR entity = delete( event.getGovHydroRId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroR( entity );

    }    




    /**
     * Method to retrieve the GovHydroR via an GovHydroRPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroR
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroR handle( FindGovHydroRQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroRId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroRs
     *
     * @param	query	FindAllGovHydroRQuery 
     * @return 	List<GovHydroR> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroR> handle( FindAllGovHydroRQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroR, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroR
	 */
	protected void emitFindGovHydroR( GovHydroR entity ) {
		LOGGER.info("handling emitFindGovHydroR" );
		
	    queryUpdateEmitter.emit(FindGovHydroRQuery.class,
	                            query -> query.getFilter().getGovHydroRId().equals(entity.getGovHydroRId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroR
	 * 
	 * @param		entity	GovHydroR
	 */
	protected void emitFindAllGovHydroR( GovHydroR entity ) {
		LOGGER.info("handling emitFindAllGovHydroR" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroRQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroRProjector.class.getName());

}
