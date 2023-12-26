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
 * Implements Spring Controller query CQRS processing for entity WindTurbineType4bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType4bIEC")
public class WindTurbineType4bIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindTurbineType4bIEC using a UUID
     * @param		UUID windTurbineType4bIECId
     * @return		WindTurbineType4bIEC
     */    
    @GetMapping("/load")
    public WindTurbineType4bIEC load( @RequestParam(required=true) UUID windTurbineType4bIECId ) {
    	WindTurbineType4bIEC entity = null;

    	try {  
    		entity = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().getWindTurbineType4bIEC( new WindTurbineType4bIECFetchOneSummary( windTurbineType4bIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindTurbineType4bIEC using Id " + windTurbineType4bIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindTurbineType4bIEC business objects
     * @return		Set<WindTurbineType4bIEC>
     */
    @GetMapping("/")
    public List<WindTurbineType4bIEC> loadAll() {                
    	List<WindTurbineType4bIEC> windTurbineType4bIECList = null;
        
    	try {
            // load the WindTurbineType4bIEC
            windTurbineType4bIECList = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().getAllWindTurbineType4bIEC();
            
            if ( windTurbineType4bIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindTurbineType4bIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindTurbineType4bIECs ", exc );
        	return null;
        }

        return windTurbineType4bIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindTurbineType4bIEC windTurbineType4bIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindTurbineType4bIECQueryRestController.class.getName());
    
}
