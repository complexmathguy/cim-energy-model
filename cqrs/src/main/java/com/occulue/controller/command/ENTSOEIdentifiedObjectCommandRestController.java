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
 * Implements Spring Controller command CQRS processing for entity ENTSOEIdentifiedObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEIdentifiedObject")
public class ENTSOEIdentifiedObjectCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ENTSOEIdentifiedObject.  if not key provided, calls create, otherwise calls save
     * @param		ENTSOEIdentifiedObject	eNTSOEIdentifiedObject
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateENTSOEIdentifiedObjectCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().createENTSOEIdentifiedObject( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ENTSOEIdentifiedObject.  if no key provided, calls create, otherwise calls save
     * @param		ENTSOEIdentifiedObject eNTSOEIdentifiedObject
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateENTSOEIdentifiedObjectCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateENTSOEIdentifiedObjectCommand
			// -----------------------------------------------
			completableFuture = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().updateENTSOEIdentifiedObject(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ENTSOEIdentifiedObjectController:update() - successfully update ENTSOEIdentifiedObject - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ENTSOEIdentifiedObject entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID eNTSOEIdentifiedObjectId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteENTSOEIdentifiedObjectCommand command = new DeleteENTSOEIdentifiedObjectCommand( eNTSOEIdentifiedObjectId );

    	try {
        	ENTSOEIdentifiedObjectBusinessDelegate delegate = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ENTSOEIdentifiedObject with key " + command.getENTSOEIdentifiedObjectId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEIdentifiedObject eNTSOEIdentifiedObject = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEIdentifiedObjectCommandRestController.class.getName());
    
}
