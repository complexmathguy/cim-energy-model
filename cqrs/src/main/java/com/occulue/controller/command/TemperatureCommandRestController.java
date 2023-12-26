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
 * Implements Spring Controller command CQRS processing for entity Temperature.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Temperature")
public class TemperatureCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Temperature.  if not key provided, calls create, otherwise calls save
     * @param		Temperature	temperature
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTemperatureCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TemperatureBusinessDelegate.getTemperatureInstance().createTemperature( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Temperature.  if no key provided, calls create, otherwise calls save
     * @param		Temperature temperature
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTemperatureCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTemperatureCommand
			// -----------------------------------------------
			completableFuture = TemperatureBusinessDelegate.getTemperatureInstance().updateTemperature(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TemperatureController:update() - successfully update Temperature - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Temperature entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID temperatureId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTemperatureCommand command = new DeleteTemperatureCommand( temperatureId );

    	try {
        	TemperatureBusinessDelegate delegate = TemperatureBusinessDelegate.getTemperatureInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Temperature with key " + command.getTemperatureId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Temperature temperature = null;
    private static final Logger LOGGER = Logger.getLogger(TemperatureCommandRestController.class.getName());
    
}
