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
 * Projector for WindContPitchAngleIEC as outlined for the CQRS pattern.  All event handling and query handling related to WindContPitchAngleIEC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindContPitchAngleIECAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windContPitchAngleIEC")
@Component("windContPitchAngleIEC-projector")
public class WindContPitchAngleIECProjector extends WindContPitchAngleIECEntityProjector {
		
	// core constructor
	public WindContPitchAngleIECProjector(WindContPitchAngleIECRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindContPitchAngleIECEvent
     */
    @EventHandler( payloadType=CreateWindContPitchAngleIECEvent.class )
    public void handle( CreateWindContPitchAngleIECEvent event) {
	    LOGGER.info("handling CreateWindContPitchAngleIECEvent - " + event );
	    WindContPitchAngleIEC entity = new WindContPitchAngleIEC();
        entity.setWindContPitchAngleIECId( event.getWindContPitchAngleIECId() );
        entity.setDthetamax( event.getDthetamax() );
        entity.setDthetamin( event.getDthetamin() );
        entity.setKic( event.getKic() );
        entity.setKiomega( event.getKiomega() );
        entity.setKpc( event.getKpc() );
        entity.setKpomega( event.getKpomega() );
        entity.setKpx( event.getKpx() );
        entity.setThetamax( event.getThetamax() );
        entity.setThetamin( event.getThetamin() );
        entity.setTtheta( event.getTtheta() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContPitchAngleIEC( entity );
    }

    /*
     * @param	event UpdateWindContPitchAngleIECEvent
     */
    @EventHandler( payloadType=UpdateWindContPitchAngleIECEvent.class )
    public void handle( UpdateWindContPitchAngleIECEvent event) {
    	LOGGER.info("handling UpdateWindContPitchAngleIECEvent - " + event );
    	
	    WindContPitchAngleIEC entity = new WindContPitchAngleIEC();
        entity.setWindContPitchAngleIECId( event.getWindContPitchAngleIECId() );
        entity.setDthetamax( event.getDthetamax() );
        entity.setDthetamin( event.getDthetamin() );
        entity.setKic( event.getKic() );
        entity.setKiomega( event.getKiomega() );
        entity.setKpc( event.getKpc() );
        entity.setKpomega( event.getKpomega() );
        entity.setKpx( event.getKpx() );
        entity.setThetamax( event.getThetamax() );
        entity.setThetamin( event.getThetamin() );
        entity.setTtheta( event.getTtheta() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindContPitchAngleIEC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContPitchAngleIEC( entity );        
    }
    
    /*
     * @param	event DeleteWindContPitchAngleIECEvent
     */
    @EventHandler( payloadType=DeleteWindContPitchAngleIECEvent.class )
    public void handle( DeleteWindContPitchAngleIECEvent event) {
    	LOGGER.info("handling DeleteWindContPitchAngleIECEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindContPitchAngleIEC entity = delete( event.getWindContPitchAngleIECId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindContPitchAngleIEC( entity );

    }    




    /**
     * Method to retrieve the WindContPitchAngleIEC via an WindContPitchAngleIECPrimaryKey.
     * @param 	id Long
     * @return 	WindContPitchAngleIEC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindContPitchAngleIEC handle( FindWindContPitchAngleIECQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindContPitchAngleIECId() );
    }
    
    /**
     * Method to retrieve a collection of all WindContPitchAngleIECs
     *
     * @param	query	FindAllWindContPitchAngleIECQuery 
     * @return 	List<WindContPitchAngleIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindContPitchAngleIEC> handle( FindAllWindContPitchAngleIECQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindContPitchAngleIEC, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindContPitchAngleIEC
	 */
	protected void emitFindWindContPitchAngleIEC( WindContPitchAngleIEC entity ) {
		LOGGER.info("handling emitFindWindContPitchAngleIEC" );
		
	    queryUpdateEmitter.emit(FindWindContPitchAngleIECQuery.class,
	                            query -> query.getFilter().getWindContPitchAngleIECId().equals(entity.getWindContPitchAngleIECId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindContPitchAngleIEC
	 * 
	 * @param		entity	WindContPitchAngleIEC
	 */
	protected void emitFindAllWindContPitchAngleIEC( WindContPitchAngleIEC entity ) {
		LOGGER.info("handling emitFindAllWindContPitchAngleIEC" );
		
	    queryUpdateEmitter.emit(FindAllWindContPitchAngleIECQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindContPitchAngleIECProjector.class.getName());

}
