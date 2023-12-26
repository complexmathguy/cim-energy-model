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
 * Implements Spring Controller command CQRS processing for entity GovSteam2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam2")
public class GovSteam2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovSteam2.  if not key provided, calls create, otherwise calls save
     * @param		GovSteam2	govSteam2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovSteam2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovSteam2BusinessDelegate.getGovSteam2Instance().createGovSteam2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovSteam2.  if no key provided, calls create, otherwise calls save
     * @param		GovSteam2 govSteam2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovSteam2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovSteam2Command
			// -----------------------------------------------
			completableFuture = GovSteam2BusinessDelegate.getGovSteam2Instance().updateGovSteam2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovSteam2Controller:update() - successfully update GovSteam2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovSteam2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govSteam2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovSteam2Command command = new DeleteGovSteam2Command( govSteam2Id );

    	try {
        	GovSteam2BusinessDelegate delegate = GovSteam2BusinessDelegate.getGovSteam2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovSteam2 with key " + command.getGovSteam2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteam2 govSteam2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteam2CommandRestController.class.getName());
    
}
