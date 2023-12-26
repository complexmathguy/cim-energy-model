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
 * Implements Spring Controller command CQRS processing for entity AccumulatorReset.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AccumulatorReset")
public class AccumulatorResetCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AccumulatorReset.  if not key provided, calls create, otherwise calls save
     * @param		AccumulatorReset	accumulatorReset
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAccumulatorResetCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance().createAccumulatorReset( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AccumulatorReset.  if no key provided, calls create, otherwise calls save
     * @param		AccumulatorReset accumulatorReset
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAccumulatorResetCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAccumulatorResetCommand
			// -----------------------------------------------
			completableFuture = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance().updateAccumulatorReset(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AccumulatorResetController:update() - successfully update AccumulatorReset - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AccumulatorReset entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID accumulatorResetId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAccumulatorResetCommand command = new DeleteAccumulatorResetCommand( accumulatorResetId );

    	try {
        	AccumulatorResetBusinessDelegate delegate = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AccumulatorReset with key " + command.getAccumulatorResetId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AccumulatorReset accumulatorReset = null;
    private static final Logger LOGGER = Logger.getLogger(AccumulatorResetCommandRestController.class.getName());
    
}
