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
 * Implements Spring Controller command CQRS processing for entity PowerTransformerEnd.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerTransformerEnd")
public class PowerTransformerEndCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PowerTransformerEnd.  if not key provided, calls create, otherwise calls save
     * @param		PowerTransformerEnd	powerTransformerEnd
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePowerTransformerEndCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().createPowerTransformerEnd( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PowerTransformerEnd.  if no key provided, calls create, otherwise calls save
     * @param		PowerTransformerEnd powerTransformerEnd
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePowerTransformerEndCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePowerTransformerEndCommand
			// -----------------------------------------------
			completableFuture = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().updatePowerTransformerEnd(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PowerTransformerEndController:update() - successfully update PowerTransformerEnd - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PowerTransformerEnd entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID powerTransformerEndId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePowerTransformerEndCommand command = new DeletePowerTransformerEndCommand( powerTransformerEndId );

    	try {
        	PowerTransformerEndBusinessDelegate delegate = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PowerTransformerEnd with key " + command.getPowerTransformerEndId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PowerTransformerEnd powerTransformerEnd = null;
    private static final Logger LOGGER = Logger.getLogger(PowerTransformerEndCommandRestController.class.getName());
    
}
