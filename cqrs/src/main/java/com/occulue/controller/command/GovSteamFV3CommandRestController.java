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
 * Implements Spring Controller command CQRS processing for entity GovSteamFV3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV3")
public class GovSteamFV3CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteamFV3.  if not key provided, calls create, otherwise calls save
     * @param		GovSteamFV3	govSteamFV3
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteamFV3Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().createGovSteamFV3( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteamFV3.  if no key provided, calls create, otherwise calls save
     * @param		GovSteamFV3 govSteamFV3
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteamFV3Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteamFV3Command
			// -----------------------------------------------
			completableFuture = GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().updateGovSteamFV3(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteamFV3Controller:update() - successfully update GovSteamFV3 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteamFV3 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteamFV3Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteamFV3Command command = new DeleteGovSteamFV3Command( govSteamFV3Id );

    	try {
        	GovSteamFV3BusinessDelegate delegate = GovSteamFV3BusinessDelegate.getGovSteamFV3Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteamFV3 with key " + command.getGovSteamFV3Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamFV3 govSteamFV3 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamFV3CommandRestController.class.getName());
    
}
