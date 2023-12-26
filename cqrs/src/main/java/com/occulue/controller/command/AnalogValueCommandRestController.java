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
 * Implements Spring Controller command CQRS processing for entity AnalogValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogValue")
public class AnalogValueCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AnalogValue.  if not key provided, calls create, otherwise calls save
     * @param		AnalogValue	analogValue
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAnalogValueCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AnalogValueBusinessDelegate.getAnalogValueInstance().createAnalogValue( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AnalogValue.  if no key provided, calls create, otherwise calls save
     * @param		AnalogValue analogValue
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAnalogValueCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAnalogValueCommand
			// -----------------------------------------------
			completableFuture = AnalogValueBusinessDelegate.getAnalogValueInstance().updateAnalogValue(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AnalogValueController:update() - successfully update AnalogValue - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AnalogValue entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID analogValueId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAnalogValueCommand command = new DeleteAnalogValueCommand( analogValueId );

    	try {
        	AnalogValueBusinessDelegate delegate = AnalogValueBusinessDelegate.getAnalogValueInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AnalogValue with key " + command.getAnalogValueId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AnalogValue analogValue = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogValueCommandRestController.class.getName());
    
}
