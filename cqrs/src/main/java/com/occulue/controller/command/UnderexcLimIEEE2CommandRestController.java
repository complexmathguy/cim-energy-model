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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimIEEE2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimIEEE2")
public class UnderexcLimIEEE2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a UnderexcLimIEEE2.  if not key provided, calls create, otherwise calls save
     * @param		UnderexcLimIEEE2	underexcLimIEEE2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateUnderexcLimIEEE2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().createUnderexcLimIEEE2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a UnderexcLimIEEE2.  if no key provided, calls create, otherwise calls save
     * @param		UnderexcLimIEEE2 underexcLimIEEE2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateUnderexcLimIEEE2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateUnderexcLimIEEE2Command
			// -----------------------------------------------
			completableFuture = UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().updateUnderexcLimIEEE2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "UnderexcLimIEEE2Controller:update() - successfully update UnderexcLimIEEE2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a UnderexcLimIEEE2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID underexcLimIEEE2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteUnderexcLimIEEE2Command command = new DeleteUnderexcLimIEEE2Command( underexcLimIEEE2Id );

    	try {
        	UnderexcLimIEEE2BusinessDelegate delegate = UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted UnderexcLimIEEE2 with key " + command.getUnderexcLimIEEE2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimIEEE2 underexcLimIEEE2 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE2CommandRestController.class.getName());
    
}
