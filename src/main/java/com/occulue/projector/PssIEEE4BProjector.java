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
 * Projector for PssIEEE4B as outlined for the CQRS pattern.  All event handling and query handling related to PssIEEE4B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssIEEE4BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssIEEE4B")
@Component("pssIEEE4B-projector")
public class PssIEEE4BProjector extends PssIEEE4BEntityProjector {
		
	// core constructor
	public PssIEEE4BProjector(PssIEEE4BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssIEEE4BEvent
     */
    @EventHandler( payloadType=CreatePssIEEE4BEvent.class )
    public void handle( CreatePssIEEE4BEvent event) {
	    LOGGER.info("handling CreatePssIEEE4BEvent - " + event );
	    PssIEEE4B entity = new PssIEEE4B();
        entity.setPssIEEE4BId( event.getPssIEEE4BId() );
        entity.setBwh1( event.getBwh1() );
        entity.setBwh2( event.getBwh2() );
        entity.setBwl1( event.getBwl1() );
        entity.setBwl2( event.getBwl2() );
        entity.setKh( event.getKh() );
        entity.setKh1( event.getKh1() );
        entity.setKh11( event.getKh11() );
        entity.setKh17( event.getKh17() );
        entity.setKh2( event.getKh2() );
        entity.setKi( event.getKi() );
        entity.setKi1( event.getKi1() );
        entity.setKi11( event.getKi11() );
        entity.setKi17( event.getKi17() );
        entity.setKi2( event.getKi2() );
        entity.setKl( event.getKl() );
        entity.setKl1( event.getKl1() );
        entity.setKl11( event.getKl11() );
        entity.setKl17( event.getKl17() );
        entity.setKl2( event.getKl2() );
        entity.setOmeganh1( event.getOmeganh1() );
        entity.setOmeganh2( event.getOmeganh2() );
        entity.setOmeganl1( event.getOmeganl1() );
        entity.setOmeganl2( event.getOmeganl2() );
        entity.setTh1( event.getTh1() );
        entity.setTh10( event.getTh10() );
        entity.setTh11( event.getTh11() );
        entity.setTh12( event.getTh12() );
        entity.setTh2( event.getTh2() );
        entity.setTh3( event.getTh3() );
        entity.setTh4( event.getTh4() );
        entity.setTh5( event.getTh5() );
        entity.setTh6( event.getTh6() );
        entity.setTh7( event.getTh7() );
        entity.setTh8( event.getTh8() );
        entity.setTh9( event.getTh9() );
        entity.setTi1( event.getTi1() );
        entity.setTi10( event.getTi10() );
        entity.setTi11( event.getTi11() );
        entity.setTi12( event.getTi12() );
        entity.setTi2( event.getTi2() );
        entity.setTi3( event.getTi3() );
        entity.setTi4( event.getTi4() );
        entity.setTi5( event.getTi5() );
        entity.setTi6( event.getTi6() );
        entity.setTi7( event.getTi7() );
        entity.setTi8( event.getTi8() );
        entity.setTi9( event.getTi9() );
        entity.setTl1( event.getTl1() );
        entity.setTl10( event.getTl10() );
        entity.setTl11( event.getTl11() );
        entity.setTl12( event.getTl12() );
        entity.setTl2( event.getTl2() );
        entity.setTl3( event.getTl3() );
        entity.setTl4( event.getTl4() );
        entity.setTl5( event.getTl5() );
        entity.setTl6( event.getTl6() );
        entity.setTl7( event.getTl7() );
        entity.setTl8( event.getTl8() );
        entity.setTl9( event.getTl9() );
        entity.setVhmax( event.getVhmax() );
        entity.setVhmin( event.getVhmin() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVlmax( event.getVlmax() );
        entity.setVlmin( event.getVlmin() );
        entity.setVstmax( event.getVstmax() );
        entity.setVstmin( event.getVstmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE4B( entity );
    }

    /*
     * @param	event UpdatePssIEEE4BEvent
     */
    @EventHandler( payloadType=UpdatePssIEEE4BEvent.class )
    public void handle( UpdatePssIEEE4BEvent event) {
    	LOGGER.info("handling UpdatePssIEEE4BEvent - " + event );
    	
	    PssIEEE4B entity = new PssIEEE4B();
        entity.setPssIEEE4BId( event.getPssIEEE4BId() );
        entity.setBwh1( event.getBwh1() );
        entity.setBwh2( event.getBwh2() );
        entity.setBwl1( event.getBwl1() );
        entity.setBwl2( event.getBwl2() );
        entity.setKh( event.getKh() );
        entity.setKh1( event.getKh1() );
        entity.setKh11( event.getKh11() );
        entity.setKh17( event.getKh17() );
        entity.setKh2( event.getKh2() );
        entity.setKi( event.getKi() );
        entity.setKi1( event.getKi1() );
        entity.setKi11( event.getKi11() );
        entity.setKi17( event.getKi17() );
        entity.setKi2( event.getKi2() );
        entity.setKl( event.getKl() );
        entity.setKl1( event.getKl1() );
        entity.setKl11( event.getKl11() );
        entity.setKl17( event.getKl17() );
        entity.setKl2( event.getKl2() );
        entity.setOmeganh1( event.getOmeganh1() );
        entity.setOmeganh2( event.getOmeganh2() );
        entity.setOmeganl1( event.getOmeganl1() );
        entity.setOmeganl2( event.getOmeganl2() );
        entity.setTh1( event.getTh1() );
        entity.setTh10( event.getTh10() );
        entity.setTh11( event.getTh11() );
        entity.setTh12( event.getTh12() );
        entity.setTh2( event.getTh2() );
        entity.setTh3( event.getTh3() );
        entity.setTh4( event.getTh4() );
        entity.setTh5( event.getTh5() );
        entity.setTh6( event.getTh6() );
        entity.setTh7( event.getTh7() );
        entity.setTh8( event.getTh8() );
        entity.setTh9( event.getTh9() );
        entity.setTi1( event.getTi1() );
        entity.setTi10( event.getTi10() );
        entity.setTi11( event.getTi11() );
        entity.setTi12( event.getTi12() );
        entity.setTi2( event.getTi2() );
        entity.setTi3( event.getTi3() );
        entity.setTi4( event.getTi4() );
        entity.setTi5( event.getTi5() );
        entity.setTi6( event.getTi6() );
        entity.setTi7( event.getTi7() );
        entity.setTi8( event.getTi8() );
        entity.setTi9( event.getTi9() );
        entity.setTl1( event.getTl1() );
        entity.setTl10( event.getTl10() );
        entity.setTl11( event.getTl11() );
        entity.setTl12( event.getTl12() );
        entity.setTl2( event.getTl2() );
        entity.setTl3( event.getTl3() );
        entity.setTl4( event.getTl4() );
        entity.setTl5( event.getTl5() );
        entity.setTl6( event.getTl6() );
        entity.setTl7( event.getTl7() );
        entity.setTl8( event.getTl8() );
        entity.setTl9( event.getTl9() );
        entity.setVhmax( event.getVhmax() );
        entity.setVhmin( event.getVhmin() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVlmax( event.getVlmax() );
        entity.setVlmin( event.getVlmin() );
        entity.setVstmax( event.getVstmax() );
        entity.setVstmin( event.getVstmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssIEEE4B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE4B( entity );        
    }
    
    /*
     * @param	event DeletePssIEEE4BEvent
     */
    @EventHandler( payloadType=DeletePssIEEE4BEvent.class )
    public void handle( DeletePssIEEE4BEvent event) {
    	LOGGER.info("handling DeletePssIEEE4BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssIEEE4B entity = delete( event.getPssIEEE4BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE4B( entity );

    }    




    /**
     * Method to retrieve the PssIEEE4B via an PssIEEE4BPrimaryKey.
     * @param 	id Long
     * @return 	PssIEEE4B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssIEEE4B handle( FindPssIEEE4BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssIEEE4BId() );
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE4Bs
     *
     * @param	query	FindAllPssIEEE4BQuery 
     * @return 	List<PssIEEE4B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssIEEE4B> handle( FindAllPssIEEE4BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssIEEE4B, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssIEEE4B
	 */
	protected void emitFindPssIEEE4B( PssIEEE4B entity ) {
		LOGGER.info("handling emitFindPssIEEE4B" );
		
	    queryUpdateEmitter.emit(FindPssIEEE4BQuery.class,
	                            query -> query.getFilter().getPssIEEE4BId().equals(entity.getPssIEEE4BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssIEEE4B
	 * 
	 * @param		entity	PssIEEE4B
	 */
	protected void emitFindAllPssIEEE4B( PssIEEE4B entity ) {
		LOGGER.info("handling emitFindAllPssIEEE4B" );
		
	    queryUpdateEmitter.emit(FindAllPssIEEE4BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE4BProjector.class.getName());

}
