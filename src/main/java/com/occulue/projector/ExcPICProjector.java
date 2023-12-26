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
 * Projector for ExcPIC as outlined for the CQRS pattern.  All event handling and query handling related to ExcPIC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcPICAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excPIC")
@Component("excPIC-projector")
public class ExcPICProjector extends ExcPICEntityProjector {
		
	// core constructor
	public ExcPICProjector(ExcPICRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcPICEvent
     */
    @EventHandler( payloadType=CreateExcPICEvent.class )
    public void handle( CreateExcPICEvent event) {
	    LOGGER.info("handling CreateExcPICEvent - " + event );
	    ExcPIC entity = new ExcPIC();
        entity.setExcPICId( event.getExcPICId() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa1( event.getTa1() );
        entity.setTa2( event.getTa2() );
        entity.setTa3( event.getTa3() );
        entity.setTa4( event.getTa4() );
        entity.setTe( event.getTe() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setVr1( event.getVr1() );
        entity.setVr2( event.getVr2() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcPIC( entity );
    }

    /*
     * @param	event UpdateExcPICEvent
     */
    @EventHandler( payloadType=UpdateExcPICEvent.class )
    public void handle( UpdateExcPICEvent event) {
    	LOGGER.info("handling UpdateExcPICEvent - " + event );
    	
	    ExcPIC entity = new ExcPIC();
        entity.setExcPICId( event.getExcPICId() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa1( event.getTa1() );
        entity.setTa2( event.getTa2() );
        entity.setTa3( event.getTa3() );
        entity.setTa4( event.getTa4() );
        entity.setTe( event.getTe() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setVr1( event.getVr1() );
        entity.setVr2( event.getVr2() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcPIC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcPIC( entity );        
    }
    
    /*
     * @param	event DeleteExcPICEvent
     */
    @EventHandler( payloadType=DeleteExcPICEvent.class )
    public void handle( DeleteExcPICEvent event) {
    	LOGGER.info("handling DeleteExcPICEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcPIC entity = delete( event.getExcPICId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcPIC( entity );

    }    




    /**
     * Method to retrieve the ExcPIC via an ExcPICPrimaryKey.
     * @param 	id Long
     * @return 	ExcPIC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcPIC handle( FindExcPICQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcPICId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcPICs
     *
     * @param	query	FindAllExcPICQuery 
     * @return 	List<ExcPIC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcPIC> handle( FindAllExcPICQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcPIC, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcPIC
	 */
	protected void emitFindExcPIC( ExcPIC entity ) {
		LOGGER.info("handling emitFindExcPIC" );
		
	    queryUpdateEmitter.emit(FindExcPICQuery.class,
	                            query -> query.getFilter().getExcPICId().equals(entity.getExcPICId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcPIC
	 * 
	 * @param		entity	ExcPIC
	 */
	protected void emitFindAllExcPIC( ExcPIC entity ) {
		LOGGER.info("handling emitFindAllExcPIC" );
		
	    queryUpdateEmitter.emit(FindAllExcPICQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcPICProjector.class.getName());

}
