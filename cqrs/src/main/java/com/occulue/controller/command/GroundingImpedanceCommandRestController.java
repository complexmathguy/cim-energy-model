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
 * Implements Spring Controller command CQRS processing for entity GroundingImpedance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GroundingImpedance")
public class GroundingImpedanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GroundingImpedance.  if not key provided, calls create, otherwise calls save
     * @param		GroundingImpedance	groundingImpedance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGroundingImpedanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().createGroundingImpedance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GroundingImpedance.  if no key provided, calls create, otherwise calls save
     * @param		GroundingImpedance groundingImpedance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGroundingImpedanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGroundingImpedanceCommand
			// -----------------------------------------------
			completableFuture = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().updateGroundingImpedance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GroundingImpedanceController:update() - successfully update GroundingImpedance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GroundingImpedance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID groundingImpedanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGroundingImpedanceCommand command = new DeleteGroundingImpedanceCommand( groundingImpedanceId );

    	try {
        	GroundingImpedanceBusinessDelegate delegate = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GroundingImpedance with key " + command.getGroundingImpedanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GroundingImpedance groundingImpedance = null;
    private static final Logger LOGGER = Logger.getLogger(GroundingImpedanceCommandRestController.class.getName());
    
}
