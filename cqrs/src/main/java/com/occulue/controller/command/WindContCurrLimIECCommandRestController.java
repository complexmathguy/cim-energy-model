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
 * Implements Spring Controller command CQRS processing for entity WindContCurrLimIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContCurrLimIEC")
public class WindContCurrLimIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindContCurrLimIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindContCurrLimIEC	windContCurrLimIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindContCurrLimIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().createWindContCurrLimIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindContCurrLimIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindContCurrLimIEC windContCurrLimIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindContCurrLimIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindContCurrLimIECCommand
			// -----------------------------------------------
			completableFuture = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().updateWindContCurrLimIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindContCurrLimIECController:update() - successfully update WindContCurrLimIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindContCurrLimIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windContCurrLimIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindContCurrLimIECCommand command = new DeleteWindContCurrLimIECCommand( windContCurrLimIECId );

    	try {
        	WindContCurrLimIECBusinessDelegate delegate = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindContCurrLimIEC with key " + command.getWindContCurrLimIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContCurrLimIEC windContCurrLimIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContCurrLimIECCommandRestController.class.getName());
    
}
