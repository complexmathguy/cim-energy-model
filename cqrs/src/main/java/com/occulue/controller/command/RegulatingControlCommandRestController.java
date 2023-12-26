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
 * Implements Spring Controller command CQRS processing for entity RegulatingControl.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegulatingControl")
public class RegulatingControlCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RegulatingControl.  if not key provided, calls create, otherwise calls save
     * @param		RegulatingControl	regulatingControl
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRegulatingControlCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RegulatingControlBusinessDelegate.getRegulatingControlInstance().createRegulatingControl( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RegulatingControl.  if no key provided, calls create, otherwise calls save
     * @param		RegulatingControl regulatingControl
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRegulatingControlCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRegulatingControlCommand
			// -----------------------------------------------
			completableFuture = RegulatingControlBusinessDelegate.getRegulatingControlInstance().updateRegulatingControl(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RegulatingControlController:update() - successfully update RegulatingControl - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RegulatingControl entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID regulatingControlId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRegulatingControlCommand command = new DeleteRegulatingControlCommand( regulatingControlId );

    	try {
        	RegulatingControlBusinessDelegate delegate = RegulatingControlBusinessDelegate.getRegulatingControlInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RegulatingControl with key " + command.getRegulatingControlId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RegulatingControl regulatingControl = null;
    private static final Logger LOGGER = Logger.getLogger(RegulatingControlCommandRestController.class.getName());
    
}
