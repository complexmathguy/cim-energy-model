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
 * Implements Spring Controller query CQRS processing for entity PowerTransformer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerTransformer")
public class PowerTransformerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PowerTransformer using a UUID
     * @param		UUID powerTransformerId
     * @return		PowerTransformer
     */    
    @GetMapping("/load")
    public PowerTransformer load( @RequestParam(required=true) UUID powerTransformerId ) {
    	PowerTransformer entity = null;

    	try {  
    		entity = PowerTransformerBusinessDelegate.getPowerTransformerInstance().getPowerTransformer( new PowerTransformerFetchOneSummary( powerTransformerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PowerTransformer using Id " + powerTransformerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PowerTransformer business objects
     * @return		Set<PowerTransformer>
     */
    @GetMapping("/")
    public List<PowerTransformer> loadAll() {                
    	List<PowerTransformer> powerTransformerList = null;
        
    	try {
            // load the PowerTransformer
            powerTransformerList = PowerTransformerBusinessDelegate.getPowerTransformerInstance().getAllPowerTransformer();
            
            if ( powerTransformerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PowerTransformers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PowerTransformers ", exc );
        	return null;
        }

        return powerTransformerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PowerTransformer powerTransformer = null;
    private static final Logger LOGGER = Logger.getLogger(PowerTransformerQueryRestController.class.getName());
    
}
