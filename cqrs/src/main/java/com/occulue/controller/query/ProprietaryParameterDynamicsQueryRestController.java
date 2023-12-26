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
 * Implements Spring Controller query CQRS processing for entity ProprietaryParameterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ProprietaryParameterDynamics")
public class ProprietaryParameterDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ProprietaryParameterDynamics using a UUID
     * @param		UUID proprietaryParameterDynamicsId
     * @return		ProprietaryParameterDynamics
     */    
    @GetMapping("/load")
    public ProprietaryParameterDynamics load( @RequestParam(required=true) UUID proprietaryParameterDynamicsId ) {
    	ProprietaryParameterDynamics entity = null;

    	try {  
    		entity = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().getProprietaryParameterDynamics( new ProprietaryParameterDynamicsFetchOneSummary( proprietaryParameterDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ProprietaryParameterDynamics using Id " + proprietaryParameterDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ProprietaryParameterDynamics business objects
     * @return		Set<ProprietaryParameterDynamics>
     */
    @GetMapping("/")
    public List<ProprietaryParameterDynamics> loadAll() {                
    	List<ProprietaryParameterDynamics> proprietaryParameterDynamicsList = null;
        
    	try {
            // load the ProprietaryParameterDynamics
            proprietaryParameterDynamicsList = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().getAllProprietaryParameterDynamics();
            
            if ( proprietaryParameterDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ProprietaryParameterDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ProprietaryParameterDynamicss ", exc );
        	return null;
        }

        return proprietaryParameterDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ProprietaryParameterDynamics proprietaryParameterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(ProprietaryParameterDynamicsQueryRestController.class.getName());
    
}
