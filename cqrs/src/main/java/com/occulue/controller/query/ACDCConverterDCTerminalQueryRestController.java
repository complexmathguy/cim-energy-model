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
 * Implements Spring Controller query CQRS processing for entity ACDCConverterDCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCConverterDCTerminal")
public class ACDCConverterDCTerminalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ACDCConverterDCTerminal using a UUID
     * @param		UUID aCDCConverterDCTerminalId
     * @return		ACDCConverterDCTerminal
     */    
    @GetMapping("/load")
    public ACDCConverterDCTerminal load( @RequestParam(required=true) UUID aCDCConverterDCTerminalId ) {
    	ACDCConverterDCTerminal entity = null;

    	try {  
    		entity = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().getACDCConverterDCTerminal( new ACDCConverterDCTerminalFetchOneSummary( aCDCConverterDCTerminalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ACDCConverterDCTerminal using Id " + aCDCConverterDCTerminalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ACDCConverterDCTerminal business objects
     * @return		Set<ACDCConverterDCTerminal>
     */
    @GetMapping("/")
    public List<ACDCConverterDCTerminal> loadAll() {                
    	List<ACDCConverterDCTerminal> aCDCConverterDCTerminalList = null;
        
    	try {
            // load the ACDCConverterDCTerminal
            aCDCConverterDCTerminalList = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().getAllACDCConverterDCTerminal();
            
            if ( aCDCConverterDCTerminalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ACDCConverterDCTerminals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ACDCConverterDCTerminals ", exc );
        	return null;
        }

        return aCDCConverterDCTerminalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ACDCConverterDCTerminal aCDCConverterDCTerminal = null;
    private static final Logger LOGGER = Logger.getLogger(ACDCConverterDCTerminalQueryRestController.class.getName());
    
}
