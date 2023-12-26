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
 * Implements Spring Controller query CQRS processing for entity WindGenTurbineType3bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3bIEC")
public class WindGenTurbineType3bIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindGenTurbineType3bIEC using a UUID
     * @param		UUID windGenTurbineType3bIECId
     * @return		WindGenTurbineType3bIEC
     */    
    @GetMapping("/load")
    public WindGenTurbineType3bIEC load( @RequestParam(required=true) UUID windGenTurbineType3bIECId ) {
    	WindGenTurbineType3bIEC entity = null;

    	try {  
    		entity = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().getWindGenTurbineType3bIEC( new WindGenTurbineType3bIECFetchOneSummary( windGenTurbineType3bIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindGenTurbineType3bIEC using Id " + windGenTurbineType3bIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindGenTurbineType3bIEC business objects
     * @return		Set<WindGenTurbineType3bIEC>
     */
    @GetMapping("/")
    public List<WindGenTurbineType3bIEC> loadAll() {                
    	List<WindGenTurbineType3bIEC> windGenTurbineType3bIECList = null;
        
    	try {
            // load the WindGenTurbineType3bIEC
            windGenTurbineType3bIECList = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().getAllWindGenTurbineType3bIEC();
            
            if ( windGenTurbineType3bIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindGenTurbineType3bIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindGenTurbineType3bIECs ", exc );
        	return null;
        }

        return windGenTurbineType3bIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType3bIEC windGenTurbineType3bIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType3bIECQueryRestController.class.getName());
    
}
