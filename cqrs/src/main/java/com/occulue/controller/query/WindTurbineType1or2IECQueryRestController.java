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
 * Implements Spring Controller query CQRS processing for entity WindTurbineType1or2IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType1or2IEC")
public class WindTurbineType1or2IECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindTurbineType1or2IEC using a UUID
     * @param		UUID windTurbineType1or2IECId
     * @return		WindTurbineType1or2IEC
     */    
    @GetMapping("/load")
    public WindTurbineType1or2IEC load( @RequestParam(required=true) UUID windTurbineType1or2IECId ) {
    	WindTurbineType1or2IEC entity = null;

    	try {  
    		entity = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance().getWindTurbineType1or2IEC( new WindTurbineType1or2IECFetchOneSummary( windTurbineType1or2IECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindTurbineType1or2IEC using Id " + windTurbineType1or2IECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindTurbineType1or2IEC business objects
     * @return		Set<WindTurbineType1or2IEC>
     */
    @GetMapping("/")
    public List<WindTurbineType1or2IEC> loadAll() {                
    	List<WindTurbineType1or2IEC> windTurbineType1or2IECList = null;
        
    	try {
            // load the WindTurbineType1or2IEC
            windTurbineType1or2IECList = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance().getAllWindTurbineType1or2IEC();
            
            if ( windTurbineType1or2IECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindTurbineType1or2IECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindTurbineType1or2IECs ", exc );
        	return null;
        }

        return windTurbineType1or2IECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType1or2IEC windTurbineType1or2IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType1or2IECQueryRestController.class.getName());
    
}
