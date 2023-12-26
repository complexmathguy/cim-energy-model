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
 * Implements Spring Controller command CQRS processing for entity PssWECC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssWECC")
public class PssWECCCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssWECC.  if not key provided, calls create, otherwise calls save
     * @param		PssWECC	pssWECC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssWECCCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssWECCBusinessDelegate.getPssWECCInstance().createPssWECC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssWECC.  if no key provided, calls create, otherwise calls save
     * @param		PssWECC pssWECC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssWECCCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssWECCCommand
			// -----------------------------------------------
			completableFuture = PssWECCBusinessDelegate.getPssWECCInstance().updatePssWECC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssWECCController:update() - successfully update PssWECC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssWECC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssWECCId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssWECCCommand command = new DeletePssWECCCommand( pssWECCId );

    	try {
        	PssWECCBusinessDelegate delegate = PssWECCBusinessDelegate.getPssWECCInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssWECC with key " + command.getPssWECCId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssWECC pssWECC = null;
    private static final Logger LOGGER = Logger.getLogger(PssWECCCommandRestController.class.getName());
    
}
