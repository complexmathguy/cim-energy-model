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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimX2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimX2")
public class UnderexcLimX2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a UnderexcLimX2.  if not key provided, calls create, otherwise calls save
     * @param		UnderexcLimX2	underexcLimX2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateUnderexcLimX2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().createUnderexcLimX2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a UnderexcLimX2.  if no key provided, calls create, otherwise calls save
     * @param		UnderexcLimX2 underexcLimX2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateUnderexcLimX2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateUnderexcLimX2Command
			// -----------------------------------------------
			completableFuture = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().updateUnderexcLimX2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "UnderexcLimX2Controller:update() - successfully update UnderexcLimX2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a UnderexcLimX2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID underexcLimX2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteUnderexcLimX2Command command = new DeleteUnderexcLimX2Command( underexcLimX2Id );

    	try {
        	UnderexcLimX2BusinessDelegate delegate = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted UnderexcLimX2 with key " + command.getUnderexcLimX2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimX2 underexcLimX2 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimX2CommandRestController.class.getName());
    
}
