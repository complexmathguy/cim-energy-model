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
 * Implements Spring Controller command CQRS processing for entity PFVArType2IEEEVArController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2IEEEVArController")
public class PFVArType2IEEEVArControllerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArType2IEEEVArController.  if not key provided, calls create, otherwise calls save
     * @param		PFVArType2IEEEVArController	pFVArType2IEEEVArController
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArType2IEEEVArControllerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().createPFVArType2IEEEVArController( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArType2IEEEVArController.  if no key provided, calls create, otherwise calls save
     * @param		PFVArType2IEEEVArController pFVArType2IEEEVArController
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArType2IEEEVArControllerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArType2IEEEVArControllerCommand
			// -----------------------------------------------
			completableFuture = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().updatePFVArType2IEEEVArController(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArType2IEEEVArControllerController:update() - successfully update PFVArType2IEEEVArController - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArType2IEEEVArController entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArType2IEEEVArControllerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArType2IEEEVArControllerCommand command = new DeletePFVArType2IEEEVArControllerCommand( pFVArType2IEEEVArControllerId );

    	try {
        	PFVArType2IEEEVArControllerBusinessDelegate delegate = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArType2IEEEVArController with key " + command.getPFVArType2IEEEVArControllerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType2IEEEVArController pFVArType2IEEEVArController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType2IEEEVArControllerCommandRestController.class.getName());
    
}
