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
 * Implements Spring Controller command CQRS processing for entity Money.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Money")
public class MoneyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Money.  if not key provided, calls create, otherwise calls save
     * @param		Money	money
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMoneyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MoneyBusinessDelegate.getMoneyInstance().createMoney( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Money.  if no key provided, calls create, otherwise calls save
     * @param		Money money
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMoneyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMoneyCommand
			// -----------------------------------------------
			completableFuture = MoneyBusinessDelegate.getMoneyInstance().updateMoney(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MoneyController:update() - successfully update Money - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Money entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID moneyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMoneyCommand command = new DeleteMoneyCommand( moneyId );

    	try {
        	MoneyBusinessDelegate delegate = MoneyBusinessDelegate.getMoneyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Money with key " + command.getMoneyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Money money = null;
    private static final Logger LOGGER = Logger.getLogger(MoneyCommandRestController.class.getName());
    
}
