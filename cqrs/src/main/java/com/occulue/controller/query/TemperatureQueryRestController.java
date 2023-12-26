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
 * Implements Spring Controller query CQRS processing for entity Temperature.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Temperature")
public class TemperatureQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Temperature using a UUID
     * @param		UUID temperatureId
     * @return		Temperature
     */    
    @GetMapping("/load")
    public Temperature load( @RequestParam(required=true) UUID temperatureId ) {
    	Temperature entity = null;

    	try {  
    		entity = TemperatureBusinessDelegate.getTemperatureInstance().getTemperature( new TemperatureFetchOneSummary( temperatureId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Temperature using Id " + temperatureId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Temperature business objects
     * @return		Set<Temperature>
     */
    @GetMapping("/")
    public List<Temperature> loadAll() {                
    	List<Temperature> temperatureList = null;
        
    	try {
            // load the Temperature
            temperatureList = TemperatureBusinessDelegate.getTemperatureInstance().getAllTemperature();
            
            if ( temperatureList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Temperatures" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Temperatures ", exc );
        	return null;
        }

        return temperatureList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Temperature temperature = null;
    private static final Logger LOGGER = Logger.getLogger(TemperatureQueryRestController.class.getName());
    
}
