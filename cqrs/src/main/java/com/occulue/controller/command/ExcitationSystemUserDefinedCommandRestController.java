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
 * Implements Spring Controller command CQRS processing for entity ExcitationSystemUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcitationSystemUserDefined")
public class ExcitationSystemUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcitationSystemUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		ExcitationSystemUserDefined	excitationSystemUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcitationSystemUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().createExcitationSystemUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcitationSystemUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		ExcitationSystemUserDefined excitationSystemUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcitationSystemUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcitationSystemUserDefinedCommand
			// -----------------------------------------------
			completableFuture = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().updateExcitationSystemUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcitationSystemUserDefinedController:update() - successfully update ExcitationSystemUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcitationSystemUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excitationSystemUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcitationSystemUserDefinedCommand command = new DeleteExcitationSystemUserDefinedCommand( excitationSystemUserDefinedId );

    	try {
        	ExcitationSystemUserDefinedBusinessDelegate delegate = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcitationSystemUserDefined with key " + command.getExcitationSystemUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcitationSystemUserDefined excitationSystemUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(ExcitationSystemUserDefinedCommandRestController.class.getName());
    
}
