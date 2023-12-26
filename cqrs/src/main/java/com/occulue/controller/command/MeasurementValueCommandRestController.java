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
 * Implements Spring Controller command CQRS processing for entity MeasurementValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValue")
public class MeasurementValueCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MeasurementValue.  if not key provided, calls create, otherwise calls save
     * @param		MeasurementValue	measurementValue
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMeasurementValueCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MeasurementValueBusinessDelegate.getMeasurementValueInstance().createMeasurementValue( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MeasurementValue.  if no key provided, calls create, otherwise calls save
     * @param		MeasurementValue measurementValue
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMeasurementValueCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMeasurementValueCommand
			// -----------------------------------------------
			completableFuture = MeasurementValueBusinessDelegate.getMeasurementValueInstance().updateMeasurementValue(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MeasurementValueController:update() - successfully update MeasurementValue - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MeasurementValue entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID measurementValueId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMeasurementValueCommand command = new DeleteMeasurementValueCommand( measurementValueId );

    	try {
        	MeasurementValueBusinessDelegate delegate = MeasurementValueBusinessDelegate.getMeasurementValueInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MeasurementValue with key " + command.getMeasurementValueId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MeasurementValue measurementValue = null;
    private static final Logger LOGGER = Logger.getLogger(MeasurementValueCommandRestController.class.getName());
    
}
