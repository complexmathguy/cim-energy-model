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
 * Implements Spring Controller query CQRS processing for entity ActivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePower")
public class ActivePowerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ActivePower using a UUID
     * @param		UUID activePowerId
     * @return		ActivePower
     */    
    @GetMapping("/load")
    public ActivePower load( @RequestParam(required=true) UUID activePowerId ) {
    	ActivePower entity = null;

    	try {  
    		entity = ActivePowerBusinessDelegate.getActivePowerInstance().getActivePower( new ActivePowerFetchOneSummary( activePowerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ActivePower using Id " + activePowerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ActivePower business objects
     * @return		Set<ActivePower>
     */
    @GetMapping("/")
    public List<ActivePower> loadAll() {                
    	List<ActivePower> activePowerList = null;
        
    	try {
            // load the ActivePower
            activePowerList = ActivePowerBusinessDelegate.getActivePowerInstance().getAllActivePower();
            
            if ( activePowerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ActivePowers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ActivePowers ", exc );
        	return null;
        }

        return activePowerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePower activePower = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerQueryRestController.class.getName());
    
}
