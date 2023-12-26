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
 * Implements Spring Controller command CQRS processing for entity VoltageAdjusterUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageAdjusterUserDefined")
public class VoltageAdjusterUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltageAdjusterUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		VoltageAdjusterUserDefined	voltageAdjusterUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltageAdjusterUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().createVoltageAdjusterUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltageAdjusterUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		VoltageAdjusterUserDefined voltageAdjusterUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltageAdjusterUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltageAdjusterUserDefinedCommand
			// -----------------------------------------------
			completableFuture = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().updateVoltageAdjusterUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltageAdjusterUserDefinedController:update() - successfully update VoltageAdjusterUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltageAdjusterUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltageAdjusterUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltageAdjusterUserDefinedCommand command = new DeleteVoltageAdjusterUserDefinedCommand( voltageAdjusterUserDefinedId );

    	try {
        	VoltageAdjusterUserDefinedBusinessDelegate delegate = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltageAdjusterUserDefined with key " + command.getVoltageAdjusterUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageAdjusterUserDefined voltageAdjusterUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageAdjusterUserDefinedCommandRestController.class.getName());
    
}
