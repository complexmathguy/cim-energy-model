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
 * Implements Spring Controller command CQRS processing for entity DCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCTerminal")
public class DCTerminalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCTerminal.  if not key provided, calls create, otherwise calls save
     * @param		DCTerminal	dCTerminal
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCTerminalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCTerminalBusinessDelegate.getDCTerminalInstance().createDCTerminal( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCTerminal.  if no key provided, calls create, otherwise calls save
     * @param		DCTerminal dCTerminal
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCTerminalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCTerminalCommand
			// -----------------------------------------------
			completableFuture = DCTerminalBusinessDelegate.getDCTerminalInstance().updateDCTerminal(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCTerminalController:update() - successfully update DCTerminal - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCTerminal entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCTerminalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCTerminalCommand command = new DeleteDCTerminalCommand( dCTerminalId );

    	try {
        	DCTerminalBusinessDelegate delegate = DCTerminalBusinessDelegate.getDCTerminalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCTerminal with key " + command.getDCTerminalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCTerminal dCTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(DCTerminalCommandRestController.class.getName());
    
}
