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
 * Implements Spring Controller query CQRS processing for entity ActivePowerLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerLimit")
public class ActivePowerLimitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ActivePowerLimit using a UUID
     * @param		UUID activePowerLimitId
     * @return		ActivePowerLimit
     */    
    @GetMapping("/load")
    public ActivePowerLimit load( @RequestParam(required=true) UUID activePowerLimitId ) {
    	ActivePowerLimit entity = null;

    	try {  
    		entity = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().getActivePowerLimit( new ActivePowerLimitFetchOneSummary( activePowerLimitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ActivePowerLimit using Id " + activePowerLimitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ActivePowerLimit business objects
     * @return		Set<ActivePowerLimit>
     */
    @GetMapping("/")
    public List<ActivePowerLimit> loadAll() {                
    	List<ActivePowerLimit> activePowerLimitList = null;
        
    	try {
            // load the ActivePowerLimit
            activePowerLimitList = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().getAllActivePowerLimit();
            
            if ( activePowerLimitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ActivePowerLimits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ActivePowerLimits ", exc );
        	return null;
        }

        return activePowerLimitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePowerLimit activePowerLimit = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerLimitQueryRestController.class.getName());
    
}
