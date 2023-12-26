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
 * Implements Spring Controller command CQRS processing for entity RatioTapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChangerTablePoint")
public class RatioTapChangerTablePointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RatioTapChangerTablePoint.  if not key provided, calls create, otherwise calls save
     * @param		RatioTapChangerTablePoint	ratioTapChangerTablePoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRatioTapChangerTablePointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().createRatioTapChangerTablePoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RatioTapChangerTablePoint.  if no key provided, calls create, otherwise calls save
     * @param		RatioTapChangerTablePoint ratioTapChangerTablePoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRatioTapChangerTablePointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRatioTapChangerTablePointCommand
			// -----------------------------------------------
			completableFuture = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().updateRatioTapChangerTablePoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RatioTapChangerTablePointController:update() - successfully update RatioTapChangerTablePoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RatioTapChangerTablePoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID ratioTapChangerTablePointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRatioTapChangerTablePointCommand command = new DeleteRatioTapChangerTablePointCommand( ratioTapChangerTablePointId );

    	try {
        	RatioTapChangerTablePointBusinessDelegate delegate = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RatioTapChangerTablePoint with key " + command.getRatioTapChangerTablePointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RatioTapChangerTablePoint ratioTapChangerTablePoint = null;
    private static final Logger LOGGER = Logger.getLogger(RatioTapChangerTablePointCommandRestController.class.getName());
    
}
