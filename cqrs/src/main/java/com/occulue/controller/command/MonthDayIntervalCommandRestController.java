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
 * Implements Spring Controller command CQRS processing for entity MonthDayInterval.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MonthDayInterval")
public class MonthDayIntervalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MonthDayInterval.  if not key provided, calls create, otherwise calls save
     * @param		MonthDayInterval	monthDayInterval
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMonthDayIntervalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().createMonthDayInterval( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MonthDayInterval.  if no key provided, calls create, otherwise calls save
     * @param		MonthDayInterval monthDayInterval
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMonthDayIntervalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMonthDayIntervalCommand
			// -----------------------------------------------
			completableFuture = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().updateMonthDayInterval(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MonthDayIntervalController:update() - successfully update MonthDayInterval - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MonthDayInterval entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID monthDayIntervalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMonthDayIntervalCommand command = new DeleteMonthDayIntervalCommand( monthDayIntervalId );

    	try {
        	MonthDayIntervalBusinessDelegate delegate = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MonthDayInterval with key " + command.getMonthDayIntervalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MonthDayInterval monthDayInterval = null;
    private static final Logger LOGGER = Logger.getLogger(MonthDayIntervalCommandRestController.class.getName());
    
}
