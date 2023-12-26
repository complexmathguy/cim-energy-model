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
 * Implements Spring Controller command CQRS processing for entity WindPitchContEmulIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPitchContEmulIEC")
public class WindPitchContEmulIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindPitchContEmulIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindPitchContEmulIEC	windPitchContEmulIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindPitchContEmulIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().createWindPitchContEmulIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindPitchContEmulIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindPitchContEmulIEC windPitchContEmulIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindPitchContEmulIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindPitchContEmulIECCommand
			// -----------------------------------------------
			completableFuture = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().updateWindPitchContEmulIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindPitchContEmulIECController:update() - successfully update WindPitchContEmulIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindPitchContEmulIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windPitchContEmulIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindPitchContEmulIECCommand command = new DeleteWindPitchContEmulIECCommand( windPitchContEmulIECId );

    	try {
        	WindPitchContEmulIECBusinessDelegate delegate = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindPitchContEmulIEC with key " + command.getWindPitchContEmulIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPitchContEmulIEC windPitchContEmulIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPitchContEmulIECCommandRestController.class.getName());
    
}
