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
 * Implements Spring Controller command CQRS processing for entity WindContPitchAngleIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPitchAngleIEC")
public class WindContPitchAngleIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindContPitchAngleIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindContPitchAngleIEC	windContPitchAngleIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindContPitchAngleIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().createWindContPitchAngleIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindContPitchAngleIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindContPitchAngleIEC windContPitchAngleIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindContPitchAngleIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindContPitchAngleIECCommand
			// -----------------------------------------------
			completableFuture = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().updateWindContPitchAngleIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindContPitchAngleIECController:update() - successfully update WindContPitchAngleIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindContPitchAngleIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windContPitchAngleIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindContPitchAngleIECCommand command = new DeleteWindContPitchAngleIECCommand( windContPitchAngleIECId );

    	try {
        	WindContPitchAngleIECBusinessDelegate delegate = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindContPitchAngleIEC with key " + command.getWindContPitchAngleIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPitchAngleIEC windContPitchAngleIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPitchAngleIECCommandRestController.class.getName());
    
}
