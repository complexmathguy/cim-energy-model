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
 * Projector for UnderexcLimIEEE2 as outlined for the CQRS pattern.  All event handling and query handling related to UnderexcLimIEEE2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnderexcLimIEEE2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("underexcLimIEEE2")
@Component("underexcLimIEEE2-projector")
public class UnderexcLimIEEE2Projector extends UnderexcLimIEEE2EntityProjector {
		
	// core constructor
	public UnderexcLimIEEE2Projector(UnderexcLimIEEE2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnderexcLimIEEE2Event
     */
    @EventHandler( payloadType=CreateUnderexcLimIEEE2Event.class )
    public void handle( CreateUnderexcLimIEEE2Event event) {
	    LOGGER.info("handling CreateUnderexcLimIEEE2Event - " + event );
	    UnderexcLimIEEE2 entity = new UnderexcLimIEEE2();
        entity.setUnderexcLimIEEE2Id( event.getUnderexcLimIEEE2Id() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setKfb( event.getKfb() );
        entity.setKuf( event.getKuf() );
        entity.setKui( event.getKui() );
        entity.setKul( event.getKul() );
        entity.setP0( event.getP0() );
        entity.setP1( event.getP1() );
        entity.setP10( event.getP10() );
        entity.setP2( event.getP2() );
        entity.setP3( event.getP3() );
        entity.setP4( event.getP4() );
        entity.setP5( event.getP5() );
        entity.setP6( event.getP6() );
        entity.setP7( event.getP7() );
        entity.setP8( event.getP8() );
        entity.setP9( event.getP9() );
        entity.setQ0( event.getQ0() );
        entity.setQ1( event.getQ1() );
        entity.setQ10( event.getQ10() );
        entity.setQ2( event.getQ2() );
        entity.setQ3( event.getQ3() );
        entity.setQ4( event.getQ4() );
        entity.setQ5( event.getQ5() );
        entity.setQ6( event.getQ6() );
        entity.setQ7( event.getQ7() );
        entity.setQ8( event.getQ8() );
        entity.setQ9( event.getQ9() );
        entity.setTu1( event.getTu1() );
        entity.setTu2( event.getTu2() );
        entity.setTu3( event.getTu3() );
        entity.setTu4( event.getTu4() );
        entity.setTul( event.getTul() );
        entity.setTup( event.getTup() );
        entity.setTuq( event.getTuq() );
        entity.setTuv( event.getTuv() );
        entity.setVuimax( event.getVuimax() );
        entity.setVuimin( event.getVuimin() );
        entity.setVulmax( event.getVulmax() );
        entity.setVulmin( event.getVulmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimIEEE2( entity );
    }

    /*
     * @param	event UpdateUnderexcLimIEEE2Event
     */
    @EventHandler( payloadType=UpdateUnderexcLimIEEE2Event.class )
    public void handle( UpdateUnderexcLimIEEE2Event event) {
    	LOGGER.info("handling UpdateUnderexcLimIEEE2Event - " + event );
    	
	    UnderexcLimIEEE2 entity = new UnderexcLimIEEE2();
        entity.setUnderexcLimIEEE2Id( event.getUnderexcLimIEEE2Id() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setKfb( event.getKfb() );
        entity.setKuf( event.getKuf() );
        entity.setKui( event.getKui() );
        entity.setKul( event.getKul() );
        entity.setP0( event.getP0() );
        entity.setP1( event.getP1() );
        entity.setP10( event.getP10() );
        entity.setP2( event.getP2() );
        entity.setP3( event.getP3() );
        entity.setP4( event.getP4() );
        entity.setP5( event.getP5() );
        entity.setP6( event.getP6() );
        entity.setP7( event.getP7() );
        entity.setP8( event.getP8() );
        entity.setP9( event.getP9() );
        entity.setQ0( event.getQ0() );
        entity.setQ1( event.getQ1() );
        entity.setQ10( event.getQ10() );
        entity.setQ2( event.getQ2() );
        entity.setQ3( event.getQ3() );
        entity.setQ4( event.getQ4() );
        entity.setQ5( event.getQ5() );
        entity.setQ6( event.getQ6() );
        entity.setQ7( event.getQ7() );
        entity.setQ8( event.getQ8() );
        entity.setQ9( event.getQ9() );
        entity.setTu1( event.getTu1() );
        entity.setTu2( event.getTu2() );
        entity.setTu3( event.getTu3() );
        entity.setTu4( event.getTu4() );
        entity.setTul( event.getTul() );
        entity.setTup( event.getTup() );
        entity.setTuq( event.getTuq() );
        entity.setTuv( event.getTuv() );
        entity.setVuimax( event.getVuimax() );
        entity.setVuimin( event.getVuimin() );
        entity.setVulmax( event.getVulmax() );
        entity.setVulmin( event.getVulmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnderexcLimIEEE2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimIEEE2( entity );        
    }
    
    /*
     * @param	event DeleteUnderexcLimIEEE2Event
     */
    @EventHandler( payloadType=DeleteUnderexcLimIEEE2Event.class )
    public void handle( DeleteUnderexcLimIEEE2Event event) {
    	LOGGER.info("handling DeleteUnderexcLimIEEE2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	UnderexcLimIEEE2 entity = delete( event.getUnderexcLimIEEE2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimIEEE2( entity );

    }    




    /**
     * Method to retrieve the UnderexcLimIEEE2 via an UnderexcLimIEEE2PrimaryKey.
     * @param 	id Long
     * @return 	UnderexcLimIEEE2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public UnderexcLimIEEE2 handle( FindUnderexcLimIEEE2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnderexcLimIEEE2Id() );
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimIEEE2s
     *
     * @param	query	FindAllUnderexcLimIEEE2Query 
     * @return 	List<UnderexcLimIEEE2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<UnderexcLimIEEE2> handle( FindAllUnderexcLimIEEE2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnderexcLimIEEE2, 
	 * but only if the id matches
	 * 
	 * @param		entity	UnderexcLimIEEE2
	 */
	protected void emitFindUnderexcLimIEEE2( UnderexcLimIEEE2 entity ) {
		LOGGER.info("handling emitFindUnderexcLimIEEE2" );
		
	    queryUpdateEmitter.emit(FindUnderexcLimIEEE2Query.class,
	                            query -> query.getFilter().getUnderexcLimIEEE2Id().equals(entity.getUnderexcLimIEEE2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnderexcLimIEEE2
	 * 
	 * @param		entity	UnderexcLimIEEE2
	 */
	protected void emitFindAllUnderexcLimIEEE2( UnderexcLimIEEE2 entity ) {
		LOGGER.info("handling emitFindAllUnderexcLimIEEE2" );
		
	    queryUpdateEmitter.emit(FindAllUnderexcLimIEEE2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimIEEE2Projector.class.getName());

}
