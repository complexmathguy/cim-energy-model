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
 * Implements Spring Controller query CQRS processing for entity WindTurbineType3or4Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType3or4Dynamics")
public class WindTurbineType3or4DynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindTurbineType3or4Dynamics using a UUID
     * @param		UUID windTurbineType3or4DynamicsId
     * @return		WindTurbineType3or4Dynamics
     */    
    @GetMapping("/load")
    public WindTurbineType3or4Dynamics load( @RequestParam(required=true) UUID windTurbineType3or4DynamicsId ) {
    	WindTurbineType3or4Dynamics entity = null;

    	try {  
    		entity = WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance().getWindTurbineType3or4Dynamics( new WindTurbineType3or4DynamicsFetchOneSummary( windTurbineType3or4DynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindTurbineType3or4Dynamics using Id " + windTurbineType3or4DynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindTurbineType3or4Dynamics business objects
     * @return		Set<WindTurbineType3or4Dynamics>
     */
    @GetMapping("/")
    public List<WindTurbineType3or4Dynamics> loadAll() {                
    	List<WindTurbineType3or4Dynamics> windTurbineType3or4DynamicsList = null;
        
    	try {
            // load the WindTurbineType3or4Dynamics
            windTurbineType3or4DynamicsList = WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance().getAllWindTurbineType3or4Dynamics();
            
            if ( windTurbineType3or4DynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindTurbineType3or4Dynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindTurbineType3or4Dynamicss ", exc );
        	return null;
        }

        return windTurbineType3or4DynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType3or4Dynamics windTurbineType3or4Dynamics = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType3or4DynamicsQueryRestController.class.getName());
    
}
