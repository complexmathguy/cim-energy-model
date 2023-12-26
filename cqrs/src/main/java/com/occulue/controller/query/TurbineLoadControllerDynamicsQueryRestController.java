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
 * Implements Spring Controller query CQRS processing for entity TurbineLoadControllerDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineLoadControllerDynamics")
public class TurbineLoadControllerDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TurbineLoadControllerDynamics using a UUID
     * @param		UUID turbineLoadControllerDynamicsId
     * @return		TurbineLoadControllerDynamics
     */    
    @GetMapping("/load")
    public TurbineLoadControllerDynamics load( @RequestParam(required=true) UUID turbineLoadControllerDynamicsId ) {
    	TurbineLoadControllerDynamics entity = null;

    	try {  
    		entity = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance().getTurbineLoadControllerDynamics( new TurbineLoadControllerDynamicsFetchOneSummary( turbineLoadControllerDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TurbineLoadControllerDynamics using Id " + turbineLoadControllerDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TurbineLoadControllerDynamics business objects
     * @return		Set<TurbineLoadControllerDynamics>
     */
    @GetMapping("/")
    public List<TurbineLoadControllerDynamics> loadAll() {                
    	List<TurbineLoadControllerDynamics> turbineLoadControllerDynamicsList = null;
        
    	try {
            // load the TurbineLoadControllerDynamics
            turbineLoadControllerDynamicsList = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance().getAllTurbineLoadControllerDynamics();
            
            if ( turbineLoadControllerDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TurbineLoadControllerDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TurbineLoadControllerDynamicss ", exc );
        	return null;
        }

        return turbineLoadControllerDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbineLoadControllerDynamics turbineLoadControllerDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(TurbineLoadControllerDynamicsQueryRestController.class.getName());
    
}
