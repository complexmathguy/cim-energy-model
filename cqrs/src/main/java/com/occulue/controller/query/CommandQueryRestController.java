/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity Command.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Command")
public class CommandQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Command using a UUID
     * @param		UUID commandId
     * @return		Command
     */    
    @GetMapping("/load")
    public Command load( @RequestParam(required=true) UUID commandId ) {
    	Command entity = null;

    	try {  
    		entity = CommandBusinessDelegate.getCommandInstance().getCommand( new CommandFetchOneSummary( commandId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Command using Id " + commandId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Command business objects
     * @return		Set<Command>
     */
    @GetMapping("/")
    public List<Command> loadAll() {                
    	List<Command> commandList = null;
        
    	try {
            // load the Command
            commandList = CommandBusinessDelegate.getCommandInstance().getAllCommand();
            
            if ( commandList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Commands" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Commands ", exc );
        	return null;
        }

        return commandList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Command command = null;
    private static final Logger LOGGER = Logger.getLogger(CommandQueryRestController.class.getName());
    
}
