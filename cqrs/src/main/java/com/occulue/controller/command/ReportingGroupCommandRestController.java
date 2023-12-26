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
 * Implements Spring Controller command CQRS processing for entity ReportingGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ReportingGroup")
public class ReportingGroupCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ReportingGroup.  if not key provided, calls create, otherwise calls save
     * @param		ReportingGroup	reportingGroup
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateReportingGroupCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ReportingGroupBusinessDelegate.getReportingGroupInstance().createReportingGroup( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ReportingGroup.  if no key provided, calls create, otherwise calls save
     * @param		ReportingGroup reportingGroup
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateReportingGroupCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateReportingGroupCommand
			// -----------------------------------------------
			completableFuture = ReportingGroupBusinessDelegate.getReportingGroupInstance().updateReportingGroup(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ReportingGroupController:update() - successfully update ReportingGroup - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ReportingGroup entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID reportingGroupId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteReportingGroupCommand command = new DeleteReportingGroupCommand( reportingGroupId );

    	try {
        	ReportingGroupBusinessDelegate delegate = ReportingGroupBusinessDelegate.getReportingGroupInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ReportingGroup with key " + command.getReportingGroupId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ReportingGroup reportingGroup = null;
    private static final Logger LOGGER = Logger.getLogger(ReportingGroupCommandRestController.class.getName());
    
}
