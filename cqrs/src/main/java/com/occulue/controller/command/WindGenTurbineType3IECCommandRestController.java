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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType3IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3IEC")
public class WindGenTurbineType3IECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGenTurbineType3IEC.  if not key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType3IEC	windGenTurbineType3IEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGenTurbineType3IECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance().createWindGenTurbineType3IEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGenTurbineType3IEC.  if no key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType3IEC windGenTurbineType3IEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGenTurbineType3IECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGenTurbineType3IECCommand
			// -----------------------------------------------
			completableFuture = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance().updateWindGenTurbineType3IEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGenTurbineType3IECController:update() - successfully update WindGenTurbineType3IEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGenTurbineType3IEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGenTurbineType3IECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGenTurbineType3IECCommand command = new DeleteWindGenTurbineType3IECCommand( windGenTurbineType3IECId );

    	try {
        	WindGenTurbineType3IECBusinessDelegate delegate = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGenTurbineType3IEC with key " + command.getWindGenTurbineType3IECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType3IEC windGenTurbineType3IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType3IECCommandRestController.class.getName());
    
}
