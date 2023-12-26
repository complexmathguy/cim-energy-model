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
 * Implements Spring Controller query CQRS processing for entity ExcitationSystemDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcitationSystemDynamics")
public class ExcitationSystemDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcitationSystemDynamics using a UUID
     * @param		UUID excitationSystemDynamicsId
     * @return		ExcitationSystemDynamics
     */    
    @GetMapping("/load")
    public ExcitationSystemDynamics load( @RequestParam(required=true) UUID excitationSystemDynamicsId ) {
    	ExcitationSystemDynamics entity = null;

    	try {  
    		entity = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().getExcitationSystemDynamics( new ExcitationSystemDynamicsFetchOneSummary( excitationSystemDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcitationSystemDynamics using Id " + excitationSystemDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcitationSystemDynamics business objects
     * @return		Set<ExcitationSystemDynamics>
     */
    @GetMapping("/")
    public List<ExcitationSystemDynamics> loadAll() {                
    	List<ExcitationSystemDynamics> excitationSystemDynamicsList = null;
        
    	try {
            // load the ExcitationSystemDynamics
            excitationSystemDynamicsList = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().getAllExcitationSystemDynamics();
            
            if ( excitationSystemDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcitationSystemDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcitationSystemDynamicss ", exc );
        	return null;
        }

        return excitationSystemDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcitationSystemDynamics excitationSystemDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(ExcitationSystemDynamicsQueryRestController.class.getName());
    
}
