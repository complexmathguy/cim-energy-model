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
 * Implements Spring Controller command CQRS processing for entity WindContPType4bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType4bIEC")
public class WindContPType4bIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindContPType4bIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindContPType4bIEC	windContPType4bIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindContPType4bIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().createWindContPType4bIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindContPType4bIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindContPType4bIEC windContPType4bIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindContPType4bIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindContPType4bIECCommand
			// -----------------------------------------------
			completableFuture = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().updateWindContPType4bIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindContPType4bIECController:update() - successfully update WindContPType4bIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindContPType4bIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windContPType4bIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindContPType4bIECCommand command = new DeleteWindContPType4bIECCommand( windContPType4bIECId );

    	try {
        	WindContPType4bIECBusinessDelegate delegate = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindContPType4bIEC with key " + command.getWindContPType4bIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPType4bIEC windContPType4bIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPType4bIECCommandRestController.class.getName());
    
}
