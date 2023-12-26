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
 * Implements Spring Controller command CQRS processing for entity PssIEEE2B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE2B")
public class PssIEEE2BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssIEEE2B.  if not key provided, calls create, otherwise calls save
     * @param		PssIEEE2B	pssIEEE2B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssIEEE2BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().createPssIEEE2B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssIEEE2B.  if no key provided, calls create, otherwise calls save
     * @param		PssIEEE2B pssIEEE2B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssIEEE2BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssIEEE2BCommand
			// -----------------------------------------------
			completableFuture = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().updatePssIEEE2B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssIEEE2BController:update() - successfully update PssIEEE2B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssIEEE2B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssIEEE2BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssIEEE2BCommand command = new DeletePssIEEE2BCommand( pssIEEE2BId );

    	try {
        	PssIEEE2BBusinessDelegate delegate = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssIEEE2B with key " + command.getPssIEEE2BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE2B pssIEEE2B = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE2BCommandRestController.class.getName());
    
}
