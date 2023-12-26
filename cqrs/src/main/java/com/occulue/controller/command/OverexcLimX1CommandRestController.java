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
 * Implements Spring Controller command CQRS processing for entity OverexcLimX1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimX1")
public class OverexcLimX1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a OverexcLimX1.  if not key provided, calls create, otherwise calls save
     * @param		OverexcLimX1	overexcLimX1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateOverexcLimX1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().createOverexcLimX1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a OverexcLimX1.  if no key provided, calls create, otherwise calls save
     * @param		OverexcLimX1 overexcLimX1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateOverexcLimX1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateOverexcLimX1Command
			// -----------------------------------------------
			completableFuture = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().updateOverexcLimX1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "OverexcLimX1Controller:update() - successfully update OverexcLimX1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a OverexcLimX1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID overexcLimX1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteOverexcLimX1Command command = new DeleteOverexcLimX1Command( overexcLimX1Id );

    	try {
        	OverexcLimX1BusinessDelegate delegate = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted OverexcLimX1 with key " + command.getOverexcLimX1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcLimX1 overexcLimX1 = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcLimX1CommandRestController.class.getName());
    
}
