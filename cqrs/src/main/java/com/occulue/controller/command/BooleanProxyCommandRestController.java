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
 * Implements Spring Controller command CQRS processing for entity BooleanProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BooleanProxy")
public class BooleanProxyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a BooleanProxy.  if not key provided, calls create, otherwise calls save
     * @param		BooleanProxy	booleanProxy
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateBooleanProxyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = BooleanProxyBusinessDelegate.getBooleanProxyInstance().createBooleanProxy( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a BooleanProxy.  if no key provided, calls create, otherwise calls save
     * @param		BooleanProxy booleanProxy
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateBooleanProxyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateBooleanProxyCommand
			// -----------------------------------------------
			completableFuture = BooleanProxyBusinessDelegate.getBooleanProxyInstance().updateBooleanProxy(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "BooleanProxyController:update() - successfully update BooleanProxy - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a BooleanProxy entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID booleanProxyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteBooleanProxyCommand command = new DeleteBooleanProxyCommand( booleanProxyId );

    	try {
        	BooleanProxyBusinessDelegate delegate = BooleanProxyBusinessDelegate.getBooleanProxyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted BooleanProxy with key " + command.getBooleanProxyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected BooleanProxy booleanProxy = null;
    private static final Logger LOGGER = Logger.getLogger(BooleanProxyCommandRestController.class.getName());
    
}
