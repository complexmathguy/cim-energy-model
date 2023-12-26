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
 * Implements Spring Controller command CQRS processing for entity ACDCConverterDCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCConverterDCTerminal")
public class ACDCConverterDCTerminalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ACDCConverterDCTerminal.  if not key provided, calls create, otherwise calls save
     * @param		ACDCConverterDCTerminal	aCDCConverterDCTerminal
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateACDCConverterDCTerminalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().createACDCConverterDCTerminal( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ACDCConverterDCTerminal.  if no key provided, calls create, otherwise calls save
     * @param		ACDCConverterDCTerminal aCDCConverterDCTerminal
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateACDCConverterDCTerminalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateACDCConverterDCTerminalCommand
			// -----------------------------------------------
			completableFuture = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().updateACDCConverterDCTerminal(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ACDCConverterDCTerminalController:update() - successfully update ACDCConverterDCTerminal - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ACDCConverterDCTerminal entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID aCDCConverterDCTerminalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteACDCConverterDCTerminalCommand command = new DeleteACDCConverterDCTerminalCommand( aCDCConverterDCTerminalId );

    	try {
        	ACDCConverterDCTerminalBusinessDelegate delegate = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ACDCConverterDCTerminal with key " + command.getACDCConverterDCTerminalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ACDCConverterDCTerminal aCDCConverterDCTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(ACDCConverterDCTerminalCommandRestController.class.getName());
    
}
