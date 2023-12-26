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
 * Implements Spring Controller query CQRS processing for entity DCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCTerminal")
public class DCTerminalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCTerminal using a UUID
     * @param		UUID dCTerminalId
     * @return		DCTerminal
     */    
    @GetMapping("/load")
    public DCTerminal load( @RequestParam(required=true) UUID dCTerminalId ) {
    	DCTerminal entity = null;

    	try {  
    		entity = DCTerminalBusinessDelegate.getDCTerminalInstance().getDCTerminal( new DCTerminalFetchOneSummary( dCTerminalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCTerminal using Id " + dCTerminalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCTerminal business objects
     * @return		Set<DCTerminal>
     */
    @GetMapping("/")
    public List<DCTerminal> loadAll() {                
    	List<DCTerminal> dCTerminalList = null;
        
    	try {
            // load the DCTerminal
            dCTerminalList = DCTerminalBusinessDelegate.getDCTerminalInstance().getAllDCTerminal();
            
            if ( dCTerminalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCTerminals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCTerminals ", exc );
        	return null;
        }

        return dCTerminalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCTerminal dCTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(DCTerminalQueryRestController.class.getName());
    
}
