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
 * Implements Spring Controller command CQRS processing for entity Junction.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Junction")
public class JunctionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Junction.  if not key provided, calls create, otherwise calls save
     * @param		Junction	junction
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateJunctionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = JunctionBusinessDelegate.getJunctionInstance().createJunction( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Junction.  if no key provided, calls create, otherwise calls save
     * @param		Junction junction
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateJunctionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateJunctionCommand
			// -----------------------------------------------
			completableFuture = JunctionBusinessDelegate.getJunctionInstance().updateJunction(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "JunctionController:update() - successfully update Junction - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Junction entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID junctionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteJunctionCommand command = new DeleteJunctionCommand( junctionId );

    	try {
        	JunctionBusinessDelegate delegate = JunctionBusinessDelegate.getJunctionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Junction with key " + command.getJunctionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Junction junction = null;
    private static final Logger LOGGER = Logger.getLogger(JunctionCommandRestController.class.getName());
    
}
