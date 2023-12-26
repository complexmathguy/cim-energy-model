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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC2A")
public class ExcIEEEDC2ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEDC2A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC2A	excIEEEDC2A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEDC2ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().createExcIEEEDC2A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEDC2A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC2A excIEEEDC2A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEDC2ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEDC2ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().updateExcIEEEDC2A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEDC2AController:update() - successfully update ExcIEEEDC2A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEDC2A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEDC2AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEDC2ACommand command = new DeleteExcIEEEDC2ACommand( excIEEEDC2AId );

    	try {
        	ExcIEEEDC2ABusinessDelegate delegate = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEDC2A with key " + command.getExcIEEEDC2AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC2A excIEEEDC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC2ACommandRestController.class.getName());
    
}
