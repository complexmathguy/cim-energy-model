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
 * Projector for GovCT2 as outlined for the CQRS pattern.  All event handling and query handling related to GovCT2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovCT2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govCT2")
@Component("govCT2-projector")
public class GovCT2Projector extends GovCT2EntityProjector {
		
	// core constructor
	public GovCT2Projector(GovCT2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovCT2Event
     */
    @EventHandler( payloadType=CreateGovCT2Event.class )
    public void handle( CreateGovCT2Event event) {
	    LOGGER.info("handling CreateGovCT2Event - " + event );
	    GovCT2 entity = new GovCT2();
        entity.setGovCT2Id( event.getGovCT2Id() );
        entity.setAset( event.getAset() );
        entity.setDb( event.getDb() );
        entity.setDm( event.getDm() );
        entity.setFlim1( event.getFlim1() );
        entity.setFlim10( event.getFlim10() );
        entity.setFlim2( event.getFlim2() );
        entity.setFlim3( event.getFlim3() );
        entity.setFlim4( event.getFlim4() );
        entity.setFlim5( event.getFlim5() );
        entity.setFlim6( event.getFlim6() );
        entity.setFlim7( event.getFlim7() );
        entity.setFlim8( event.getFlim8() );
        entity.setFlim9( event.getFlim9() );
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
        entity.setPlim1( event.getPlim1() );
        entity.setPlim10( event.getPlim10() );
        entity.setPlim2( event.getPlim2() );
        entity.setPlim3( event.getPlim3() );
        entity.setPlim4( event.getPlim4() );
        entity.setPlim5( event.getPlim5() );
        entity.setPlim6( event.getPlim6() );
        entity.setPlim7( event.getPlim7() );
        entity.setPlim8( event.getPlim8() );
        entity.setPlim9( event.getPlim9() );
        entity.setPrate( event.getPrate() );
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
        emitFindAllGovCT2( entity );
    }

    /*
     * @param	event UpdateGovCT2Event
     */
    @EventHandler( payloadType=UpdateGovCT2Event.class )
    public void handle( UpdateGovCT2Event event) {
    	LOGGER.info("handling UpdateGovCT2Event - " + event );
    	
	    GovCT2 entity = new GovCT2();
        entity.setGovCT2Id( event.getGovCT2Id() );
        entity.setAset( event.getAset() );
        entity.setDb( event.getDb() );
        entity.setDm( event.getDm() );
        entity.setFlim1( event.getFlim1() );
        entity.setFlim10( event.getFlim10() );
        entity.setFlim2( event.getFlim2() );
        entity.setFlim3( event.getFlim3() );
        entity.setFlim4( event.getFlim4() );
        entity.setFlim5( event.getFlim5() );
        entity.setFlim6( event.getFlim6() );
        entity.setFlim7( event.getFlim7() );
        entity.setFlim8( event.getFlim8() );
        entity.setFlim9( event.getFlim9() );
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
        entity.setPlim1( event.getPlim1() );
        entity.setPlim10( event.getPlim10() );
        entity.setPlim2( event.getPlim2() );
        entity.setPlim3( event.getPlim3() );
        entity.setPlim4( event.getPlim4() );
        entity.setPlim5( event.getPlim5() );
        entity.setPlim6( event.getPlim6() );
        entity.setPlim7( event.getPlim7() );
        entity.setPlim8( event.getPlim8() );
        entity.setPlim9( event.getPlim9() );
        entity.setPrate( event.getPrate() );
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
        emitFindGovCT2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovCT2( entity );        
    }
    
    /*
     * @param	event DeleteGovCT2Event
     */
    @EventHandler( payloadType=DeleteGovCT2Event.class )
    public void handle( DeleteGovCT2Event event) {
    	LOGGER.info("handling DeleteGovCT2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovCT2 entity = delete( event.getGovCT2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovCT2( entity );

    }    




    /**
     * Method to retrieve the GovCT2 via an GovCT2PrimaryKey.
     * @param 	id Long
     * @return 	GovCT2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovCT2 handle( FindGovCT2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovCT2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovCT2s
     *
     * @param	query	FindAllGovCT2Query 
     * @return 	List<GovCT2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovCT2> handle( FindAllGovCT2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovCT2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovCT2
	 */
	protected void emitFindGovCT2( GovCT2 entity ) {
		LOGGER.info("handling emitFindGovCT2" );
		
	    queryUpdateEmitter.emit(FindGovCT2Query.class,
	                            query -> query.getFilter().getGovCT2Id().equals(entity.getGovCT2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovCT2
	 * 
	 * @param		entity	GovCT2
	 */
	protected void emitFindAllGovCT2( GovCT2 entity ) {
		LOGGER.info("handling emitFindAllGovCT2" );
		
	    queryUpdateEmitter.emit(FindAllGovCT2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovCT2Projector.class.getName());

}
