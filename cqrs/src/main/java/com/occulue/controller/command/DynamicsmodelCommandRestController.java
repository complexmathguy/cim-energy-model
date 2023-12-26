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
 * Implements Spring Controller command CQRS processing for entity Dynamicsmodel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Dynamicsmodel")
public class DynamicsmodelCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Dynamicsmodel.  if not key provided, calls create, otherwise calls save
     * @param		Dynamicsmodel	dynamicsmodel
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDynamicsmodelCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().createDynamicsmodel( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Dynamicsmodel.  if no key provided, calls create, otherwise calls save
     * @param		Dynamicsmodel dynamicsmodel
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDynamicsmodelCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDynamicsmodelCommand
			// -----------------------------------------------
			completableFuture = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().updateDynamicsmodel(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DynamicsmodelController:update() - successfully update Dynamicsmodel - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Dynamicsmodel entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dynamicsmodelId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDynamicsmodelCommand command = new DeleteDynamicsmodelCommand( dynamicsmodelId );

    	try {
        	DynamicsmodelBusinessDelegate delegate = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Dynamicsmodel with key " + command.getDynamicsmodelId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Dynamicsmodel dynamicsmodel = null;
    private static final Logger LOGGER = Logger.getLogger(DynamicsmodelCommandRestController.class.getName());
    
}
