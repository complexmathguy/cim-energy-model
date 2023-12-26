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
 * Implements Spring Controller command CQRS processing for entity MechanicalLoadUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechanicalLoadUserDefined")
public class MechanicalLoadUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MechanicalLoadUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		MechanicalLoadUserDefined	mechanicalLoadUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMechanicalLoadUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().createMechanicalLoadUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MechanicalLoadUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		MechanicalLoadUserDefined mechanicalLoadUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMechanicalLoadUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMechanicalLoadUserDefinedCommand
			// -----------------------------------------------
			completableFuture = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().updateMechanicalLoadUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MechanicalLoadUserDefinedController:update() - successfully update MechanicalLoadUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MechanicalLoadUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID mechanicalLoadUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMechanicalLoadUserDefinedCommand command = new DeleteMechanicalLoadUserDefinedCommand( mechanicalLoadUserDefinedId );

    	try {
        	MechanicalLoadUserDefinedBusinessDelegate delegate = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MechanicalLoadUserDefined with key " + command.getMechanicalLoadUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MechanicalLoadUserDefined mechanicalLoadUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(MechanicalLoadUserDefinedCommandRestController.class.getName());
    
}
