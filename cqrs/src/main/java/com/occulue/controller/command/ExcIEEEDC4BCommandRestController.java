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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC4B")
public class ExcIEEEDC4BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEDC4B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC4B	excIEEEDC4B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEDC4BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().createExcIEEEDC4B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEDC4B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC4B excIEEEDC4B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEDC4BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEDC4BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().updateExcIEEEDC4B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEDC4BController:update() - successfully update ExcIEEEDC4B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEDC4B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEDC4BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEDC4BCommand command = new DeleteExcIEEEDC4BCommand( excIEEEDC4BId );

    	try {
        	ExcIEEEDC4BBusinessDelegate delegate = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEDC4B with key " + command.getExcIEEEDC4BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC4B excIEEEDC4B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC4BCommandRestController.class.getName());
    
}
