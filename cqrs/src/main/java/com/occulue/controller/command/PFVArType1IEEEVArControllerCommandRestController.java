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
 * Implements Spring Controller command CQRS processing for entity PFVArType1IEEEVArController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType1IEEEVArController")
public class PFVArType1IEEEVArControllerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArType1IEEEVArController.  if not key provided, calls create, otherwise calls save
     * @param		PFVArType1IEEEVArController	pFVArType1IEEEVArController
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArType1IEEEVArControllerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().createPFVArType1IEEEVArController( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArType1IEEEVArController.  if no key provided, calls create, otherwise calls save
     * @param		PFVArType1IEEEVArController pFVArType1IEEEVArController
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArType1IEEEVArControllerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArType1IEEEVArControllerCommand
			// -----------------------------------------------
			completableFuture = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().updatePFVArType1IEEEVArController(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArType1IEEEVArControllerController:update() - successfully update PFVArType1IEEEVArController - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArType1IEEEVArController entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArType1IEEEVArControllerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArType1IEEEVArControllerCommand command = new DeletePFVArType1IEEEVArControllerCommand( pFVArType1IEEEVArControllerId );

    	try {
        	PFVArType1IEEEVArControllerBusinessDelegate delegate = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArType1IEEEVArController with key " + command.getPFVArType1IEEEVArControllerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType1IEEEVArController pFVArType1IEEEVArController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType1IEEEVArControllerCommandRestController.class.getName());
    
}
