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
 * Implements Spring Controller query CQRS processing for entity OverexcitationLimiterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcitationLimiterDynamics")
public class OverexcitationLimiterDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a OverexcitationLimiterDynamics using a UUID
     * @param		UUID overexcitationLimiterDynamicsId
     * @return		OverexcitationLimiterDynamics
     */    
    @GetMapping("/load")
    public OverexcitationLimiterDynamics load( @RequestParam(required=true) UUID overexcitationLimiterDynamicsId ) {
    	OverexcitationLimiterDynamics entity = null;

    	try {  
    		entity = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().getOverexcitationLimiterDynamics( new OverexcitationLimiterDynamicsFetchOneSummary( overexcitationLimiterDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load OverexcitationLimiterDynamics using Id " + overexcitationLimiterDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all OverexcitationLimiterDynamics business objects
     * @return		Set<OverexcitationLimiterDynamics>
     */
    @GetMapping("/")
    public List<OverexcitationLimiterDynamics> loadAll() {                
    	List<OverexcitationLimiterDynamics> overexcitationLimiterDynamicsList = null;
        
    	try {
            // load the OverexcitationLimiterDynamics
            overexcitationLimiterDynamicsList = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().getAllOverexcitationLimiterDynamics();
            
            if ( overexcitationLimiterDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all OverexcitationLimiterDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all OverexcitationLimiterDynamicss ", exc );
        	return null;
        }

        return overexcitationLimiterDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcitationLimiterDynamics overexcitationLimiterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcitationLimiterDynamicsQueryRestController.class.getName());
    
}
