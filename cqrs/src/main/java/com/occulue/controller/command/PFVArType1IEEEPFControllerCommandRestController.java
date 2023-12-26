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
 * Implements Spring Controller command CQRS processing for entity PFVArType1IEEEPFController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType1IEEEPFController")
public class PFVArType1IEEEPFControllerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArType1IEEEPFController.  if not key provided, calls create, otherwise calls save
     * @param		PFVArType1IEEEPFController	pFVArType1IEEEPFController
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArType1IEEEPFControllerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().createPFVArType1IEEEPFController( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArType1IEEEPFController.  if no key provided, calls create, otherwise calls save
     * @param		PFVArType1IEEEPFController pFVArType1IEEEPFController
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArType1IEEEPFControllerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArType1IEEEPFControllerCommand
			// -----------------------------------------------
			completableFuture = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().updatePFVArType1IEEEPFController(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArType1IEEEPFControllerController:update() - successfully update PFVArType1IEEEPFController - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArType1IEEEPFController entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArType1IEEEPFControllerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArType1IEEEPFControllerCommand command = new DeletePFVArType1IEEEPFControllerCommand( pFVArType1IEEEPFControllerId );

    	try {
        	PFVArType1IEEEPFControllerBusinessDelegate delegate = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArType1IEEEPFController with key " + command.getPFVArType1IEEEPFControllerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType1IEEEPFController pFVArType1IEEEPFController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType1IEEEPFControllerCommandRestController.class.getName());
    
}
