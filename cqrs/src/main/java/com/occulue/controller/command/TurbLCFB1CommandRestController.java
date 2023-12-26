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
 * Implements Spring Controller command CQRS processing for entity TurbLCFB1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbLCFB1")
public class TurbLCFB1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TurbLCFB1.  if not key provided, calls create, otherwise calls save
     * @param		TurbLCFB1	turbLCFB1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTurbLCFB1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().createTurbLCFB1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TurbLCFB1.  if no key provided, calls create, otherwise calls save
     * @param		TurbLCFB1 turbLCFB1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTurbLCFB1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTurbLCFB1Command
			// -----------------------------------------------
			completableFuture = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().updateTurbLCFB1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TurbLCFB1Controller:update() - successfully update TurbLCFB1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TurbLCFB1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID turbLCFB1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTurbLCFB1Command command = new DeleteTurbLCFB1Command( turbLCFB1Id );

    	try {
        	TurbLCFB1BusinessDelegate delegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TurbLCFB1 with key " + command.getTurbLCFB1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbLCFB1 turbLCFB1 = null;
    private static final Logger LOGGER = Logger.getLogger(TurbLCFB1CommandRestController.class.getName());
    
}
