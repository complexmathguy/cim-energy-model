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
 * Implements Spring Controller command CQRS processing for entity VoltageCompensatorUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageCompensatorUserDefined")
public class VoltageCompensatorUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltageCompensatorUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		VoltageCompensatorUserDefined	voltageCompensatorUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltageCompensatorUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().createVoltageCompensatorUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltageCompensatorUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		VoltageCompensatorUserDefined voltageCompensatorUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltageCompensatorUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltageCompensatorUserDefinedCommand
			// -----------------------------------------------
			completableFuture = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().updateVoltageCompensatorUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltageCompensatorUserDefinedController:update() - successfully update VoltageCompensatorUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltageCompensatorUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltageCompensatorUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltageCompensatorUserDefinedCommand command = new DeleteVoltageCompensatorUserDefinedCommand( voltageCompensatorUserDefinedId );

    	try {
        	VoltageCompensatorUserDefinedBusinessDelegate delegate = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltageCompensatorUserDefined with key " + command.getVoltageCompensatorUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageCompensatorUserDefined voltageCompensatorUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageCompensatorUserDefinedCommandRestController.class.getName());
    
}
