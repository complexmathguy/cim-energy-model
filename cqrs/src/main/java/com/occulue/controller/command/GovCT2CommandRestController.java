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
 * Implements Spring Controller command CQRS processing for entity GovCT2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovCT2")
public class GovCT2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovCT2.  if not key provided, calls create, otherwise calls save
     * @param		GovCT2	govCT2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovCT2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovCT2BusinessDelegate.getGovCT2Instance().createGovCT2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovCT2.  if no key provided, calls create, otherwise calls save
     * @param		GovCT2 govCT2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovCT2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovCT2Command
			// -----------------------------------------------
			completableFuture = GovCT2BusinessDelegate.getGovCT2Instance().updateGovCT2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovCT2Controller:update() - successfully update GovCT2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovCT2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govCT2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovCT2Command command = new DeleteGovCT2Command( govCT2Id );

    	try {
        	GovCT2BusinessDelegate delegate = GovCT2BusinessDelegate.getGovCT2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovCT2 with key " + command.getGovCT2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovCT2 govCT2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovCT2CommandRestController.class.getName());
    
}
