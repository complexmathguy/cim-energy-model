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
 * Implements Spring Controller command CQRS processing for entity GovSteamFV4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV4")
public class GovSteamFV4CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteamFV4.  if not key provided, calls create, otherwise calls save
     * @param		GovSteamFV4	govSteamFV4
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteamFV4Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().createGovSteamFV4( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteamFV4.  if no key provided, calls create, otherwise calls save
     * @param		GovSteamFV4 govSteamFV4
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteamFV4Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteamFV4Command
			// -----------------------------------------------
			completableFuture = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().updateGovSteamFV4(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteamFV4Controller:update() - successfully update GovSteamFV4 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteamFV4 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteamFV4Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteamFV4Command command = new DeleteGovSteamFV4Command( govSteamFV4Id );

    	try {
        	GovSteamFV4BusinessDelegate delegate = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteamFV4 with key " + command.getGovSteamFV4Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamFV4 govSteamFV4 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamFV4CommandRestController.class.getName());
    
}
