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
 * Implements Spring Controller command CQRS processing for entity Simple_Float.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Simple_Float")
public class Simple_FloatCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Simple_Float.  if not key provided, calls create, otherwise calls save
     * @param		Simple_Float	simple_Float
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSimple_FloatCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = Simple_FloatBusinessDelegate.getSimple_FloatInstance().createSimple_Float( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Simple_Float.  if no key provided, calls create, otherwise calls save
     * @param		Simple_Float simple_Float
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSimple_FloatCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSimple_FloatCommand
			// -----------------------------------------------
			completableFuture = Simple_FloatBusinessDelegate.getSimple_FloatInstance().updateSimple_Float(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "Simple_FloatController:update() - successfully update Simple_Float - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Simple_Float entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID simple_FloatId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSimple_FloatCommand command = new DeleteSimple_FloatCommand( simple_FloatId );

    	try {
        	Simple_FloatBusinessDelegate delegate = Simple_FloatBusinessDelegate.getSimple_FloatInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Simple_Float with key " + command.getSimple_FloatId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Simple_Float simple_Float = null;
    private static final Logger LOGGER = Logger.getLogger(Simple_FloatCommandRestController.class.getName());
    
}
