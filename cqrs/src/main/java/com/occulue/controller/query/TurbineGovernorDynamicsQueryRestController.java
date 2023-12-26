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
 * Implements Spring Controller query CQRS processing for entity TurbineGovernorDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineGovernorDynamics")
public class TurbineGovernorDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TurbineGovernorDynamics using a UUID
     * @param		UUID turbineGovernorDynamicsId
     * @return		TurbineGovernorDynamics
     */    
    @GetMapping("/load")
    public TurbineGovernorDynamics load( @RequestParam(required=true) UUID turbineGovernorDynamicsId ) {
    	TurbineGovernorDynamics entity = null;

    	try {  
    		entity = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().getTurbineGovernorDynamics( new TurbineGovernorDynamicsFetchOneSummary( turbineGovernorDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TurbineGovernorDynamics using Id " + turbineGovernorDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TurbineGovernorDynamics business objects
     * @return		Set<TurbineGovernorDynamics>
     */
    @GetMapping("/")
    public List<TurbineGovernorDynamics> loadAll() {                
    	List<TurbineGovernorDynamics> turbineGovernorDynamicsList = null;
        
    	try {
            // load the TurbineGovernorDynamics
            turbineGovernorDynamicsList = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().getAllTurbineGovernorDynamics();
            
            if ( turbineGovernorDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TurbineGovernorDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TurbineGovernorDynamicss ", exc );
        	return null;
        }

        return turbineGovernorDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbineGovernorDynamics turbineGovernorDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(TurbineGovernorDynamicsQueryRestController.class.getName());
    
}
