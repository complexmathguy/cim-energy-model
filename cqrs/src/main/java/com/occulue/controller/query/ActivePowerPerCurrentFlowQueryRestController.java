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
 * Implements Spring Controller query CQRS processing for entity ActivePowerPerCurrentFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerPerCurrentFlow")
public class ActivePowerPerCurrentFlowQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ActivePowerPerCurrentFlow using a UUID
     * @param		UUID activePowerPerCurrentFlowId
     * @return		ActivePowerPerCurrentFlow
     */    
    @GetMapping("/load")
    public ActivePowerPerCurrentFlow load( @RequestParam(required=true) UUID activePowerPerCurrentFlowId ) {
    	ActivePowerPerCurrentFlow entity = null;

    	try {  
    		entity = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().getActivePowerPerCurrentFlow( new ActivePowerPerCurrentFlowFetchOneSummary( activePowerPerCurrentFlowId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ActivePowerPerCurrentFlow using Id " + activePowerPerCurrentFlowId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ActivePowerPerCurrentFlow business objects
     * @return		Set<ActivePowerPerCurrentFlow>
     */
    @GetMapping("/")
    public List<ActivePowerPerCurrentFlow> loadAll() {                
    	List<ActivePowerPerCurrentFlow> activePowerPerCurrentFlowList = null;
        
    	try {
            // load the ActivePowerPerCurrentFlow
            activePowerPerCurrentFlowList = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().getAllActivePowerPerCurrentFlow();
            
            if ( activePowerPerCurrentFlowList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ActivePowerPerCurrentFlows" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ActivePowerPerCurrentFlows ", exc );
        	return null;
        }

        return activePowerPerCurrentFlowList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePowerPerCurrentFlow activePowerPerCurrentFlow = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerPerCurrentFlowQueryRestController.class.getName());
    
}
