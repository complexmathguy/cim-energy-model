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
 * Implements Spring Controller command CQRS processing for entity ReactivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ReactivePower")
public class ReactivePowerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ReactivePower.  if not key provided, calls create, otherwise calls save
     * @param		ReactivePower	reactivePower
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateReactivePowerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ReactivePowerBusinessDelegate.getReactivePowerInstance().createReactivePower( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ReactivePower.  if no key provided, calls create, otherwise calls save
     * @param		ReactivePower reactivePower
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateReactivePowerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateReactivePowerCommand
			// -----------------------------------------------
			completableFuture = ReactivePowerBusinessDelegate.getReactivePowerInstance().updateReactivePower(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ReactivePowerController:update() - successfully update ReactivePower - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ReactivePower entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID reactivePowerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteReactivePowerCommand command = new DeleteReactivePowerCommand( reactivePowerId );

    	try {
        	ReactivePowerBusinessDelegate delegate = ReactivePowerBusinessDelegate.getReactivePowerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ReactivePower with key " + command.getReactivePowerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ReactivePower reactivePower = null;
    private static final Logger LOGGER = Logger.getLogger(ReactivePowerCommandRestController.class.getName());
    
}
