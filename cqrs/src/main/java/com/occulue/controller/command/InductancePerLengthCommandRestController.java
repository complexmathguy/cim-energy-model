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
 * Implements Spring Controller command CQRS processing for entity InductancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/InductancePerLength")
public class InductancePerLengthCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a InductancePerLength.  if not key provided, calls create, otherwise calls save
     * @param		InductancePerLength	inductancePerLength
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateInductancePerLengthCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().createInductancePerLength( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a InductancePerLength.  if no key provided, calls create, otherwise calls save
     * @param		InductancePerLength inductancePerLength
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateInductancePerLengthCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateInductancePerLengthCommand
			// -----------------------------------------------
			completableFuture = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().updateInductancePerLength(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "InductancePerLengthController:update() - successfully update InductancePerLength - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a InductancePerLength entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID inductancePerLengthId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteInductancePerLengthCommand command = new DeleteInductancePerLengthCommand( inductancePerLengthId );

    	try {
        	InductancePerLengthBusinessDelegate delegate = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted InductancePerLength with key " + command.getInductancePerLengthId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected InductancePerLength inductancePerLength = null;
    private static final Logger LOGGER = Logger.getLogger(InductancePerLengthCommandRestController.class.getName());
    
}
