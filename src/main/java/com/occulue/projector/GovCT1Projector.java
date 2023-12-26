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
 * Projector for GovCT1 as outlined for the CQRS pattern.  All event handling and query handling related to GovCT1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovCT1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govCT1")
@Component("govCT1-projector")
public class GovCT1Projector extends GovCT1EntityProjector {
		
	// core constructor
	public GovCT1Projector(GovCT1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovCT1Event
     */
    @EventHandler( payloadType=CreateGovCT1Event.class )
    public void handle( CreateGovCT1Event event) {
	    LOGGER.info("handling CreateGovCT1Event - " + event );
	    GovCT1 entity = new GovCT1();
        entity.setGovCT1Id( event.getGovCT1Id() );
        entity.setAset( event.getAset() );
        entity.setDb( event.getDb() );
        entity.setDm( event.getDm() );
        entity.setKa( event.getKa() );
        entity.setKdgov( event.getKdgov() );
        entity.setKigov( event.getKigov() );
        entity.setKiload( event.getKiload() );
        entity.setKimw( event.getKimw() );
        entity.setKpgov( event.getKpgov() );
        entity.setKpload( event.getKpload() );
        entity.setKturb( event.getKturb() );
        entity.setLdref( event.getLdref() );
        entity.setMaxerr( event.getMaxerr() );
        entity.setMinerr( event.getMinerr() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setRclose( event.getRclose() );
        entity.setRdown( event.getRdown() );
        entity.setRopen( event.getRopen() );
        entity.setRselect( event.getRselect() );
        entity.setRup( event.getRup() );
        entity.setTa( event.getTa() );
        entity.setTact( event.getTact() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTdgov( event.getTdgov() );
        entity.setTeng( event.getTeng() );
        entity.setTfload( event.getTfload() );
        entity.setTpelec( event.getTpelec() );
        entity.setTsa( event.getTsa() );
        entity.setTsb( event.getTsb() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
        entity.setWfnl( event.getWfnl() );
        entity.setWfspd( event.getWfspd() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovCT1( entity );
    }

    /*
     * @param	event UpdateGovCT1Event
     */
    @EventHandler( payloadType=UpdateGovCT1Event.class )
    public void handle( UpdateGovCT1Event event) {
    	LOGGER.info("handling UpdateGovCT1Event - " + event );
    	
	    GovCT1 entity = new GovCT1();
        entity.setGovCT1Id( event.getGovCT1Id() );
        entity.setAset( event.getAset() );
        entity.setDb( event.getDb() );
        entity.setDm( event.getDm() );
        entity.setKa( event.getKa() );
        entity.setKdgov( event.getKdgov() );
        entity.setKigov( event.getKigov() );
        entity.setKiload( event.getKiload() );
        entity.setKimw( event.getKimw() );
        entity.setKpgov( event.getKpgov() );
        entity.setKpload( event.getKpload() );
        entity.setKturb( event.getKturb() );
        entity.setLdref( event.getLdref() );
        entity.setMaxerr( event.getMaxerr() );
        entity.setMinerr( event.getMinerr() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setRclose( event.getRclose() );
        entity.setRdown( event.getRdown() );
        entity.setRopen( event.getRopen() );
        entity.setRselect( event.getRselect() );
        entity.setRup( event.getRup() );
        entity.setTa( event.getTa() );
        entity.setTact( event.getTact() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTdgov( event.getTdgov() );
        entity.setTeng( event.getTeng() );
        entity.setTfload( event.getTfload() );
        entity.setTpelec( event.getTpelec() );
        entity.setTsa( event.getTsa() );
        entity.setTsb( event.getTsb() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
        entity.setWfnl( event.getWfnl() );
        entity.setWfspd( event.getWfspd() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovCT1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovCT1( entity );        
    }
    
    /*
     * @param	event DeleteGovCT1Event
     */
    @EventHandler( payloadType=DeleteGovCT1Event.class )
    public void handle( DeleteGovCT1Event event) {
    	LOGGER.info("handling DeleteGovCT1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovCT1 entity = delete( event.getGovCT1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovCT1( entity );

    }    




    /**
     * Method to retrieve the GovCT1 via an GovCT1PrimaryKey.
     * @param 	id Long
     * @return 	GovCT1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovCT1 handle( FindGovCT1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovCT1Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovCT1s
     *
     * @param	query	FindAllGovCT1Query 
     * @return 	List<GovCT1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovCT1> handle( FindAllGovCT1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovCT1, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovCT1
	 */
	protected void emitFindGovCT1( GovCT1 entity ) {
		LOGGER.info("handling emitFindGovCT1" );
		
	    queryUpdateEmitter.emit(FindGovCT1Query.class,
	                            query -> query.getFilter().getGovCT1Id().equals(entity.getGovCT1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovCT1
	 * 
	 * @param		entity	GovCT1
	 */
	protected void emitFindAllGovCT1( GovCT1 entity ) {
		LOGGER.info("handling emitFindAllGovCT1" );
		
	    queryUpdateEmitter.emit(FindAllGovCT1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovCT1Projector.class.getName());

}
