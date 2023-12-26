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
 * Implements Spring Controller command CQRS processing for entity CurveData.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CurveData")
public class CurveDataCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a CurveData.  if not key provided, calls create, otherwise calls save
     * @param		CurveData	curveData
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateCurveDataCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = CurveDataBusinessDelegate.getCurveDataInstance().createCurveData( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a CurveData.  if no key provided, calls create, otherwise calls save
     * @param		CurveData curveData
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateCurveDataCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateCurveDataCommand
			// -----------------------------------------------
			completableFuture = CurveDataBusinessDelegate.getCurveDataInstance().updateCurveData(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "CurveDataController:update() - successfully update CurveData - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a CurveData entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID curveDataId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteCurveDataCommand command = new DeleteCurveDataCommand( curveDataId );

    	try {
        	CurveDataBusinessDelegate delegate = CurveDataBusinessDelegate.getCurveDataInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted CurveData with key " + command.getCurveDataId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected CurveData curveData = null;
    private static final Logger LOGGER = Logger.getLogger(CurveDataCommandRestController.class.getName());
    
}
