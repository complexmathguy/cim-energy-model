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
 * Projector for GovSteamEU as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamEU are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamEUAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamEU")
@Component("govSteamEU-projector")
public class GovSteamEUProjector extends GovSteamEUEntityProjector {
		
	// core constructor
	public GovSteamEUProjector(GovSteamEURepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamEUEvent
     */
    @EventHandler( payloadType=CreateGovSteamEUEvent.class )
    public void handle( CreateGovSteamEUEvent event) {
	    LOGGER.info("handling CreateGovSteamEUEvent - " + event );
	    GovSteamEU entity = new GovSteamEU();
        entity.setGovSteamEUId( event.getGovSteamEUId() );
        entity.setChc( event.getChc() );
        entity.setCho( event.getCho() );
        entity.setCic( event.getCic() );
        entity.setCio( event.getCio() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setHhpmax( event.getHhpmax() );
        entity.setKe( event.getKe() );
        entity.setKfcor( event.getKfcor() );
        entity.setKhp( event.getKhp() );
        entity.setKlp( event.getKlp() );
        entity.setKwcor( event.getKwcor() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPrhmax( event.getPrhmax() );
        entity.setSimx( event.getSimx() );
        entity.setTb( event.getTb() );
        entity.setTdp( event.getTdp() );
        entity.setTen( event.getTen() );
        entity.setTf( event.getTf() );
        entity.setTfp( event.getTfp() );
        entity.setThp( event.getThp() );
        entity.setTip( event.getTip() );
        entity.setTlp( event.getTlp() );
        entity.setTp( event.getTp() );
        entity.setTrh( event.getTrh() );
        entity.setTvhp( event.getTvhp() );
        entity.setTvip( event.getTvip() );
        entity.setTw( event.getTw() );
        entity.setWfmax( event.getWfmax() );
        entity.setWfmin( event.getWfmin() );
        entity.setWmax1( event.getWmax1() );
        entity.setWmax2( event.getWmax2() );
        entity.setWwmax( event.getWwmax() );
        entity.setWwmin( event.getWwmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamEU( entity );
    }

    /*
     * @param	event UpdateGovSteamEUEvent
     */
    @EventHandler( payloadType=UpdateGovSteamEUEvent.class )
    public void handle( UpdateGovSteamEUEvent event) {
    	LOGGER.info("handling UpdateGovSteamEUEvent - " + event );
    	
	    GovSteamEU entity = new GovSteamEU();
        entity.setGovSteamEUId( event.getGovSteamEUId() );
        entity.setChc( event.getChc() );
        entity.setCho( event.getCho() );
        entity.setCic( event.getCic() );
        entity.setCio( event.getCio() );
        entity.setDb1( event.getDb1() );
        entity.setDb2( event.getDb2() );
        entity.setHhpmax( event.getHhpmax() );
        entity.setKe( event.getKe() );
        entity.setKfcor( event.getKfcor() );
        entity.setKhp( event.getKhp() );
        entity.setKlp( event.getKlp() );
        entity.setKwcor( event.getKwcor() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPrhmax( event.getPrhmax() );
        entity.setSimx( event.getSimx() );
        entity.setTb( event.getTb() );
        entity.setTdp( event.getTdp() );
        entity.setTen( event.getTen() );
        entity.setTf( event.getTf() );
        entity.setTfp( event.getTfp() );
        entity.setThp( event.getThp() );
        entity.setTip( event.getTip() );
        entity.setTlp( event.getTlp() );
        entity.setTp( event.getTp() );
        entity.setTrh( event.getTrh() );
        entity.setTvhp( event.getTvhp() );
        entity.setTvip( event.getTvip() );
        entity.setTw( event.getTw() );
        entity.setWfmax( event.getWfmax() );
        entity.setWfmin( event.getWfmin() );
        entity.setWmax1( event.getWmax1() );
        entity.setWmax2( event.getWmax2() );
        entity.setWwmax( event.getWwmax() );
        entity.setWwmin( event.getWwmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamEU( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamEU( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamEUEvent
     */
    @EventHandler( payloadType=DeleteGovSteamEUEvent.class )
    public void handle( DeleteGovSteamEUEvent event) {
    	LOGGER.info("handling DeleteGovSteamEUEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamEU entity = delete( event.getGovSteamEUId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamEU( entity );

    }    




    /**
     * Method to retrieve the GovSteamEU via an GovSteamEUPrimaryKey.
     * @param 	id Long
     * @return 	GovSteamEU
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamEU handle( FindGovSteamEUQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamEUId() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamEUs
     *
     * @param	query	FindAllGovSteamEUQuery 
     * @return 	List<GovSteamEU> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamEU> handle( FindAllGovSteamEUQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamEU, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamEU
	 */
	protected void emitFindGovSteamEU( GovSteamEU entity ) {
		LOGGER.info("handling emitFindGovSteamEU" );
		
	    queryUpdateEmitter.emit(FindGovSteamEUQuery.class,
	                            query -> query.getFilter().getGovSteamEUId().equals(entity.getGovSteamEUId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamEU
	 * 
	 * @param		entity	GovSteamEU
	 */
	protected void emitFindAllGovSteamEU( GovSteamEU entity ) {
		LOGGER.info("handling emitFindAllGovSteamEU" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamEUQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamEUProjector.class.getName());

}
