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
 * Implements Spring Controller command CQRS processing for entity EquivalentInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentInjection")
public class EquivalentInjectionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquivalentInjection.  if not key provided, calls create, otherwise calls save
     * @param		EquivalentInjection	equivalentInjection
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquivalentInjectionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().createEquivalentInjection( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquivalentInjection.  if no key provided, calls create, otherwise calls save
     * @param		EquivalentInjection equivalentInjection
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquivalentInjectionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquivalentInjectionCommand
			// -----------------------------------------------
			completableFuture = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().updateEquivalentInjection(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquivalentInjectionController:update() - successfully update EquivalentInjection - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquivalentInjection entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equivalentInjectionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquivalentInjectionCommand command = new DeleteEquivalentInjectionCommand( equivalentInjectionId );

    	try {
        	EquivalentInjectionBusinessDelegate delegate = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquivalentInjection with key " + command.getEquivalentInjectionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentInjection equivalentInjection = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentInjectionCommandRestController.class.getName());
    
}
