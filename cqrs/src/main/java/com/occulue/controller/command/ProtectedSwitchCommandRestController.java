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
 * Implements Spring Controller command CQRS processing for entity ProtectedSwitch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ProtectedSwitch")
public class ProtectedSwitchCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ProtectedSwitch.  if not key provided, calls create, otherwise calls save
     * @param		ProtectedSwitch	protectedSwitch
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateProtectedSwitchCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().createProtectedSwitch( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ProtectedSwitch.  if no key provided, calls create, otherwise calls save
     * @param		ProtectedSwitch protectedSwitch
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateProtectedSwitchCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateProtectedSwitchCommand
			// -----------------------------------------------
			completableFuture = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().updateProtectedSwitch(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ProtectedSwitchController:update() - successfully update ProtectedSwitch - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ProtectedSwitch entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID protectedSwitchId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteProtectedSwitchCommand command = new DeleteProtectedSwitchCommand( protectedSwitchId );

    	try {
        	ProtectedSwitchBusinessDelegate delegate = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ProtectedSwitch with key " + command.getProtectedSwitchId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ProtectedSwitch protectedSwitch = null;
    private static final Logger LOGGER = Logger.getLogger(ProtectedSwitchCommandRestController.class.getName());
    
}
