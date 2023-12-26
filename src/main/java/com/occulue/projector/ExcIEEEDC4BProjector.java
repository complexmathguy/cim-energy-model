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
 * Projector for ExcIEEEDC4B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEDC4B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEDC4BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEDC4B")
@Component("excIEEEDC4B-projector")
public class ExcIEEEDC4BProjector extends ExcIEEEDC4BEntityProjector {
		
	// core constructor
	public ExcIEEEDC4BProjector(ExcIEEEDC4BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEDC4BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEDC4BEvent.class )
    public void handle( CreateExcIEEEDC4BEvent event) {
	    LOGGER.info("handling CreateExcIEEEDC4BEvent - " + event );
	    ExcIEEEDC4B entity = new ExcIEEEDC4B();
        entity.setExcIEEEDC4BId( event.getExcIEEEDC4BId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setKa( event.getKa() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setOelin( event.getOelin() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
        entity.setTd( event.getTd() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVemin( event.getVemin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC4B( entity );
    }

    /*
     * @param	event UpdateExcIEEEDC4BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEDC4BEvent.class )
    public void handle( UpdateExcIEEEDC4BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEDC4BEvent - " + event );
    	
	    ExcIEEEDC4B entity = new ExcIEEEDC4B();
        entity.setExcIEEEDC4BId( event.getExcIEEEDC4BId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setKa( event.getKa() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setOelin( event.getOelin() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
        entity.setTd( event.getTd() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVemin( event.getVemin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEDC4B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC4B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEDC4BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEDC4BEvent.class )
    public void handle( DeleteExcIEEEDC4BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEDC4BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEDC4B entity = delete( event.getExcIEEEDC4BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC4B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEDC4B via an ExcIEEEDC4BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEDC4B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEDC4B handle( FindExcIEEEDC4BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEDC4BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC4Bs
     *
     * @param	query	FindAllExcIEEEDC4BQuery 
     * @return 	List<ExcIEEEDC4B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEDC4B> handle( FindAllExcIEEEDC4BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEDC4B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEDC4B
	 */
	protected void emitFindExcIEEEDC4B( ExcIEEEDC4B entity ) {
		LOGGER.info("handling emitFindExcIEEEDC4B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEDC4BQuery.class,
	                            query -> query.getFilter().getExcIEEEDC4BId().equals(entity.getExcIEEEDC4BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEDC4B
	 * 
	 * @param		entity	ExcIEEEDC4B
	 */
	protected void emitFindAllExcIEEEDC4B( ExcIEEEDC4B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEDC4B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEDC4BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC4BProjector.class.getName());

}
