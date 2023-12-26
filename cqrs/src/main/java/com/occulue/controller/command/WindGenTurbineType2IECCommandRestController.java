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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType2IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType2IEC")
public class WindGenTurbineType2IECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGenTurbineType2IEC.  if not key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType2IEC	windGenTurbineType2IEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGenTurbineType2IECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().createWindGenTurbineType2IEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGenTurbineType2IEC.  if no key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType2IEC windGenTurbineType2IEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGenTurbineType2IECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGenTurbineType2IECCommand
			// -----------------------------------------------
			completableFuture = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().updateWindGenTurbineType2IEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGenTurbineType2IECController:update() - successfully update WindGenTurbineType2IEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGenTurbineType2IEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGenTurbineType2IECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGenTurbineType2IECCommand command = new DeleteWindGenTurbineType2IECCommand( windGenTurbineType2IECId );

    	try {
        	WindGenTurbineType2IECBusinessDelegate delegate = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGenTurbineType2IEC with key " + command.getWindGenTurbineType2IECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType2IEC windGenTurbineType2IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType2IECCommandRestController.class.getName());
    
}
