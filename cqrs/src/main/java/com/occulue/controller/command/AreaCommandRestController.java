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
 * Implements Spring Controller command CQRS processing for entity Area.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Area")
public class AreaCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Area.  if not key provided, calls create, otherwise calls save
     * @param		Area	area
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAreaCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AreaBusinessDelegate.getAreaInstance().createArea( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Area.  if no key provided, calls create, otherwise calls save
     * @param		Area area
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAreaCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAreaCommand
			// -----------------------------------------------
			completableFuture = AreaBusinessDelegate.getAreaInstance().updateArea(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AreaController:update() - successfully update Area - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Area entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID areaId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAreaCommand command = new DeleteAreaCommand( areaId );

    	try {
        	AreaBusinessDelegate delegate = AreaBusinessDelegate.getAreaInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Area with key " + command.getAreaId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Area area = null;
    private static final Logger LOGGER = Logger.getLogger(AreaCommandRestController.class.getName());
    
}
