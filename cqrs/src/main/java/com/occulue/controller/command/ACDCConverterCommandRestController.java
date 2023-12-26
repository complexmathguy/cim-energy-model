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
 * Implements Spring Controller command CQRS processing for entity ACDCConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCConverter")
public class ACDCConverterCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ACDCConverter.  if not key provided, calls create, otherwise calls save
     * @param		ACDCConverter	aCDCConverter
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateACDCConverterCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ACDCConverterBusinessDelegate.getACDCConverterInstance().createACDCConverter( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ACDCConverter.  if no key provided, calls create, otherwise calls save
     * @param		ACDCConverter aCDCConverter
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateACDCConverterCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateACDCConverterCommand
			// -----------------------------------------------
			completableFuture = ACDCConverterBusinessDelegate.getACDCConverterInstance().updateACDCConverter(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ACDCConverterController:update() - successfully update ACDCConverter - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ACDCConverter entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID aCDCConverterId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteACDCConverterCommand command = new DeleteACDCConverterCommand( aCDCConverterId );

    	try {
        	ACDCConverterBusinessDelegate delegate = ACDCConverterBusinessDelegate.getACDCConverterInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ACDCConverter with key " + command.getACDCConverterId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ACDCConverter aCDCConverter = null;
    private static final Logger LOGGER = Logger.getLogger(ACDCConverterCommandRestController.class.getName());
    
}
