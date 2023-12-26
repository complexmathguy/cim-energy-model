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
 * Implements Spring Controller command CQRS processing for entity SwitchProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SwitchProxy")
public class SwitchProxyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SwitchProxy.  if not key provided, calls create, otherwise calls save
     * @param		SwitchProxy	switchProxy
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSwitchProxyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SwitchProxyBusinessDelegate.getSwitchProxyInstance().createSwitchProxy( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SwitchProxy.  if no key provided, calls create, otherwise calls save
     * @param		SwitchProxy switchProxy
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSwitchProxyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSwitchProxyCommand
			// -----------------------------------------------
			completableFuture = SwitchProxyBusinessDelegate.getSwitchProxyInstance().updateSwitchProxy(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SwitchProxyController:update() - successfully update SwitchProxy - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SwitchProxy entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID switchProxyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSwitchProxyCommand command = new DeleteSwitchProxyCommand( switchProxyId );

    	try {
        	SwitchProxyBusinessDelegate delegate = SwitchProxyBusinessDelegate.getSwitchProxyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SwitchProxy with key " + command.getSwitchProxyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SwitchProxy switchProxy = null;
    private static final Logger LOGGER = Logger.getLogger(SwitchProxyCommandRestController.class.getName());
    
}
