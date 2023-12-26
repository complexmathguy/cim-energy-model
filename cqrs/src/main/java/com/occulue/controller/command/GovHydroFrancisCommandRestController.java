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
 * Implements Spring Controller command CQRS processing for entity GovHydroFrancis.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroFrancis")
public class GovHydroFrancisCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroFrancis.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroFrancis	govHydroFrancis
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroFrancisCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().createGovHydroFrancis( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroFrancis.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroFrancis govHydroFrancis
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroFrancisCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroFrancisCommand
			// -----------------------------------------------
			completableFuture = GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().updateGovHydroFrancis(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroFrancisController:update() - successfully update GovHydroFrancis - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroFrancis entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroFrancisId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroFrancisCommand command = new DeleteGovHydroFrancisCommand( govHydroFrancisId );

    	try {
        	GovHydroFrancisBusinessDelegate delegate = GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroFrancis with key " + command.getGovHydroFrancisId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroFrancis govHydroFrancis = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroFrancisCommandRestController.class.getName());
    
}
