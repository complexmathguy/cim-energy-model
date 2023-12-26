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
 * Implements Spring Controller command CQRS processing for entity GroundDisconnector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GroundDisconnector")
public class GroundDisconnectorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GroundDisconnector.  if not key provided, calls create, otherwise calls save
     * @param		GroundDisconnector	groundDisconnector
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGroundDisconnectorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().createGroundDisconnector( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GroundDisconnector.  if no key provided, calls create, otherwise calls save
     * @param		GroundDisconnector groundDisconnector
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGroundDisconnectorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGroundDisconnectorCommand
			// -----------------------------------------------
			completableFuture = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().updateGroundDisconnector(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GroundDisconnectorController:update() - successfully update GroundDisconnector - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GroundDisconnector entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID groundDisconnectorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGroundDisconnectorCommand command = new DeleteGroundDisconnectorCommand( groundDisconnectorId );

    	try {
        	GroundDisconnectorBusinessDelegate delegate = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GroundDisconnector with key " + command.getGroundDisconnectorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GroundDisconnector groundDisconnector = null;
    private static final Logger LOGGER = Logger.getLogger(GroundDisconnectorCommandRestController.class.getName());
    
}
