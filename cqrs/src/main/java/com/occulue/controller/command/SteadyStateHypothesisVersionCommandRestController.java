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
 * Implements Spring Controller command CQRS processing for entity SteadyStateHypothesisVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SteadyStateHypothesisVersion")
public class SteadyStateHypothesisVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SteadyStateHypothesisVersion.  if not key provided, calls create, otherwise calls save
     * @param		SteadyStateHypothesisVersion	steadyStateHypothesisVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSteadyStateHypothesisVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().createSteadyStateHypothesisVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SteadyStateHypothesisVersion.  if no key provided, calls create, otherwise calls save
     * @param		SteadyStateHypothesisVersion steadyStateHypothesisVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSteadyStateHypothesisVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSteadyStateHypothesisVersionCommand
			// -----------------------------------------------
			completableFuture = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().updateSteadyStateHypothesisVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SteadyStateHypothesisVersionController:update() - successfully update SteadyStateHypothesisVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SteadyStateHypothesisVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID steadyStateHypothesisVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSteadyStateHypothesisVersionCommand command = new DeleteSteadyStateHypothesisVersionCommand( steadyStateHypothesisVersionId );

    	try {
        	SteadyStateHypothesisVersionBusinessDelegate delegate = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SteadyStateHypothesisVersion with key " + command.getSteadyStateHypothesisVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SteadyStateHypothesisVersion steadyStateHypothesisVersion = null;
    private static final Logger LOGGER = Logger.getLogger(SteadyStateHypothesisVersionCommandRestController.class.getName());
    
}
