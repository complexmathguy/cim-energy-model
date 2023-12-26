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
 * Implements Spring Controller command CQRS processing for entity ExtensionVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExtensionVersion")
public class ExtensionVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExtensionVersion.  if not key provided, calls create, otherwise calls save
     * @param		ExtensionVersion	extensionVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExtensionVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExtensionVersionBusinessDelegate.getExtensionVersionInstance().createExtensionVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExtensionVersion.  if no key provided, calls create, otherwise calls save
     * @param		ExtensionVersion extensionVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExtensionVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExtensionVersionCommand
			// -----------------------------------------------
			completableFuture = ExtensionVersionBusinessDelegate.getExtensionVersionInstance().updateExtensionVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExtensionVersionController:update() - successfully update ExtensionVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExtensionVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID extensionVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExtensionVersionCommand command = new DeleteExtensionVersionCommand( extensionVersionId );

    	try {
        	ExtensionVersionBusinessDelegate delegate = ExtensionVersionBusinessDelegate.getExtensionVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExtensionVersion with key " + command.getExtensionVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExtensionVersion extensionVersion = null;
    private static final Logger LOGGER = Logger.getLogger(ExtensionVersionCommandRestController.class.getName());
    
}
