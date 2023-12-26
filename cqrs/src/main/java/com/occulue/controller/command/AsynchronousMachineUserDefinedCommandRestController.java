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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachineUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineUserDefined")
public class AsynchronousMachineUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AsynchronousMachineUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineUserDefined	asynchronousMachineUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAsynchronousMachineUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().createAsynchronousMachineUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AsynchronousMachineUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		AsynchronousMachineUserDefined asynchronousMachineUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAsynchronousMachineUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAsynchronousMachineUserDefinedCommand
			// -----------------------------------------------
			completableFuture = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().updateAsynchronousMachineUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AsynchronousMachineUserDefinedController:update() - successfully update AsynchronousMachineUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AsynchronousMachineUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID asynchronousMachineUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAsynchronousMachineUserDefinedCommand command = new DeleteAsynchronousMachineUserDefinedCommand( asynchronousMachineUserDefinedId );

    	try {
        	AsynchronousMachineUserDefinedBusinessDelegate delegate = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AsynchronousMachineUserDefined with key " + command.getAsynchronousMachineUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachineUserDefined asynchronousMachineUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineUserDefinedCommandRestController.class.getName());
    
}
