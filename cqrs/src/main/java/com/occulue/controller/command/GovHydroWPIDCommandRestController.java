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
 * Implements Spring Controller command CQRS processing for entity GovHydroWPID.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroWPID")
public class GovHydroWPIDCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroWPID.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroWPID	govHydroWPID
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroWPIDCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().createGovHydroWPID( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroWPID.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroWPID govHydroWPID
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroWPIDCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroWPIDCommand
			// -----------------------------------------------
			completableFuture = GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().updateGovHydroWPID(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroWPIDController:update() - successfully update GovHydroWPID - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroWPID entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroWPIDId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroWPIDCommand command = new DeleteGovHydroWPIDCommand( govHydroWPIDId );

    	try {
        	GovHydroWPIDBusinessDelegate delegate = GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroWPID with key " + command.getGovHydroWPIDId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroWPID govHydroWPID = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroWPIDCommandRestController.class.getName());
    
}
