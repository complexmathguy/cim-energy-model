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
 * Implements Spring Controller query CQRS processing for entity WindPlantUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantUserDefined")
public class WindPlantUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindPlantUserDefined using a UUID
     * @param		UUID windPlantUserDefinedId
     * @return		WindPlantUserDefined
     */    
    @GetMapping("/load")
    public WindPlantUserDefined load( @RequestParam(required=true) UUID windPlantUserDefinedId ) {
    	WindPlantUserDefined entity = null;

    	try {  
    		entity = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().getWindPlantUserDefined( new WindPlantUserDefinedFetchOneSummary( windPlantUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindPlantUserDefined using Id " + windPlantUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindPlantUserDefined business objects
     * @return		Set<WindPlantUserDefined>
     */
    @GetMapping("/")
    public List<WindPlantUserDefined> loadAll() {                
    	List<WindPlantUserDefined> windPlantUserDefinedList = null;
        
    	try {
            // load the WindPlantUserDefined
            windPlantUserDefinedList = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().getAllWindPlantUserDefined();
            
            if ( windPlantUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindPlantUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindPlantUserDefineds ", exc );
        	return null;
        }

        return windPlantUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantUserDefined windPlantUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantUserDefinedQueryRestController.class.getName());
    
}
