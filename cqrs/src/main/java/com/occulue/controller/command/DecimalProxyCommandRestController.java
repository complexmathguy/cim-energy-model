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
 * Implements Spring Controller command CQRS processing for entity DecimalProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DecimalProxy")
public class DecimalProxyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DecimalProxy.  if not key provided, calls create, otherwise calls save
     * @param		DecimalProxy	decimalProxy
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDecimalProxyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DecimalProxyBusinessDelegate.getDecimalProxyInstance().createDecimalProxy( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DecimalProxy.  if no key provided, calls create, otherwise calls save
     * @param		DecimalProxy decimalProxy
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDecimalProxyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDecimalProxyCommand
			// -----------------------------------------------
			completableFuture = DecimalProxyBusinessDelegate.getDecimalProxyInstance().updateDecimalProxy(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DecimalProxyController:update() - successfully update DecimalProxy - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DecimalProxy entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID decimalProxyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDecimalProxyCommand command = new DeleteDecimalProxyCommand( decimalProxyId );

    	try {
        	DecimalProxyBusinessDelegate delegate = DecimalProxyBusinessDelegate.getDecimalProxyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DecimalProxy with key " + command.getDecimalProxyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DecimalProxy decimalProxy = null;
    private static final Logger LOGGER = Logger.getLogger(DecimalProxyCommandRestController.class.getName());
    
}
