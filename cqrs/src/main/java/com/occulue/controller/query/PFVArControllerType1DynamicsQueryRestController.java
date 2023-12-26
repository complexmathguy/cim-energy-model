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
 * Implements Spring Controller query CQRS processing for entity PFVArControllerType1Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType1Dynamics")
public class PFVArControllerType1DynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArControllerType1Dynamics using a UUID
     * @param		UUID pFVArControllerType1DynamicsId
     * @return		PFVArControllerType1Dynamics
     */    
    @GetMapping("/load")
    public PFVArControllerType1Dynamics load( @RequestParam(required=true) UUID pFVArControllerType1DynamicsId ) {
    	PFVArControllerType1Dynamics entity = null;

    	try {  
    		entity = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().getPFVArControllerType1Dynamics( new PFVArControllerType1DynamicsFetchOneSummary( pFVArControllerType1DynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArControllerType1Dynamics using Id " + pFVArControllerType1DynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArControllerType1Dynamics business objects
     * @return		Set<PFVArControllerType1Dynamics>
     */
    @GetMapping("/")
    public List<PFVArControllerType1Dynamics> loadAll() {                
    	List<PFVArControllerType1Dynamics> pFVArControllerType1DynamicsList = null;
        
    	try {
            // load the PFVArControllerType1Dynamics
            pFVArControllerType1DynamicsList = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().getAllPFVArControllerType1Dynamics();
            
            if ( pFVArControllerType1DynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArControllerType1Dynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArControllerType1Dynamicss ", exc );
        	return null;
        }

        return pFVArControllerType1DynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType1Dynamics pFVArControllerType1Dynamics = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType1DynamicsQueryRestController.class.getName());
    
}
