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
 * Implements Spring Controller command CQRS processing for entity StringMeasurement.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringMeasurement")
public class StringMeasurementCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a StringMeasurement.  if not key provided, calls create, otherwise calls save
     * @param		StringMeasurement	stringMeasurement
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStringMeasurementCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StringMeasurementBusinessDelegate.getStringMeasurementInstance().createStringMeasurement( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a StringMeasurement.  if no key provided, calls create, otherwise calls save
     * @param		StringMeasurement stringMeasurement
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStringMeasurementCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStringMeasurementCommand
			// -----------------------------------------------
			completableFuture = StringMeasurementBusinessDelegate.getStringMeasurementInstance().updateStringMeasurement(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StringMeasurementController:update() - successfully update StringMeasurement - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a StringMeasurement entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID stringMeasurementId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStringMeasurementCommand command = new DeleteStringMeasurementCommand( stringMeasurementId );

    	try {
        	StringMeasurementBusinessDelegate delegate = StringMeasurementBusinessDelegate.getStringMeasurementInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted StringMeasurement with key " + command.getStringMeasurementId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected StringMeasurement stringMeasurement = null;
    private static final Logger LOGGER = Logger.getLogger(StringMeasurementCommandRestController.class.getName());
    
}
