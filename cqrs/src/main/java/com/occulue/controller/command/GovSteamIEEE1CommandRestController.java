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
 * Implements Spring Controller command CQRS processing for entity GovSteamIEEE1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamIEEE1")
public class GovSteamIEEE1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteamIEEE1.  if not key provided, calls create, otherwise calls save
     * @param		GovSteamIEEE1	govSteamIEEE1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteamIEEE1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().createGovSteamIEEE1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteamIEEE1.  if no key provided, calls create, otherwise calls save
     * @param		GovSteamIEEE1 govSteamIEEE1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteamIEEE1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteamIEEE1Command
			// -----------------------------------------------
			completableFuture = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().updateGovSteamIEEE1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteamIEEE1Controller:update() - successfully update GovSteamIEEE1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteamIEEE1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteamIEEE1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteamIEEE1Command command = new DeleteGovSteamIEEE1Command( govSteamIEEE1Id );

    	try {
        	GovSteamIEEE1BusinessDelegate delegate = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteamIEEE1 with key " + command.getGovSteamIEEE1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamIEEE1 govSteamIEEE1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamIEEE1CommandRestController.class.getName());
    
}
