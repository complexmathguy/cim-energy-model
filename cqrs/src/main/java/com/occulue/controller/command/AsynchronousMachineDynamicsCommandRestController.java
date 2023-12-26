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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineDynamics")
public class AsynchronousMachineDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AsynchronousMachineDynamics.  if not key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineDynamics	asynchronousMachineDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAsynchronousMachineDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().createAsynchronousMachineDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AsynchronousMachineDynamics.  if no key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineDynamics asynchronousMachineDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAsynchronousMachineDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAsynchronousMachineDynamicsCommand
			// -----------------------------------------------
			completableFuture = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().updateAsynchronousMachineDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AsynchronousMachineDynamicsController:update() - successfully update AsynchronousMachineDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AsynchronousMachineDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID asynchronousMachineDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAsynchronousMachineDynamicsCommand command = new DeleteAsynchronousMachineDynamicsCommand( asynchronousMachineDynamicsId );

    	try {
        	AsynchronousMachineDynamicsBusinessDelegate delegate = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AsynchronousMachineDynamics with key " + command.getAsynchronousMachineDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachineDynamics asynchronousMachineDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineDynamicsCommandRestController.class.getName());
    
}
