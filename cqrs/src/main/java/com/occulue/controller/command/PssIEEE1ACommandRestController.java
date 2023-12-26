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
 * Implements Spring Controller command CQRS processing for entity PssIEEE1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE1A")
public class PssIEEE1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssIEEE1A.  if not key provided, calls create, otherwise calls save
     * @param		PssIEEE1A	pssIEEE1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssIEEE1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().createPssIEEE1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssIEEE1A.  if no key provided, calls create, otherwise calls save
     * @param		PssIEEE1A pssIEEE1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssIEEE1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssIEEE1ACommand
			// -----------------------------------------------
			completableFuture = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().updatePssIEEE1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssIEEE1AController:update() - successfully update PssIEEE1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssIEEE1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssIEEE1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssIEEE1ACommand command = new DeletePssIEEE1ACommand( pssIEEE1AId );

    	try {
        	PssIEEE1ABusinessDelegate delegate = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssIEEE1A with key " + command.getPssIEEE1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE1A pssIEEE1A = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE1ACommandRestController.class.getName());
    
}
