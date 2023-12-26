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
 * Implements Spring Controller command CQRS processing for entity NonlinearShuntCompensatorPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonlinearShuntCompensatorPoint")
public class NonlinearShuntCompensatorPointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a NonlinearShuntCompensatorPoint.  if not key provided, calls create, otherwise calls save
     * @param		NonlinearShuntCompensatorPoint	nonlinearShuntCompensatorPoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateNonlinearShuntCompensatorPointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().createNonlinearShuntCompensatorPoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a NonlinearShuntCompensatorPoint.  if no key provided, calls create, otherwise calls save
     * @param		NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateNonlinearShuntCompensatorPointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateNonlinearShuntCompensatorPointCommand
			// -----------------------------------------------
			completableFuture = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().updateNonlinearShuntCompensatorPoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "NonlinearShuntCompensatorPointController:update() - successfully update NonlinearShuntCompensatorPoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a NonlinearShuntCompensatorPoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID nonlinearShuntCompensatorPointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteNonlinearShuntCompensatorPointCommand command = new DeleteNonlinearShuntCompensatorPointCommand( nonlinearShuntCompensatorPointId );

    	try {
        	NonlinearShuntCompensatorPointBusinessDelegate delegate = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted NonlinearShuntCompensatorPoint with key " + command.getNonlinearShuntCompensatorPointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint = null;
    private static final Logger LOGGER = Logger.getLogger(NonlinearShuntCompensatorPointCommandRestController.class.getName());
    
}
