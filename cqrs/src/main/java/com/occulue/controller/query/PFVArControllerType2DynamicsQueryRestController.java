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
 * Implements Spring Controller query CQRS processing for entity PFVArControllerType2Dynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType2Dynamics")
public class PFVArControllerType2DynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArControllerType2Dynamics using a UUID
     * @param		UUID pFVArControllerType2DynamicsId
     * @return		PFVArControllerType2Dynamics
     */    
    @GetMapping("/load")
    public PFVArControllerType2Dynamics load( @RequestParam(required=true) UUID pFVArControllerType2DynamicsId ) {
    	PFVArControllerType2Dynamics entity = null;

    	try {  
    		entity = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance().getPFVArControllerType2Dynamics( new PFVArControllerType2DynamicsFetchOneSummary( pFVArControllerType2DynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArControllerType2Dynamics using Id " + pFVArControllerType2DynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArControllerType2Dynamics business objects
     * @return		Set<PFVArControllerType2Dynamics>
     */
    @GetMapping("/")
    public List<PFVArControllerType2Dynamics> loadAll() {                
    	List<PFVArControllerType2Dynamics> pFVArControllerType2DynamicsList = null;
        
    	try {
            // load the PFVArControllerType2Dynamics
            pFVArControllerType2DynamicsList = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance().getAllPFVArControllerType2Dynamics();
            
            if ( pFVArControllerType2DynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArControllerType2Dynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArControllerType2Dynamicss ", exc );
        	return null;
        }

        return pFVArControllerType2DynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType2Dynamics pFVArControllerType2Dynamics = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType2DynamicsQueryRestController.class.getName());
    
}
