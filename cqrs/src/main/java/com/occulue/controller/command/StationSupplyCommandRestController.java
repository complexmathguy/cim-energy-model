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
 * Implements Spring Controller command CQRS processing for entity StationSupply.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StationSupply")
public class StationSupplyCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a StationSupply.  if not key provided, calls create, otherwise calls save
     * @param		StationSupply	stationSupply
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStationSupplyCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StationSupplyBusinessDelegate.getStationSupplyInstance().createStationSupply( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a StationSupply.  if no key provided, calls create, otherwise calls save
     * @param		StationSupply stationSupply
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStationSupplyCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStationSupplyCommand
			// -----------------------------------------------
			completableFuture = StationSupplyBusinessDelegate.getStationSupplyInstance().updateStationSupply(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StationSupplyController:update() - successfully update StationSupply - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a StationSupply entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID stationSupplyId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStationSupplyCommand command = new DeleteStationSupplyCommand( stationSupplyId );

    	try {
        	StationSupplyBusinessDelegate delegate = StationSupplyBusinessDelegate.getStationSupplyInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted StationSupply with key " + command.getStationSupplyId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected StationSupply stationSupply = null;
    private static final Logger LOGGER = Logger.getLogger(StationSupplyCommandRestController.class.getName());
    
}
