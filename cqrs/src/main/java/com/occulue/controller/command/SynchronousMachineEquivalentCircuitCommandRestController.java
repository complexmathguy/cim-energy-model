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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineEquivalentCircuit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineEquivalentCircuit")
public class SynchronousMachineEquivalentCircuitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachineEquivalentCircuit.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachineEquivalentCircuit	synchronousMachineEquivalentCircuit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineEquivalentCircuitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().createSynchronousMachineEquivalentCircuit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachineEquivalentCircuit.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineEquivalentCircuitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineEquivalentCircuitCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().updateSynchronousMachineEquivalentCircuit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineEquivalentCircuitController:update() - successfully update SynchronousMachineEquivalentCircuit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachineEquivalentCircuit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineEquivalentCircuitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineEquivalentCircuitCommand command = new DeleteSynchronousMachineEquivalentCircuitCommand( synchronousMachineEquivalentCircuitId );

    	try {
        	SynchronousMachineEquivalentCircuitBusinessDelegate delegate = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachineEquivalentCircuit with key " + command.getSynchronousMachineEquivalentCircuitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineEquivalentCircuitCommandRestController.class.getName());
    
}
