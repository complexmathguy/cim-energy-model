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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineTimeConstantReactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineTimeConstantReactance")
public class SynchronousMachineTimeConstantReactanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachineTimeConstantReactance.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachineTimeConstantReactance	synchronousMachineTimeConstantReactance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineTimeConstantReactanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().createSynchronousMachineTimeConstantReactance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachineTimeConstantReactance.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineTimeConstantReactanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineTimeConstantReactanceCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().updateSynchronousMachineTimeConstantReactance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineTimeConstantReactanceController:update() - successfully update SynchronousMachineTimeConstantReactance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachineTimeConstantReactance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineTimeConstantReactanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineTimeConstantReactanceCommand command = new DeleteSynchronousMachineTimeConstantReactanceCommand( synchronousMachineTimeConstantReactanceId );

    	try {
        	SynchronousMachineTimeConstantReactanceBusinessDelegate delegate = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachineTimeConstantReactance with key " + command.getSynchronousMachineTimeConstantReactanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineTimeConstantReactanceCommandRestController.class.getName());
    
}
