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
 * Projector for ExcELIN1 as outlined for the CQRS pattern.  All event handling and query handling related to ExcELIN1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcELIN1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excELIN1")
@Component("excELIN1-projector")
public class ExcELIN1Projector extends ExcELIN1EntityProjector {
		
	// core constructor
	public ExcELIN1Projector(ExcELIN1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcELIN1Event
     */
    @EventHandler( payloadType=CreateExcELIN1Event.class )
    public void handle( CreateExcELIN1Event event) {
	    LOGGER.info("handling CreateExcELIN1Event - " + event );
	    ExcELIN1 entity = new ExcELIN1();
        entity.setExcELIN1Id( event.getExcELIN1Id() );
        entity.setDpnf( event.getDpnf() );
        entity.setEfmax( event.getEfmax() );
        entity.setEfmin( event.getEfmin() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setSmax( event.getSmax() );
        entity.setTfi( event.getTfi() );
        entity.setTnu( event.getTnu() );
        entity.setTs1( event.getTs1() );
        entity.setTs2( event.getTs2() );
        entity.setTsw( event.getTsw() );
        entity.setVpi( event.getVpi() );
        entity.setVpnf( event.getVpnf() );
        entity.setVpu( event.getVpu() );
        entity.setXe( event.getXe() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcELIN1( entity );
    }

    /*
     * @param	event UpdateExcELIN1Event
     */
    @EventHandler( payloadType=UpdateExcELIN1Event.class )
    public void handle( UpdateExcELIN1Event event) {
    	LOGGER.info("handling UpdateExcELIN1Event - " + event );
    	
	    ExcELIN1 entity = new ExcELIN1();
        entity.setExcELIN1Id( event.getExcELIN1Id() );
        entity.setDpnf( event.getDpnf() );
        entity.setEfmax( event.getEfmax() );
        entity.setEfmin( event.getEfmin() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setSmax( event.getSmax() );
        entity.setTfi( event.getTfi() );
        entity.setTnu( event.getTnu() );
        entity.setTs1( event.getTs1() );
        entity.setTs2( event.getTs2() );
        entity.setTsw( event.getTsw() );
        entity.setVpi( event.getVpi() );
        entity.setVpnf( event.getVpnf() );
        entity.setVpu( event.getVpu() );
        entity.setXe( event.getXe() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcELIN1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcELIN1( entity );        
    }
    
    /*
     * @param	event DeleteExcELIN1Event
     */
    @EventHandler( payloadType=DeleteExcELIN1Event.class )
    public void handle( DeleteExcELIN1Event event) {
    	LOGGER.info("handling DeleteExcELIN1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcELIN1 entity = delete( event.getExcELIN1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcELIN1( entity );

    }    




    /**
     * Method to retrieve the ExcELIN1 via an ExcELIN1PrimaryKey.
     * @param 	id Long
     * @return 	ExcELIN1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcELIN1 handle( FindExcELIN1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcELIN1Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcELIN1s
     *
     * @param	query	FindAllExcELIN1Query 
     * @return 	List<ExcELIN1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcELIN1> handle( FindAllExcELIN1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcELIN1, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcELIN1
	 */
	protected void emitFindExcELIN1( ExcELIN1 entity ) {
		LOGGER.info("handling emitFindExcELIN1" );
		
	    queryUpdateEmitter.emit(FindExcELIN1Query.class,
	                            query -> query.getFilter().getExcELIN1Id().equals(entity.getExcELIN1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcELIN1
	 * 
	 * @param		entity	ExcELIN1
	 */
	protected void emitFindAllExcELIN1( ExcELIN1 entity ) {
		LOGGER.info("handling emitFindAllExcELIN1" );
		
	    queryUpdateEmitter.emit(FindAllExcELIN1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcELIN1Projector.class.getName());

}
