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
 * Projector for CsConverter as outlined for the CQRS pattern.  All event handling and query handling related to CsConverter are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by CsConverterAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("csConverter")
@Component("csConverter-projector")
public class CsConverterProjector extends CsConverterEntityProjector {
		
	// core constructor
	public CsConverterProjector(CsConverterRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateCsConverterEvent
     */
    @EventHandler( payloadType=CreateCsConverterEvent.class )
    public void handle( CreateCsConverterEvent event) {
	    LOGGER.info("handling CreateCsConverterEvent - " + event );
	    CsConverter entity = new CsConverter();
        entity.setCsConverterId( event.getCsConverterId() );
        entity.setMaxAlpha( event.getMaxAlpha() );
        entity.setMaxGamma( event.getMaxGamma() );
        entity.setMaxIdc( event.getMaxIdc() );
        entity.setMinAlpha( event.getMinAlpha() );
        entity.setMinGamma( event.getMinGamma() );
        entity.setMinIdc( event.getMinIdc() );
        entity.setRatedIdc( event.getRatedIdc() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCsConverter( entity );
    }

    /*
     * @param	event UpdateCsConverterEvent
     */
    @EventHandler( payloadType=UpdateCsConverterEvent.class )
    public void handle( UpdateCsConverterEvent event) {
    	LOGGER.info("handling UpdateCsConverterEvent - " + event );
    	
	    CsConverter entity = new CsConverter();
        entity.setCsConverterId( event.getCsConverterId() );
        entity.setMaxAlpha( event.getMaxAlpha() );
        entity.setMaxGamma( event.getMaxGamma() );
        entity.setMaxIdc( event.getMaxIdc() );
        entity.setMinAlpha( event.getMinAlpha() );
        entity.setMinGamma( event.getMinGamma() );
        entity.setMinIdc( event.getMinIdc() );
        entity.setRatedIdc( event.getRatedIdc() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindCsConverter( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCsConverter( entity );        
    }
    
    /*
     * @param	event DeleteCsConverterEvent
     */
    @EventHandler( payloadType=DeleteCsConverterEvent.class )
    public void handle( DeleteCsConverterEvent event) {
    	LOGGER.info("handling DeleteCsConverterEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	CsConverter entity = delete( event.getCsConverterId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCsConverter( entity );

    }    




    /**
     * Method to retrieve the CsConverter via an CsConverterPrimaryKey.
     * @param 	id Long
     * @return 	CsConverter
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public CsConverter handle( FindCsConverterQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getCsConverterId() );
    }
    
    /**
     * Method to retrieve a collection of all CsConverters
     *
     * @param	query	FindAllCsConverterQuery 
     * @return 	List<CsConverter> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<CsConverter> handle( FindAllCsConverterQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindCsConverter, 
	 * but only if the id matches
	 * 
	 * @param		entity	CsConverter
	 */
	protected void emitFindCsConverter( CsConverter entity ) {
		LOGGER.info("handling emitFindCsConverter" );
		
	    queryUpdateEmitter.emit(FindCsConverterQuery.class,
	                            query -> query.getFilter().getCsConverterId().equals(entity.getCsConverterId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllCsConverter
	 * 
	 * @param		entity	CsConverter
	 */
	protected void emitFindAllCsConverter( CsConverter entity ) {
		LOGGER.info("handling emitFindAllCsConverter" );
		
	    queryUpdateEmitter.emit(FindAllCsConverterQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(CsConverterProjector.class.getName());

}
