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
 * Implements Spring Controller command CQRS processing for entity PssSK.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSK")
public class PssSKCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssSK.  if not key provided, calls create, otherwise calls save
     * @param		PssSK	pssSK
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssSKCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssSKBusinessDelegate.getPssSKInstance().createPssSK( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssSK.  if no key provided, calls create, otherwise calls save
     * @param		PssSK pssSK
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssSKCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssSKCommand
			// -----------------------------------------------
			completableFuture = PssSKBusinessDelegate.getPssSKInstance().updatePssSK(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssSKController:update() - successfully update PssSK - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssSK entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssSKId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssSKCommand command = new DeletePssSKCommand( pssSKId );

    	try {
        	PssSKBusinessDelegate delegate = PssSKBusinessDelegate.getPssSKInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssSK with key " + command.getPssSKId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssSK pssSK = null;
    private static final Logger LOGGER = Logger.getLogger(PssSKCommandRestController.class.getName());
    
}
