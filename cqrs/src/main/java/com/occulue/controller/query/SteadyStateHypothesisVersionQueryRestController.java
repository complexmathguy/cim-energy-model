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
 * Implements Spring Controller query CQRS processing for entity SteadyStateHypothesisVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SteadyStateHypothesisVersion")
public class SteadyStateHypothesisVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SteadyStateHypothesisVersion using a UUID
     * @param		UUID steadyStateHypothesisVersionId
     * @return		SteadyStateHypothesisVersion
     */    
    @GetMapping("/load")
    public SteadyStateHypothesisVersion load( @RequestParam(required=true) UUID steadyStateHypothesisVersionId ) {
    	SteadyStateHypothesisVersion entity = null;

    	try {  
    		entity = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().getSteadyStateHypothesisVersion( new SteadyStateHypothesisVersionFetchOneSummary( steadyStateHypothesisVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SteadyStateHypothesisVersion using Id " + steadyStateHypothesisVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SteadyStateHypothesisVersion business objects
     * @return		Set<SteadyStateHypothesisVersion>
     */
    @GetMapping("/")
    public List<SteadyStateHypothesisVersion> loadAll() {                
    	List<SteadyStateHypothesisVersion> steadyStateHypothesisVersionList = null;
        
    	try {
            // load the SteadyStateHypothesisVersion
            steadyStateHypothesisVersionList = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().getAllSteadyStateHypothesisVersion();
            
            if ( steadyStateHypothesisVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SteadyStateHypothesisVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SteadyStateHypothesisVersions ", exc );
        	return null;
        }

        return steadyStateHypothesisVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SteadyStateHypothesisVersion steadyStateHypothesisVersion = null;
    private static final Logger LOGGER = Logger.getLogger(SteadyStateHypothesisVersionQueryRestController.class.getName());
    
}
