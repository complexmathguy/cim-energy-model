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
 * Implements Spring Controller command CQRS processing for entity DiscontinuousExcitationControlDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscontinuousExcitationControlDynamics")
public class DiscontinuousExcitationControlDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiscontinuousExcitationControlDynamics.  if not key provided, calls create, otherwise calls save
     * @param		DiscontinuousExcitationControlDynamics	discontinuousExcitationControlDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiscontinuousExcitationControlDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance().createDiscontinuousExcitationControlDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiscontinuousExcitationControlDynamics.  if no key provided, calls create, otherwise calls save
     * @param		DiscontinuousExcitationControlDynamics discontinuousExcitationControlDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiscontinuousExcitationControlDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiscontinuousExcitationControlDynamicsCommand
			// -----------------------------------------------
			completableFuture = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance().updateDiscontinuousExcitationControlDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiscontinuousExcitationControlDynamicsController:update() - successfully update DiscontinuousExcitationControlDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiscontinuousExcitationControlDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID discontinuousExcitationControlDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiscontinuousExcitationControlDynamicsCommand command = new DeleteDiscontinuousExcitationControlDynamicsCommand( discontinuousExcitationControlDynamicsId );

    	try {
        	DiscontinuousExcitationControlDynamicsBusinessDelegate delegate = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiscontinuousExcitationControlDynamics with key " + command.getDiscontinuousExcitationControlDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscontinuousExcitationControlDynamics discontinuousExcitationControlDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(DiscontinuousExcitationControlDynamicsCommandRestController.class.getName());
    
}
