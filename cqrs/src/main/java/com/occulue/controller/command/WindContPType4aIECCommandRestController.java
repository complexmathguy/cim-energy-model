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
 * Implements Spring Controller command CQRS processing for entity WindContPType4aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType4aIEC")
public class WindContPType4aIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindContPType4aIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindContPType4aIEC	windContPType4aIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindContPType4aIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().createWindContPType4aIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindContPType4aIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindContPType4aIEC windContPType4aIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindContPType4aIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindContPType4aIECCommand
			// -----------------------------------------------
			completableFuture = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().updateWindContPType4aIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindContPType4aIECController:update() - successfully update WindContPType4aIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindContPType4aIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windContPType4aIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindContPType4aIECCommand command = new DeleteWindContPType4aIECCommand( windContPType4aIECId );

    	try {
        	WindContPType4aIECBusinessDelegate delegate = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindContPType4aIEC with key " + command.getWindContPType4aIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPType4aIEC windContPType4aIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPType4aIECCommandRestController.class.getName());
    
}
