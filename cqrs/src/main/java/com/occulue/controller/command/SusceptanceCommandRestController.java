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
 * Implements Spring Controller command CQRS processing for entity Susceptance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Susceptance")
public class SusceptanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Susceptance.  if not key provided, calls create, otherwise calls save
     * @param		Susceptance	susceptance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSusceptanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SusceptanceBusinessDelegate.getSusceptanceInstance().createSusceptance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Susceptance.  if no key provided, calls create, otherwise calls save
     * @param		Susceptance susceptance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSusceptanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSusceptanceCommand
			// -----------------------------------------------
			completableFuture = SusceptanceBusinessDelegate.getSusceptanceInstance().updateSusceptance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SusceptanceController:update() - successfully update Susceptance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Susceptance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID susceptanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSusceptanceCommand command = new DeleteSusceptanceCommand( susceptanceId );

    	try {
        	SusceptanceBusinessDelegate delegate = SusceptanceBusinessDelegate.getSusceptanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Susceptance with key " + command.getSusceptanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Susceptance susceptance = null;
    private static final Logger LOGGER = Logger.getLogger(SusceptanceCommandRestController.class.getName());
    
}
