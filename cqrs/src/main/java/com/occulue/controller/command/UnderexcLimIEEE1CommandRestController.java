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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimIEEE1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimIEEE1")
public class UnderexcLimIEEE1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a UnderexcLimIEEE1.  if not key provided, calls create, otherwise calls save
     * @param		UnderexcLimIEEE1	underexcLimIEEE1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateUnderexcLimIEEE1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().createUnderexcLimIEEE1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a UnderexcLimIEEE1.  if no key provided, calls create, otherwise calls save
     * @param		UnderexcLimIEEE1 underexcLimIEEE1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateUnderexcLimIEEE1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateUnderexcLimIEEE1Command
			// -----------------------------------------------
			completableFuture = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().updateUnderexcLimIEEE1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "UnderexcLimIEEE1Controller:update() - successfully update UnderexcLimIEEE1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a UnderexcLimIEEE1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID underexcLimIEEE1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteUnderexcLimIEEE1Command command = new DeleteUnderexcLimIEEE1Command( underexcLimIEEE1Id );

    	try {
        	UnderexcLimIEEE1BusinessDelegate delegate = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted UnderexcLimIEEE1 with key " + command.getUnderexcLimIEEE1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimIEEE1 underexcLimIEEE1 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE1CommandRestController.class.getName());
    
}
