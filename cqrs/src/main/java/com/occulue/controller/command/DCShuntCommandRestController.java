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
 * Implements Spring Controller command CQRS processing for entity DCShunt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCShunt")
public class DCShuntCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCShunt.  if not key provided, calls create, otherwise calls save
     * @param		DCShunt	dCShunt
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCShuntCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCShuntBusinessDelegate.getDCShuntInstance().createDCShunt( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCShunt.  if no key provided, calls create, otherwise calls save
     * @param		DCShunt dCShunt
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCShuntCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCShuntCommand
			// -----------------------------------------------
			completableFuture = DCShuntBusinessDelegate.getDCShuntInstance().updateDCShunt(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCShuntController:update() - successfully update DCShunt - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCShunt entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCShuntId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCShuntCommand command = new DeleteDCShuntCommand( dCShuntId );

    	try {
        	DCShuntBusinessDelegate delegate = DCShuntBusinessDelegate.getDCShuntInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCShunt with key " + command.getDCShuntId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCShunt dCShunt = null;
    private static final Logger LOGGER = Logger.getLogger(DCShuntCommandRestController.class.getName());
    
}
