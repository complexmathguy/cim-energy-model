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
 * Implements Spring Controller command CQRS processing for entity StaticVarCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StaticVarCompensator")
public class StaticVarCompensatorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a StaticVarCompensator.  if not key provided, calls create, otherwise calls save
     * @param		StaticVarCompensator	staticVarCompensator
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStaticVarCompensatorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().createStaticVarCompensator( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a StaticVarCompensator.  if no key provided, calls create, otherwise calls save
     * @param		StaticVarCompensator staticVarCompensator
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStaticVarCompensatorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStaticVarCompensatorCommand
			// -----------------------------------------------
			completableFuture = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().updateStaticVarCompensator(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StaticVarCompensatorController:update() - successfully update StaticVarCompensator - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a StaticVarCompensator entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID staticVarCompensatorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStaticVarCompensatorCommand command = new DeleteStaticVarCompensatorCommand( staticVarCompensatorId );

    	try {
        	StaticVarCompensatorBusinessDelegate delegate = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted StaticVarCompensator with key " + command.getStaticVarCompensatorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected StaticVarCompensator staticVarCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(StaticVarCompensatorCommandRestController.class.getName());
    
}
