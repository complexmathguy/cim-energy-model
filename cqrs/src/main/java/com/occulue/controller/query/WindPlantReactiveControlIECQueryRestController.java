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
 * Implements Spring Controller query CQRS processing for entity WindPlantReactiveControlIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantReactiveControlIEC")
public class WindPlantReactiveControlIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindPlantReactiveControlIEC using a UUID
     * @param		UUID windPlantReactiveControlIECId
     * @return		WindPlantReactiveControlIEC
     */    
    @GetMapping("/load")
    public WindPlantReactiveControlIEC load( @RequestParam(required=true) UUID windPlantReactiveControlIECId ) {
    	WindPlantReactiveControlIEC entity = null;

    	try {  
    		entity = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().getWindPlantReactiveControlIEC( new WindPlantReactiveControlIECFetchOneSummary( windPlantReactiveControlIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindPlantReactiveControlIEC using Id " + windPlantReactiveControlIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindPlantReactiveControlIEC business objects
     * @return		Set<WindPlantReactiveControlIEC>
     */
    @GetMapping("/")
    public List<WindPlantReactiveControlIEC> loadAll() {                
    	List<WindPlantReactiveControlIEC> windPlantReactiveControlIECList = null;
        
    	try {
            // load the WindPlantReactiveControlIEC
            windPlantReactiveControlIECList = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().getAllWindPlantReactiveControlIEC();
            
            if ( windPlantReactiveControlIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindPlantReactiveControlIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindPlantReactiveControlIECs ", exc );
        	return null;
        }

        return windPlantReactiveControlIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantReactiveControlIEC windPlantReactiveControlIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantReactiveControlIECQueryRestController.class.getName());
    
}
