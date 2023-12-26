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
 * Implements Spring Controller command CQRS processing for entity DynamicsVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DynamicsVersion")
public class DynamicsVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DynamicsVersion.  if not key provided, calls create, otherwise calls save
     * @param		DynamicsVersion	dynamicsVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDynamicsVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().createDynamicsVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DynamicsVersion.  if no key provided, calls create, otherwise calls save
     * @param		DynamicsVersion dynamicsVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDynamicsVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDynamicsVersionCommand
			// -----------------------------------------------
			completableFuture = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().updateDynamicsVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DynamicsVersionController:update() - successfully update DynamicsVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DynamicsVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dynamicsVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDynamicsVersionCommand command = new DeleteDynamicsVersionCommand( dynamicsVersionId );

    	try {
        	DynamicsVersionBusinessDelegate delegate = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DynamicsVersion with key " + command.getDynamicsVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DynamicsVersion dynamicsVersion = null;
    private static final Logger LOGGER = Logger.getLogger(DynamicsVersionCommandRestController.class.getName());
    
}
