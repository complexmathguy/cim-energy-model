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
 * Implements Spring Controller query CQRS processing for entity AsynchronousMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineDynamics")
public class AsynchronousMachineDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AsynchronousMachineDynamics using a UUID
     * @param		UUID asynchronousMachineDynamicsId
     * @return		AsynchronousMachineDynamics
     */    
    @GetMapping("/load")
    public AsynchronousMachineDynamics load( @RequestParam(required=true) UUID asynchronousMachineDynamicsId ) {
    	AsynchronousMachineDynamics entity = null;

    	try {  
    		entity = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().getAsynchronousMachineDynamics( new AsynchronousMachineDynamicsFetchOneSummary( asynchronousMachineDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AsynchronousMachineDynamics using Id " + asynchronousMachineDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AsynchronousMachineDynamics business objects
     * @return		Set<AsynchronousMachineDynamics>
     */
    @GetMapping("/")
    public List<AsynchronousMachineDynamics> loadAll() {                
    	List<AsynchronousMachineDynamics> asynchronousMachineDynamicsList = null;
        
    	try {
            // load the AsynchronousMachineDynamics
            asynchronousMachineDynamicsList = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().getAllAsynchronousMachineDynamics();
            
            if ( asynchronousMachineDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AsynchronousMachineDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AsynchronousMachineDynamicss ", exc );
        	return null;
        }

        return asynchronousMachineDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachineDynamics asynchronousMachineDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineDynamicsQueryRestController.class.getName());
    
}
