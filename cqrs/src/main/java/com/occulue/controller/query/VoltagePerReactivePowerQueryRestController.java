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
 * Implements Spring Controller query CQRS processing for entity VoltagePerReactivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltagePerReactivePower")
public class VoltagePerReactivePowerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltagePerReactivePower using a UUID
     * @param		UUID voltagePerReactivePowerId
     * @return		VoltagePerReactivePower
     */    
    @GetMapping("/load")
    public VoltagePerReactivePower load( @RequestParam(required=true) UUID voltagePerReactivePowerId ) {
    	VoltagePerReactivePower entity = null;

    	try {  
    		entity = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().getVoltagePerReactivePower( new VoltagePerReactivePowerFetchOneSummary( voltagePerReactivePowerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltagePerReactivePower using Id " + voltagePerReactivePowerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltagePerReactivePower business objects
     * @return		Set<VoltagePerReactivePower>
     */
    @GetMapping("/")
    public List<VoltagePerReactivePower> loadAll() {                
    	List<VoltagePerReactivePower> voltagePerReactivePowerList = null;
        
    	try {
            // load the VoltagePerReactivePower
            voltagePerReactivePowerList = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().getAllVoltagePerReactivePower();
            
            if ( voltagePerReactivePowerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltagePerReactivePowers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltagePerReactivePowers ", exc );
        	return null;
        }

        return voltagePerReactivePowerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltagePerReactivePower voltagePerReactivePower = null;
    private static final Logger LOGGER = Logger.getLogger(VoltagePerReactivePowerQueryRestController.class.getName());
    
}
