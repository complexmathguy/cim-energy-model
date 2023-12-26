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
 * Implements Spring Controller command CQRS processing for entity ActivePowerLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerLimit")
public class ActivePowerLimitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ActivePowerLimit.  if not key provided, calls create, otherwise calls save
     * @param		ActivePowerLimit	activePowerLimit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateActivePowerLimitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().createActivePowerLimit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ActivePowerLimit.  if no key provided, calls create, otherwise calls save
     * @param		ActivePowerLimit activePowerLimit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateActivePowerLimitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateActivePowerLimitCommand
			// -----------------------------------------------
			completableFuture = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().updateActivePowerLimit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ActivePowerLimitController:update() - successfully update ActivePowerLimit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ActivePowerLimit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID activePowerLimitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteActivePowerLimitCommand command = new DeleteActivePowerLimitCommand( activePowerLimitId );

    	try {
        	ActivePowerLimitBusinessDelegate delegate = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ActivePowerLimit with key " + command.getActivePowerLimitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePowerLimit activePowerLimit = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerLimitCommandRestController.class.getName());
    
}
