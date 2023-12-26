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
 * Implements Spring Controller command CQRS processing for entity WindGenType4IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenType4IEC")
public class WindGenType4IECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindGenType4IEC.  if not key provided, calls create, otherwise calls save
     * @param		WindGenType4IEC	windGenType4IEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindGenType4IECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().createWindGenType4IEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindGenType4IEC.  if no key provided, calls create, otherwise calls save
     * @param		WindGenType4IEC windGenType4IEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindGenType4IECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindGenType4IECCommand
			// -----------------------------------------------
			completableFuture = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().updateWindGenType4IEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindGenType4IECController:update() - successfully update WindGenType4IEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindGenType4IEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windGenType4IECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindGenType4IECCommand command = new DeleteWindGenType4IECCommand( windGenType4IECId );

    	try {
        	WindGenType4IECBusinessDelegate delegate = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindGenType4IEC with key " + command.getWindGenType4IECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenType4IEC windGenType4IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenType4IECCommandRestController.class.getName());
    
}
