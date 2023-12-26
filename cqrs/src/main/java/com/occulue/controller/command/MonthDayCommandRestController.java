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
 * Implements Spring Controller command CQRS processing for entity MonthDay.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MonthDay")
public class MonthDayCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MonthDay.  if not key provided, calls create, otherwise calls save
     * @param		MonthDay	monthDay
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMonthDayCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MonthDayBusinessDelegate.getMonthDayInstance().createMonthDay( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MonthDay.  if no key provided, calls create, otherwise calls save
     * @param		MonthDay monthDay
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMonthDayCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMonthDayCommand
			// -----------------------------------------------
			completableFuture = MonthDayBusinessDelegate.getMonthDayInstance().updateMonthDay(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MonthDayController:update() - successfully update MonthDay - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MonthDay entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID monthDayId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMonthDayCommand command = new DeleteMonthDayCommand( monthDayId );

    	try {
        	MonthDayBusinessDelegate delegate = MonthDayBusinessDelegate.getMonthDayInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MonthDay with key " + command.getMonthDayId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MonthDay monthDay = null;
    private static final Logger LOGGER = Logger.getLogger(MonthDayCommandRestController.class.getName());
    
}
