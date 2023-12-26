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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType4bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType4bIEC")
public class WindTurbineType4bIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindTurbineType4bIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindTurbineType4bIEC	windTurbineType4bIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindTurbineType4bIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().createWindTurbineType4bIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindTurbineType4bIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindTurbineType4bIEC windTurbineType4bIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindTurbineType4bIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindTurbineType4bIECCommand
			// -----------------------------------------------
			completableFuture = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().updateWindTurbineType4bIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindTurbineType4bIECController:update() - successfully update WindTurbineType4bIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindTurbineType4bIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windTurbineType4bIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindTurbineType4bIECCommand command = new DeleteWindTurbineType4bIECCommand( windTurbineType4bIECId );

    	try {
        	WindTurbineType4bIECBusinessDelegate delegate = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindTurbineType4bIEC with key " + command.getWindTurbineType4bIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType4bIEC windTurbineType4bIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType4bIECCommandRestController.class.getName());
    
}
