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
 * Implements Spring Controller command CQRS processing for entity DateTime.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DateTime")
public class DateTimeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DateTime.  if not key provided, calls create, otherwise calls save
     * @param		DateTime	dateTime
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDateTimeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DateTimeBusinessDelegate.getDateTimeInstance().createDateTime( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DateTime.  if no key provided, calls create, otherwise calls save
     * @param		DateTime dateTime
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDateTimeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDateTimeCommand
			// -----------------------------------------------
			completableFuture = DateTimeBusinessDelegate.getDateTimeInstance().updateDateTime(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DateTimeController:update() - successfully update DateTime - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DateTime entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dateTimeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDateTimeCommand command = new DeleteDateTimeCommand( dateTimeId );

    	try {
        	DateTimeBusinessDelegate delegate = DateTimeBusinessDelegate.getDateTimeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DateTime with key " + command.getDateTimeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DateTime dateTime = null;
    private static final Logger LOGGER = Logger.getLogger(DateTimeCommandRestController.class.getName());
    
}
