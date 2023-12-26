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
 * Implements Spring Controller command CQRS processing for entity GovHydroIEEE0.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroIEEE0")
public class GovHydroIEEE0CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroIEEE0.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroIEEE0	govHydroIEEE0
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroIEEE0Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().createGovHydroIEEE0( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroIEEE0.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroIEEE0 govHydroIEEE0
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroIEEE0Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroIEEE0Command
			// -----------------------------------------------
			completableFuture = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().updateGovHydroIEEE0(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroIEEE0Controller:update() - successfully update GovHydroIEEE0 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroIEEE0 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroIEEE0Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroIEEE0Command command = new DeleteGovHydroIEEE0Command( govHydroIEEE0Id );

    	try {
        	GovHydroIEEE0BusinessDelegate delegate = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroIEEE0 with key " + command.getGovHydroIEEE0Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroIEEE0 govHydroIEEE0 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE0CommandRestController.class.getName());
    
}
