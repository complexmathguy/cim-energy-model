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
 * Implements Spring Controller command CQRS processing for entity DCBusbar.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCBusbar")
public class DCBusbarCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCBusbar.  if not key provided, calls create, otherwise calls save
     * @param		DCBusbar	dCBusbar
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCBusbarCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCBusbarBusinessDelegate.getDCBusbarInstance().createDCBusbar( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCBusbar.  if no key provided, calls create, otherwise calls save
     * @param		DCBusbar dCBusbar
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCBusbarCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCBusbarCommand
			// -----------------------------------------------
			completableFuture = DCBusbarBusinessDelegate.getDCBusbarInstance().updateDCBusbar(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCBusbarController:update() - successfully update DCBusbar - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCBusbar entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCBusbarId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCBusbarCommand command = new DeleteDCBusbarCommand( dCBusbarId );

    	try {
        	DCBusbarBusinessDelegate delegate = DCBusbarBusinessDelegate.getDCBusbarInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCBusbar with key " + command.getDCBusbarId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCBusbar dCBusbar = null;
    private static final Logger LOGGER = Logger.getLogger(DCBusbarCommandRestController.class.getName());
    
}
