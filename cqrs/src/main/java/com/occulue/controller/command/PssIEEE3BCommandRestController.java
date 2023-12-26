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
 * Implements Spring Controller command CQRS processing for entity PssIEEE3B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE3B")
public class PssIEEE3BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssIEEE3B.  if not key provided, calls create, otherwise calls save
     * @param		PssIEEE3B	pssIEEE3B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssIEEE3BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().createPssIEEE3B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssIEEE3B.  if no key provided, calls create, otherwise calls save
     * @param		PssIEEE3B pssIEEE3B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssIEEE3BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssIEEE3BCommand
			// -----------------------------------------------
			completableFuture = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().updatePssIEEE3B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssIEEE3BController:update() - successfully update PssIEEE3B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssIEEE3B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssIEEE3BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssIEEE3BCommand command = new DeletePssIEEE3BCommand( pssIEEE3BId );

    	try {
        	PssIEEE3BBusinessDelegate delegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssIEEE3B with key " + command.getPssIEEE3BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE3B pssIEEE3B = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE3BCommandRestController.class.getName());
    
}
