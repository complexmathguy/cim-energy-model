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
 * Implements Spring Controller command CQRS processing for entity DCSwitch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCSwitch")
public class DCSwitchCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCSwitch.  if not key provided, calls create, otherwise calls save
     * @param		DCSwitch	dCSwitch
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCSwitchCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCSwitchBusinessDelegate.getDCSwitchInstance().createDCSwitch( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCSwitch.  if no key provided, calls create, otherwise calls save
     * @param		DCSwitch dCSwitch
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCSwitchCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCSwitchCommand
			// -----------------------------------------------
			completableFuture = DCSwitchBusinessDelegate.getDCSwitchInstance().updateDCSwitch(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCSwitchController:update() - successfully update DCSwitch - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCSwitch entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCSwitchId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCSwitchCommand command = new DeleteDCSwitchCommand( dCSwitchId );

    	try {
        	DCSwitchBusinessDelegate delegate = DCSwitchBusinessDelegate.getDCSwitchInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCSwitch with key " + command.getDCSwitchId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCSwitch dCSwitch = null;
    private static final Logger LOGGER = Logger.getLogger(DCSwitchCommandRestController.class.getName());
    
}
