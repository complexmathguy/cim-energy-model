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
 * Projector for ExcSK as outlined for the CQRS pattern.  All event handling and query handling related to ExcSK are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcSKAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excSK")
@Component("excSK-projector")
public class ExcSKProjector extends ExcSKEntityProjector {
		
	// core constructor
	public ExcSKProjector(ExcSKRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcSKEvent
     */
    @EventHandler( payloadType=CreateExcSKEvent.class )
    public void handle( CreateExcSKEvent event) {
	    LOGGER.info("handling CreateExcSKEvent - " + event );
	    ExcSK entity = new ExcSK();
        entity.setExcSKId( event.getExcSKId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setKc( event.getKc() );
        entity.setKce( event.getKce() );
        entity.setKd( event.getKd() );
        entity.setKgob( event.getKgob() );
        entity.setKp( event.getKp() );
        entity.setKqi( event.getKqi() );
        entity.setKqob( event.getKqob() );
        entity.setKqp( event.getKqp() );
        entity.setNq( event.getNq() );
        entity.setQconoff( event.getQconoff() );
        entity.setQz( event.getQz() );
        entity.setRemote( event.getRemote() );
        entity.setSbase( event.getSbase() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTi( event.getTi() );
        entity.setTp( event.getTp() );
        entity.setTr( event.getTr() );
        entity.setUimax( event.getUimax() );
        entity.setUimin( event.getUimin() );
        entity.setUrmax( event.getUrmax() );
        entity.setUrmin( event.getUrmin() );
        entity.setVtmax( event.getVtmax() );
        entity.setVtmin( event.getVtmin() );
        entity.setYp( event.getYp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSK( entity );
    }

    /*
     * @param	event UpdateExcSKEvent
     */
    @EventHandler( payloadType=UpdateExcSKEvent.class )
    public void handle( UpdateExcSKEvent event) {
    	LOGGER.info("handling UpdateExcSKEvent - " + event );
    	
	    ExcSK entity = new ExcSK();
        entity.setExcSKId( event.getExcSKId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setKc( event.getKc() );
        entity.setKce( event.getKce() );
        entity.setKd( event.getKd() );
        entity.setKgob( event.getKgob() );
        entity.setKp( event.getKp() );
        entity.setKqi( event.getKqi() );
        entity.setKqob( event.getKqob() );
        entity.setKqp( event.getKqp() );
        entity.setNq( event.getNq() );
        entity.setQconoff( event.getQconoff() );
        entity.setQz( event.getQz() );
        entity.setRemote( event.getRemote() );
        entity.setSbase( event.getSbase() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTi( event.getTi() );
        entity.setTp( event.getTp() );
        entity.setTr( event.getTr() );
        entity.setUimax( event.getUimax() );
        entity.setUimin( event.getUimin() );
        entity.setUrmax( event.getUrmax() );
        entity.setUrmin( event.getUrmin() );
        entity.setVtmax( event.getVtmax() );
        entity.setVtmin( event.getVtmin() );
        entity.setYp( event.getYp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcSK( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSK( entity );        
    }
    
    /*
     * @param	event DeleteExcSKEvent
     */
    @EventHandler( payloadType=DeleteExcSKEvent.class )
    public void handle( DeleteExcSKEvent event) {
    	LOGGER.info("handling DeleteExcSKEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcSK entity = delete( event.getExcSKId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSK( entity );

    }    




    /**
     * Method to retrieve the ExcSK via an ExcSKPrimaryKey.
     * @param 	id Long
     * @return 	ExcSK
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcSK handle( FindExcSKQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcSKId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcSKs
     *
     * @param	query	FindAllExcSKQuery 
     * @return 	List<ExcSK> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcSK> handle( FindAllExcSKQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcSK, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcSK
	 */
	protected void emitFindExcSK( ExcSK entity ) {
		LOGGER.info("handling emitFindExcSK" );
		
	    queryUpdateEmitter.emit(FindExcSKQuery.class,
	                            query -> query.getFilter().getExcSKId().equals(entity.getExcSKId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcSK
	 * 
	 * @param		entity	ExcSK
	 */
	protected void emitFindAllExcSK( ExcSK entity ) {
		LOGGER.info("handling emitFindAllExcSK" );
		
	    queryUpdateEmitter.emit(FindAllExcSKQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcSKProjector.class.getName());

}
