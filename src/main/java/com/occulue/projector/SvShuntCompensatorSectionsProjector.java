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
 * Projector for SvShuntCompensatorSections as outlined for the CQRS pattern.  All event handling and query handling related to SvShuntCompensatorSections are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SvShuntCompensatorSectionsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("svShuntCompensatorSections")
@Component("svShuntCompensatorSections-projector")
public class SvShuntCompensatorSectionsProjector extends SvShuntCompensatorSectionsEntityProjector {
		
	// core constructor
	public SvShuntCompensatorSectionsProjector(SvShuntCompensatorSectionsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSvShuntCompensatorSectionsEvent
     */
    @EventHandler( payloadType=CreateSvShuntCompensatorSectionsEvent.class )
    public void handle( CreateSvShuntCompensatorSectionsEvent event) {
	    LOGGER.info("handling CreateSvShuntCompensatorSectionsEvent - " + event );
	    SvShuntCompensatorSections entity = new SvShuntCompensatorSections();
        entity.setSvShuntCompensatorSectionsId( event.getSvShuntCompensatorSectionsId() );
        entity.setSections( event.getSections() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvShuntCompensatorSections( entity );
    }

    /*
     * @param	event UpdateSvShuntCompensatorSectionsEvent
     */
    @EventHandler( payloadType=UpdateSvShuntCompensatorSectionsEvent.class )
    public void handle( UpdateSvShuntCompensatorSectionsEvent event) {
    	LOGGER.info("handling UpdateSvShuntCompensatorSectionsEvent - " + event );
    	
	    SvShuntCompensatorSections entity = new SvShuntCompensatorSections();
        entity.setSvShuntCompensatorSectionsId( event.getSvShuntCompensatorSectionsId() );
        entity.setSections( event.getSections() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSvShuntCompensatorSections( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvShuntCompensatorSections( entity );        
    }
    
    /*
     * @param	event DeleteSvShuntCompensatorSectionsEvent
     */
    @EventHandler( payloadType=DeleteSvShuntCompensatorSectionsEvent.class )
    public void handle( DeleteSvShuntCompensatorSectionsEvent event) {
    	LOGGER.info("handling DeleteSvShuntCompensatorSectionsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SvShuntCompensatorSections entity = delete( event.getSvShuntCompensatorSectionsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvShuntCompensatorSections( entity );

    }    




    /**
     * Method to retrieve the SvShuntCompensatorSections via an SvShuntCompensatorSectionsPrimaryKey.
     * @param 	id Long
     * @return 	SvShuntCompensatorSections
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SvShuntCompensatorSections handle( FindSvShuntCompensatorSectionsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSvShuntCompensatorSectionsId() );
    }
    
    /**
     * Method to retrieve a collection of all SvShuntCompensatorSectionss
     *
     * @param	query	FindAllSvShuntCompensatorSectionsQuery 
     * @return 	List<SvShuntCompensatorSections> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SvShuntCompensatorSections> handle( FindAllSvShuntCompensatorSectionsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSvShuntCompensatorSections, 
	 * but only if the id matches
	 * 
	 * @param		entity	SvShuntCompensatorSections
	 */
	protected void emitFindSvShuntCompensatorSections( SvShuntCompensatorSections entity ) {
		LOGGER.info("handling emitFindSvShuntCompensatorSections" );
		
	    queryUpdateEmitter.emit(FindSvShuntCompensatorSectionsQuery.class,
	                            query -> query.getFilter().getSvShuntCompensatorSectionsId().equals(entity.getSvShuntCompensatorSectionsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSvShuntCompensatorSections
	 * 
	 * @param		entity	SvShuntCompensatorSections
	 */
	protected void emitFindAllSvShuntCompensatorSections( SvShuntCompensatorSections entity ) {
		LOGGER.info("handling emitFindAllSvShuntCompensatorSections" );
		
	    queryUpdateEmitter.emit(FindAllSvShuntCompensatorSectionsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SvShuntCompensatorSectionsProjector.class.getName());

}
