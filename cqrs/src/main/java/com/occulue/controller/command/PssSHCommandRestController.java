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
 * Implements Spring Controller command CQRS processing for entity PssSH.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSH")
public class PssSHCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssSH.  if not key provided, calls create, otherwise calls save
     * @param		PssSH	pssSH
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssSHCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssSHBusinessDelegate.getPssSHInstance().createPssSH( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssSH.  if no key provided, calls create, otherwise calls save
     * @param		PssSH pssSH
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssSHCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssSHCommand
			// -----------------------------------------------
			completableFuture = PssSHBusinessDelegate.getPssSHInstance().updatePssSH(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssSHController:update() - successfully update PssSH - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssSH entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssSHId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssSHCommand command = new DeletePssSHCommand( pssSHId );

    	try {
        	PssSHBusinessDelegate delegate = PssSHBusinessDelegate.getPssSHInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssSH with key " + command.getPssSHId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssSH pssSH = null;
    private static final Logger LOGGER = Logger.getLogger(PssSHCommandRestController.class.getName());
    
}
