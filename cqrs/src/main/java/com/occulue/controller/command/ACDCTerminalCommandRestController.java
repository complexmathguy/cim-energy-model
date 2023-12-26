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
 * Implements Spring Controller command CQRS processing for entity ACDCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCTerminal")
public class ACDCTerminalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ACDCTerminal.  if not key provided, calls create, otherwise calls save
     * @param		ACDCTerminal	aCDCTerminal
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateACDCTerminalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ACDCTerminalBusinessDelegate.getACDCTerminalInstance().createACDCTerminal( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ACDCTerminal.  if no key provided, calls create, otherwise calls save
     * @param		ACDCTerminal aCDCTerminal
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateACDCTerminalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateACDCTerminalCommand
			// -----------------------------------------------
			completableFuture = ACDCTerminalBusinessDelegate.getACDCTerminalInstance().updateACDCTerminal(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ACDCTerminalController:update() - successfully update ACDCTerminal - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ACDCTerminal entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID aCDCTerminalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteACDCTerminalCommand command = new DeleteACDCTerminalCommand( aCDCTerminalId );

    	try {
        	ACDCTerminalBusinessDelegate delegate = ACDCTerminalBusinessDelegate.getACDCTerminalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ACDCTerminal with key " + command.getACDCTerminalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ACDCTerminal aCDCTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(ACDCTerminalCommandRestController.class.getName());
    
}
