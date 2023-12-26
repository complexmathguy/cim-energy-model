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
 * Projector for ExcREXS as outlined for the CQRS pattern.  All event handling and query handling related to ExcREXS are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcREXSAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excREXS")
@Component("excREXS-projector")
public class ExcREXSProjector extends ExcREXSEntityProjector {
		
	// core constructor
	public ExcREXSProjector(ExcREXSRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcREXSEvent
     */
    @EventHandler( payloadType=CreateExcREXSEvent.class )
    public void handle( CreateExcREXSEvent event) {
	    LOGGER.info("handling CreateExcREXSEvent - " + event );
	    ExcREXS entity = new ExcREXS();
        entity.setExcREXSId( event.getExcREXSId() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setFbf( event.getFbf() );
        entity.setFlimf( event.getFlimf() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKefd( event.getKefd() );
        entity.setKf( event.getKf() );
        entity.setKh( event.getKh() );
        entity.setKii( event.getKii() );
        entity.setKip( event.getKip() );
        entity.setKs( event.getKs() );
        entity.setKvi( event.getKvi() );
        entity.setKvp( event.getKvp() );
        entity.setKvphz( event.getKvphz() );
        entity.setNvphz( event.getNvphz() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa( event.getTa() );
        entity.setTb1( event.getTb1() );
        entity.setTb2( event.getTb2() );
        entity.setTc1( event.getTc1() );
        entity.setTc2( event.getTc2() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setTp( event.getTp() );
        entity.setVcmax( event.getVcmax() );
        entity.setVfmax( event.getVfmax() );
        entity.setVfmin( event.getVfmin() );
        entity.setVimax( event.getVimax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXc( event.getXc() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcREXS( entity );
    }

    /*
     * @param	event UpdateExcREXSEvent
     */
    @EventHandler( payloadType=UpdateExcREXSEvent.class )
    public void handle( UpdateExcREXSEvent event) {
    	LOGGER.info("handling UpdateExcREXSEvent - " + event );
    	
	    ExcREXS entity = new ExcREXS();
        entity.setExcREXSId( event.getExcREXSId() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setFbf( event.getFbf() );
        entity.setFlimf( event.getFlimf() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKefd( event.getKefd() );
        entity.setKf( event.getKf() );
        entity.setKh( event.getKh() );
        entity.setKii( event.getKii() );
        entity.setKip( event.getKip() );
        entity.setKs( event.getKs() );
        entity.setKvi( event.getKvi() );
        entity.setKvp( event.getKvp() );
        entity.setKvphz( event.getKvphz() );
        entity.setNvphz( event.getNvphz() );
        entity.setSe1( event.getSe1() );
        entity.setSe2( event.getSe2() );
        entity.setTa( event.getTa() );
        entity.setTb1( event.getTb1() );
        entity.setTb2( event.getTb2() );
        entity.setTc1( event.getTc1() );
        entity.setTc2( event.getTc2() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setTp( event.getTp() );
        entity.setVcmax( event.getVcmax() );
        entity.setVfmax( event.getVfmax() );
        entity.setVfmin( event.getVfmin() );
        entity.setVimax( event.getVimax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXc( event.getXc() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcREXS( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcREXS( entity );        
    }
    
    /*
     * @param	event DeleteExcREXSEvent
     */
    @EventHandler( payloadType=DeleteExcREXSEvent.class )
    public void handle( DeleteExcREXSEvent event) {
    	LOGGER.info("handling DeleteExcREXSEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcREXS entity = delete( event.getExcREXSId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcREXS( entity );

    }    




    /**
     * Method to retrieve the ExcREXS via an ExcREXSPrimaryKey.
     * @param 	id Long
     * @return 	ExcREXS
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcREXS handle( FindExcREXSQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcREXSId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcREXSs
     *
     * @param	query	FindAllExcREXSQuery 
     * @return 	List<ExcREXS> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcREXS> handle( FindAllExcREXSQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcREXS, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcREXS
	 */
	protected void emitFindExcREXS( ExcREXS entity ) {
		LOGGER.info("handling emitFindExcREXS" );
		
	    queryUpdateEmitter.emit(FindExcREXSQuery.class,
	                            query -> query.getFilter().getExcREXSId().equals(entity.getExcREXSId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcREXS
	 * 
	 * @param		entity	ExcREXS
	 */
	protected void emitFindAllExcREXS( ExcREXS entity ) {
		LOGGER.info("handling emitFindAllExcREXS" );
		
	    queryUpdateEmitter.emit(FindAllExcREXSQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcREXSProjector.class.getName());

}
