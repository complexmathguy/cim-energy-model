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
 * Implements Spring Controller query CQRS processing for entity VoltageCompensatorDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageCompensatorDynamics")
public class VoltageCompensatorDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltageCompensatorDynamics using a UUID
     * @param		UUID voltageCompensatorDynamicsId
     * @return		VoltageCompensatorDynamics
     */    
    @GetMapping("/load")
    public VoltageCompensatorDynamics load( @RequestParam(required=true) UUID voltageCompensatorDynamicsId ) {
    	VoltageCompensatorDynamics entity = null;

    	try {  
    		entity = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().getVoltageCompensatorDynamics( new VoltageCompensatorDynamicsFetchOneSummary( voltageCompensatorDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltageCompensatorDynamics using Id " + voltageCompensatorDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltageCompensatorDynamics business objects
     * @return		Set<VoltageCompensatorDynamics>
     */
    @GetMapping("/")
    public List<VoltageCompensatorDynamics> loadAll() {                
    	List<VoltageCompensatorDynamics> voltageCompensatorDynamicsList = null;
        
    	try {
            // load the VoltageCompensatorDynamics
            voltageCompensatorDynamicsList = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().getAllVoltageCompensatorDynamics();
            
            if ( voltageCompensatorDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltageCompensatorDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltageCompensatorDynamicss ", exc );
        	return null;
        }

        return voltageCompensatorDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageCompensatorDynamics voltageCompensatorDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageCompensatorDynamicsQueryRestController.class.getName());
    
}
