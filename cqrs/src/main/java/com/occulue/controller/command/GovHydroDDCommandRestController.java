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
 * Implements Spring Controller command CQRS processing for entity GovHydroDD.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroDD")
public class GovHydroDDCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroDD.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroDD	govHydroDD
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroDDCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroDDBusinessDelegate.getGovHydroDDInstance().createGovHydroDD( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroDD.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroDD govHydroDD
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroDDCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroDDCommand
			// -----------------------------------------------
			completableFuture = GovHydroDDBusinessDelegate.getGovHydroDDInstance().updateGovHydroDD(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroDDController:update() - successfully update GovHydroDD - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroDD entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroDDId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroDDCommand command = new DeleteGovHydroDDCommand( govHydroDDId );

    	try {
        	GovHydroDDBusinessDelegate delegate = GovHydroDDBusinessDelegate.getGovHydroDDInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroDD with key " + command.getGovHydroDDId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroDD govHydroDD = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroDDCommandRestController.class.getName());
    
}
