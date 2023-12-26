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
 * Implements Spring Controller command CQRS processing for entity SvInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvInjection")
public class SvInjectionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SvInjection.  if not key provided, calls create, otherwise calls save
     * @param		SvInjection	svInjection
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSvInjectionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SvInjectionBusinessDelegate.getSvInjectionInstance().createSvInjection( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SvInjection.  if no key provided, calls create, otherwise calls save
     * @param		SvInjection svInjection
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSvInjectionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSvInjectionCommand
			// -----------------------------------------------
			completableFuture = SvInjectionBusinessDelegate.getSvInjectionInstance().updateSvInjection(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SvInjectionController:update() - successfully update SvInjection - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SvInjection entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID svInjectionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSvInjectionCommand command = new DeleteSvInjectionCommand( svInjectionId );

    	try {
        	SvInjectionBusinessDelegate delegate = SvInjectionBusinessDelegate.getSvInjectionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SvInjection with key " + command.getSvInjectionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SvInjection svInjection = null;
    private static final Logger LOGGER = Logger.getLogger(SvInjectionCommandRestController.class.getName());
    
}
