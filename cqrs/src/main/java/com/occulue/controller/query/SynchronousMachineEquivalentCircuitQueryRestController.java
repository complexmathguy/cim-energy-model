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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachineEquivalentCircuit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineEquivalentCircuit")
public class SynchronousMachineEquivalentCircuitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachineEquivalentCircuit using a UUID
     * @param		UUID synchronousMachineEquivalentCircuitId
     * @return		SynchronousMachineEquivalentCircuit
     */    
    @GetMapping("/load")
    public SynchronousMachineEquivalentCircuit load( @RequestParam(required=true) UUID synchronousMachineEquivalentCircuitId ) {
    	SynchronousMachineEquivalentCircuit entity = null;

    	try {  
    		entity = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().getSynchronousMachineEquivalentCircuit( new SynchronousMachineEquivalentCircuitFetchOneSummary( synchronousMachineEquivalentCircuitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachineEquivalentCircuit using Id " + synchronousMachineEquivalentCircuitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachineEquivalentCircuit business objects
     * @return		Set<SynchronousMachineEquivalentCircuit>
     */
    @GetMapping("/")
    public List<SynchronousMachineEquivalentCircuit> loadAll() {                
    	List<SynchronousMachineEquivalentCircuit> synchronousMachineEquivalentCircuitList = null;
        
    	try {
            // load the SynchronousMachineEquivalentCircuit
            synchronousMachineEquivalentCircuitList = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().getAllSynchronousMachineEquivalentCircuit();
            
            if ( synchronousMachineEquivalentCircuitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachineEquivalentCircuits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachineEquivalentCircuits ", exc );
        	return null;
        }

        return synchronousMachineEquivalentCircuitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineEquivalentCircuitQueryRestController.class.getName());
    
}
