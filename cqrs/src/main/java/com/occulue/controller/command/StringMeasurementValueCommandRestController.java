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
 * Implements Spring Controller command CQRS processing for entity StringMeasurementValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringMeasurementValue")
public class StringMeasurementValueCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a StringMeasurementValue.  if not key provided, calls create, otherwise calls save
     * @param		StringMeasurementValue	stringMeasurementValue
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStringMeasurementValueCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().createStringMeasurementValue( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a StringMeasurementValue.  if no key provided, calls create, otherwise calls save
     * @param		StringMeasurementValue stringMeasurementValue
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStringMeasurementValueCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStringMeasurementValueCommand
			// -----------------------------------------------
			completableFuture = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().updateStringMeasurementValue(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StringMeasurementValueController:update() - successfully update StringMeasurementValue - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a StringMeasurementValue entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID stringMeasurementValueId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStringMeasurementValueCommand command = new DeleteStringMeasurementValueCommand( stringMeasurementValueId );

    	try {
        	StringMeasurementValueBusinessDelegate delegate = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted StringMeasurementValue with key " + command.getStringMeasurementValueId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected StringMeasurementValue stringMeasurementValue = null;
    private static final Logger LOGGER = Logger.getLogger(StringMeasurementValueCommandRestController.class.getName());
    
}
