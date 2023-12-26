/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.controller.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;

import com.occulue.controller.*;

/** 
 * Implements Spring Controller command CQRS processing for entity SeriesCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SeriesCompensator")
public class SeriesCompensatorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SeriesCompensator.  if not key provided, calls create, otherwise calls save
     * @param		SeriesCompensator	seriesCompensator
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSeriesCompensatorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().createSeriesCompensator( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SeriesCompensator.  if no key provided, calls create, otherwise calls save
     * @param		SeriesCompensator seriesCompensator
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSeriesCompensatorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSeriesCompensatorCommand
			// -----------------------------------------------
			completableFuture = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().updateSeriesCompensator(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SeriesCompensatorController:update() - successfully update SeriesCompensator - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SeriesCompensator entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID seriesCompensatorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSeriesCompensatorCommand command = new DeleteSeriesCompensatorCommand( seriesCompensatorId );

    	try {
        	SeriesCompensatorBusinessDelegate delegate = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SeriesCompensator with key " + command.getSeriesCompensatorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SeriesCompensator seriesCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(SeriesCompensatorCommandRestController.class.getName());
    
}
