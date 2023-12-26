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
 * Implements Spring Controller command CQRS processing for entity WindDynamicsLookupTable.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindDynamicsLookupTable")
public class WindDynamicsLookupTableCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindDynamicsLookupTable.  if not key provided, calls create, otherwise calls save
     * @param		WindDynamicsLookupTable	windDynamicsLookupTable
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindDynamicsLookupTableCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().createWindDynamicsLookupTable( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindDynamicsLookupTable.  if no key provided, calls create, otherwise calls save
     * @param		WindDynamicsLookupTable windDynamicsLookupTable
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindDynamicsLookupTableCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindDynamicsLookupTableCommand
			// -----------------------------------------------
			completableFuture = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().updateWindDynamicsLookupTable(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindDynamicsLookupTableController:update() - successfully update WindDynamicsLookupTable - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindDynamicsLookupTable entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windDynamicsLookupTableId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindDynamicsLookupTableCommand command = new DeleteWindDynamicsLookupTableCommand( windDynamicsLookupTableId );

    	try {
        	WindDynamicsLookupTableBusinessDelegate delegate = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindDynamicsLookupTable with key " + command.getWindDynamicsLookupTableId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindDynamicsLookupTable windDynamicsLookupTable = null;
    private static final Logger LOGGER = Logger.getLogger(WindDynamicsLookupTableCommandRestController.class.getName());
    
}
