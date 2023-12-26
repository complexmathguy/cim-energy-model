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
 * Implements Spring Controller command CQRS processing for entity DCBaseTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCBaseTerminal")
public class DCBaseTerminalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCBaseTerminal.  if not key provided, calls create, otherwise calls save
     * @param		DCBaseTerminal	dCBaseTerminal
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCBaseTerminalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance().createDCBaseTerminal( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCBaseTerminal.  if no key provided, calls create, otherwise calls save
     * @param		DCBaseTerminal dCBaseTerminal
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCBaseTerminalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCBaseTerminalCommand
			// -----------------------------------------------
			completableFuture = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance().updateDCBaseTerminal(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCBaseTerminalController:update() - successfully update DCBaseTerminal - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCBaseTerminal entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCBaseTerminalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCBaseTerminalCommand command = new DeleteDCBaseTerminalCommand( dCBaseTerminalId );

    	try {
        	DCBaseTerminalBusinessDelegate delegate = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCBaseTerminal with key " + command.getDCBaseTerminalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCBaseTerminal dCBaseTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(DCBaseTerminalCommandRestController.class.getName());
    
}
