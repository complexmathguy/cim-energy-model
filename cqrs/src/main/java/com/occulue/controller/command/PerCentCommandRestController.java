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
 * Implements Spring Controller command CQRS processing for entity PerCent.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PerCent")
public class PerCentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PerCent.  if not key provided, calls create, otherwise calls save
     * @param		PerCent	perCent
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePerCentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PerCentBusinessDelegate.getPerCentInstance().createPerCent( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PerCent.  if no key provided, calls create, otherwise calls save
     * @param		PerCent perCent
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePerCentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePerCentCommand
			// -----------------------------------------------
			completableFuture = PerCentBusinessDelegate.getPerCentInstance().updatePerCent(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PerCentController:update() - successfully update PerCent - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PerCent entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID perCentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePerCentCommand command = new DeletePerCentCommand( perCentId );

    	try {
        	PerCentBusinessDelegate delegate = PerCentBusinessDelegate.getPerCentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PerCent with key " + command.getPerCentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PerCent perCent = null;
    private static final Logger LOGGER = Logger.getLogger(PerCentCommandRestController.class.getName());
    
}
