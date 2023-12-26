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
 * Implements Spring Controller command CQRS processing for entity WindPlantFreqPcontrolIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantFreqPcontrolIEC")
public class WindPlantFreqPcontrolIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindPlantFreqPcontrolIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindPlantFreqPcontrolIEC	windPlantFreqPcontrolIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindPlantFreqPcontrolIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().createWindPlantFreqPcontrolIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindPlantFreqPcontrolIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindPlantFreqPcontrolIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindPlantFreqPcontrolIECCommand
			// -----------------------------------------------
			completableFuture = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().updateWindPlantFreqPcontrolIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindPlantFreqPcontrolIECController:update() - successfully update WindPlantFreqPcontrolIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindPlantFreqPcontrolIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windPlantFreqPcontrolIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindPlantFreqPcontrolIECCommand command = new DeleteWindPlantFreqPcontrolIECCommand( windPlantFreqPcontrolIECId );

    	try {
        	WindPlantFreqPcontrolIECBusinessDelegate delegate = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindPlantFreqPcontrolIEC with key " + command.getWindPlantFreqPcontrolIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantFreqPcontrolIECCommandRestController.class.getName());
    
}
