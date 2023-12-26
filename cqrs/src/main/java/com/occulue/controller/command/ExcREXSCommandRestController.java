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
 * Implements Spring Controller command CQRS processing for entity ExcREXS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcREXS")
public class ExcREXSCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcREXS.  if not key provided, calls create, otherwise calls save
     * @param		ExcREXS	excREXS
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcREXSCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcREXSBusinessDelegate.getExcREXSInstance().createExcREXS( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcREXS.  if no key provided, calls create, otherwise calls save
     * @param		ExcREXS excREXS
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcREXSCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcREXSCommand
			// -----------------------------------------------
			completableFuture = ExcREXSBusinessDelegate.getExcREXSInstance().updateExcREXS(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcREXSController:update() - successfully update ExcREXS - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcREXS entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excREXSId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcREXSCommand command = new DeleteExcREXSCommand( excREXSId );

    	try {
        	ExcREXSBusinessDelegate delegate = ExcREXSBusinessDelegate.getExcREXSInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcREXS with key " + command.getExcREXSId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcREXS excREXS = null;
    private static final Logger LOGGER = Logger.getLogger(ExcREXSCommandRestController.class.getName());
    
}
