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
 * Implements Spring Controller command CQRS processing for entity SwitchIt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SwitchIt")
public class SwitchItCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SwitchIt.  if not key provided, calls create, otherwise calls save
     * @param		SwitchIt	switchIt
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSwitchItCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SwitchItBusinessDelegate.getSwitchItInstance().createSwitchIt( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SwitchIt.  if no key provided, calls create, otherwise calls save
     * @param		SwitchIt switchIt
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSwitchItCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSwitchItCommand
			// -----------------------------------------------
			completableFuture = SwitchItBusinessDelegate.getSwitchItInstance().updateSwitchIt(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SwitchItController:update() - successfully update SwitchIt - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SwitchIt entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID switchItId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSwitchItCommand command = new DeleteSwitchItCommand( switchItId );

    	try {
        	SwitchItBusinessDelegate delegate = SwitchItBusinessDelegate.getSwitchItInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SwitchIt with key " + command.getSwitchItId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SwitchIt switchIt = null;
    private static final Logger LOGGER = Logger.getLogger(SwitchItCommandRestController.class.getName());
    
}
