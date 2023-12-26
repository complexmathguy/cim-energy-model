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
 * Projector for GovHydroWEH as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroWEH are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroWEHAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroWEH")
@Component("govHydroWEH-projector")
public class GovHydroWEHProjector extends GovHydroWEHEntityProjector {
		
	// core constructor
	public GovHydroWEHProjector(GovHydroWEHRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroWEHEvent
     */
    @EventHandler( payloadType=CreateGovHydroWEHEvent.class )
    public void handle( CreateGovHydroWEHEvent event) {
	    LOGGER.info("handling CreateGovHydroWEHEvent - " + event );
	    GovHydroWEH entity = new GovHydroWEH();
        entity.setGovHydroWEHId( event.getGovHydroWEHId() );
        entity.setDb( event.getDb() );
        entity.setDicn( event.getDicn() );
        entity.setDpv( event.getDpv() );
        entity.setDturb( event.getDturb() );
        entity.setFeedbackSignal( event.getFeedbackSignal() );
        entity.setFl1( event.getFl1() );
        entity.setFl2( event.getFl2() );
        entity.setFl3( event.getFl3() );
        entity.setFl4( event.getFl4() );
        entity.setFl5( event.getFl5() );
        entity.setFp1( event.getFp1() );
        entity.setFp10( event.getFp10() );
        entity.setFp2( event.getFp2() );
        entity.setFp3( event.getFp3() );
        entity.setFp4( event.getFp4() );
        entity.setFp5( event.getFp5() );
        entity.setFp6( event.getFp6() );
        entity.setFp7( event.getFp7() );
        entity.setFp8( event.getFp8() );
        entity.setFp9( event.getFp9() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGtmxcl( event.getGtmxcl() );
        entity.setGtmxop( event.getGtmxop() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setKd( event.getKd() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmss1( event.getPmss1() );
        entity.setPmss10( event.getPmss10() );
        entity.setPmss2( event.getPmss2() );
        entity.setPmss3( event.getPmss3() );
        entity.setPmss4( event.getPmss4() );
        entity.setPmss5( event.getPmss5() );
        entity.setPmss6( event.getPmss6() );
        entity.setPmss7( event.getPmss7() );
        entity.setPmss8( event.getPmss8() );
        entity.setPmss9( event.getPmss9() );
        entity.setRpg( event.getRpg() );
        entity.setRpp( event.getRpp() );
        entity.setTd( event.getTd() );
        entity.setTdv( event.getTdv() );
        entity.setTg( event.getTg() );
        entity.setTp( event.getTp() );
        entity.setTpe( event.getTpe() );
        entity.setTw( event.getTw() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroWEH( entity );
    }

    /*
     * @param	event UpdateGovHydroWEHEvent
     */
    @EventHandler( payloadType=UpdateGovHydroWEHEvent.class )
    public void handle( UpdateGovHydroWEHEvent event) {
    	LOGGER.info("handling UpdateGovHydroWEHEvent - " + event );
    	
	    GovHydroWEH entity = new GovHydroWEH();
        entity.setGovHydroWEHId( event.getGovHydroWEHId() );
        entity.setDb( event.getDb() );
        entity.setDicn( event.getDicn() );
        entity.setDpv( event.getDpv() );
        entity.setDturb( event.getDturb() );
        entity.setFeedbackSignal( event.getFeedbackSignal() );
        entity.setFl1( event.getFl1() );
        entity.setFl2( event.getFl2() );
        entity.setFl3( event.getFl3() );
        entity.setFl4( event.getFl4() );
        entity.setFl5( event.getFl5() );
        entity.setFp1( event.getFp1() );
        entity.setFp10( event.getFp10() );
        entity.setFp2( event.getFp2() );
        entity.setFp3( event.getFp3() );
        entity.setFp4( event.getFp4() );
        entity.setFp5( event.getFp5() );
        entity.setFp6( event.getFp6() );
        entity.setFp7( event.getFp7() );
        entity.setFp8( event.getFp8() );
        entity.setFp9( event.getFp9() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setGtmxcl( event.getGtmxcl() );
        entity.setGtmxop( event.getGtmxop() );
        entity.setGv1( event.getGv1() );
        entity.setGv2( event.getGv2() );
        entity.setGv3( event.getGv3() );
        entity.setGv4( event.getGv4() );
        entity.setGv5( event.getGv5() );
        entity.setKd( event.getKd() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmss1( event.getPmss1() );
        entity.setPmss10( event.getPmss10() );
        entity.setPmss2( event.getPmss2() );
        entity.setPmss3( event.getPmss3() );
        entity.setPmss4( event.getPmss4() );
        entity.setPmss5( event.getPmss5() );
        entity.setPmss6( event.getPmss6() );
        entity.setPmss7( event.getPmss7() );
        entity.setPmss8( event.getPmss8() );
        entity.setPmss9( event.getPmss9() );
        entity.setRpg( event.getRpg() );
        entity.setRpp( event.getRpp() );
        entity.setTd( event.getTd() );
        entity.setTdv( event.getTdv() );
        entity.setTg( event.getTg() );
        entity.setTp( event.getTp() );
        entity.setTpe( event.getTpe() );
        entity.setTw( event.getTw() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroWEH( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroWEH( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroWEHEvent
     */
    @EventHandler( payloadType=DeleteGovHydroWEHEvent.class )
    public void handle( DeleteGovHydroWEHEvent event) {
    	LOGGER.info("handling DeleteGovHydroWEHEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroWEH entity = delete( event.getGovHydroWEHId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroWEH( entity );

    }    




    /**
     * Method to retrieve the GovHydroWEH via an GovHydroWEHPrimaryKey.
     * @param 	id Long
     * @return 	GovHydroWEH
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroWEH handle( FindGovHydroWEHQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroWEHId() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroWEHs
     *
     * @param	query	FindAllGovHydroWEHQuery 
     * @return 	List<GovHydroWEH> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroWEH> handle( FindAllGovHydroWEHQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroWEH, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroWEH
	 */
	protected void emitFindGovHydroWEH( GovHydroWEH entity ) {
		LOGGER.info("handling emitFindGovHydroWEH" );
		
	    queryUpdateEmitter.emit(FindGovHydroWEHQuery.class,
	                            query -> query.getFilter().getGovHydroWEHId().equals(entity.getGovHydroWEHId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroWEH
	 * 
	 * @param		entity	GovHydroWEH
	 */
	protected void emitFindAllGovHydroWEH( GovHydroWEH entity ) {
		LOGGER.info("handling emitFindAllGovHydroWEH" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroWEHQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroWEHProjector.class.getName());

}
