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
 * Implements Spring Controller command CQRS processing for entity ExternalNetworkInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExternalNetworkInjection")
public class ExternalNetworkInjectionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExternalNetworkInjection.  if not key provided, calls create, otherwise calls save
     * @param		ExternalNetworkInjection	externalNetworkInjection
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExternalNetworkInjectionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().createExternalNetworkInjection( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExternalNetworkInjection.  if no key provided, calls create, otherwise calls save
     * @param		ExternalNetworkInjection externalNetworkInjection
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExternalNetworkInjectionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExternalNetworkInjectionCommand
			// -----------------------------------------------
			completableFuture = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().updateExternalNetworkInjection(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExternalNetworkInjectionController:update() - successfully update ExternalNetworkInjection - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExternalNetworkInjection entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID externalNetworkInjectionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExternalNetworkInjectionCommand command = new DeleteExternalNetworkInjectionCommand( externalNetworkInjectionId );

    	try {
        	ExternalNetworkInjectionBusinessDelegate delegate = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExternalNetworkInjection with key " + command.getExternalNetworkInjectionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExternalNetworkInjection externalNetworkInjection = null;
    private static final Logger LOGGER = Logger.getLogger(ExternalNetworkInjectionCommandRestController.class.getName());
    
}
