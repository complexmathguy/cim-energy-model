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
 * Implements Spring Controller command CQRS processing for entity PowerSystemResource.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerSystemResource")
public class PowerSystemResourceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PowerSystemResource.  if not key provided, calls create, otherwise calls save
     * @param		PowerSystemResource	powerSystemResource
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePowerSystemResourceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().createPowerSystemResource( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PowerSystemResource.  if no key provided, calls create, otherwise calls save
     * @param		PowerSystemResource powerSystemResource
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePowerSystemResourceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePowerSystemResourceCommand
			// -----------------------------------------------
			completableFuture = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().updatePowerSystemResource(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PowerSystemResourceController:update() - successfully update PowerSystemResource - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PowerSystemResource entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID powerSystemResourceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePowerSystemResourceCommand command = new DeletePowerSystemResourceCommand( powerSystemResourceId );

    	try {
        	PowerSystemResourceBusinessDelegate delegate = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PowerSystemResource with key " + command.getPowerSystemResourceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PowerSystemResource powerSystemResource = null;
    private static final Logger LOGGER = Logger.getLogger(PowerSystemResourceCommandRestController.class.getName());
    
}
