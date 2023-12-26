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
 * Implements Spring Controller command CQRS processing for entity EquivalentNetwork.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentNetwork")
public class EquivalentNetworkCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquivalentNetwork.  if not key provided, calls create, otherwise calls save
     * @param		EquivalentNetwork	equivalentNetwork
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquivalentNetworkCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().createEquivalentNetwork( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquivalentNetwork.  if no key provided, calls create, otherwise calls save
     * @param		EquivalentNetwork equivalentNetwork
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquivalentNetworkCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquivalentNetworkCommand
			// -----------------------------------------------
			completableFuture = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().updateEquivalentNetwork(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquivalentNetworkController:update() - successfully update EquivalentNetwork - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquivalentNetwork entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equivalentNetworkId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquivalentNetworkCommand command = new DeleteEquivalentNetworkCommand( equivalentNetworkId );

    	try {
        	EquivalentNetworkBusinessDelegate delegate = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquivalentNetwork with key " + command.getEquivalentNetworkId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentNetwork equivalentNetwork = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentNetworkCommandRestController.class.getName());
    
}
