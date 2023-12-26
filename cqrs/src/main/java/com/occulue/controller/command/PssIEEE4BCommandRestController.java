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
 * Implements Spring Controller command CQRS processing for entity PssIEEE4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE4B")
public class PssIEEE4BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssIEEE4B.  if not key provided, calls create, otherwise calls save
     * @param		PssIEEE4B	pssIEEE4B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssIEEE4BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().createPssIEEE4B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssIEEE4B.  if no key provided, calls create, otherwise calls save
     * @param		PssIEEE4B pssIEEE4B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssIEEE4BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssIEEE4BCommand
			// -----------------------------------------------
			completableFuture = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().updatePssIEEE4B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssIEEE4BController:update() - successfully update PssIEEE4B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssIEEE4B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssIEEE4BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssIEEE4BCommand command = new DeletePssIEEE4BCommand( pssIEEE4BId );

    	try {
        	PssIEEE4BBusinessDelegate delegate = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssIEEE4B with key " + command.getPssIEEE4BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE4B pssIEEE4B = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE4BCommandRestController.class.getName());
    
}
