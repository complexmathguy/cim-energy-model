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
 * Implements Spring Controller command CQRS processing for entity WindAeroLinearIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindAeroLinearIEC")
public class WindAeroLinearIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindAeroLinearIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindAeroLinearIEC	windAeroLinearIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindAeroLinearIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().createWindAeroLinearIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindAeroLinearIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindAeroLinearIEC windAeroLinearIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindAeroLinearIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindAeroLinearIECCommand
			// -----------------------------------------------
			completableFuture = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().updateWindAeroLinearIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindAeroLinearIECController:update() - successfully update WindAeroLinearIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindAeroLinearIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windAeroLinearIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindAeroLinearIECCommand command = new DeleteWindAeroLinearIECCommand( windAeroLinearIECId );

    	try {
        	WindAeroLinearIECBusinessDelegate delegate = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindAeroLinearIEC with key " + command.getWindAeroLinearIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindAeroLinearIEC windAeroLinearIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindAeroLinearIECCommandRestController.class.getName());
    
}
