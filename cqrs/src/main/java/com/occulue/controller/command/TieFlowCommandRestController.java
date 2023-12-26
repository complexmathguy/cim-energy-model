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
 * Implements Spring Controller command CQRS processing for entity TieFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TieFlow")
public class TieFlowCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TieFlow.  if not key provided, calls create, otherwise calls save
     * @param		TieFlow	tieFlow
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTieFlowCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TieFlowBusinessDelegate.getTieFlowInstance().createTieFlow( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TieFlow.  if no key provided, calls create, otherwise calls save
     * @param		TieFlow tieFlow
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTieFlowCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTieFlowCommand
			// -----------------------------------------------
			completableFuture = TieFlowBusinessDelegate.getTieFlowInstance().updateTieFlow(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TieFlowController:update() - successfully update TieFlow - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TieFlow entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID tieFlowId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTieFlowCommand command = new DeleteTieFlowCommand( tieFlowId );

    	try {
        	TieFlowBusinessDelegate delegate = TieFlowBusinessDelegate.getTieFlowInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TieFlow with key " + command.getTieFlowId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TieFlow tieFlow = null;
    private static final Logger LOGGER = Logger.getLogger(TieFlowCommandRestController.class.getName());
    
}
