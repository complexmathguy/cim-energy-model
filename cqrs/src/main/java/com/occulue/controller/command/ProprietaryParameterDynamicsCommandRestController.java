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
 * Implements Spring Controller command CQRS processing for entity ProprietaryParameterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ProprietaryParameterDynamics")
public class ProprietaryParameterDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ProprietaryParameterDynamics.  if not key provided, calls create, otherwise calls save
     * @param		ProprietaryParameterDynamics	proprietaryParameterDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateProprietaryParameterDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().createProprietaryParameterDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ProprietaryParameterDynamics.  if no key provided, calls create, otherwise calls save
     * @param		ProprietaryParameterDynamics proprietaryParameterDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateProprietaryParameterDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateProprietaryParameterDynamicsCommand
			// -----------------------------------------------
			completableFuture = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().updateProprietaryParameterDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ProprietaryParameterDynamicsController:update() - successfully update ProprietaryParameterDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ProprietaryParameterDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID proprietaryParameterDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteProprietaryParameterDynamicsCommand command = new DeleteProprietaryParameterDynamicsCommand( proprietaryParameterDynamicsId );

    	try {
        	ProprietaryParameterDynamicsBusinessDelegate delegate = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ProprietaryParameterDynamics with key " + command.getProprietaryParameterDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ProprietaryParameterDynamics proprietaryParameterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(ProprietaryParameterDynamicsCommandRestController.class.getName());
    
}
