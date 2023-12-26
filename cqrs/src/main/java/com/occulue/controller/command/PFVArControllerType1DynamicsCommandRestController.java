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
 * Implements Spring Controller command CQRS processing for entity PFVArControllerType1Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType1Dynamics")
public class PFVArControllerType1DynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArControllerType1Dynamics.  if not key provided, calls create, otherwise calls save
     * @param		PFVArControllerType1Dynamics	pFVArControllerType1Dynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArControllerType1DynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().createPFVArControllerType1Dynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArControllerType1Dynamics.  if no key provided, calls create, otherwise calls save
     * @param		PFVArControllerType1Dynamics pFVArControllerType1Dynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArControllerType1DynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArControllerType1DynamicsCommand
			// -----------------------------------------------
			completableFuture = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().updatePFVArControllerType1Dynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArControllerType1DynamicsController:update() - successfully update PFVArControllerType1Dynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArControllerType1Dynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArControllerType1DynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArControllerType1DynamicsCommand command = new DeletePFVArControllerType1DynamicsCommand( pFVArControllerType1DynamicsId );

    	try {
        	PFVArControllerType1DynamicsBusinessDelegate delegate = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArControllerType1Dynamics with key " + command.getPFVArControllerType1DynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType1Dynamics pFVArControllerType1Dynamics = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType1DynamicsCommandRestController.class.getName());
    
}
