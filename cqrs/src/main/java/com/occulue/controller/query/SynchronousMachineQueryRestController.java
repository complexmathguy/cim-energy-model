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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachine")
public class SynchronousMachineQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachine using a UUID
     * @param		UUID synchronousMachineId
     * @return		SynchronousMachine
     */    
    @GetMapping("/load")
    public SynchronousMachine load( @RequestParam(required=true) UUID synchronousMachineId ) {
    	SynchronousMachine entity = null;

    	try {  
    		entity = SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().getSynchronousMachine( new SynchronousMachineFetchOneSummary( synchronousMachineId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachine using Id " + synchronousMachineId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachine business objects
     * @return		Set<SynchronousMachine>
     */
    @GetMapping("/")
    public List<SynchronousMachine> loadAll() {                
    	List<SynchronousMachine> synchronousMachineList = null;
        
    	try {
            // load the SynchronousMachine
            synchronousMachineList = SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().getAllSynchronousMachine();
            
            if ( synchronousMachineList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachines" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachines ", exc );
        	return null;
        }

        return synchronousMachineList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachine synchronousMachine = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineQueryRestController.class.getName());
    
}
