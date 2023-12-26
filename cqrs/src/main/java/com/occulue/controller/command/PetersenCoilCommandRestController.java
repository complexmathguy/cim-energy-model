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
 * Implements Spring Controller command CQRS processing for entity PetersenCoil.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PetersenCoil")
public class PetersenCoilCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PetersenCoil.  if not key provided, calls create, otherwise calls save
     * @param		PetersenCoil	petersenCoil
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePetersenCoilCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PetersenCoilBusinessDelegate.getPetersenCoilInstance().createPetersenCoil( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PetersenCoil.  if no key provided, calls create, otherwise calls save
     * @param		PetersenCoil petersenCoil
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePetersenCoilCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePetersenCoilCommand
			// -----------------------------------------------
			completableFuture = PetersenCoilBusinessDelegate.getPetersenCoilInstance().updatePetersenCoil(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PetersenCoilController:update() - successfully update PetersenCoil - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PetersenCoil entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID petersenCoilId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePetersenCoilCommand command = new DeletePetersenCoilCommand( petersenCoilId );

    	try {
        	PetersenCoilBusinessDelegate delegate = PetersenCoilBusinessDelegate.getPetersenCoilInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PetersenCoil with key " + command.getPetersenCoilId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PetersenCoil petersenCoil = null;
    private static final Logger LOGGER = Logger.getLogger(PetersenCoilCommandRestController.class.getName());
    
}
