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
 * Implements Spring Controller command CQRS processing for entity GovHydro4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro4")
public class GovHydro4CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydro4.  if not key provided, calls create, otherwise calls save
     * @param		GovHydro4	govHydro4
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydro4Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydro4BusinessDelegate.getGovHydro4Instance().createGovHydro4( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydro4.  if no key provided, calls create, otherwise calls save
     * @param		GovHydro4 govHydro4
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydro4Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydro4Command
			// -----------------------------------------------
			completableFuture = GovHydro4BusinessDelegate.getGovHydro4Instance().updateGovHydro4(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydro4Controller:update() - successfully update GovHydro4 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydro4 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydro4Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydro4Command command = new DeleteGovHydro4Command( govHydro4Id );

    	try {
        	GovHydro4BusinessDelegate delegate = GovHydro4BusinessDelegate.getGovHydro4Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydro4 with key " + command.getGovHydro4Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydro4 govHydro4 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydro4CommandRestController.class.getName());
    
}
