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
 * Implements Spring Controller command CQRS processing for entity StringProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringProxy")
public class StringProxyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a StringProxy.  if not key provided, calls create, otherwise calls save
     * @param		StringProxy	stringProxy
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStringProxyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StringProxyBusinessDelegate.getStringProxyInstance().createStringProxy( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a StringProxy.  if no key provided, calls create, otherwise calls save
     * @param		StringProxy stringProxy
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStringProxyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStringProxyCommand
			// -----------------------------------------------
			completableFuture = StringProxyBusinessDelegate.getStringProxyInstance().updateStringProxy(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StringProxyController:update() - successfully update StringProxy - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a StringProxy entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID stringProxyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStringProxyCommand command = new DeleteStringProxyCommand( stringProxyId );

    	try {
        	StringProxyBusinessDelegate delegate = StringProxyBusinessDelegate.getStringProxyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted StringProxy with key " + command.getStringProxyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected StringProxy stringProxy = null;
    private static final Logger LOGGER = Logger.getLogger(StringProxyCommandRestController.class.getName());
    
}
