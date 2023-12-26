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
 * Projector for LoadMotor as outlined for the CQRS pattern.  All event handling and query handling related to LoadMotor are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadMotorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadMotor")
@Component("loadMotor-projector")
public class LoadMotorProjector extends LoadMotorEntityProjector {
		
	// core constructor
	public LoadMotorProjector(LoadMotorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadMotorEvent
     */
    @EventHandler( payloadType=CreateLoadMotorEvent.class )
    public void handle( CreateLoadMotorEvent event) {
	    LOGGER.info("handling CreateLoadMotorEvent - " + event );
	    LoadMotor entity = new LoadMotor();
        entity.setLoadMotorId( event.getLoadMotorId() );
        entity.setD( event.getD() );
        entity.setH( event.getH() );
        entity.setLfac( event.getLfac() );
        entity.setLp( event.getLp() );
        entity.setLpp( event.getLpp() );
        entity.setLs( event.getLs() );
        entity.setPfrac( event.getPfrac() );
        entity.setRa( event.getRa() );
        entity.setTbkr( event.getTbkr() );
        entity.setTpo( event.getTpo() );
        entity.setTppo( event.getTppo() );
        entity.setTv( event.getTv() );
        entity.setVt( event.getVt() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadMotor( entity );
    }

    /*
     * @param	event UpdateLoadMotorEvent
     */
    @EventHandler( payloadType=UpdateLoadMotorEvent.class )
    public void handle( UpdateLoadMotorEvent event) {
    	LOGGER.info("handling UpdateLoadMotorEvent - " + event );
    	
	    LoadMotor entity = new LoadMotor();
        entity.setLoadMotorId( event.getLoadMotorId() );
        entity.setD( event.getD() );
        entity.setH( event.getH() );
        entity.setLfac( event.getLfac() );
        entity.setLp( event.getLp() );
        entity.setLpp( event.getLpp() );
        entity.setLs( event.getLs() );
        entity.setPfrac( event.getPfrac() );
        entity.setRa( event.getRa() );
        entity.setTbkr( event.getTbkr() );
        entity.setTpo( event.getTpo() );
        entity.setTppo( event.getTppo() );
        entity.setTv( event.getTv() );
        entity.setVt( event.getVt() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadMotor( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadMotor( entity );        
    }
    
    /*
     * @param	event DeleteLoadMotorEvent
     */
    @EventHandler( payloadType=DeleteLoadMotorEvent.class )
    public void handle( DeleteLoadMotorEvent event) {
    	LOGGER.info("handling DeleteLoadMotorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadMotor entity = delete( event.getLoadMotorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadMotor( entity );

    }    




    /**
     * Method to retrieve the LoadMotor via an LoadMotorPrimaryKey.
     * @param 	id Long
     * @return 	LoadMotor
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadMotor handle( FindLoadMotorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadMotorId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadMotors
     *
     * @param	query	FindAllLoadMotorQuery 
     * @return 	List<LoadMotor> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadMotor> handle( FindAllLoadMotorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadMotor, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadMotor
	 */
	protected void emitFindLoadMotor( LoadMotor entity ) {
		LOGGER.info("handling emitFindLoadMotor" );
		
	    queryUpdateEmitter.emit(FindLoadMotorQuery.class,
	                            query -> query.getFilter().getLoadMotorId().equals(entity.getLoadMotorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadMotor
	 * 
	 * @param		entity	LoadMotor
	 */
	protected void emitFindAllLoadMotor( LoadMotor entity ) {
		LOGGER.info("handling emitFindAllLoadMotor" );
		
	    queryUpdateEmitter.emit(FindAllLoadMotorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadMotorProjector.class.getName());

}
