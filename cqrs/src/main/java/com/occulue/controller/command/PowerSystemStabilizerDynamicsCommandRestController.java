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
 * Implements Spring Controller command CQRS processing for entity PowerSystemStabilizerDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerSystemStabilizerDynamics")
public class PowerSystemStabilizerDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PowerSystemStabilizerDynamics.  if not key provided, calls create, otherwise calls save
     * @param		PowerSystemStabilizerDynamics	powerSystemStabilizerDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePowerSystemStabilizerDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance().createPowerSystemStabilizerDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PowerSystemStabilizerDynamics.  if no key provided, calls create, otherwise calls save
     * @param		PowerSystemStabilizerDynamics powerSystemStabilizerDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePowerSystemStabilizerDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePowerSystemStabilizerDynamicsCommand
			// -----------------------------------------------
			completableFuture = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance().updatePowerSystemStabilizerDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PowerSystemStabilizerDynamicsController:update() - successfully update PowerSystemStabilizerDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PowerSystemStabilizerDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID powerSystemStabilizerDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePowerSystemStabilizerDynamicsCommand command = new DeletePowerSystemStabilizerDynamicsCommand( powerSystemStabilizerDynamicsId );

    	try {
        	PowerSystemStabilizerDynamicsBusinessDelegate delegate = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PowerSystemStabilizerDynamics with key " + command.getPowerSystemStabilizerDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PowerSystemStabilizerDynamics powerSystemStabilizerDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(PowerSystemStabilizerDynamicsCommandRestController.class.getName());
    
}
