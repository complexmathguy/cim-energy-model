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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType1IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType1IEC")
public class WindGenTurbineType1IECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGenTurbineType1IEC.  if not key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType1IEC	windGenTurbineType1IEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGenTurbineType1IECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().createWindGenTurbineType1IEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGenTurbineType1IEC.  if no key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType1IEC windGenTurbineType1IEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGenTurbineType1IECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGenTurbineType1IECCommand
			// -----------------------------------------------
			completableFuture = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().updateWindGenTurbineType1IEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGenTurbineType1IECController:update() - successfully update WindGenTurbineType1IEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGenTurbineType1IEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGenTurbineType1IECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGenTurbineType1IECCommand command = new DeleteWindGenTurbineType1IECCommand( windGenTurbineType1IECId );

    	try {
        	WindGenTurbineType1IECBusinessDelegate delegate = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGenTurbineType1IEC with key " + command.getWindGenTurbineType1IECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType1IEC windGenTurbineType1IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType1IECCommandRestController.class.getName());
    
}
