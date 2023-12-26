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
 * Implements Spring Controller command CQRS processing for entity EquivalentShunt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentShunt")
public class EquivalentShuntCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquivalentShunt.  if not key provided, calls create, otherwise calls save
     * @param		EquivalentShunt	equivalentShunt
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquivalentShuntCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().createEquivalentShunt( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquivalentShunt.  if no key provided, calls create, otherwise calls save
     * @param		EquivalentShunt equivalentShunt
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquivalentShuntCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquivalentShuntCommand
			// -----------------------------------------------
			completableFuture = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().updateEquivalentShunt(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquivalentShuntController:update() - successfully update EquivalentShunt - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquivalentShunt entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equivalentShuntId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquivalentShuntCommand command = new DeleteEquivalentShuntCommand( equivalentShuntId );

    	try {
        	EquivalentShuntBusinessDelegate delegate = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquivalentShunt with key " + command.getEquivalentShuntId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentShunt equivalentShunt = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentShuntCommandRestController.class.getName());
    
}
