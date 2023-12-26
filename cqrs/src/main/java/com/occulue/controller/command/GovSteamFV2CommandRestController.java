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
 * Implements Spring Controller command CQRS processing for entity GovSteamFV2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV2")
public class GovSteamFV2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteamFV2.  if not key provided, calls create, otherwise calls save
     * @param		GovSteamFV2	govSteamFV2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteamFV2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().createGovSteamFV2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteamFV2.  if no key provided, calls create, otherwise calls save
     * @param		GovSteamFV2 govSteamFV2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteamFV2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteamFV2Command
			// -----------------------------------------------
			completableFuture = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().updateGovSteamFV2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteamFV2Controller:update() - successfully update GovSteamFV2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteamFV2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteamFV2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteamFV2Command command = new DeleteGovSteamFV2Command( govSteamFV2Id );

    	try {
        	GovSteamFV2BusinessDelegate delegate = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteamFV2 with key " + command.getGovSteamFV2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamFV2 govSteamFV2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamFV2CommandRestController.class.getName());
    
}
