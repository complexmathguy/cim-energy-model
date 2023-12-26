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
 * Implements Spring Controller command CQRS processing for entity Disconnector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Disconnector")
public class DisconnectorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Disconnector.  if not key provided, calls create, otherwise calls save
     * @param		Disconnector	disconnector
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDisconnectorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DisconnectorBusinessDelegate.getDisconnectorInstance().createDisconnector( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Disconnector.  if no key provided, calls create, otherwise calls save
     * @param		Disconnector disconnector
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDisconnectorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDisconnectorCommand
			// -----------------------------------------------
			completableFuture = DisconnectorBusinessDelegate.getDisconnectorInstance().updateDisconnector(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DisconnectorController:update() - successfully update Disconnector - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Disconnector entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID disconnectorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDisconnectorCommand command = new DeleteDisconnectorCommand( disconnectorId );

    	try {
        	DisconnectorBusinessDelegate delegate = DisconnectorBusinessDelegate.getDisconnectorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Disconnector with key " + command.getDisconnectorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Disconnector disconnector = null;
    private static final Logger LOGGER = Logger.getLogger(DisconnectorCommandRestController.class.getName());
    
}
