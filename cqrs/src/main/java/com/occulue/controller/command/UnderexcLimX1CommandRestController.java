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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimX1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimX1")
public class UnderexcLimX1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a UnderexcLimX1.  if not key provided, calls create, otherwise calls save
     * @param		UnderexcLimX1	underexcLimX1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateUnderexcLimX1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().createUnderexcLimX1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a UnderexcLimX1.  if no key provided, calls create, otherwise calls save
     * @param		UnderexcLimX1 underexcLimX1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateUnderexcLimX1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateUnderexcLimX1Command
			// -----------------------------------------------
			completableFuture = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().updateUnderexcLimX1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "UnderexcLimX1Controller:update() - successfully update UnderexcLimX1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a UnderexcLimX1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID underexcLimX1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteUnderexcLimX1Command command = new DeleteUnderexcLimX1Command( underexcLimX1Id );

    	try {
        	UnderexcLimX1BusinessDelegate delegate = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted UnderexcLimX1 with key " + command.getUnderexcLimX1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimX1 underexcLimX1 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimX1CommandRestController.class.getName());
    
}
