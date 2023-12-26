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
 * Implements Spring Controller command CQRS processing for entity DCChopper.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCChopper")
public class DCChopperCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCChopper.  if not key provided, calls create, otherwise calls save
     * @param		DCChopper	dCChopper
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCChopperCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCChopperBusinessDelegate.getDCChopperInstance().createDCChopper( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCChopper.  if no key provided, calls create, otherwise calls save
     * @param		DCChopper dCChopper
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCChopperCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCChopperCommand
			// -----------------------------------------------
			completableFuture = DCChopperBusinessDelegate.getDCChopperInstance().updateDCChopper(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCChopperController:update() - successfully update DCChopper - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCChopper entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCChopperId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCChopperCommand command = new DeleteDCChopperCommand( dCChopperId );

    	try {
        	DCChopperBusinessDelegate delegate = DCChopperBusinessDelegate.getDCChopperInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCChopper with key " + command.getDCChopperId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCChopper dCChopper = null;
    private static final Logger LOGGER = Logger.getLogger(DCChopperCommandRestController.class.getName());
    
}
