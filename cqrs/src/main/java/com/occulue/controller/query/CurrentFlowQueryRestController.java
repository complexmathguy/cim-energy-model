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
 * Implements Spring Controller query CQRS processing for entity CurrentFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CurrentFlow")
public class CurrentFlowQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a CurrentFlow using a UUID
     * @param		UUID currentFlowId
     * @return		CurrentFlow
     */    
    @GetMapping("/load")
    public CurrentFlow load( @RequestParam(required=true) UUID currentFlowId ) {
    	CurrentFlow entity = null;

    	try {  
    		entity = CurrentFlowBusinessDelegate.getCurrentFlowInstance().getCurrentFlow( new CurrentFlowFetchOneSummary( currentFlowId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load CurrentFlow using Id " + currentFlowId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all CurrentFlow business objects
     * @return		Set<CurrentFlow>
     */
    @GetMapping("/")
    public List<CurrentFlow> loadAll() {                
    	List<CurrentFlow> currentFlowList = null;
        
    	try {
            // load the CurrentFlow
            currentFlowList = CurrentFlowBusinessDelegate.getCurrentFlowInstance().getAllCurrentFlow();
            
            if ( currentFlowList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all CurrentFlows" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all CurrentFlows ", exc );
        	return null;
        }

        return currentFlowList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected CurrentFlow currentFlow = null;
    private static final Logger LOGGER = Logger.getLogger(CurrentFlowQueryRestController.class.getName());
    
}
