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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachineSimplified.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineSimplified")
public class SynchronousMachineSimplifiedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachineSimplified using a UUID
     * @param		UUID synchronousMachineSimplifiedId
     * @return		SynchronousMachineSimplified
     */    
    @GetMapping("/load")
    public SynchronousMachineSimplified load( @RequestParam(required=true) UUID synchronousMachineSimplifiedId ) {
    	SynchronousMachineSimplified entity = null;

    	try {  
    		entity = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().getSynchronousMachineSimplified( new SynchronousMachineSimplifiedFetchOneSummary( synchronousMachineSimplifiedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachineSimplified using Id " + synchronousMachineSimplifiedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachineSimplified business objects
     * @return		Set<SynchronousMachineSimplified>
     */
    @GetMapping("/")
    public List<SynchronousMachineSimplified> loadAll() {                
    	List<SynchronousMachineSimplified> synchronousMachineSimplifiedList = null;
        
    	try {
            // load the SynchronousMachineSimplified
            synchronousMachineSimplifiedList = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().getAllSynchronousMachineSimplified();
            
            if ( synchronousMachineSimplifiedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachineSimplifieds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachineSimplifieds ", exc );
        	return null;
        }

        return synchronousMachineSimplifiedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineSimplified synchronousMachineSimplified = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineSimplifiedQueryRestController.class.getName());
    
}
