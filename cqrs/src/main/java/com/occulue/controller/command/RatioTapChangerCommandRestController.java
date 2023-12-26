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
 * Implements Spring Controller command CQRS processing for entity RatioTapChanger.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChanger")
public class RatioTapChangerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RatioTapChanger.  if not key provided, calls create, otherwise calls save
     * @param		RatioTapChanger	ratioTapChanger
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRatioTapChangerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().createRatioTapChanger( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RatioTapChanger.  if no key provided, calls create, otherwise calls save
     * @param		RatioTapChanger ratioTapChanger
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRatioTapChangerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRatioTapChangerCommand
			// -----------------------------------------------
			completableFuture = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().updateRatioTapChanger(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RatioTapChangerController:update() - successfully update RatioTapChanger - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RatioTapChanger entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID ratioTapChangerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRatioTapChangerCommand command = new DeleteRatioTapChangerCommand( ratioTapChangerId );

    	try {
        	RatioTapChangerBusinessDelegate delegate = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RatioTapChanger with key " + command.getRatioTapChangerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RatioTapChanger ratioTapChanger = null;
    private static final Logger LOGGER = Logger.getLogger(RatioTapChangerCommandRestController.class.getName());
    
}
