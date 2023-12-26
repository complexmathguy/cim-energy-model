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
 * Implements Spring Controller command CQRS processing for entity LoadResponseCharacteristic.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadResponseCharacteristic")
public class LoadResponseCharacteristicCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadResponseCharacteristic.  if not key provided, calls create, otherwise calls save
     * @param		LoadResponseCharacteristic	loadResponseCharacteristic
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadResponseCharacteristicCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance().createLoadResponseCharacteristic( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadResponseCharacteristic.  if no key provided, calls create, otherwise calls save
     * @param		LoadResponseCharacteristic loadResponseCharacteristic
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadResponseCharacteristicCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadResponseCharacteristicCommand
			// -----------------------------------------------
			completableFuture = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance().updateLoadResponseCharacteristic(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadResponseCharacteristicController:update() - successfully update LoadResponseCharacteristic - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadResponseCharacteristic entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadResponseCharacteristicId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadResponseCharacteristicCommand command = new DeleteLoadResponseCharacteristicCommand( loadResponseCharacteristicId );

    	try {
        	LoadResponseCharacteristicBusinessDelegate delegate = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadResponseCharacteristic with key " + command.getLoadResponseCharacteristicId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadResponseCharacteristic loadResponseCharacteristic = null;
    private static final Logger LOGGER = Logger.getLogger(LoadResponseCharacteristicCommandRestController.class.getName());
    
}
