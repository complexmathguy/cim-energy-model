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
 * Implements Spring Controller command CQRS processing for entity GovCT1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovCT1")
public class GovCT1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovCT1.  if not key provided, calls create, otherwise calls save
     * @param		GovCT1	govCT1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovCT1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovCT1BusinessDelegate.getGovCT1Instance().createGovCT1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovCT1.  if no key provided, calls create, otherwise calls save
     * @param		GovCT1 govCT1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovCT1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovCT1Command
			// -----------------------------------------------
			completableFuture = GovCT1BusinessDelegate.getGovCT1Instance().updateGovCT1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovCT1Controller:update() - successfully update GovCT1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovCT1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govCT1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovCT1Command command = new DeleteGovCT1Command( govCT1Id );

    	try {
        	GovCT1BusinessDelegate delegate = GovCT1BusinessDelegate.getGovCT1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovCT1 with key " + command.getGovCT1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovCT1 govCT1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovCT1CommandRestController.class.getName());
    
}
