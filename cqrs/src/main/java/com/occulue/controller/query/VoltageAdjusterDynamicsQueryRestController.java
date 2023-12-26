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
 * Implements Spring Controller query CQRS processing for entity VoltageAdjusterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageAdjusterDynamics")
public class VoltageAdjusterDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltageAdjusterDynamics using a UUID
     * @param		UUID voltageAdjusterDynamicsId
     * @return		VoltageAdjusterDynamics
     */    
    @GetMapping("/load")
    public VoltageAdjusterDynamics load( @RequestParam(required=true) UUID voltageAdjusterDynamicsId ) {
    	VoltageAdjusterDynamics entity = null;

    	try {  
    		entity = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().getVoltageAdjusterDynamics( new VoltageAdjusterDynamicsFetchOneSummary( voltageAdjusterDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltageAdjusterDynamics using Id " + voltageAdjusterDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltageAdjusterDynamics business objects
     * @return		Set<VoltageAdjusterDynamics>
     */
    @GetMapping("/")
    public List<VoltageAdjusterDynamics> loadAll() {                
    	List<VoltageAdjusterDynamics> voltageAdjusterDynamicsList = null;
        
    	try {
            // load the VoltageAdjusterDynamics
            voltageAdjusterDynamicsList = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().getAllVoltageAdjusterDynamics();
            
            if ( voltageAdjusterDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltageAdjusterDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltageAdjusterDynamicss ", exc );
        	return null;
        }

        return voltageAdjusterDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageAdjusterDynamics voltageAdjusterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageAdjusterDynamicsQueryRestController.class.getName());
    
}
