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
 * Implements Spring Controller command CQRS processing for entity LoadGenericNonLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadGenericNonLinear")
public class LoadGenericNonLinearCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadGenericNonLinear.  if not key provided, calls create, otherwise calls save
     * @param		LoadGenericNonLinear	loadGenericNonLinear
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadGenericNonLinearCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().createLoadGenericNonLinear( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadGenericNonLinear.  if no key provided, calls create, otherwise calls save
     * @param		LoadGenericNonLinear loadGenericNonLinear
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadGenericNonLinearCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadGenericNonLinearCommand
			// -----------------------------------------------
			completableFuture = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().updateLoadGenericNonLinear(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadGenericNonLinearController:update() - successfully update LoadGenericNonLinear - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadGenericNonLinear entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadGenericNonLinearId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadGenericNonLinearCommand command = new DeleteLoadGenericNonLinearCommand( loadGenericNonLinearId );

    	try {
        	LoadGenericNonLinearBusinessDelegate delegate = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadGenericNonLinear with key " + command.getLoadGenericNonLinearId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadGenericNonLinear loadGenericNonLinear = null;
    private static final Logger LOGGER = Logger.getLogger(LoadGenericNonLinearCommandRestController.class.getName());
    
}
