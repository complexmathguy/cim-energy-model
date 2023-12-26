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
 * Implements Spring Controller command CQRS processing for entity DCSeriesDevice.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCSeriesDevice")
public class DCSeriesDeviceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCSeriesDevice.  if not key provided, calls create, otherwise calls save
     * @param		DCSeriesDevice	dCSeriesDevice
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCSeriesDeviceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().createDCSeriesDevice( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCSeriesDevice.  if no key provided, calls create, otherwise calls save
     * @param		DCSeriesDevice dCSeriesDevice
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCSeriesDeviceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCSeriesDeviceCommand
			// -----------------------------------------------
			completableFuture = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().updateDCSeriesDevice(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCSeriesDeviceController:update() - successfully update DCSeriesDevice - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCSeriesDevice entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCSeriesDeviceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCSeriesDeviceCommand command = new DeleteDCSeriesDeviceCommand( dCSeriesDeviceId );

    	try {
        	DCSeriesDeviceBusinessDelegate delegate = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCSeriesDevice with key " + command.getDCSeriesDeviceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCSeriesDevice dCSeriesDevice = null;
    private static final Logger LOGGER = Logger.getLogger(DCSeriesDeviceCommandRestController.class.getName());
    
}
