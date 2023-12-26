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
 * Implements Spring Controller command CQRS processing for entity RatioTapChangerTable.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChangerTable")
public class RatioTapChangerTableCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RatioTapChangerTable.  if not key provided, calls create, otherwise calls save
     * @param		RatioTapChangerTable	ratioTapChangerTable
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRatioTapChangerTableCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance().createRatioTapChangerTable( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RatioTapChangerTable.  if no key provided, calls create, otherwise calls save
     * @param		RatioTapChangerTable ratioTapChangerTable
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRatioTapChangerTableCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRatioTapChangerTableCommand
			// -----------------------------------------------
			completableFuture = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance().updateRatioTapChangerTable(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RatioTapChangerTableController:update() - successfully update RatioTapChangerTable - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RatioTapChangerTable entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID ratioTapChangerTableId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRatioTapChangerTableCommand command = new DeleteRatioTapChangerTableCommand( ratioTapChangerTableId );

    	try {
        	RatioTapChangerTableBusinessDelegate delegate = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RatioTapChangerTable with key " + command.getRatioTapChangerTableId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RatioTapChangerTable ratioTapChangerTable = null;
    private static final Logger LOGGER = Logger.getLogger(RatioTapChangerTableCommandRestController.class.getName());
    
}
