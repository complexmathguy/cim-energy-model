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
 * Projector for EquivalentBranch as outlined for the CQRS pattern.  All event handling and query handling related to EquivalentBranch are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquivalentBranchAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equivalentBranch")
@Component("equivalentBranch-projector")
public class EquivalentBranchProjector extends EquivalentBranchEntityProjector {
		
	// core constructor
	public EquivalentBranchProjector(EquivalentBranchRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquivalentBranchEvent
     */
    @EventHandler( payloadType=CreateEquivalentBranchEvent.class )
    public void handle( CreateEquivalentBranchEvent event) {
	    LOGGER.info("handling CreateEquivalentBranchEvent - " + event );
	    EquivalentBranch entity = new EquivalentBranch();
        entity.setEquivalentBranchId( event.getEquivalentBranchId() );
        entity.setNegativeR12( event.getNegativeR12() );
        entity.setNegativeR21( event.getNegativeR21() );
        entity.setNegativeX12( event.getNegativeX12() );
        entity.setNegativeX21( event.getNegativeX21() );
        entity.setPositiveR12( event.getPositiveR12() );
        entity.setPositiveR21( event.getPositiveR21() );
        entity.setPositiveX12( event.getPositiveX12() );
        entity.setPositiveX21( event.getPositiveX21() );
        entity.setR( event.getR() );
        entity.setR21( event.getR21() );
        entity.setX( event.getX() );
        entity.setX21( event.getX21() );
        entity.setZeroR12( event.getZeroR12() );
        entity.setZeroR21( event.getZeroR21() );
        entity.setZeroX12( event.getZeroX12() );
        entity.setZeroX21( event.getZeroX21() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentBranch( entity );
    }

    /*
     * @param	event UpdateEquivalentBranchEvent
     */
    @EventHandler( payloadType=UpdateEquivalentBranchEvent.class )
    public void handle( UpdateEquivalentBranchEvent event) {
    	LOGGER.info("handling UpdateEquivalentBranchEvent - " + event );
    	
	    EquivalentBranch entity = new EquivalentBranch();
        entity.setEquivalentBranchId( event.getEquivalentBranchId() );
        entity.setNegativeR12( event.getNegativeR12() );
        entity.setNegativeR21( event.getNegativeR21() );
        entity.setNegativeX12( event.getNegativeX12() );
        entity.setNegativeX21( event.getNegativeX21() );
        entity.setPositiveR12( event.getPositiveR12() );
        entity.setPositiveR21( event.getPositiveR21() );
        entity.setPositiveX12( event.getPositiveX12() );
        entity.setPositiveX21( event.getPositiveX21() );
        entity.setR( event.getR() );
        entity.setR21( event.getR21() );
        entity.setX( event.getX() );
        entity.setX21( event.getX21() );
        entity.setZeroR12( event.getZeroR12() );
        entity.setZeroR21( event.getZeroR21() );
        entity.setZeroX12( event.getZeroX12() );
        entity.setZeroX21( event.getZeroX21() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquivalentBranch( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentBranch( entity );        
    }
    
    /*
     * @param	event DeleteEquivalentBranchEvent
     */
    @EventHandler( payloadType=DeleteEquivalentBranchEvent.class )
    public void handle( DeleteEquivalentBranchEvent event) {
    	LOGGER.info("handling DeleteEquivalentBranchEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquivalentBranch entity = delete( event.getEquivalentBranchId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentBranch( entity );

    }    




    /**
     * Method to retrieve the EquivalentBranch via an EquivalentBranchPrimaryKey.
     * @param 	id Long
     * @return 	EquivalentBranch
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquivalentBranch handle( FindEquivalentBranchQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquivalentBranchId() );
    }
    
    /**
     * Method to retrieve a collection of all EquivalentBranchs
     *
     * @param	query	FindAllEquivalentBranchQuery 
     * @return 	List<EquivalentBranch> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquivalentBranch> handle( FindAllEquivalentBranchQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquivalentBranch, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquivalentBranch
	 */
	protected void emitFindEquivalentBranch( EquivalentBranch entity ) {
		LOGGER.info("handling emitFindEquivalentBranch" );
		
	    queryUpdateEmitter.emit(FindEquivalentBranchQuery.class,
	                            query -> query.getFilter().getEquivalentBranchId().equals(entity.getEquivalentBranchId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquivalentBranch
	 * 
	 * @param		entity	EquivalentBranch
	 */
	protected void emitFindAllEquivalentBranch( EquivalentBranch entity ) {
		LOGGER.info("handling emitFindAllEquivalentBranch" );
		
	    queryUpdateEmitter.emit(FindAllEquivalentBranchQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquivalentBranchProjector.class.getName());

}
