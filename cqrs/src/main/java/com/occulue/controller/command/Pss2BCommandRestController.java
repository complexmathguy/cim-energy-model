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
 * Implements Spring Controller command CQRS processing for entity Pss2B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss2B")
public class Pss2BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Pss2B.  if not key provided, calls create, otherwise calls save
     * @param		Pss2B	pss2B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePss2BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = Pss2BBusinessDelegate.getPss2BInstance().createPss2B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Pss2B.  if no key provided, calls create, otherwise calls save
     * @param		Pss2B pss2B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePss2BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePss2BCommand
			// -----------------------------------------------
			completableFuture = Pss2BBusinessDelegate.getPss2BInstance().updatePss2B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "Pss2BController:update() - successfully update Pss2B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Pss2B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pss2BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePss2BCommand command = new DeletePss2BCommand( pss2BId );

    	try {
        	Pss2BBusinessDelegate delegate = Pss2BBusinessDelegate.getPss2BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Pss2B with key " + command.getPss2BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss2B pss2B = null;
    private static final Logger LOGGER = Logger.getLogger(Pss2BCommandRestController.class.getName());
    
}
