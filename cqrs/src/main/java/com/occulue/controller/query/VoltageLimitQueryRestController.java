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
 * Implements Spring Controller query CQRS processing for entity VoltageLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageLimit")
public class VoltageLimitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltageLimit using a UUID
     * @param		UUID voltageLimitId
     * @return		VoltageLimit
     */    
    @GetMapping("/load")
    public VoltageLimit load( @RequestParam(required=true) UUID voltageLimitId ) {
    	VoltageLimit entity = null;

    	try {  
    		entity = VoltageLimitBusinessDelegate.getVoltageLimitInstance().getVoltageLimit( new VoltageLimitFetchOneSummary( voltageLimitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltageLimit using Id " + voltageLimitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltageLimit business objects
     * @return		Set<VoltageLimit>
     */
    @GetMapping("/")
    public List<VoltageLimit> loadAll() {                
    	List<VoltageLimit> voltageLimitList = null;
        
    	try {
            // load the VoltageLimit
            voltageLimitList = VoltageLimitBusinessDelegate.getVoltageLimitInstance().getAllVoltageLimit();
            
            if ( voltageLimitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltageLimits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltageLimits ", exc );
        	return null;
        }

        return voltageLimitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageLimit voltageLimit = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageLimitQueryRestController.class.getName());
    
}
