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
 * Implements Spring Controller command CQRS processing for entity DCDisconnector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCDisconnector")
public class DCDisconnectorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCDisconnector.  if not key provided, calls create, otherwise calls save
     * @param		DCDisconnector	dCDisconnector
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCDisconnectorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance().createDCDisconnector( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCDisconnector.  if no key provided, calls create, otherwise calls save
     * @param		DCDisconnector dCDisconnector
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCDisconnectorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCDisconnectorCommand
			// -----------------------------------------------
			completableFuture = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance().updateDCDisconnector(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCDisconnectorController:update() - successfully update DCDisconnector - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCDisconnector entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCDisconnectorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCDisconnectorCommand command = new DeleteDCDisconnectorCommand( dCDisconnectorId );

    	try {
        	DCDisconnectorBusinessDelegate delegate = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCDisconnector with key " + command.getDCDisconnectorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCDisconnector dCDisconnector = null;
    private static final Logger LOGGER = Logger.getLogger(DCDisconnectorCommandRestController.class.getName());
    
}
