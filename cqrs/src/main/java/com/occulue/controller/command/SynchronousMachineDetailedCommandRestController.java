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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineDetailed.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineDetailed")
public class SynchronousMachineDetailedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SynchronousMachineDetailed.  if not key provided, calls create, otherwise calls save
     * @param		SynchronousMachineDetailed	synchronousMachineDetailed
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSynchronousMachineDetailedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().createSynchronousMachineDetailed( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SynchronousMachineDetailed.  if no key provided, calls create, otherwise calls save
     * @param		SynchronousMachineDetailed synchronousMachineDetailed
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSynchronousMachineDetailedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSynchronousMachineDetailedCommand
			// -----------------------------------------------
			completableFuture = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().updateSynchronousMachineDetailed(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SynchronousMachineDetailedController:update() - successfully update SynchronousMachineDetailed - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SynchronousMachineDetailed entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID synchronousMachineDetailedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSynchronousMachineDetailedCommand command = new DeleteSynchronousMachineDetailedCommand( synchronousMachineDetailedId );

    	try {
        	SynchronousMachineDetailedBusinessDelegate delegate = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SynchronousMachineDetailed with key " + command.getSynchronousMachineDetailedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineDetailed synchronousMachineDetailed = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineDetailedCommandRestController.class.getName());
    
}
