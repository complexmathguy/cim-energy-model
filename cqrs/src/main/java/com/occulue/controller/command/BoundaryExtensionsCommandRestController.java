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
 * Implements Spring Controller command CQRS processing for entity BoundaryExtensions.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BoundaryExtensions")
public class BoundaryExtensionsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a BoundaryExtensions.  if not key provided, calls create, otherwise calls save
     * @param		BoundaryExtensions	boundaryExtensions
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateBoundaryExtensionsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().createBoundaryExtensions( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a BoundaryExtensions.  if no key provided, calls create, otherwise calls save
     * @param		BoundaryExtensions boundaryExtensions
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateBoundaryExtensionsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateBoundaryExtensionsCommand
			// -----------------------------------------------
			completableFuture = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().updateBoundaryExtensions(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "BoundaryExtensionsController:update() - successfully update BoundaryExtensions - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a BoundaryExtensions entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID boundaryExtensionsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteBoundaryExtensionsCommand command = new DeleteBoundaryExtensionsCommand( boundaryExtensionsId );

    	try {
        	BoundaryExtensionsBusinessDelegate delegate = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted BoundaryExtensions with key " + command.getBoundaryExtensionsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected BoundaryExtensions boundaryExtensions = null;
    private static final Logger LOGGER = Logger.getLogger(BoundaryExtensionsCommandRestController.class.getName());
    
}
