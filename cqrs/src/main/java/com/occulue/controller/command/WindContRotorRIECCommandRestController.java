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
 * Implements Spring Controller command CQRS processing for entity WindContRotorRIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContRotorRIEC")
public class WindContRotorRIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindContRotorRIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindContRotorRIEC	windContRotorRIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindContRotorRIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().createWindContRotorRIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindContRotorRIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindContRotorRIEC windContRotorRIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindContRotorRIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindContRotorRIECCommand
			// -----------------------------------------------
			completableFuture = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().updateWindContRotorRIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindContRotorRIECController:update() - successfully update WindContRotorRIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindContRotorRIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windContRotorRIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindContRotorRIECCommand command = new DeleteWindContRotorRIECCommand( windContRotorRIECId );

    	try {
        	WindContRotorRIECBusinessDelegate delegate = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindContRotorRIEC with key " + command.getWindContRotorRIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContRotorRIEC windContRotorRIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContRotorRIECCommandRestController.class.getName());
    
}
