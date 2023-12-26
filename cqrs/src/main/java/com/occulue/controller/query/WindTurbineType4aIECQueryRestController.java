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
 * Implements Spring Controller query CQRS processing for entity WindTurbineType4aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType4aIEC")
public class WindTurbineType4aIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindTurbineType4aIEC using a UUID
     * @param		UUID windTurbineType4aIECId
     * @return		WindTurbineType4aIEC
     */    
    @GetMapping("/load")
    public WindTurbineType4aIEC load( @RequestParam(required=true) UUID windTurbineType4aIECId ) {
    	WindTurbineType4aIEC entity = null;

    	try {  
    		entity = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().getWindTurbineType4aIEC( new WindTurbineType4aIECFetchOneSummary( windTurbineType4aIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindTurbineType4aIEC using Id " + windTurbineType4aIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindTurbineType4aIEC business objects
     * @return		Set<WindTurbineType4aIEC>
     */
    @GetMapping("/")
    public List<WindTurbineType4aIEC> loadAll() {                
    	List<WindTurbineType4aIEC> windTurbineType4aIECList = null;
        
    	try {
            // load the WindTurbineType4aIEC
            windTurbineType4aIECList = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().getAllWindTurbineType4aIEC();
            
            if ( windTurbineType4aIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindTurbineType4aIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindTurbineType4aIECs ", exc );
        	return null;
        }

        return windTurbineType4aIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType4aIEC windTurbineType4aIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType4aIECQueryRestController.class.getName());
    
}
