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
 * Implements Spring Controller command CQRS processing for entity RotatingMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotatingMachineDynamics")
public class RotatingMachineDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RotatingMachineDynamics.  if not key provided, calls create, otherwise calls save
     * @param		RotatingMachineDynamics	rotatingMachineDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRotatingMachineDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().createRotatingMachineDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RotatingMachineDynamics.  if no key provided, calls create, otherwise calls save
     * @param		RotatingMachineDynamics rotatingMachineDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRotatingMachineDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRotatingMachineDynamicsCommand
			// -----------------------------------------------
			completableFuture = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().updateRotatingMachineDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RotatingMachineDynamicsController:update() - successfully update RotatingMachineDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RotatingMachineDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID rotatingMachineDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRotatingMachineDynamicsCommand command = new DeleteRotatingMachineDynamicsCommand( rotatingMachineDynamicsId );

    	try {
        	RotatingMachineDynamicsBusinessDelegate delegate = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RotatingMachineDynamics with key " + command.getRotatingMachineDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RotatingMachineDynamics rotatingMachineDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(RotatingMachineDynamicsCommandRestController.class.getName());
    
}
