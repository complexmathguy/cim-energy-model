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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachineEquivalentCircuit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineEquivalentCircuit")
public class AsynchronousMachineEquivalentCircuitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AsynchronousMachineEquivalentCircuit.  if not key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineEquivalentCircuit	asynchronousMachineEquivalentCircuit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAsynchronousMachineEquivalentCircuitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance().createAsynchronousMachineEquivalentCircuit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AsynchronousMachineEquivalentCircuit.  if no key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineEquivalentCircuit asynchronousMachineEquivalentCircuit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAsynchronousMachineEquivalentCircuitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAsynchronousMachineEquivalentCircuitCommand
			// -----------------------------------------------
			completableFuture = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance().updateAsynchronousMachineEquivalentCircuit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AsynchronousMachineEquivalentCircuitController:update() - successfully update AsynchronousMachineEquivalentCircuit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AsynchronousMachineEquivalentCircuit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID asynchronousMachineEquivalentCircuitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAsynchronousMachineEquivalentCircuitCommand command = new DeleteAsynchronousMachineEquivalentCircuitCommand( asynchronousMachineEquivalentCircuitId );

    	try {
        	AsynchronousMachineEquivalentCircuitBusinessDelegate delegate = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AsynchronousMachineEquivalentCircuit with key " + command.getAsynchronousMachineEquivalentCircuitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachineEquivalentCircuit asynchronousMachineEquivalentCircuit = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineEquivalentCircuitCommandRestController.class.getName());
    
}
