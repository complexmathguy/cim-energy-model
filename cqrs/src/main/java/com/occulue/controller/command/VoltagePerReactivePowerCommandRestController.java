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
 * Implements Spring Controller command CQRS processing for entity VoltagePerReactivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltagePerReactivePower")
public class VoltagePerReactivePowerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltagePerReactivePower.  if not key provided, calls create, otherwise calls save
     * @param		VoltagePerReactivePower	voltagePerReactivePower
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltagePerReactivePowerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().createVoltagePerReactivePower( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltagePerReactivePower.  if no key provided, calls create, otherwise calls save
     * @param		VoltagePerReactivePower voltagePerReactivePower
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltagePerReactivePowerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltagePerReactivePowerCommand
			// -----------------------------------------------
			completableFuture = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().updateVoltagePerReactivePower(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltagePerReactivePowerController:update() - successfully update VoltagePerReactivePower - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltagePerReactivePower entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltagePerReactivePowerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltagePerReactivePowerCommand command = new DeleteVoltagePerReactivePowerCommand( voltagePerReactivePowerId );

    	try {
        	VoltagePerReactivePowerBusinessDelegate delegate = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltagePerReactivePower with key " + command.getVoltagePerReactivePowerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltagePerReactivePower voltagePerReactivePower = null;
    private static final Logger LOGGER = Logger.getLogger(VoltagePerReactivePowerCommandRestController.class.getName());
    
}
