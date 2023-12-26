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
 * Implements Spring Controller command CQRS processing for entity ENTSOEJunction.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEJunction")
public class ENTSOEJunctionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ENTSOEJunction.  if not key provided, calls create, otherwise calls save
     * @param		ENTSOEJunction	eNTSOEJunction
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateENTSOEJunctionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().createENTSOEJunction( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ENTSOEJunction.  if no key provided, calls create, otherwise calls save
     * @param		ENTSOEJunction eNTSOEJunction
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateENTSOEJunctionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateENTSOEJunctionCommand
			// -----------------------------------------------
			completableFuture = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().updateENTSOEJunction(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ENTSOEJunctionController:update() - successfully update ENTSOEJunction - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ENTSOEJunction entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID eNTSOEJunctionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteENTSOEJunctionCommand command = new DeleteENTSOEJunctionCommand( eNTSOEJunctionId );

    	try {
        	ENTSOEJunctionBusinessDelegate delegate = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ENTSOEJunction with key " + command.getENTSOEJunctionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEJunction eNTSOEJunction = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEJunctionCommandRestController.class.getName());
    
}
