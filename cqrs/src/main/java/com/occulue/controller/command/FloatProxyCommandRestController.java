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
 * Implements Spring Controller command CQRS processing for entity FloatProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/FloatProxy")
public class FloatProxyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a FloatProxy.  if not key provided, calls create, otherwise calls save
     * @param		FloatProxy	floatProxy
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateFloatProxyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = FloatProxyBusinessDelegate.getFloatProxyInstance().createFloatProxy( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a FloatProxy.  if no key provided, calls create, otherwise calls save
     * @param		FloatProxy floatProxy
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateFloatProxyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateFloatProxyCommand
			// -----------------------------------------------
			completableFuture = FloatProxyBusinessDelegate.getFloatProxyInstance().updateFloatProxy(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "FloatProxyController:update() - successfully update FloatProxy - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a FloatProxy entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID floatProxyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteFloatProxyCommand command = new DeleteFloatProxyCommand( floatProxyId );

    	try {
        	FloatProxyBusinessDelegate delegate = FloatProxyBusinessDelegate.getFloatProxyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted FloatProxy with key " + command.getFloatProxyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected FloatProxy floatProxy = null;
    private static final Logger LOGGER = Logger.getLogger(FloatProxyCommandRestController.class.getName());
    
}
