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
 * Implements Spring Controller command CQRS processing for entity EnergyConsumer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergyConsumer")
public class EnergyConsumerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EnergyConsumer.  if not key provided, calls create, otherwise calls save
     * @param		EnergyConsumer	energyConsumer
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEnergyConsumerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().createEnergyConsumer( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EnergyConsumer.  if no key provided, calls create, otherwise calls save
     * @param		EnergyConsumer energyConsumer
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEnergyConsumerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEnergyConsumerCommand
			// -----------------------------------------------
			completableFuture = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().updateEnergyConsumer(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EnergyConsumerController:update() - successfully update EnergyConsumer - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EnergyConsumer entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID energyConsumerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEnergyConsumerCommand command = new DeleteEnergyConsumerCommand( energyConsumerId );

    	try {
        	EnergyConsumerBusinessDelegate delegate = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EnergyConsumer with key " + command.getEnergyConsumerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EnergyConsumer energyConsumer = null;
    private static final Logger LOGGER = Logger.getLogger(EnergyConsumerCommandRestController.class.getName());
    
}
