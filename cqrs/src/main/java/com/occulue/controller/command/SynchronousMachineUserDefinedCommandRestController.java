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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineUserDefined")
public class SynchronousMachineUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachineUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachineUserDefined	synchronousMachineUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().createSynchronousMachineUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachineUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachineUserDefined synchronousMachineUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineUserDefinedCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().updateSynchronousMachineUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineUserDefinedController:update() - successfully update SynchronousMachineUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachineUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineUserDefinedCommand command = new DeleteSynchronousMachineUserDefinedCommand( synchronousMachineUserDefinedId );

    	try {
        	SynchronousMachineUserDefinedBusinessDelegate delegate = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachineUserDefined with key " + command.getSynchronousMachineUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineUserDefined synchronousMachineUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineUserDefinedCommandRestController.class.getName());
    
}
