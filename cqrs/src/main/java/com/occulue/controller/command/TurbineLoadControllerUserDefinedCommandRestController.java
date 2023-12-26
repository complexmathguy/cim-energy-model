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
 * Implements Spring Controller command CQRS processing for entity TurbineLoadControllerUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineLoadControllerUserDefined")
public class TurbineLoadControllerUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TurbineLoadControllerUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		TurbineLoadControllerUserDefined	turbineLoadControllerUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTurbineLoadControllerUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().createTurbineLoadControllerUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TurbineLoadControllerUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		TurbineLoadControllerUserDefined turbineLoadControllerUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTurbineLoadControllerUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTurbineLoadControllerUserDefinedCommand
			// -----------------------------------------------
			completableFuture = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().updateTurbineLoadControllerUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TurbineLoadControllerUserDefinedController:update() - successfully update TurbineLoadControllerUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TurbineLoadControllerUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID turbineLoadControllerUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTurbineLoadControllerUserDefinedCommand command = new DeleteTurbineLoadControllerUserDefinedCommand( turbineLoadControllerUserDefinedId );

    	try {
        	TurbineLoadControllerUserDefinedBusinessDelegate delegate = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TurbineLoadControllerUserDefined with key " + command.getTurbineLoadControllerUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbineLoadControllerUserDefined turbineLoadControllerUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(TurbineLoadControllerUserDefinedCommandRestController.class.getName());
    
}
