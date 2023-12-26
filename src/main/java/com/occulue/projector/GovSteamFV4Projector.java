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
 * Projector for GovSteamFV4 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamFV4 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamFV4Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamFV4")
@Component("govSteamFV4-projector")
public class GovSteamFV4Projector extends GovSteamFV4EntityProjector {
		
	// core constructor
	public GovSteamFV4Projector(GovSteamFV4Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamFV4Event
     */
    @EventHandler( payloadType=CreateGovSteamFV4Event.class )
    public void handle( CreateGovSteamFV4Event event) {
	    LOGGER.info("handling CreateGovSteamFV4Event - " + event );
	    GovSteamFV4 entity = new GovSteamFV4();
        entity.setGovSteamFV4Id( event.getGovSteamFV4Id() );
        entity.setCpsmn( event.getCpsmn() );
        entity.setCpsmx( event.getCpsmx() );
        entity.setCrmn( event.getCrmn() );
        entity.setCrmx( event.getCrmx() );
        entity.setKdc( event.getKdc() );
        entity.setKf1( event.getKf1() );
        entity.setKf3( event.getKf3() );
        entity.setKhp( event.getKhp() );
        entity.setKic( event.getKic() );
        entity.setKip( event.getKip() );
        entity.setKit( event.getKit() );
        entity.setKmp1( event.getKmp1() );
        entity.setKmp2( event.getKmp2() );
        entity.setKpc( event.getKpc() );
        entity.setKpp( event.getKpp() );
        entity.setKpt( event.getKpt() );
        entity.setKrc( event.getKrc() );
        entity.setKsh( event.getKsh() );
        entity.setLpi( event.getLpi() );
        entity.setLps( event.getLps() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setPr1( event.getPr1() );
        entity.setPr2( event.getPr2() );
        entity.setPsmn( event.getPsmn() );
        entity.setRsmimn( event.getRsmimn() );
        entity.setRsmimx( event.getRsmimx() );
        entity.setRvgmn( event.getRvgmn() );
        entity.setRvgmx( event.getRvgmx() );
        entity.setSrmn( event.getSrmn() );
        entity.setSrmx( event.getSrmx() );
        entity.setSrsmp( event.getSrsmp() );
        entity.setSvmn( event.getSvmn() );
        entity.setSvmx( event.getSvmx() );
        entity.setTa( event.getTa() );
        entity.setTam( event.getTam() );
        entity.setTc( event.getTc() );
        entity.setTcm( event.getTcm() );
        entity.setTdc( event.getTdc() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setThp( event.getThp() );
        entity.setTmp( event.getTmp() );
        entity.setTrh( event.getTrh() );
        entity.setTv( event.getTv() );
        entity.setTy( event.getTy() );
        entity.setY( event.getY() );
        entity.setYhpmn( event.getYhpmn() );
        entity.setYhpmx( event.getYhpmx() );
        entity.setYmpmn( event.getYmpmn() );
        entity.setYmpmx( event.getYmpmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV4( entity );
    }

    /*
     * @param	event UpdateGovSteamFV4Event
     */
    @EventHandler( payloadType=UpdateGovSteamFV4Event.class )
    public void handle( UpdateGovSteamFV4Event event) {
    	LOGGER.info("handling UpdateGovSteamFV4Event - " + event );
    	
	    GovSteamFV4 entity = new GovSteamFV4();
        entity.setGovSteamFV4Id( event.getGovSteamFV4Id() );
        entity.setCpsmn( event.getCpsmn() );
        entity.setCpsmx( event.getCpsmx() );
        entity.setCrmn( event.getCrmn() );
        entity.setCrmx( event.getCrmx() );
        entity.setKdc( event.getKdc() );
        entity.setKf1( event.getKf1() );
        entity.setKf3( event.getKf3() );
        entity.setKhp( event.getKhp() );
        entity.setKic( event.getKic() );
        entity.setKip( event.getKip() );
        entity.setKit( event.getKit() );
        entity.setKmp1( event.getKmp1() );
        entity.setKmp2( event.getKmp2() );
        entity.setKpc( event.getKpc() );
        entity.setKpp( event.getKpp() );
        entity.setKpt( event.getKpt() );
        entity.setKrc( event.getKrc() );
        entity.setKsh( event.getKsh() );
        entity.setLpi( event.getLpi() );
        entity.setLps( event.getLps() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setPr1( event.getPr1() );
        entity.setPr2( event.getPr2() );
        entity.setPsmn( event.getPsmn() );
        entity.setRsmimn( event.getRsmimn() );
        entity.setRsmimx( event.getRsmimx() );
        entity.setRvgmn( event.getRvgmn() );
        entity.setRvgmx( event.getRvgmx() );
        entity.setSrmn( event.getSrmn() );
        entity.setSrmx( event.getSrmx() );
        entity.setSrsmp( event.getSrsmp() );
        entity.setSvmn( event.getSvmn() );
        entity.setSvmx( event.getSvmx() );
        entity.setTa( event.getTa() );
        entity.setTam( event.getTam() );
        entity.setTc( event.getTc() );
        entity.setTcm( event.getTcm() );
        entity.setTdc( event.getTdc() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setThp( event.getThp() );
        entity.setTmp( event.getTmp() );
        entity.setTrh( event.getTrh() );
        entity.setTv( event.getTv() );
        entity.setTy( event.getTy() );
        entity.setY( event.getY() );
        entity.setYhpmn( event.getYhpmn() );
        entity.setYhpmx( event.getYhpmx() );
        entity.setYmpmn( event.getYmpmn() );
        entity.setYmpmx( event.getYmpmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamFV4( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV4( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamFV4Event
     */
    @EventHandler( payloadType=DeleteGovSteamFV4Event.class )
    public void handle( DeleteGovSteamFV4Event event) {
    	LOGGER.info("handling DeleteGovSteamFV4Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamFV4 entity = delete( event.getGovSteamFV4Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV4( entity );

    }    




    /**
     * Method to retrieve the GovSteamFV4 via an GovSteamFV4PrimaryKey.
     * @param 	id Long
     * @return 	GovSteamFV4
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamFV4 handle( FindGovSteamFV4Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamFV4Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamFV4s
     *
     * @param	query	FindAllGovSteamFV4Query 
     * @return 	List<GovSteamFV4> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamFV4> handle( FindAllGovSteamFV4Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamFV4, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamFV4
	 */
	protected void emitFindGovSteamFV4( GovSteamFV4 entity ) {
		LOGGER.info("handling emitFindGovSteamFV4" );
		
	    queryUpdateEmitter.emit(FindGovSteamFV4Query.class,
	                            query -> query.getFilter().getGovSteamFV4Id().equals(entity.getGovSteamFV4Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamFV4
	 * 
	 * @param		entity	GovSteamFV4
	 */
	protected void emitFindAllGovSteamFV4( GovSteamFV4 entity ) {
		LOGGER.info("handling emitFindAllGovSteamFV4" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamFV4Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV4Projector.class.getName());

}
