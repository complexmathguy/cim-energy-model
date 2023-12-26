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
 * Implements Spring Controller command CQRS processing for entity GovHydroWEH.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroWEH")
public class GovHydroWEHCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroWEH.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroWEH	govHydroWEH
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroWEHCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().createGovHydroWEH( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroWEH.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroWEH govHydroWEH
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroWEHCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroWEHCommand
			// -----------------------------------------------
			completableFuture = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().updateGovHydroWEH(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroWEHController:update() - successfully update GovHydroWEH - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroWEH entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroWEHId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroWEHCommand command = new DeleteGovHydroWEHCommand( govHydroWEHId );

    	try {
        	GovHydroWEHBusinessDelegate delegate = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroWEH with key " + command.getGovHydroWEHId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroWEH govHydroWEH = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroWEHCommandRestController.class.getName());
    
}
