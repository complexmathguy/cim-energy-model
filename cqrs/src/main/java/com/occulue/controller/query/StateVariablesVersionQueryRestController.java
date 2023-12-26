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
 * Implements Spring Controller query CQRS processing for entity StateVariablesVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StateVariablesVersion")
public class StateVariablesVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a StateVariablesVersion using a UUID
     * @param		UUID stateVariablesVersionId
     * @return		StateVariablesVersion
     */    
    @GetMapping("/load")
    public StateVariablesVersion load( @RequestParam(required=true) UUID stateVariablesVersionId ) {
    	StateVariablesVersion entity = null;

    	try {  
    		entity = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().getStateVariablesVersion( new StateVariablesVersionFetchOneSummary( stateVariablesVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load StateVariablesVersion using Id " + stateVariablesVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all StateVariablesVersion business objects
     * @return		Set<StateVariablesVersion>
     */
    @GetMapping("/")
    public List<StateVariablesVersion> loadAll() {                
    	List<StateVariablesVersion> stateVariablesVersionList = null;
        
    	try {
            // load the StateVariablesVersion
            stateVariablesVersionList = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().getAllStateVariablesVersion();
            
            if ( stateVariablesVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all StateVariablesVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all StateVariablesVersions ", exc );
        	return null;
        }

        return stateVariablesVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected StateVariablesVersion stateVariablesVersion = null;
    private static final Logger LOGGER = Logger.getLogger(StateVariablesVersionQueryRestController.class.getName());
    
}
