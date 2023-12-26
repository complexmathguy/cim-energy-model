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
 * Implements Spring Controller query CQRS processing for entity WindPlantIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantIEC")
public class WindPlantIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindPlantIEC using a UUID
     * @param		UUID windPlantIECId
     * @return		WindPlantIEC
     */    
    @GetMapping("/load")
    public WindPlantIEC load( @RequestParam(required=true) UUID windPlantIECId ) {
    	WindPlantIEC entity = null;

    	try {  
    		entity = WindPlantIECBusinessDelegate.getWindPlantIECInstance().getWindPlantIEC( new WindPlantIECFetchOneSummary( windPlantIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindPlantIEC using Id " + windPlantIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindPlantIEC business objects
     * @return		Set<WindPlantIEC>
     */
    @GetMapping("/")
    public List<WindPlantIEC> loadAll() {                
    	List<WindPlantIEC> windPlantIECList = null;
        
    	try {
            // load the WindPlantIEC
            windPlantIECList = WindPlantIECBusinessDelegate.getWindPlantIECInstance().getAllWindPlantIEC();
            
            if ( windPlantIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindPlantIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindPlantIECs ", exc );
        	return null;
        }

        return windPlantIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantIEC windPlantIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantIECQueryRestController.class.getName());
    
}
