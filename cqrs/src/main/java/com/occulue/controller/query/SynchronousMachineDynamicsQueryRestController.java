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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineDynamics")
public class SynchronousMachineDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachineDynamics using a UUID
     * @param		UUID synchronousMachineDynamicsId
     * @return		SynchronousMachineDynamics
     */    
    @GetMapping("/load")
    public SynchronousMachineDynamics load( @RequestParam(required=true) UUID synchronousMachineDynamicsId ) {
    	SynchronousMachineDynamics entity = null;

    	try {  
    		entity = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().getSynchronousMachineDynamics( new SynchronousMachineDynamicsFetchOneSummary( synchronousMachineDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachineDynamics using Id " + synchronousMachineDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachineDynamics business objects
     * @return		Set<SynchronousMachineDynamics>
     */
    @GetMapping("/")
    public List<SynchronousMachineDynamics> loadAll() {                
    	List<SynchronousMachineDynamics> synchronousMachineDynamicsList = null;
        
    	try {
            // load the SynchronousMachineDynamics
            synchronousMachineDynamicsList = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().getAllSynchronousMachineDynamics();
            
            if ( synchronousMachineDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachineDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachineDynamicss ", exc );
        	return null;
        }

        return synchronousMachineDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineDynamics synchronousMachineDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineDynamicsQueryRestController.class.getName());
    
}
