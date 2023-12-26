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
 * Implements Spring Controller command CQRS processing for entity RotationSpeed.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotationSpeed")
public class RotationSpeedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RotationSpeed.  if not key provided, calls create, otherwise calls save
     * @param		RotationSpeed	rotationSpeed
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRotationSpeedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RotationSpeedBusinessDelegate.getRotationSpeedInstance().createRotationSpeed( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RotationSpeed.  if no key provided, calls create, otherwise calls save
     * @param		RotationSpeed rotationSpeed
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRotationSpeedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRotationSpeedCommand
			// -----------------------------------------------
			completableFuture = RotationSpeedBusinessDelegate.getRotationSpeedInstance().updateRotationSpeed(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RotationSpeedController:update() - successfully update RotationSpeed - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RotationSpeed entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID rotationSpeedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRotationSpeedCommand command = new DeleteRotationSpeedCommand( rotationSpeedId );

    	try {
        	RotationSpeedBusinessDelegate delegate = RotationSpeedBusinessDelegate.getRotationSpeedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RotationSpeed with key " + command.getRotationSpeedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RotationSpeed rotationSpeed = null;
    private static final Logger LOGGER = Logger.getLogger(RotationSpeedCommandRestController.class.getName());
    
}
