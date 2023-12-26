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
 * Implements Spring Controller command CQRS processing for entity VoltageAdjusterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageAdjusterDynamics")
public class VoltageAdjusterDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltageAdjusterDynamics.  if not key provided, calls create, otherwise calls save
     * @param		VoltageAdjusterDynamics	voltageAdjusterDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltageAdjusterDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().createVoltageAdjusterDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltageAdjusterDynamics.  if no key provided, calls create, otherwise calls save
     * @param		VoltageAdjusterDynamics voltageAdjusterDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltageAdjusterDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltageAdjusterDynamicsCommand
			// -----------------------------------------------
			completableFuture = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().updateVoltageAdjusterDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltageAdjusterDynamicsController:update() - successfully update VoltageAdjusterDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltageAdjusterDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltageAdjusterDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltageAdjusterDynamicsCommand command = new DeleteVoltageAdjusterDynamicsCommand( voltageAdjusterDynamicsId );

    	try {
        	VoltageAdjusterDynamicsBusinessDelegate delegate = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltageAdjusterDynamics with key " + command.getVoltageAdjusterDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageAdjusterDynamics voltageAdjusterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageAdjusterDynamicsCommandRestController.class.getName());
    
}
