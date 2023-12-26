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
 * Implements Spring Controller command CQRS processing for entity AnalogLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogLimitSet")
public class AnalogLimitSetCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AnalogLimitSet.  if not key provided, calls create, otherwise calls save
     * @param		AnalogLimitSet	analogLimitSet
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAnalogLimitSetCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().createAnalogLimitSet( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AnalogLimitSet.  if no key provided, calls create, otherwise calls save
     * @param		AnalogLimitSet analogLimitSet
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAnalogLimitSetCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAnalogLimitSetCommand
			// -----------------------------------------------
			completableFuture = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().updateAnalogLimitSet(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AnalogLimitSetController:update() - successfully update AnalogLimitSet - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AnalogLimitSet entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID analogLimitSetId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAnalogLimitSetCommand command = new DeleteAnalogLimitSetCommand( analogLimitSetId );

    	try {
        	AnalogLimitSetBusinessDelegate delegate = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AnalogLimitSet with key " + command.getAnalogLimitSetId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AnalogLimitSet analogLimitSet = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogLimitSetCommandRestController.class.getName());
    
}
