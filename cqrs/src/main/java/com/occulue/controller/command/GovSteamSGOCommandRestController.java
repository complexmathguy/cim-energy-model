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
 * Implements Spring Controller command CQRS processing for entity GovSteamSGO.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamSGO")
public class GovSteamSGOCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteamSGO.  if not key provided, calls create, otherwise calls save
     * @param		GovSteamSGO	govSteamSGO
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteamSGOCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().createGovSteamSGO( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteamSGO.  if no key provided, calls create, otherwise calls save
     * @param		GovSteamSGO govSteamSGO
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteamSGOCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteamSGOCommand
			// -----------------------------------------------
			completableFuture = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().updateGovSteamSGO(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteamSGOController:update() - successfully update GovSteamSGO - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteamSGO entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteamSGOId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteamSGOCommand command = new DeleteGovSteamSGOCommand( govSteamSGOId );

    	try {
        	GovSteamSGOBusinessDelegate delegate = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteamSGO with key " + command.getGovSteamSGOId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamSGO govSteamSGO = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamSGOCommandRestController.class.getName());
    
}
