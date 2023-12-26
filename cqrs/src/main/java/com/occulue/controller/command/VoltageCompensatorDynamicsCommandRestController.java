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
 * Implements Spring Controller command CQRS processing for entity VoltageCompensatorDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageCompensatorDynamics")
public class VoltageCompensatorDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltageCompensatorDynamics.  if not key provided, calls create, otherwise calls save
     * @param		VoltageCompensatorDynamics	voltageCompensatorDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltageCompensatorDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().createVoltageCompensatorDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltageCompensatorDynamics.  if no key provided, calls create, otherwise calls save
     * @param		VoltageCompensatorDynamics voltageCompensatorDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltageCompensatorDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltageCompensatorDynamicsCommand
			// -----------------------------------------------
			completableFuture = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().updateVoltageCompensatorDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltageCompensatorDynamicsController:update() - successfully update VoltageCompensatorDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltageCompensatorDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltageCompensatorDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltageCompensatorDynamicsCommand command = new DeleteVoltageCompensatorDynamicsCommand( voltageCompensatorDynamicsId );

    	try {
        	VoltageCompensatorDynamicsBusinessDelegate delegate = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltageCompensatorDynamics with key " + command.getVoltageCompensatorDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageCompensatorDynamics voltageCompensatorDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageCompensatorDynamicsCommandRestController.class.getName());
    
}
