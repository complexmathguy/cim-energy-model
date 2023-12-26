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
 * Implements Spring Controller command CQRS processing for entity OverexcLimX2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimX2")
public class OverexcLimX2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a OverexcLimX2.  if not key provided, calls create, otherwise calls save
     * @param		OverexcLimX2	overexcLimX2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateOverexcLimX2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().createOverexcLimX2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a OverexcLimX2.  if no key provided, calls create, otherwise calls save
     * @param		OverexcLimX2 overexcLimX2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateOverexcLimX2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateOverexcLimX2Command
			// -----------------------------------------------
			completableFuture = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().updateOverexcLimX2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "OverexcLimX2Controller:update() - successfully update OverexcLimX2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a OverexcLimX2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID overexcLimX2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteOverexcLimX2Command command = new DeleteOverexcLimX2Command( overexcLimX2Id );

    	try {
        	OverexcLimX2BusinessDelegate delegate = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted OverexcLimX2 with key " + command.getOverexcLimX2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcLimX2 overexcLimX2 = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcLimX2CommandRestController.class.getName());
    
}
