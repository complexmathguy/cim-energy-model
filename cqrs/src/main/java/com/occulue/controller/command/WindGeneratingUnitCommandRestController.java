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
 * Implements Spring Controller command CQRS processing for entity WindGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGeneratingUnit")
public class WindGeneratingUnitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGeneratingUnit.  if not key provided, calls create, otherwise calls save
     * @param		WindGeneratingUnit	windGeneratingUnit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGeneratingUnitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().createWindGeneratingUnit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGeneratingUnit.  if no key provided, calls create, otherwise calls save
     * @param		WindGeneratingUnit windGeneratingUnit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGeneratingUnitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGeneratingUnitCommand
			// -----------------------------------------------
			completableFuture = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().updateWindGeneratingUnit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGeneratingUnitController:update() - successfully update WindGeneratingUnit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGeneratingUnit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGeneratingUnitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGeneratingUnitCommand command = new DeleteWindGeneratingUnitCommand( windGeneratingUnitId );

    	try {
        	WindGeneratingUnitBusinessDelegate delegate = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGeneratingUnit with key " + command.getWindGeneratingUnitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGeneratingUnit windGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(WindGeneratingUnitCommandRestController.class.getName());
    
}
