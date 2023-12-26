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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachineTimeConstantReactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineTimeConstantReactance")
public class AsynchronousMachineTimeConstantReactanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AsynchronousMachineTimeConstantReactance.  if not key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineTimeConstantReactance	asynchronousMachineTimeConstantReactance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAsynchronousMachineTimeConstantReactanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance().createAsynchronousMachineTimeConstantReactance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AsynchronousMachineTimeConstantReactance.  if no key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAsynchronousMachineTimeConstantReactanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAsynchronousMachineTimeConstantReactanceCommand
			// -----------------------------------------------
			completableFuture = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance().updateAsynchronousMachineTimeConstantReactance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AsynchronousMachineTimeConstantReactanceController:update() - successfully update AsynchronousMachineTimeConstantReactance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AsynchronousMachineTimeConstantReactance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID asynchronousMachineTimeConstantReactanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAsynchronousMachineTimeConstantReactanceCommand command = new DeleteAsynchronousMachineTimeConstantReactanceCommand( asynchronousMachineTimeConstantReactanceId );

    	try {
        	AsynchronousMachineTimeConstantReactanceBusinessDelegate delegate = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AsynchronousMachineTimeConstantReactance with key " + command.getAsynchronousMachineTimeConstantReactanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineTimeConstantReactanceCommandRestController.class.getName());
    
}
