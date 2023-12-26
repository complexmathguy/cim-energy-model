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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineDynamics")
public class SynchronousMachineDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachineDynamics.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachineDynamics	synchronousMachineDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().createSynchronousMachineDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachineDynamics.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachineDynamics synchronousMachineDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineDynamicsCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().updateSynchronousMachineDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineDynamicsController:update() - successfully update SynchronousMachineDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachineDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineDynamicsCommand command = new DeleteSynchronousMachineDynamicsCommand( synchronousMachineDynamicsId );

    	try {
        	SynchronousMachineDynamicsBusinessDelegate delegate = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachineDynamics with key " + command.getSynchronousMachineDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineDynamics synchronousMachineDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineDynamicsCommandRestController.class.getName());
    
}
