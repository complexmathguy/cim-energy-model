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
 * Implements Spring Controller query CQRS processing for entity RotatingMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotatingMachineDynamics")
public class RotatingMachineDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RotatingMachineDynamics using a UUID
     * @param		UUID rotatingMachineDynamicsId
     * @return		RotatingMachineDynamics
     */    
    @GetMapping("/load")
    public RotatingMachineDynamics load( @RequestParam(required=true) UUID rotatingMachineDynamicsId ) {
    	RotatingMachineDynamics entity = null;

    	try {  
    		entity = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().getRotatingMachineDynamics( new RotatingMachineDynamicsFetchOneSummary( rotatingMachineDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RotatingMachineDynamics using Id " + rotatingMachineDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RotatingMachineDynamics business objects
     * @return		Set<RotatingMachineDynamics>
     */
    @GetMapping("/")
    public List<RotatingMachineDynamics> loadAll() {                
    	List<RotatingMachineDynamics> rotatingMachineDynamicsList = null;
        
    	try {
            // load the RotatingMachineDynamics
            rotatingMachineDynamicsList = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().getAllRotatingMachineDynamics();
            
            if ( rotatingMachineDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RotatingMachineDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RotatingMachineDynamicss ", exc );
        	return null;
        }

        return rotatingMachineDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RotatingMachineDynamics rotatingMachineDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(RotatingMachineDynamicsQueryRestController.class.getName());
    
}
