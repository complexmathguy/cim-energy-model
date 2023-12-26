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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType3bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3bIEC")
public class WindGenTurbineType3bIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGenTurbineType3bIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType3bIEC	windGenTurbineType3bIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGenTurbineType3bIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().createWindGenTurbineType3bIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGenTurbineType3bIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType3bIEC windGenTurbineType3bIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGenTurbineType3bIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGenTurbineType3bIECCommand
			// -----------------------------------------------
			completableFuture = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().updateWindGenTurbineType3bIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGenTurbineType3bIECController:update() - successfully update WindGenTurbineType3bIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGenTurbineType3bIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGenTurbineType3bIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGenTurbineType3bIECCommand command = new DeleteWindGenTurbineType3bIECCommand( windGenTurbineType3bIECId );

    	try {
        	WindGenTurbineType3bIECBusinessDelegate delegate = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGenTurbineType3bIEC with key " + command.getWindGenTurbineType3bIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType3bIEC windGenTurbineType3bIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType3bIECCommandRestController.class.getName());
    
}
