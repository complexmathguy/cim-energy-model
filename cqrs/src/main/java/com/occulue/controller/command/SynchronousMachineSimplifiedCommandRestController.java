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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineSimplified.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineSimplified")
public class SynchronousMachineSimplifiedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachineSimplified.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachineSimplified	synchronousMachineSimplified
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineSimplifiedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().createSynchronousMachineSimplified( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachineSimplified.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachineSimplified synchronousMachineSimplified
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineSimplifiedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineSimplifiedCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().updateSynchronousMachineSimplified(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineSimplifiedController:update() - successfully update SynchronousMachineSimplified - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachineSimplified entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineSimplifiedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineSimplifiedCommand command = new DeleteSynchronousMachineSimplifiedCommand( synchronousMachineSimplifiedId );

    	try {
        	SynchronousMachineSimplifiedBusinessDelegate delegate = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachineSimplified with key " + command.getSynchronousMachineSimplifiedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineSimplified synchronousMachineSimplified = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineSimplifiedCommandRestController.class.getName());
    
}
