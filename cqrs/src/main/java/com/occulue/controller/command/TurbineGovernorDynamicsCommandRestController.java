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
 * Implements Spring Controller command CQRS processing for entity TurbineGovernorDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineGovernorDynamics")
public class TurbineGovernorDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TurbineGovernorDynamics.  if not key provided, calls create, otherwise calls save
     * @param		TurbineGovernorDynamics	turbineGovernorDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTurbineGovernorDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().createTurbineGovernorDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TurbineGovernorDynamics.  if no key provided, calls create, otherwise calls save
     * @param		TurbineGovernorDynamics turbineGovernorDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTurbineGovernorDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTurbineGovernorDynamicsCommand
			// -----------------------------------------------
			completableFuture = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().updateTurbineGovernorDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TurbineGovernorDynamicsController:update() - successfully update TurbineGovernorDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TurbineGovernorDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID turbineGovernorDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTurbineGovernorDynamicsCommand command = new DeleteTurbineGovernorDynamicsCommand( turbineGovernorDynamicsId );

    	try {
        	TurbineGovernorDynamicsBusinessDelegate delegate = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TurbineGovernorDynamics with key " + command.getTurbineGovernorDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbineGovernorDynamics turbineGovernorDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(TurbineGovernorDynamicsCommandRestController.class.getName());
    
}
