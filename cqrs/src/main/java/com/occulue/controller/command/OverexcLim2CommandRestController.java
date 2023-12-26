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
 * Implements Spring Controller command CQRS processing for entity OverexcLim2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLim2")
public class OverexcLim2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a OverexcLim2.  if not key provided, calls create, otherwise calls save
     * @param		OverexcLim2	overexcLim2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateOverexcLim2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = OverexcLim2BusinessDelegate.getOverexcLim2Instance().createOverexcLim2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a OverexcLim2.  if no key provided, calls create, otherwise calls save
     * @param		OverexcLim2 overexcLim2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateOverexcLim2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateOverexcLim2Command
			// -----------------------------------------------
			completableFuture = OverexcLim2BusinessDelegate.getOverexcLim2Instance().updateOverexcLim2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "OverexcLim2Controller:update() - successfully update OverexcLim2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a OverexcLim2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID overexcLim2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteOverexcLim2Command command = new DeleteOverexcLim2Command( overexcLim2Id );

    	try {
        	OverexcLim2BusinessDelegate delegate = OverexcLim2BusinessDelegate.getOverexcLim2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted OverexcLim2 with key " + command.getOverexcLim2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcLim2 overexcLim2 = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcLim2CommandRestController.class.getName());
    
}
