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
 * Implements Spring Controller command CQRS processing for entity UnderexcLim2Simplified.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLim2Simplified")
public class UnderexcLim2SimplifiedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a UnderexcLim2Simplified.  if not key provided, calls create, otherwise calls save
     * @param		UnderexcLim2Simplified	underexcLim2Simplified
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateUnderexcLim2SimplifiedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().createUnderexcLim2Simplified( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a UnderexcLim2Simplified.  if no key provided, calls create, otherwise calls save
     * @param		UnderexcLim2Simplified underexcLim2Simplified
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateUnderexcLim2SimplifiedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateUnderexcLim2SimplifiedCommand
			// -----------------------------------------------
			completableFuture = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().updateUnderexcLim2Simplified(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "UnderexcLim2SimplifiedController:update() - successfully update UnderexcLim2Simplified - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a UnderexcLim2Simplified entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID underexcLim2SimplifiedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteUnderexcLim2SimplifiedCommand command = new DeleteUnderexcLim2SimplifiedCommand( underexcLim2SimplifiedId );

    	try {
        	UnderexcLim2SimplifiedBusinessDelegate delegate = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted UnderexcLim2Simplified with key " + command.getUnderexcLim2SimplifiedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLim2Simplified underexcLim2Simplified = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLim2SimplifiedCommandRestController.class.getName());
    
}
