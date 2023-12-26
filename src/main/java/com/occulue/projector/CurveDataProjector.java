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
 * Projector for CurveData as outlined for the CQRS pattern.  All event handling and query handling related to CurveData are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by CurveDataAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("curveData")
@Component("curveData-projector")
public class CurveDataProjector extends CurveDataEntityProjector {
		
	// core constructor
	public CurveDataProjector(CurveDataRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateCurveDataEvent
     */
    @EventHandler( payloadType=CreateCurveDataEvent.class )
    public void handle( CreateCurveDataEvent event) {
	    LOGGER.info("handling CreateCurveDataEvent - " + event );
	    CurveData entity = new CurveData();
        entity.setCurveDataId( event.getCurveDataId() );
        entity.setXvalue( event.getXvalue() );
        entity.setY1value( event.getY1value() );
        entity.setY2value( event.getY2value() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurveData( entity );
    }

    /*
     * @param	event UpdateCurveDataEvent
     */
    @EventHandler( payloadType=UpdateCurveDataEvent.class )
    public void handle( UpdateCurveDataEvent event) {
    	LOGGER.info("handling UpdateCurveDataEvent - " + event );
    	
	    CurveData entity = new CurveData();
        entity.setCurveDataId( event.getCurveDataId() );
        entity.setXvalue( event.getXvalue() );
        entity.setY1value( event.getY1value() );
        entity.setY2value( event.getY2value() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindCurveData( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurveData( entity );        
    }
    
    /*
     * @param	event DeleteCurveDataEvent
     */
    @EventHandler( payloadType=DeleteCurveDataEvent.class )
    public void handle( DeleteCurveDataEvent event) {
    	LOGGER.info("handling DeleteCurveDataEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	CurveData entity = delete( event.getCurveDataId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurveData( entity );

    }    




    /**
     * Method to retrieve the CurveData via an CurveDataPrimaryKey.
     * @param 	id Long
     * @return 	CurveData
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public CurveData handle( FindCurveDataQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getCurveDataId() );
    }
    
    /**
     * Method to retrieve a collection of all CurveDatas
     *
     * @param	query	FindAllCurveDataQuery 
     * @return 	List<CurveData> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<CurveData> handle( FindAllCurveDataQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindCurveData, 
	 * but only if the id matches
	 * 
	 * @param		entity	CurveData
	 */
	protected void emitFindCurveData( CurveData entity ) {
		LOGGER.info("handling emitFindCurveData" );
		
	    queryUpdateEmitter.emit(FindCurveDataQuery.class,
	                            query -> query.getFilter().getCurveDataId().equals(entity.getCurveDataId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllCurveData
	 * 
	 * @param		entity	CurveData
	 */
	protected void emitFindAllCurveData( CurveData entity ) {
		LOGGER.info("handling emitFindAllCurveData" );
		
	    queryUpdateEmitter.emit(FindAllCurveDataQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(CurveDataProjector.class.getName());

}
