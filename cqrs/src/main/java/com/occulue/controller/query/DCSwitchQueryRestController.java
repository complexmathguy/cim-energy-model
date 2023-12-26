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
 * Implements Spring Controller query CQRS processing for entity DCSwitch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCSwitch")
public class DCSwitchQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCSwitch using a UUID
     * @param		UUID dCSwitchId
     * @return		DCSwitch
     */    
    @GetMapping("/load")
    public DCSwitch load( @RequestParam(required=true) UUID dCSwitchId ) {
    	DCSwitch entity = null;

    	try {  
    		entity = DCSwitchBusinessDelegate.getDCSwitchInstance().getDCSwitch( new DCSwitchFetchOneSummary( dCSwitchId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCSwitch using Id " + dCSwitchId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCSwitch business objects
     * @return		Set<DCSwitch>
     */
    @GetMapping("/")
    public List<DCSwitch> loadAll() {                
    	List<DCSwitch> dCSwitchList = null;
        
    	try {
            // load the DCSwitch
            dCSwitchList = DCSwitchBusinessDelegate.getDCSwitchInstance().getAllDCSwitch();
            
            if ( dCSwitchList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCSwitchs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCSwitchs ", exc );
        	return null;
        }

        return dCSwitchList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCSwitch dCSwitch = null;
    private static final Logger LOGGER = Logger.getLogger(DCSwitchQueryRestController.class.getName());
    
}
