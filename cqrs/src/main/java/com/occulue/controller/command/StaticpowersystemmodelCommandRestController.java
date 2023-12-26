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
 * Implements Spring Controller command CQRS processing for entity Staticpowersystemmodel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Staticpowersystemmodel")
public class StaticpowersystemmodelCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Staticpowersystemmodel.  if not key provided, calls create, otherwise calls save
     * @param		Staticpowersystemmodel	staticpowersystemmodel
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStaticpowersystemmodelCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().createStaticpowersystemmodel( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Staticpowersystemmodel.  if no key provided, calls create, otherwise calls save
     * @param		Staticpowersystemmodel staticpowersystemmodel
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStaticpowersystemmodelCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStaticpowersystemmodelCommand
			// -----------------------------------------------
			completableFuture = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().updateStaticpowersystemmodel(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StaticpowersystemmodelController:update() - successfully update Staticpowersystemmodel - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Staticpowersystemmodel entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID staticpowersystemmodelId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStaticpowersystemmodelCommand command = new DeleteStaticpowersystemmodelCommand( staticpowersystemmodelId );

    	try {
        	StaticpowersystemmodelBusinessDelegate delegate = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Staticpowersystemmodel with key " + command.getStaticpowersystemmodelId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Staticpowersystemmodel staticpowersystemmodel = null;
    private static final Logger LOGGER = Logger.getLogger(StaticpowersystemmodelCommandRestController.class.getName());
    
}
