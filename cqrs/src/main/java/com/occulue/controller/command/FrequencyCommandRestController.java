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
 * Implements Spring Controller command CQRS processing for entity Frequency.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Frequency")
public class FrequencyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Frequency.  if not key provided, calls create, otherwise calls save
     * @param		Frequency	frequency
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateFrequencyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = FrequencyBusinessDelegate.getFrequencyInstance().createFrequency( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Frequency.  if no key provided, calls create, otherwise calls save
     * @param		Frequency frequency
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateFrequencyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateFrequencyCommand
			// -----------------------------------------------
			completableFuture = FrequencyBusinessDelegate.getFrequencyInstance().updateFrequency(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "FrequencyController:update() - successfully update Frequency - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Frequency entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID frequencyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteFrequencyCommand command = new DeleteFrequencyCommand( frequencyId );

    	try {
        	FrequencyBusinessDelegate delegate = FrequencyBusinessDelegate.getFrequencyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Frequency with key " + command.getFrequencyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Frequency frequency = null;
    private static final Logger LOGGER = Logger.getLogger(FrequencyCommandRestController.class.getName());
    
}
