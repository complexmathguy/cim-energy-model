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
 * Implements Spring Controller command CQRS processing for entity DayType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DayType")
public class DayTypeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DayType.  if not key provided, calls create, otherwise calls save
     * @param		DayType	dayType
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDayTypeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DayTypeBusinessDelegate.getDayTypeInstance().createDayType( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DayType.  if no key provided, calls create, otherwise calls save
     * @param		DayType dayType
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDayTypeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDayTypeCommand
			// -----------------------------------------------
			completableFuture = DayTypeBusinessDelegate.getDayTypeInstance().updateDayType(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DayTypeController:update() - successfully update DayType - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DayType entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dayTypeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDayTypeCommand command = new DeleteDayTypeCommand( dayTypeId );

    	try {
        	DayTypeBusinessDelegate delegate = DayTypeBusinessDelegate.getDayTypeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DayType with key " + command.getDayTypeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DayType dayType = null;
    private static final Logger LOGGER = Logger.getLogger(DayTypeCommandRestController.class.getName());
    
}
