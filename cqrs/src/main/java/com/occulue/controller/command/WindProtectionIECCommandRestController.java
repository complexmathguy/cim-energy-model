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
 * Implements Spring Controller command CQRS processing for entity WindProtectionIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindProtectionIEC")
public class WindProtectionIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindProtectionIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindProtectionIEC	windProtectionIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindProtectionIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().createWindProtectionIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindProtectionIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindProtectionIEC windProtectionIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindProtectionIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindProtectionIECCommand
			// -----------------------------------------------
			completableFuture = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().updateWindProtectionIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindProtectionIECController:update() - successfully update WindProtectionIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindProtectionIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windProtectionIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindProtectionIECCommand command = new DeleteWindProtectionIECCommand( windProtectionIECId );

    	try {
        	WindProtectionIECBusinessDelegate delegate = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindProtectionIEC with key " + command.getWindProtectionIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindProtectionIEC windProtectionIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindProtectionIECCommandRestController.class.getName());
    
}
