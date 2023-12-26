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
 * Implements Spring Controller command CQRS processing for entity PerLengthDCLineParameter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PerLengthDCLineParameter")
public class PerLengthDCLineParameterCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PerLengthDCLineParameter.  if not key provided, calls create, otherwise calls save
     * @param		PerLengthDCLineParameter	perLengthDCLineParameter
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePerLengthDCLineParameterCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().createPerLengthDCLineParameter( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PerLengthDCLineParameter.  if no key provided, calls create, otherwise calls save
     * @param		PerLengthDCLineParameter perLengthDCLineParameter
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePerLengthDCLineParameterCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePerLengthDCLineParameterCommand
			// -----------------------------------------------
			completableFuture = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().updatePerLengthDCLineParameter(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PerLengthDCLineParameterController:update() - successfully update PerLengthDCLineParameter - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PerLengthDCLineParameter entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID perLengthDCLineParameterId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePerLengthDCLineParameterCommand command = new DeletePerLengthDCLineParameterCommand( perLengthDCLineParameterId );

    	try {
        	PerLengthDCLineParameterBusinessDelegate delegate = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PerLengthDCLineParameter with key " + command.getPerLengthDCLineParameterId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PerLengthDCLineParameter perLengthDCLineParameter = null;
    private static final Logger LOGGER = Logger.getLogger(PerLengthDCLineParameterCommandRestController.class.getName());
    
}
