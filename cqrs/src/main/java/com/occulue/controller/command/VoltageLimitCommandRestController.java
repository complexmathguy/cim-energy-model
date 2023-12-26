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
 * Implements Spring Controller command CQRS processing for entity VoltageLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageLimit")
public class VoltageLimitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltageLimit.  if not key provided, calls create, otherwise calls save
     * @param		VoltageLimit	voltageLimit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltageLimitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltageLimitBusinessDelegate.getVoltageLimitInstance().createVoltageLimit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltageLimit.  if no key provided, calls create, otherwise calls save
     * @param		VoltageLimit voltageLimit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltageLimitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltageLimitCommand
			// -----------------------------------------------
			completableFuture = VoltageLimitBusinessDelegate.getVoltageLimitInstance().updateVoltageLimit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltageLimitController:update() - successfully update VoltageLimit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltageLimit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltageLimitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltageLimitCommand command = new DeleteVoltageLimitCommand( voltageLimitId );

    	try {
        	VoltageLimitBusinessDelegate delegate = VoltageLimitBusinessDelegate.getVoltageLimitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltageLimit with key " + command.getVoltageLimitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageLimit voltageLimit = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageLimitCommandRestController.class.getName());
    
}
