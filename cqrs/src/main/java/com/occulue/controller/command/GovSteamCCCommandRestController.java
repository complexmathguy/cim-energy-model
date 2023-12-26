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
 * Implements Spring Controller command CQRS processing for entity GovSteamCC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamCC")
public class GovSteamCCCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteamCC.  if not key provided, calls create, otherwise calls save
     * @param		GovSteamCC	govSteamCC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteamCCCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteamCCBusinessDelegate.getGovSteamCCInstance().createGovSteamCC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteamCC.  if no key provided, calls create, otherwise calls save
     * @param		GovSteamCC govSteamCC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteamCCCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteamCCCommand
			// -----------------------------------------------
			completableFuture = GovSteamCCBusinessDelegate.getGovSteamCCInstance().updateGovSteamCC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteamCCController:update() - successfully update GovSteamCC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteamCC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteamCCId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteamCCCommand command = new DeleteGovSteamCCCommand( govSteamCCId );

    	try {
        	GovSteamCCBusinessDelegate delegate = GovSteamCCBusinessDelegate.getGovSteamCCInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteamCC with key " + command.getGovSteamCCId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamCC govSteamCC = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamCCCommandRestController.class.getName());
    
}
