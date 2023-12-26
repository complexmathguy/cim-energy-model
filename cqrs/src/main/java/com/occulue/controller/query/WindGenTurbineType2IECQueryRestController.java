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
 * Implements Spring Controller query CQRS processing for entity WindGenTurbineType2IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType2IEC")
public class WindGenTurbineType2IECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindGenTurbineType2IEC using a UUID
     * @param		UUID windGenTurbineType2IECId
     * @return		WindGenTurbineType2IEC
     */    
    @GetMapping("/load")
    public WindGenTurbineType2IEC load( @RequestParam(required=true) UUID windGenTurbineType2IECId ) {
    	WindGenTurbineType2IEC entity = null;

    	try {  
    		entity = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().getWindGenTurbineType2IEC( new WindGenTurbineType2IECFetchOneSummary( windGenTurbineType2IECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindGenTurbineType2IEC using Id " + windGenTurbineType2IECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindGenTurbineType2IEC business objects
     * @return		Set<WindGenTurbineType2IEC>
     */
    @GetMapping("/")
    public List<WindGenTurbineType2IEC> loadAll() {                
    	List<WindGenTurbineType2IEC> windGenTurbineType2IECList = null;
        
    	try {
            // load the WindGenTurbineType2IEC
            windGenTurbineType2IECList = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().getAllWindGenTurbineType2IEC();
            
            if ( windGenTurbineType2IECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindGenTurbineType2IECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindGenTurbineType2IECs ", exc );
        	return null;
        }

        return windGenTurbineType2IECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType2IEC windGenTurbineType2IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType2IECQueryRestController.class.getName());
    
}
