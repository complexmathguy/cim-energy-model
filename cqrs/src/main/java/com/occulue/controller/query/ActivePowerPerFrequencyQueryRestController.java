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
 * Implements Spring Controller query CQRS processing for entity ActivePowerPerFrequency.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerPerFrequency")
public class ActivePowerPerFrequencyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ActivePowerPerFrequency using a UUID
     * @param		UUID activePowerPerFrequencyId
     * @return		ActivePowerPerFrequency
     */    
    @GetMapping("/load")
    public ActivePowerPerFrequency load( @RequestParam(required=true) UUID activePowerPerFrequencyId ) {
    	ActivePowerPerFrequency entity = null;

    	try {  
    		entity = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().getActivePowerPerFrequency( new ActivePowerPerFrequencyFetchOneSummary( activePowerPerFrequencyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ActivePowerPerFrequency using Id " + activePowerPerFrequencyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ActivePowerPerFrequency business objects
     * @return		Set<ActivePowerPerFrequency>
     */
    @GetMapping("/")
    public List<ActivePowerPerFrequency> loadAll() {                
    	List<ActivePowerPerFrequency> activePowerPerFrequencyList = null;
        
    	try {
            // load the ActivePowerPerFrequency
            activePowerPerFrequencyList = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().getAllActivePowerPerFrequency();
            
            if ( activePowerPerFrequencyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ActivePowerPerFrequencys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ActivePowerPerFrequencys ", exc );
        	return null;
        }

        return activePowerPerFrequencyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePowerPerFrequency activePowerPerFrequency = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerPerFrequencyQueryRestController.class.getName());
    
}
