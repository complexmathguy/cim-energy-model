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
 * Implements Spring Controller query CQRS processing for entity WindTurbineType1or2Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType1or2Dynamics")
public class WindTurbineType1or2DynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindTurbineType1or2Dynamics using a UUID
     * @param		UUID windTurbineType1or2DynamicsId
     * @return		WindTurbineType1or2Dynamics
     */    
    @GetMapping("/load")
    public WindTurbineType1or2Dynamics load( @RequestParam(required=true) UUID windTurbineType1or2DynamicsId ) {
    	WindTurbineType1or2Dynamics entity = null;

    	try {  
    		entity = WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance().getWindTurbineType1or2Dynamics( new WindTurbineType1or2DynamicsFetchOneSummary( windTurbineType1or2DynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindTurbineType1or2Dynamics using Id " + windTurbineType1or2DynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindTurbineType1or2Dynamics business objects
     * @return		Set<WindTurbineType1or2Dynamics>
     */
    @GetMapping("/")
    public List<WindTurbineType1or2Dynamics> loadAll() {                
    	List<WindTurbineType1or2Dynamics> windTurbineType1or2DynamicsList = null;
        
    	try {
            // load the WindTurbineType1or2Dynamics
            windTurbineType1or2DynamicsList = WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance().getAllWindTurbineType1or2Dynamics();
            
            if ( windTurbineType1or2DynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindTurbineType1or2Dynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindTurbineType1or2Dynamicss ", exc );
        	return null;
        }

        return windTurbineType1or2DynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType1or2Dynamics windTurbineType1or2Dynamics = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType1or2DynamicsQueryRestController.class.getName());
    
}
