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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType3aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3aIEC")
public class WindGenTurbineType3aIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGenTurbineType3aIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType3aIEC	windGenTurbineType3aIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGenTurbineType3aIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().createWindGenTurbineType3aIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGenTurbineType3aIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindGenTurbineType3aIEC windGenTurbineType3aIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGenTurbineType3aIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGenTurbineType3aIECCommand
			// -----------------------------------------------
			completableFuture = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().updateWindGenTurbineType3aIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGenTurbineType3aIECController:update() - successfully update WindGenTurbineType3aIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGenTurbineType3aIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGenTurbineType3aIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGenTurbineType3aIECCommand command = new DeleteWindGenTurbineType3aIECCommand( windGenTurbineType3aIECId );

    	try {
        	WindGenTurbineType3aIECBusinessDelegate delegate = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGenTurbineType3aIEC with key " + command.getWindGenTurbineType3aIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType3aIEC windGenTurbineType3aIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType3aIECCommandRestController.class.getName());
    
}
