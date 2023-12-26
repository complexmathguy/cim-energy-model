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
 * Implements Spring Controller command CQRS processing for entity MeasurementValueSource.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValueSource")
public class MeasurementValueSourceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MeasurementValueSource.  if not key provided, calls create, otherwise calls save
     * @param		MeasurementValueSource	measurementValueSource
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMeasurementValueSourceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().createMeasurementValueSource( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MeasurementValueSource.  if no key provided, calls create, otherwise calls save
     * @param		MeasurementValueSource measurementValueSource
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMeasurementValueSourceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMeasurementValueSourceCommand
			// -----------------------------------------------
			completableFuture = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().updateMeasurementValueSource(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MeasurementValueSourceController:update() - successfully update MeasurementValueSource - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MeasurementValueSource entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID measurementValueSourceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMeasurementValueSourceCommand command = new DeleteMeasurementValueSourceCommand( measurementValueSourceId );

    	try {
        	MeasurementValueSourceBusinessDelegate delegate = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MeasurementValueSource with key " + command.getMeasurementValueSourceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MeasurementValueSource measurementValueSource = null;
    private static final Logger LOGGER = Logger.getLogger(MeasurementValueSourceCommandRestController.class.getName());
    
}
