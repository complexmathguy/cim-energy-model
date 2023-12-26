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
 * Implements Spring Controller command CQRS processing for entity RaiseLowerCommand.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RaiseLowerCommand")
public class RaiseLowerCommandCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RaiseLowerCommand.  if not key provided, calls create, otherwise calls save
     * @param		RaiseLowerCommand	raiseLowerCommand
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRaiseLowerCommandCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().createRaiseLowerCommand( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RaiseLowerCommand.  if no key provided, calls create, otherwise calls save
     * @param		RaiseLowerCommand raiseLowerCommand
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRaiseLowerCommandCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRaiseLowerCommandCommand
			// -----------------------------------------------
			completableFuture = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().updateRaiseLowerCommand(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RaiseLowerCommandController:update() - successfully update RaiseLowerCommand - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RaiseLowerCommand entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID raiseLowerCommandId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRaiseLowerCommandCommand command = new DeleteRaiseLowerCommandCommand( raiseLowerCommandId );

    	try {
        	RaiseLowerCommandBusinessDelegate delegate = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RaiseLowerCommand with key " + command.getRaiseLowerCommandId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RaiseLowerCommand raiseLowerCommand = null;
    private static final Logger LOGGER = Logger.getLogger(RaiseLowerCommandCommandRestController.class.getName());
    
}
