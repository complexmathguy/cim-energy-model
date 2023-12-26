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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC1A")
public class ExcIEEEDC1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEDC1A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC1A	excIEEEDC1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEDC1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().createExcIEEEDC1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEDC1A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEDC1A excIEEEDC1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEDC1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEDC1ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().updateExcIEEEDC1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEDC1AController:update() - successfully update ExcIEEEDC1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEDC1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEDC1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEDC1ACommand command = new DeleteExcIEEEDC1ACommand( excIEEEDC1AId );

    	try {
        	ExcIEEEDC1ABusinessDelegate delegate = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEDC1A with key " + command.getExcIEEEDC1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC1A excIEEEDC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC1ACommandRestController.class.getName());
    
}
