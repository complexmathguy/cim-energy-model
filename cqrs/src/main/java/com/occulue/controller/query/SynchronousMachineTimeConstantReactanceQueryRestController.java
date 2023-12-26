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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachineTimeConstantReactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineTimeConstantReactance")
public class SynchronousMachineTimeConstantReactanceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachineTimeConstantReactance using a UUID
     * @param		UUID synchronousMachineTimeConstantReactanceId
     * @return		SynchronousMachineTimeConstantReactance
     */    
    @GetMapping("/load")
    public SynchronousMachineTimeConstantReactance load( @RequestParam(required=true) UUID synchronousMachineTimeConstantReactanceId ) {
    	SynchronousMachineTimeConstantReactance entity = null;

    	try {  
    		entity = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().getSynchronousMachineTimeConstantReactance( new SynchronousMachineTimeConstantReactanceFetchOneSummary( synchronousMachineTimeConstantReactanceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachineTimeConstantReactance using Id " + synchronousMachineTimeConstantReactanceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachineTimeConstantReactance business objects
     * @return		Set<SynchronousMachineTimeConstantReactance>
     */
    @GetMapping("/")
    public List<SynchronousMachineTimeConstantReactance> loadAll() {                
    	List<SynchronousMachineTimeConstantReactance> synchronousMachineTimeConstantReactanceList = null;
        
    	try {
            // load the SynchronousMachineTimeConstantReactance
            synchronousMachineTimeConstantReactanceList = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().getAllSynchronousMachineTimeConstantReactance();
            
            if ( synchronousMachineTimeConstantReactanceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachineTimeConstantReactances" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachineTimeConstantReactances ", exc );
        	return null;
        }

        return synchronousMachineTimeConstantReactanceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineTimeConstantReactanceQueryRestController.class.getName());
    
}
