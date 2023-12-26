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
 * Implements Spring Controller command CQRS processing for entity TapChangerControl.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChangerControl")
public class TapChangerControlCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TapChangerControl.  if not key provided, calls create, otherwise calls save
     * @param		TapChangerControl	tapChangerControl
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTapChangerControlCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TapChangerControlBusinessDelegate.getTapChangerControlInstance().createTapChangerControl( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TapChangerControl.  if no key provided, calls create, otherwise calls save
     * @param		TapChangerControl tapChangerControl
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTapChangerControlCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTapChangerControlCommand
			// -----------------------------------------------
			completableFuture = TapChangerControlBusinessDelegate.getTapChangerControlInstance().updateTapChangerControl(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TapChangerControlController:update() - successfully update TapChangerControl - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TapChangerControl entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID tapChangerControlId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTapChangerControlCommand command = new DeleteTapChangerControlCommand( tapChangerControlId );

    	try {
        	TapChangerControlBusinessDelegate delegate = TapChangerControlBusinessDelegate.getTapChangerControlInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TapChangerControl with key " + command.getTapChangerControlId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TapChangerControl tapChangerControl = null;
    private static final Logger LOGGER = Logger.getLogger(TapChangerControlCommandRestController.class.getName());
    
}
