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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachine")
public class SynchronousMachineCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachine.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachine	synchronousMachine
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().createSynchronousMachine( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachine.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachine synchronousMachine
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().updateSynchronousMachine(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineController:update() - successfully update SynchronousMachine - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachine entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineCommand command = new DeleteSynchronousMachineCommand( synchronousMachineId );

    	try {
        	SynchronousMachineBusinessDelegate delegate = SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachine with key " + command.getSynchronousMachineId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachine synchronousMachine = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineCommandRestController.class.getName());
    
}
