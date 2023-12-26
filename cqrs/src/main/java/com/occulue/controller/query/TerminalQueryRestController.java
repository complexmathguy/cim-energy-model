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
 * Implements Spring Controller query CQRS processing for entity Terminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Terminal")
public class TerminalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Terminal using a UUID
     * @param		UUID terminalId
     * @return		Terminal
     */    
    @GetMapping("/load")
    public Terminal load( @RequestParam(required=true) UUID terminalId ) {
    	Terminal entity = null;

    	try {  
    		entity = TerminalBusinessDelegate.getTerminalInstance().getTerminal( new TerminalFetchOneSummary( terminalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Terminal using Id " + terminalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Terminal business objects
     * @return		Set<Terminal>
     */
    @GetMapping("/")
    public List<Terminal> loadAll() {                
    	List<Terminal> terminalList = null;
        
    	try {
            // load the Terminal
            terminalList = TerminalBusinessDelegate.getTerminalInstance().getAllTerminal();
            
            if ( terminalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Terminals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Terminals ", exc );
        	return null;
        }

        return terminalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Terminal terminal = null;
    private static final Logger LOGGER = Logger.getLogger(TerminalQueryRestController.class.getName());
    
}
