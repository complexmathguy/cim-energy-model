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
 * Projector for WindPlantFreqPcontrolIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindPlantFreqPcontrolIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindPlantFreqPcontrolIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windPlantFreqPcontrolIEC")
@Component("windPlantFreqPcontrolIEC-projector")
public class WindPlantFreqPcontrolIECProjector extends WindPlantFreqPcontrolIECEntityProjector {
		
	// core constructor
	public WindPlantFreqPcontrolIECProjector(WindPlantFreqPcontrolIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindPlantFreqPcontrolIECEvent
     */
    @EventHandler( payloadType=CreateWindPlantFreqPcontrolIECEvent.class )
    public void handle( CreateWindPlantFreqPcontrolIECEvent event) {
	    LOGGER.info("handling CreateWindPlantFreqPcontrolIECEvent - " + event );
	    WindPlantFreqPcontrolIEC entity = new WindPlantFreqPcontrolIEC();
        entity.setWindPlantFreqPcontrolIECId( event.getWindPlantFreqPcontrolIECId() );
        entity.setDprefmax( event.getDprefmax() );
        entity.setDprefmin( event.getDprefmin() );
        entity.setKiwpp( event.getKiwpp() );
        entity.setKpwpp( event.getKpwpp() );
        entity.setPrefmax( event.getPrefmax() );
        entity.setPrefmin( event.getPrefmin() );
        entity.setTpft( event.getTpft() );
        entity.setTpfv( event.getTpfv() );
        entity.setTwpffilt( event.getTwpffilt() );
        entity.setTwppfilt( event.getTwppfilt() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantFreqPcontrolIEC( entity );
    }

    /*
     * @param	event UpdateWindPlantFreqPcontrolIECEvent
     */
    @EventHandler( payloadType=UpdateWindPlantFreqPcontrolIECEvent.class )
    public void handle( UpdateWindPlantFreqPcontrolIECEvent event) {
    	LOGGER.info("handling UpdateWindPlantFreqPcontrolIECEvent - " + event );
    	
	    WindPlantFreqPcontrolIEC entity = new WindPlantFreqPcontrolIEC();
        entity.setWindPlantFreqPcontrolIECId( event.getWindPlantFreqPcontrolIECId() );
        entity.setDprefmax( event.getDprefmax() );
        entity.setDprefmin( event.getDprefmin() );
        entity.setKiwpp( event.getKiwpp() );
        entity.setKpwpp( event.getKpwpp() );
        entity.setPrefmax( event.getPrefmax() );
        entity.setPrefmin( event.getPrefmin() );
        entity.setTpft( event.getTpft() );
        entity.setTpfv( event.getTpfv() );
        entity.setTwpffilt( event.getTwpffilt() );
        entity.setTwppfilt( event.getTwppfilt() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindPlantFreqPcontrolIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantFreqPcontrolIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindPlantFreqPcontrolIECEvent
     */
    @EventHandler( payloadType=DeleteWindPlantFreqPcontrolIECEvent.class )
    public void handle( DeleteWindPlantFreqPcontrolIECEvent event) {
    	LOGGER.info("handling DeleteWindPlantFreqPcontrolIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindPlantFreqPcontrolIEC entity = delete( event.getWindPlantFreqPcontrolIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantFreqPcontrolIEC( entity );

    }    




    /**
     * Method to retrieve the WindPlantFreqPcontrolIEC via an WindPlantFreqPcontrolIECPrimaryKey.
     * @param 	id Long
     * @return 	WindPlantFreqPcontrolIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindPlantFreqPcontrolIEC handle( FindWindPlantFreqPcontrolIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindPlantFreqPcontrolIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindPlantFreqPcontrolIECs
     *
     * @param	query	FindAllWindPlantFreqPcontrolIECQuery 
     * @return 	List<WindPlantFreqPcontrolIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindPlantFreqPcontrolIEC> handle( FindAllWindPlantFreqPcontrolIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindPlantFreqPcontrolIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindPlantFreqPcontrolIEC
	 */
	protected void emitFindWindPlantFreqPcontrolIEC( WindPlantFreqPcontrolIEC entity ) {
		LOGGER.info("handling emitFindWindPlantFreqPcontrolIEC" );
		
	    queryUpdateEmitter.emit(FindWindPlantFreqPcontrolIECQuery.class,
	                            query -> query.getFilter().getWindPlantFreqPcontrolIECId().equals(entity.getWindPlantFreqPcontrolIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindPlantFreqPcontrolIEC
	 * 
	 * @param		entity	WindPlantFreqPcontrolIEC
	 */
	protected void emitFindAllWindPlantFreqPcontrolIEC( WindPlantFreqPcontrolIEC entity ) {
		LOGGER.info("handling emitFindAllWindPlantFreqPcontrolIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindPlantFreqPcontrolIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindPlantFreqPcontrolIECProjector.class.getName());

}
