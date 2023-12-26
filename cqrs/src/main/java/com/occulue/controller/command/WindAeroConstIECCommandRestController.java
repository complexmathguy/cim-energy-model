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
 * Implements Spring Controller command CQRS processing for entity WindAeroConstIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindAeroConstIEC")
public class WindAeroConstIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindAeroConstIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindAeroConstIEC	windAeroConstIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindAeroConstIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().createWindAeroConstIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindAeroConstIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindAeroConstIEC windAeroConstIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindAeroConstIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindAeroConstIECCommand
			// -----------------------------------------------
			completableFuture = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().updateWindAeroConstIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindAeroConstIECController:update() - successfully update WindAeroConstIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindAeroConstIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windAeroConstIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindAeroConstIECCommand command = new DeleteWindAeroConstIECCommand( windAeroConstIECId );

    	try {
        	WindAeroConstIECBusinessDelegate delegate = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindAeroConstIEC with key " + command.getWindAeroConstIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindAeroConstIEC windAeroConstIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindAeroConstIECCommandRestController.class.getName());
    
}
