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
 * Projector for ExcELIN2 as outlined for the CQRS pattern.  All event handling and query handling related to ExcELIN2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcELIN2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excELIN2")
@Component("excELIN2-projector")
public class ExcELIN2Projector extends ExcELIN2EntityProjector {
		
	// core constructor
	public ExcELIN2Projector(ExcELIN2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcELIN2Event
     */
    @EventHandler( payloadType=CreateExcELIN2Event.class )
    public void handle( CreateExcELIN2Event event) {
	    LOGGER.info("handling CreateExcELIN2Event - " + event );
	    ExcELIN2 entity = new ExcELIN2();
        entity.setExcELIN2Id( event.getExcELIN2Id() );
        entity.setEfdbas( event.getEfdbas() );
        entity.setIefmax( event.getIefmax() );
        entity.setIefmax2( event.getIefmax2() );
        entity.setIefmin( event.getIefmin() );
        entity.setK1( event.getK1() );
        entity.setK1ec( event.getK1ec() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setKd1( event.getKd1() );
        entity.setKe2( event.getKe2() );
        entity.setKetb( event.getKetb() );
        entity.setPid1max( event.getPid1max() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTb1( event.getTb1() );
        entity.setTe( event.getTe() );
        entity.setTe2( event.getTe2() );
        entity.setTi1( event.getTi1() );
        entity.setTi3( event.getTi3() );
        entity.setTi4( event.getTi4() );
        entity.setTr4( event.getTr4() );
        entity.setUpmax( event.getUpmax() );
        entity.setUpmin( event.getUpmin() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setXp( event.getXp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcELIN2( entity );
    }

    /*
     * @param	event UpdateExcELIN2Event
     */
    @EventHandler( payloadType=UpdateExcELIN2Event.class )
    public void handle( UpdateExcELIN2Event event) {
    	LOGGER.info("handling UpdateExcELIN2Event - " + event );
    	
	    ExcELIN2 entity = new ExcELIN2();
        entity.setExcELIN2Id( event.getExcELIN2Id() );
        entity.setEfdbas( event.getEfdbas() );
        entity.setIefmax( event.getIefmax() );
        entity.setIefmax2( event.getIefmax2() );
        entity.setIefmin( event.getIefmin() );
        entity.setK1( event.getK1() );
        entity.setK1ec( event.getK1ec() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setKd1( event.getKd1() );
        entity.setKe2( event.getKe2() );
        entity.setKetb( event.getKetb() );
        entity.setPid1max( event.getPid1max() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTb1( event.getTb1() );
        entity.setTe( event.getTe() );
        entity.setTe2( event.getTe2() );
        entity.setTi1( event.getTi1() );
        entity.setTi3( event.getTi3() );
        entity.setTi4( event.getTi4() );
        entity.setTr4( event.getTr4() );
        entity.setUpmax( event.getUpmax() );
        entity.setUpmin( event.getUpmin() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setXp( event.getXp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcELIN2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcELIN2( entity );        
    }
    
    /*
     * @param	event DeleteExcELIN2Event
     */
    @EventHandler( payloadType=DeleteExcELIN2Event.class )
    public void handle( DeleteExcELIN2Event event) {
    	LOGGER.info("handling DeleteExcELIN2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcELIN2 entity = delete( event.getExcELIN2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcELIN2( entity );

    }    




    /**
     * Method to retrieve the ExcELIN2 via an ExcELIN2PrimaryKey.
     * @param 	id Long
     * @return 	ExcELIN2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcELIN2 handle( FindExcELIN2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcELIN2Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcELIN2s
     *
     * @param	query	FindAllExcELIN2Query 
     * @return 	List<ExcELIN2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcELIN2> handle( FindAllExcELIN2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcELIN2, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcELIN2
	 */
	protected void emitFindExcELIN2( ExcELIN2 entity ) {
		LOGGER.info("handling emitFindExcELIN2" );
		
	    queryUpdateEmitter.emit(FindExcELIN2Query.class,
	                            query -> query.getFilter().getExcELIN2Id().equals(entity.getExcELIN2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcELIN2
	 * 
	 * @param		entity	ExcELIN2
	 */
	protected void emitFindAllExcELIN2( ExcELIN2 entity ) {
		LOGGER.info("handling emitFindAllExcELIN2" );
		
	    queryUpdateEmitter.emit(FindAllExcELIN2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcELIN2Projector.class.getName());

}
