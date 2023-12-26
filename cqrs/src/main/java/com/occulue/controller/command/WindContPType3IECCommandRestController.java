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
 * Implements Spring Controller command CQRS processing for entity WindContPType3IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType3IEC")
public class WindContPType3IECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindContPType3IEC.  if not key provided, calls create, otherwise calls save
     * @param		WindContPType3IEC	windContPType3IEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindContPType3IECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().createWindContPType3IEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindContPType3IEC.  if no key provided, calls create, otherwise calls save
     * @param		WindContPType3IEC windContPType3IEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindContPType3IECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindContPType3IECCommand
			// -----------------------------------------------
			completableFuture = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().updateWindContPType3IEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindContPType3IECController:update() - successfully update WindContPType3IEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindContPType3IEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windContPType3IECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindContPType3IECCommand command = new DeleteWindContPType3IECCommand( windContPType3IECId );

    	try {
        	WindContPType3IECBusinessDelegate delegate = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindContPType3IEC with key " + command.getWindContPType3IECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPType3IEC windContPType3IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPType3IECCommandRestController.class.getName());
    
}
