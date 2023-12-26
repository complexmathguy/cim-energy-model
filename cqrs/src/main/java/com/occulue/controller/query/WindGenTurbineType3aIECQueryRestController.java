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
 * Implements Spring Controller query CQRS processing for entity WindGenTurbineType3aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3aIEC")
public class WindGenTurbineType3aIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindGenTurbineType3aIEC using a UUID
     * @param		UUID windGenTurbineType3aIECId
     * @return		WindGenTurbineType3aIEC
     */    
    @GetMapping("/load")
    public WindGenTurbineType3aIEC load( @RequestParam(required=true) UUID windGenTurbineType3aIECId ) {
    	WindGenTurbineType3aIEC entity = null;

    	try {  
    		entity = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().getWindGenTurbineType3aIEC( new WindGenTurbineType3aIECFetchOneSummary( windGenTurbineType3aIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindGenTurbineType3aIEC using Id " + windGenTurbineType3aIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindGenTurbineType3aIEC business objects
     * @return		Set<WindGenTurbineType3aIEC>
     */
    @GetMapping("/")
    public List<WindGenTurbineType3aIEC> loadAll() {                
    	List<WindGenTurbineType3aIEC> windGenTurbineType3aIECList = null;
        
    	try {
            // load the WindGenTurbineType3aIEC
            windGenTurbineType3aIECList = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().getAllWindGenTurbineType3aIEC();
            
            if ( windGenTurbineType3aIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindGenTurbineType3aIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindGenTurbineType3aIECs ", exc );
        	return null;
        }

        return windGenTurbineType3aIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenTurbineType3aIEC windGenTurbineType3aIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenTurbineType3aIECQueryRestController.class.getName());
    
}
