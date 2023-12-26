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
 * Implements Spring Controller command CQRS processing for entity GovHydroIEEE2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroIEEE2")
public class GovHydroIEEE2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroIEEE2.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroIEEE2	govHydroIEEE2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroIEEE2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().createGovHydroIEEE2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroIEEE2.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroIEEE2 govHydroIEEE2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroIEEE2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroIEEE2Command
			// -----------------------------------------------
			completableFuture = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().updateGovHydroIEEE2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroIEEE2Controller:update() - successfully update GovHydroIEEE2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroIEEE2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroIEEE2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroIEEE2Command command = new DeleteGovHydroIEEE2Command( govHydroIEEE2Id );

    	try {
        	GovHydroIEEE2BusinessDelegate delegate = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroIEEE2 with key " + command.getGovHydroIEEE2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroIEEE2 govHydroIEEE2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE2CommandRestController.class.getName());
    
}
