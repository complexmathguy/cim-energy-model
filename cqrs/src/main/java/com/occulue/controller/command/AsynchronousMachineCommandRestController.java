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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachine")
public class AsynchronousMachineCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AsynchronousMachine.  if not key provided, calls create, otherwise calls save
     * @param		AsynchronousMachine	asynchronousMachine
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAsynchronousMachineCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().createAsynchronousMachine( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AsynchronousMachine.  if no key provided, calls create, otherwise calls save
     * @param		AsynchronousMachine asynchronousMachine
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAsynchronousMachineCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAsynchronousMachineCommand
			// -----------------------------------------------
			completableFuture = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().updateAsynchronousMachine(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AsynchronousMachineController:update() - successfully update AsynchronousMachine - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AsynchronousMachine entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID asynchronousMachineId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAsynchronousMachineCommand command = new DeleteAsynchronousMachineCommand( asynchronousMachineId );

    	try {
        	AsynchronousMachineBusinessDelegate delegate = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AsynchronousMachine with key " + command.getAsynchronousMachineId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachine asynchronousMachine = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineCommandRestController.class.getName());
    
}
