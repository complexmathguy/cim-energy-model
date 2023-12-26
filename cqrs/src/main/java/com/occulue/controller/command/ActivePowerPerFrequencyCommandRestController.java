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
 * Implements Spring Controller command CQRS processing for entity ActivePowerPerFrequency.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerPerFrequency")
public class ActivePowerPerFrequencyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ActivePowerPerFrequency.  if not key provided, calls create, otherwise calls save
     * @param		ActivePowerPerFrequency	activePowerPerFrequency
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateActivePowerPerFrequencyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().createActivePowerPerFrequency( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ActivePowerPerFrequency.  if no key provided, calls create, otherwise calls save
     * @param		ActivePowerPerFrequency activePowerPerFrequency
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateActivePowerPerFrequencyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateActivePowerPerFrequencyCommand
			// -----------------------------------------------
			completableFuture = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().updateActivePowerPerFrequency(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ActivePowerPerFrequencyController:update() - successfully update ActivePowerPerFrequency - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ActivePowerPerFrequency entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID activePowerPerFrequencyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteActivePowerPerFrequencyCommand command = new DeleteActivePowerPerFrequencyCommand( activePowerPerFrequencyId );

    	try {
        	ActivePowerPerFrequencyBusinessDelegate delegate = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ActivePowerPerFrequency with key " + command.getActivePowerPerFrequencyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePowerPerFrequency activePowerPerFrequency = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerPerFrequencyCommandRestController.class.getName());
    
}
