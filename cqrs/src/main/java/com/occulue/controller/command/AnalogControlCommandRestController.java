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
 * Implements Spring Controller command CQRS processing for entity AnalogControl.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogControl")
public class AnalogControlCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AnalogControl.  if not key provided, calls create, otherwise calls save
     * @param		AnalogControl	analogControl
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAnalogControlCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AnalogControlBusinessDelegate.getAnalogControlInstance().createAnalogControl( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AnalogControl.  if no key provided, calls create, otherwise calls save
     * @param		AnalogControl analogControl
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAnalogControlCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAnalogControlCommand
			// -----------------------------------------------
			completableFuture = AnalogControlBusinessDelegate.getAnalogControlInstance().updateAnalogControl(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AnalogControlController:update() - successfully update AnalogControl - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AnalogControl entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID analogControlId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAnalogControlCommand command = new DeleteAnalogControlCommand( analogControlId );

    	try {
        	AnalogControlBusinessDelegate delegate = AnalogControlBusinessDelegate.getAnalogControlInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AnalogControl with key " + command.getAnalogControlId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AnalogControl analogControl = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogControlCommandRestController.class.getName());
    
}
