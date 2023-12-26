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
 * Implements Spring Controller query CQRS processing for entity ACDCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCTerminal")
public class ACDCTerminalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ACDCTerminal using a UUID
     * @param		UUID aCDCTerminalId
     * @return		ACDCTerminal
     */    
    @GetMapping("/load")
    public ACDCTerminal load( @RequestParam(required=true) UUID aCDCTerminalId ) {
    	ACDCTerminal entity = null;

    	try {  
    		entity = ACDCTerminalBusinessDelegate.getACDCTerminalInstance().getACDCTerminal( new ACDCTerminalFetchOneSummary( aCDCTerminalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ACDCTerminal using Id " + aCDCTerminalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ACDCTerminal business objects
     * @return		Set<ACDCTerminal>
     */
    @GetMapping("/")
    public List<ACDCTerminal> loadAll() {                
    	List<ACDCTerminal> aCDCTerminalList = null;
        
    	try {
            // load the ACDCTerminal
            aCDCTerminalList = ACDCTerminalBusinessDelegate.getACDCTerminalInstance().getAllACDCTerminal();
            
            if ( aCDCTerminalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ACDCTerminals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ACDCTerminals ", exc );
        	return null;
        }

        return aCDCTerminalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ACDCTerminal aCDCTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(ACDCTerminalQueryRestController.class.getName());
    
}
