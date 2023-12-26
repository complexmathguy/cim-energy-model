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
 * Implements Spring Controller query CQRS processing for entity WindGenTurbineType1IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType1IEC")
public class WindGenTurbineType1IECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindGenTurbineType1IEC using a UUID
     * @param		UUID windGenTurbineType1IECId
     * @return		WindGenTurbineType1IEC
     */    
    @GetMapping("/load")
    public WindGenTurbineType1IEC load( @RequestParam(required=true) UUID windGenTurbineType1IECId ) {
    	WindGenTurbineType1IEC entity = null;

    	try {  
    		entity = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().getWindGenTurbineType1IEC( new WindGenTurbineType1IECFetchOneSummary( windGenTurbineType1IECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindGenTurbineType1IEC using Id " + windGenTurbineType1IECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindGenTurbineType1IEC business objects
     * @return		Set<WindGenTurbineType1IEC>
     */
    @GetMapping("/")
    public List<WindGenTurbineType1IEC> loadAll() {                
    	List<WindGenTurbineType1IEC> windGenTurbineType1IECList = null;
        
    	try {
            // load the WindGenTurbineType1IEC
            windGenTurbineType1IECList = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().getAllWindGenTurbineType1IEC();
            
            if ( windGenTurbineType1IECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindGenTurbineType1IECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindGenTurbineType1IECs ", exc );
        	return null;
        }

        return windGenTurbineType1IECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType1IEC windGenTurbineType1IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType1IECQueryRestController.class.getName());
    
}
