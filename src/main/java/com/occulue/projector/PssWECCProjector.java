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
 * Projector for PssWECC as outlined for the CQRS pattern.  All event handling and query handling related to PssWECC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssWECCAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssWECC")
@Component("pssWECC-projector")
public class PssWECCProjector extends PssWECCEntityProjector {
		
	// core constructor
	public PssWECCProjector(PssWECCRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssWECCEvent
     */
    @EventHandler( payloadType=CreatePssWECCEvent.class )
    public void handle( CreatePssWECCEvent event) {
	    LOGGER.info("handling CreatePssWECCEvent - " + event );
	    PssWECC entity = new PssWECC();
        entity.setPssWECCId( event.getPssWECCId() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setT1( event.getT1() );
        entity.setT10( event.getT10() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setVcl( event.getVcl() );
        entity.setVcu( event.getVcu() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssWECC( entity );
    }

    /*
     * @param	event UpdatePssWECCEvent
     */
    @EventHandler( payloadType=UpdatePssWECCEvent.class )
    public void handle( UpdatePssWECCEvent event) {
    	LOGGER.info("handling UpdatePssWECCEvent - " + event );
    	
	    PssWECC entity = new PssWECC();
        entity.setPssWECCId( event.getPssWECCId() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setT1( event.getT1() );
        entity.setT10( event.getT10() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setVcl( event.getVcl() );
        entity.setVcu( event.getVcu() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssWECC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssWECC( entity );        
    }
    
    /*
     * @param	event DeletePssWECCEvent
     */
    @EventHandler( payloadType=DeletePssWECCEvent.class )
    public void handle( DeletePssWECCEvent event) {
    	LOGGER.info("handling DeletePssWECCEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssWECC entity = delete( event.getPssWECCId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssWECC( entity );

    }    




    /**
     * Method to retrieve the PssWECC via an PssWECCPrimaryKey.
     * @param 	id Long
     * @return 	PssWECC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssWECC handle( FindPssWECCQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssWECCId() );
    }
    
    /**
     * Method to retrieve a collection of all PssWECCs
     *
     * @param	query	FindAllPssWECCQuery 
     * @return 	List<PssWECC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssWECC> handle( FindAllPssWECCQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssWECC, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssWECC
	 */
	protected void emitFindPssWECC( PssWECC entity ) {
		LOGGER.info("handling emitFindPssWECC" );
		
	    queryUpdateEmitter.emit(FindPssWECCQuery.class,
	                            query -> query.getFilter().getPssWECCId().equals(entity.getPssWECCId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssWECC
	 * 
	 * @param		entity	PssWECC
	 */
	protected void emitFindAllPssWECC( PssWECC entity ) {
		LOGGER.info("handling emitFindAllPssWECC" );
		
	    queryUpdateEmitter.emit(FindAllPssWECCQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssWECCProjector.class.getName());

}
