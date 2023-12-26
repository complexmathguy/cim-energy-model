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
 * Projector for GovHydroDD as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroDD are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroDDAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroDD")
@Component("govHydroDD-projector")
public class GovHydroDDProjector extends GovHydroDDEntityProjector {
		
	// core constructor
	public GovHydroDDProjector(GovHydroDDRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroDDEvent
     */
    @EventHandler( payloadType=CreateGovHydroDDEvent.class )
    public void handle( CreateGovHydroDDEvent event) {
	    LOGGER.info("handling CreateGovHydroDDEvent - " + event );
	    GovHydroDD entity = new GovHydroDD();
        entity.setGovHydroDDId( event.getGovHydroDDId() );
        entity.setAturb( event.getAturb() );
        entity.setBturb( event.getBturb() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setInputSignal( event.getInputSignal() );
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
        emitFindAllGovHydroDD( entity );
    }

    /*
     * @param	event UpdateGovHydroDDEvent
     */
    @EventHandler( payloadType=UpdateGovHydroDDEvent.class )
    public void handle( UpdateGovHydroDDEvent event) {
    	LOGGER.info("handling UpdateGovHydroDDEvent - " + event );
    	
	    GovHydroDD entity = new GovHydroDD();
        entity.setGovHydroDDId( event.getGovHydroDDId() );
        entity.setAturb( event.getAturb() );
        entity.setBturb( event.getBturb() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setEps( event.getEps() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setGv6( event.getGv6() );
        entity.setInputSignal( event.getInputSignal() );
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
        emitFindGovHydroDD( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroDD( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroDDEvent
     */
    @EventHandler( payloadType=DeleteGovHydroDDEvent.class )
    public void handle( DeleteGovHydroDDEvent event) {
    	LOGGER.info("handling DeleteGovHydroDDEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroDD entity = delete( event.getGovHydroDDId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroDD( entity );

    }    




    /**
     * Method to retrieve the GovHydroDD via an GovHydroDDPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroDD
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroDD handle( FindGovHydroDDQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroDDId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroDDs
     *
     * @param	query	FindAllGovHydroDDQuery 
     * @return 	List<GovHydroDD> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroDD> handle( FindAllGovHydroDDQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroDD, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroDD
	 */
	protected void emitFindGovHydroDD( GovHydroDD entity ) {
		LOGGER.info("handling emitFindGovHydroDD" );
		
	    queryUpdateEmitter.emit(FindGovHydroDDQuery.class,
	                            query -> query.getFilter().getGovHydroDDId().equals(entity.getGovHydroDDId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroDD
	 * 
	 * @param		entity	GovHydroDD
	 */
	protected void emitFindAllGovHydroDD( GovHydroDD entity ) {
		LOGGER.info("handling emitFindAllGovHydroDD" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroDDQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroDDProjector.class.getName());

}
