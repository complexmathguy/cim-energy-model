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
 * Implements Spring Controller command CQRS processing for entity ValueAliasSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ValueAliasSet")
public class ValueAliasSetCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ValueAliasSet.  if not key provided, calls create, otherwise calls save
     * @param		ValueAliasSet	valueAliasSet
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateValueAliasSetCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ValueAliasSetBusinessDelegate.getValueAliasSetInstance().createValueAliasSet( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ValueAliasSet.  if no key provided, calls create, otherwise calls save
     * @param		ValueAliasSet valueAliasSet
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateValueAliasSetCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateValueAliasSetCommand
			// -----------------------------------------------
			completableFuture = ValueAliasSetBusinessDelegate.getValueAliasSetInstance().updateValueAliasSet(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ValueAliasSetController:update() - successfully update ValueAliasSet - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ValueAliasSet entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID valueAliasSetId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteValueAliasSetCommand command = new DeleteValueAliasSetCommand( valueAliasSetId );

    	try {
        	ValueAliasSetBusinessDelegate delegate = ValueAliasSetBusinessDelegate.getValueAliasSetInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ValueAliasSet with key " + command.getValueAliasSetId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ValueAliasSet valueAliasSet = null;
    private static final Logger LOGGER = Logger.getLogger(ValueAliasSetCommandRestController.class.getName());
    
}
