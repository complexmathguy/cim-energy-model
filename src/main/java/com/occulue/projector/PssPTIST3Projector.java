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
 * Projector for PssPTIST3 as outlined for the CQRS pattern.  All event handling and query handling related to PssPTIST3 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssPTIST3Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssPTIST3")
@Component("pssPTIST3-projector")
public class PssPTIST3Projector extends PssPTIST3EntityProjector {
		
	// core constructor
	public PssPTIST3Projector(PssPTIST3Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssPTIST3Event
     */
    @EventHandler( payloadType=CreatePssPTIST3Event.class )
    public void handle( CreatePssPTIST3Event event) {
	    LOGGER.info("handling CreatePssPTIST3Event - " + event );
	    PssPTIST3 entity = new PssPTIST3();
        entity.setPssPTIST3Id( event.getPssPTIST3Id() );
        entity.setA0( event.getA0() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setAl( event.getAl() );
        entity.setAthres( event.getAthres() );
        entity.setB0( event.getB0() );
        entity.setB1( event.getB1() );
        entity.setB2( event.getB2() );
        entity.setB3( event.getB3() );
        entity.setB4( event.getB4() );
        entity.setB5( event.getB5() );
        entity.setDl( event.getDl() );
        entity.setDtc( event.getDtc() );
        entity.setDtf( event.getDtf() );
        entity.setDtp( event.getDtp() );
        entity.setIsw( event.getIsw() );
        entity.setK( event.getK() );
        entity.setLthres( event.getLthres() );
        entity.setM( event.getM() );
        entity.setNav( event.getNav() );
        entity.setNcl( event.getNcl() );
        entity.setNcr( event.getNcr() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssPTIST3( entity );
    }

    /*
     * @param	event UpdatePssPTIST3Event
     */
    @EventHandler( payloadType=UpdatePssPTIST3Event.class )
    public void handle( UpdatePssPTIST3Event event) {
    	LOGGER.info("handling UpdatePssPTIST3Event - " + event );
    	
	    PssPTIST3 entity = new PssPTIST3();
        entity.setPssPTIST3Id( event.getPssPTIST3Id() );
        entity.setA0( event.getA0() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setAl( event.getAl() );
        entity.setAthres( event.getAthres() );
        entity.setB0( event.getB0() );
        entity.setB1( event.getB1() );
        entity.setB2( event.getB2() );
        entity.setB3( event.getB3() );
        entity.setB4( event.getB4() );
        entity.setB5( event.getB5() );
        entity.setDl( event.getDl() );
        entity.setDtc( event.getDtc() );
        entity.setDtf( event.getDtf() );
        entity.setDtp( event.getDtp() );
        entity.setIsw( event.getIsw() );
        entity.setK( event.getK() );
        entity.setLthres( event.getLthres() );
        entity.setM( event.getM() );
        entity.setNav( event.getNav() );
        entity.setNcl( event.getNcl() );
        entity.setNcr( event.getNcr() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssPTIST3( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssPTIST3( entity );        
    }
    
    /*
     * @param	event DeletePssPTIST3Event
     */
    @EventHandler( payloadType=DeletePssPTIST3Event.class )
    public void handle( DeletePssPTIST3Event event) {
    	LOGGER.info("handling DeletePssPTIST3Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssPTIST3 entity = delete( event.getPssPTIST3Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssPTIST3( entity );

    }    




    /**
     * Method to retrieve the PssPTIST3 via an PssPTIST3PrimaryKey.
     * @param 	id Long
     * @return 	PssPTIST3
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssPTIST3 handle( FindPssPTIST3Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssPTIST3Id() );
    }
    
    /**
     * Method to retrieve a collection of all PssPTIST3s
     *
     * @param	query	FindAllPssPTIST3Query 
     * @return 	List<PssPTIST3> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssPTIST3> handle( FindAllPssPTIST3Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssPTIST3, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssPTIST3
	 */
	protected void emitFindPssPTIST3( PssPTIST3 entity ) {
		LOGGER.info("handling emitFindPssPTIST3" );
		
	    queryUpdateEmitter.emit(FindPssPTIST3Query.class,
	                            query -> query.getFilter().getPssPTIST3Id().equals(entity.getPssPTIST3Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssPTIST3
	 * 
	 * @param		entity	PssPTIST3
	 */
	protected void emitFindAllPssPTIST3( PssPTIST3 entity ) {
		LOGGER.info("handling emitFindAllPssPTIST3" );
		
	    queryUpdateEmitter.emit(FindAllPssPTIST3Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssPTIST3Projector.class.getName());

}
