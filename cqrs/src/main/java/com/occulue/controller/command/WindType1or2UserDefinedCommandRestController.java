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
 * Implements Spring Controller command CQRS processing for entity WindType1or2UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindType1or2UserDefined")
public class WindType1or2UserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindType1or2UserDefined.  if not key provided, calls create, otherwise calls save
     * @param		WindType1or2UserDefined	windType1or2UserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindType1or2UserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().createWindType1or2UserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindType1or2UserDefined.  if no key provided, calls create, otherwise calls save
     * @param		WindType1or2UserDefined windType1or2UserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindType1or2UserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindType1or2UserDefinedCommand
			// -----------------------------------------------
			completableFuture = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().updateWindType1or2UserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindType1or2UserDefinedController:update() - successfully update WindType1or2UserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindType1or2UserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windType1or2UserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindType1or2UserDefinedCommand command = new DeleteWindType1or2UserDefinedCommand( windType1or2UserDefinedId );

    	try {
        	WindType1or2UserDefinedBusinessDelegate delegate = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindType1or2UserDefined with key " + command.getWindType1or2UserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindType1or2UserDefined windType1or2UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(WindType1or2UserDefinedCommandRestController.class.getName());
    
}
