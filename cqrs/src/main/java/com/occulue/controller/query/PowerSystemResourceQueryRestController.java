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
 * Implements Spring Controller query CQRS processing for entity PowerSystemResource.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerSystemResource")
public class PowerSystemResourceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PowerSystemResource using a UUID
     * @param		UUID powerSystemResourceId
     * @return		PowerSystemResource
     */    
    @GetMapping("/load")
    public PowerSystemResource load( @RequestParam(required=true) UUID powerSystemResourceId ) {
    	PowerSystemResource entity = null;

    	try {  
    		entity = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().getPowerSystemResource( new PowerSystemResourceFetchOneSummary( powerSystemResourceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PowerSystemResource using Id " + powerSystemResourceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PowerSystemResource business objects
     * @return		Set<PowerSystemResource>
     */
    @GetMapping("/")
    public List<PowerSystemResource> loadAll() {                
    	List<PowerSystemResource> powerSystemResourceList = null;
        
    	try {
            // load the PowerSystemResource
            powerSystemResourceList = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().getAllPowerSystemResource();
            
            if ( powerSystemResourceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PowerSystemResources" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PowerSystemResources ", exc );
        	return null;
        }

        return powerSystemResourceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PowerSystemResource powerSystemResource = null;
    private static final Logger LOGGER = Logger.getLogger(PowerSystemResourceQueryRestController.class.getName());
    
}
