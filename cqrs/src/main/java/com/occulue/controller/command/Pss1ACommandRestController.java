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
 * Implements Spring Controller command CQRS processing for entity Pss1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss1A")
public class Pss1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Pss1A.  if not key provided, calls create, otherwise calls save
     * @param		Pss1A	pss1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePss1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = Pss1ABusinessDelegate.getPss1AInstance().createPss1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Pss1A.  if no key provided, calls create, otherwise calls save
     * @param		Pss1A pss1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePss1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePss1ACommand
			// -----------------------------------------------
			completableFuture = Pss1ABusinessDelegate.getPss1AInstance().updatePss1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "Pss1AController:update() - successfully update Pss1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Pss1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pss1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePss1ACommand command = new DeletePss1ACommand( pss1AId );

    	try {
        	Pss1ABusinessDelegate delegate = Pss1ABusinessDelegate.getPss1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Pss1A with key " + command.getPss1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss1A pss1A = null;
    private static final Logger LOGGER = Logger.getLogger(Pss1ACommandRestController.class.getName());
    
}
