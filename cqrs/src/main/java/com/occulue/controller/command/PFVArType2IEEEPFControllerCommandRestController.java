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
 * Implements Spring Controller command CQRS processing for entity PFVArType2IEEEPFController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2IEEEPFController")
public class PFVArType2IEEEPFControllerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArType2IEEEPFController.  if not key provided, calls create, otherwise calls save
     * @param		PFVArType2IEEEPFController	pFVArType2IEEEPFController
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArType2IEEEPFControllerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().createPFVArType2IEEEPFController( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArType2IEEEPFController.  if no key provided, calls create, otherwise calls save
     * @param		PFVArType2IEEEPFController pFVArType2IEEEPFController
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArType2IEEEPFControllerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArType2IEEEPFControllerCommand
			// -----------------------------------------------
			completableFuture = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().updatePFVArType2IEEEPFController(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArType2IEEEPFControllerController:update() - successfully update PFVArType2IEEEPFController - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArType2IEEEPFController entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArType2IEEEPFControllerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArType2IEEEPFControllerCommand command = new DeletePFVArType2IEEEPFControllerCommand( pFVArType2IEEEPFControllerId );

    	try {
        	PFVArType2IEEEPFControllerBusinessDelegate delegate = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArType2IEEEPFController with key " + command.getPFVArType2IEEEPFControllerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType2IEEEPFController pFVArType2IEEEPFController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType2IEEEPFControllerCommandRestController.class.getName());
    
}
