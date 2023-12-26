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
 * Implements Spring Controller command CQRS processing for entity WindPlantUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantUserDefined")
public class WindPlantUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindPlantUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		WindPlantUserDefined	windPlantUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindPlantUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().createWindPlantUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindPlantUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		WindPlantUserDefined windPlantUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindPlantUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindPlantUserDefinedCommand
			// -----------------------------------------------
			completableFuture = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().updateWindPlantUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindPlantUserDefinedController:update() - successfully update WindPlantUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindPlantUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windPlantUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindPlantUserDefinedCommand command = new DeleteWindPlantUserDefinedCommand( windPlantUserDefinedId );

    	try {
        	WindPlantUserDefinedBusinessDelegate delegate = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindPlantUserDefined with key " + command.getWindPlantUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantUserDefined windPlantUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantUserDefinedCommandRestController.class.getName());
    
}
