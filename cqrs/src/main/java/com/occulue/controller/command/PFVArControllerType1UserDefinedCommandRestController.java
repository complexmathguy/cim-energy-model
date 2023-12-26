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
 * Implements Spring Controller command CQRS processing for entity PFVArControllerType1UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType1UserDefined")
public class PFVArControllerType1UserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArControllerType1UserDefined.  if not key provided, calls create, otherwise calls save
     * @param		PFVArControllerType1UserDefined	pFVArControllerType1UserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArControllerType1UserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().createPFVArControllerType1UserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArControllerType1UserDefined.  if no key provided, calls create, otherwise calls save
     * @param		PFVArControllerType1UserDefined pFVArControllerType1UserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArControllerType1UserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArControllerType1UserDefinedCommand
			// -----------------------------------------------
			completableFuture = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().updatePFVArControllerType1UserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArControllerType1UserDefinedController:update() - successfully update PFVArControllerType1UserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArControllerType1UserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArControllerType1UserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArControllerType1UserDefinedCommand command = new DeletePFVArControllerType1UserDefinedCommand( pFVArControllerType1UserDefinedId );

    	try {
        	PFVArControllerType1UserDefinedBusinessDelegate delegate = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArControllerType1UserDefined with key " + command.getPFVArControllerType1UserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType1UserDefined pFVArControllerType1UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType1UserDefinedCommandRestController.class.getName());
    
}
