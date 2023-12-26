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
 * Projector for WindGenTurbineType3aIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindGenTurbineType3aIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGenTurbineType3aIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGenTurbineType3aIEC")
@Component("windGenTurbineType3aIEC-projector")
public class WindGenTurbineType3aIECProjector extends WindGenTurbineType3aIECEntityProjector {
		
	// core constructor
	public WindGenTurbineType3aIECProjector(WindGenTurbineType3aIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGenTurbineType3aIECEvent
     */
    @EventHandler( payloadType=CreateWindGenTurbineType3aIECEvent.class )
    public void handle( CreateWindGenTurbineType3aIECEvent event) {
	    LOGGER.info("handling CreateWindGenTurbineType3aIECEvent - " + event );
	    WindGenTurbineType3aIEC entity = new WindGenTurbineType3aIEC();
        entity.setWindGenTurbineType3aIECId( event.getWindGenTurbineType3aIECId() );
        entity.setKpc( event.getKpc() );
        entity.setTic( event.getTic() );
        entity.setXs( event.getXs() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3aIEC( entity );
    }

    /*
     * @param	event UpdateWindGenTurbineType3aIECEvent
     */
    @EventHandler( payloadType=UpdateWindGenTurbineType3aIECEvent.class )
    public void handle( UpdateWindGenTurbineType3aIECEvent event) {
    	LOGGER.info("handling UpdateWindGenTurbineType3aIECEvent - " + event );
    	
	    WindGenTurbineType3aIEC entity = new WindGenTurbineType3aIEC();
        entity.setWindGenTurbineType3aIECId( event.getWindGenTurbineType3aIECId() );
        entity.setKpc( event.getKpc() );
        entity.setTic( event.getTic() );
        entity.setXs( event.getXs() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGenTurbineType3aIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3aIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindGenTurbineType3aIECEvent
     */
    @EventHandler( payloadType=DeleteWindGenTurbineType3aIECEvent.class )
    public void handle( DeleteWindGenTurbineType3aIECEvent event) {
    	LOGGER.info("handling DeleteWindGenTurbineType3aIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGenTurbineType3aIEC entity = delete( event.getWindGenTurbineType3aIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGenTurbineType3aIEC( entity );

    }    




    /**
     * Method to retrieve the WindGenTurbineType3aIEC via an WindGenTurbineType3aIECPrimaryKey.
     * @param 	id Long
     * @return 	WindGenTurbineType3aIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGenTurbineType3aIEC handle( FindWindGenTurbineType3aIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGenTurbineType3aIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType3aIECs
     *
     * @param	query	FindAllWindGenTurbineType3aIECQuery 
     * @return 	List<WindGenTurbineType3aIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGenTurbineType3aIEC> handle( FindAllWindGenTurbineType3aIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGenTurbineType3aIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGenTurbineType3aIEC
	 */
	protected void emitFindWindGenTurbineType3aIEC( WindGenTurbineType3aIEC entity ) {
		LOGGER.info("handling emitFindWindGenTurbineType3aIEC" );
		
	    queryUpdateEmitter.emit(FindWindGenTurbineType3aIECQuery.class,
	                            query -> query.getFilter().getWindGenTurbineType3aIECId().equals(entity.getWindGenTurbineType3aIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGenTurbineType3aIEC
	 * 
	 * @param		entity	WindGenTurbineType3aIEC
	 */
	protected void emitFindAllWindGenTurbineType3aIEC( WindGenTurbineType3aIEC entity ) {
		LOGGER.info("handling emitFindAllWindGenTurbineType3aIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindGenTurbineType3aIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3aIECProjector.class.getName());

}
