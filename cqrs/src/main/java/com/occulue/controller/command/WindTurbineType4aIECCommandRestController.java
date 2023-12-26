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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType4aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType4aIEC")
public class WindTurbineType4aIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindTurbineType4aIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindTurbineType4aIEC	windTurbineType4aIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindTurbineType4aIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().createWindTurbineType4aIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindTurbineType4aIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindTurbineType4aIEC windTurbineType4aIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindTurbineType4aIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindTurbineType4aIECCommand
			// -----------------------------------------------
			completableFuture = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().updateWindTurbineType4aIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindTurbineType4aIECController:update() - successfully update WindTurbineType4aIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindTurbineType4aIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windTurbineType4aIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindTurbineType4aIECCommand command = new DeleteWindTurbineType4aIECCommand( windTurbineType4aIECId );

    	try {
        	WindTurbineType4aIECBusinessDelegate delegate = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindTurbineType4aIEC with key " + command.getWindTurbineType4aIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType4aIEC windTurbineType4aIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType4aIECCommandRestController.class.getName());
    
}
