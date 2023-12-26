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
 * Implements Spring Controller query CQRS processing for entity LoadDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadDynamics")
public class LoadDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadDynamics using a UUID
     * @param		UUID loadDynamicsId
     * @return		LoadDynamics
     */    
    @GetMapping("/load")
    public LoadDynamics load( @RequestParam(required=true) UUID loadDynamicsId ) {
    	LoadDynamics entity = null;

    	try {  
    		entity = LoadDynamicsBusinessDelegate.getLoadDynamicsInstance().getLoadDynamics( new LoadDynamicsFetchOneSummary( loadDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadDynamics using Id " + loadDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadDynamics business objects
     * @return		Set<LoadDynamics>
     */
    @GetMapping("/")
    public List<LoadDynamics> loadAll() {                
    	List<LoadDynamics> loadDynamicsList = null;
        
    	try {
            // load the LoadDynamics
            loadDynamicsList = LoadDynamicsBusinessDelegate.getLoadDynamicsInstance().getAllLoadDynamics();
            
            if ( loadDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadDynamicss ", exc );
        	return null;
        }

        return loadDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadDynamics loadDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(LoadDynamicsQueryRestController.class.getName());
    
}
