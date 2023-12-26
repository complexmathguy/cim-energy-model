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
 * Implements Spring Controller query CQRS processing for entity UnderexcitationLimiterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcitationLimiterDynamics")
public class UnderexcitationLimiterDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a UnderexcitationLimiterDynamics using a UUID
     * @param		UUID underexcitationLimiterDynamicsId
     * @return		UnderexcitationLimiterDynamics
     */    
    @GetMapping("/load")
    public UnderexcitationLimiterDynamics load( @RequestParam(required=true) UUID underexcitationLimiterDynamicsId ) {
    	UnderexcitationLimiterDynamics entity = null;

    	try {  
    		entity = UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance().getUnderexcitationLimiterDynamics( new UnderexcitationLimiterDynamicsFetchOneSummary( underexcitationLimiterDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load UnderexcitationLimiterDynamics using Id " + underexcitationLimiterDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all UnderexcitationLimiterDynamics business objects
     * @return		Set<UnderexcitationLimiterDynamics>
     */
    @GetMapping("/")
    public List<UnderexcitationLimiterDynamics> loadAll() {                
    	List<UnderexcitationLimiterDynamics> underexcitationLimiterDynamicsList = null;
        
    	try {
            // load the UnderexcitationLimiterDynamics
            underexcitationLimiterDynamicsList = UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance().getAllUnderexcitationLimiterDynamics();
            
            if ( underexcitationLimiterDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all UnderexcitationLimiterDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all UnderexcitationLimiterDynamicss ", exc );
        	return null;
        }

        return underexcitationLimiterDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcitationLimiterDynamics underexcitationLimiterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcitationLimiterDynamicsQueryRestController.class.getName());
    
}
