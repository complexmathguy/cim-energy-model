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
 * Projector for VsConverter as outlined for the CQRS pattern.  All event handling and query handling related to VsConverter are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VsConverterAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("vsConverter")
@Component("vsConverter-projector")
public class VsConverterProjector extends VsConverterEntityProjector {
		
	// core constructor
	public VsConverterProjector(VsConverterRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVsConverterEvent
     */
    @EventHandler( payloadType=CreateVsConverterEvent.class )
    public void handle( CreateVsConverterEvent event) {
	    LOGGER.info("handling CreateVsConverterEvent - " + event );
	    VsConverter entity = new VsConverter();
        entity.setVsConverterId( event.getVsConverterId() );
        entity.setMaxModulationIndex( event.getMaxModulationIndex() );
        entity.setMaxValveCurrent( event.getMaxValveCurrent() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVsConverter( entity );
    }

    /*
     * @param	event UpdateVsConverterEvent
     */
    @EventHandler( payloadType=UpdateVsConverterEvent.class )
    public void handle( UpdateVsConverterEvent event) {
    	LOGGER.info("handling UpdateVsConverterEvent - " + event );
    	
	    VsConverter entity = new VsConverter();
        entity.setVsConverterId( event.getVsConverterId() );
        entity.setMaxModulationIndex( event.getMaxModulationIndex() );
        entity.setMaxValveCurrent( event.getMaxValveCurrent() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVsConverter( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVsConverter( entity );        
    }
    
    /*
     * @param	event DeleteVsConverterEvent
     */
    @EventHandler( payloadType=DeleteVsConverterEvent.class )
    public void handle( DeleteVsConverterEvent event) {
    	LOGGER.info("handling DeleteVsConverterEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VsConverter entity = delete( event.getVsConverterId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVsConverter( entity );

    }    




    /**
     * Method to retrieve the VsConverter via an VsConverterPrimaryKey.
     * @param 	id Long
     * @return 	VsConverter
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VsConverter handle( FindVsConverterQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVsConverterId() );
    }
    
    /**
     * Method to retrieve a collection of all VsConverters
     *
     * @param	query	FindAllVsConverterQuery 
     * @return 	List<VsConverter> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VsConverter> handle( FindAllVsConverterQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVsConverter, 
	 * but only if the id matches
	 * 
	 * @param		entity	VsConverter
	 */
	protected void emitFindVsConverter( VsConverter entity ) {
		LOGGER.info("handling emitFindVsConverter" );
		
	    queryUpdateEmitter.emit(FindVsConverterQuery.class,
	                            query -> query.getFilter().getVsConverterId().equals(entity.getVsConverterId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVsConverter
	 * 
	 * @param		entity	VsConverter
	 */
	protected void emitFindAllVsConverter( VsConverter entity ) {
		LOGGER.info("handling emitFindAllVsConverter" );
		
	    queryUpdateEmitter.emit(FindAllVsConverterQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VsConverterProjector.class.getName());

}
