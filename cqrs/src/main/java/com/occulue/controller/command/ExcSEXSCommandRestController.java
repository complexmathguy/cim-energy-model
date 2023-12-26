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
 * Implements Spring Controller command CQRS processing for entity ExcSEXS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSEXS")
public class ExcSEXSCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcSEXS.  if not key provided, calls create, otherwise calls save
     * @param		ExcSEXS	excSEXS
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcSEXSCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcSEXSBusinessDelegate.getExcSEXSInstance().createExcSEXS( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcSEXS.  if no key provided, calls create, otherwise calls save
     * @param		ExcSEXS excSEXS
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcSEXSCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcSEXSCommand
			// -----------------------------------------------
			completableFuture = ExcSEXSBusinessDelegate.getExcSEXSInstance().updateExcSEXS(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcSEXSController:update() - successfully update ExcSEXS - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcSEXS entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excSEXSId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcSEXSCommand command = new DeleteExcSEXSCommand( excSEXSId );

    	try {
        	ExcSEXSBusinessDelegate delegate = ExcSEXSBusinessDelegate.getExcSEXSInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcSEXS with key " + command.getExcSEXSId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcSEXS excSEXS = null;
    private static final Logger LOGGER = Logger.getLogger(ExcSEXSCommandRestController.class.getName());
    
}
