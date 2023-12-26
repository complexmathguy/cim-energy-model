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
 * Implements Spring Controller command CQRS processing for entity ExcSCRX.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSCRX")
public class ExcSCRXCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcSCRX.  if not key provided, calls create, otherwise calls save
     * @param		ExcSCRX	excSCRX
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcSCRXCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcSCRXBusinessDelegate.getExcSCRXInstance().createExcSCRX( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcSCRX.  if no key provided, calls create, otherwise calls save
     * @param		ExcSCRX excSCRX
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcSCRXCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcSCRXCommand
			// -----------------------------------------------
			completableFuture = ExcSCRXBusinessDelegate.getExcSCRXInstance().updateExcSCRX(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcSCRXController:update() - successfully update ExcSCRX - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcSCRX entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excSCRXId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcSCRXCommand command = new DeleteExcSCRXCommand( excSCRXId );

    	try {
        	ExcSCRXBusinessDelegate delegate = ExcSCRXBusinessDelegate.getExcSCRXInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcSCRX with key " + command.getExcSCRXId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcSCRX excSCRX = null;
    private static final Logger LOGGER = Logger.getLogger(ExcSCRXCommandRestController.class.getName());
    
}
