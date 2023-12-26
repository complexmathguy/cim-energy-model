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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC3A")
public class ExcIEEEDC3ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEDC3A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC3A	excIEEEDC3A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEDC3ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().createExcIEEEDC3A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEDC3A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC3A excIEEEDC3A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEDC3ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEDC3ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().updateExcIEEEDC3A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEDC3AController:update() - successfully update ExcIEEEDC3A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEDC3A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEDC3AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEDC3ACommand command = new DeleteExcIEEEDC3ACommand( excIEEEDC3AId );

    	try {
        	ExcIEEEDC3ABusinessDelegate delegate = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEDC3A with key " + command.getExcIEEEDC3AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC3A excIEEEDC3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC3ACommandRestController.class.getName());
    
}
