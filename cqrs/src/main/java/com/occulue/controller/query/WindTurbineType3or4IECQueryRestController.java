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
 * Implements Spring Controller query CQRS processing for entity WindTurbineType3or4IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType3or4IEC")
public class WindTurbineType3or4IECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindTurbineType3or4IEC using a UUID
     * @param		UUID windTurbineType3or4IECId
     * @return		WindTurbineType3or4IEC
     */    
    @GetMapping("/load")
    public WindTurbineType3or4IEC load( @RequestParam(required=true) UUID windTurbineType3or4IECId ) {
    	WindTurbineType3or4IEC entity = null;

    	try {  
    		entity = WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance().getWindTurbineType3or4IEC( new WindTurbineType3or4IECFetchOneSummary( windTurbineType3or4IECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindTurbineType3or4IEC using Id " + windTurbineType3or4IECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindTurbineType3or4IEC business objects
     * @return		Set<WindTurbineType3or4IEC>
     */
    @GetMapping("/")
    public List<WindTurbineType3or4IEC> loadAll() {                
    	List<WindTurbineType3or4IEC> windTurbineType3or4IECList = null;
        
    	try {
            // load the WindTurbineType3or4IEC
            windTurbineType3or4IECList = WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance().getAllWindTurbineType3or4IEC();
            
            if ( windTurbineType3or4IECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindTurbineType3or4IECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindTurbineType3or4IECs ", exc );
        	return null;
        }

        return windTurbineType3or4IECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType3or4IEC windTurbineType3or4IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType3or4IECQueryRestController.class.getName());
    
}
