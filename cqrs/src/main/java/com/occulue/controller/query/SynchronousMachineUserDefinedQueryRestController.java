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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachineUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineUserDefined")
public class SynchronousMachineUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachineUserDefined using a UUID
     * @param		UUID synchronousMachineUserDefinedId
     * @return		SynchronousMachineUserDefined
     */    
    @GetMapping("/load")
    public SynchronousMachineUserDefined load( @RequestParam(required=true) UUID synchronousMachineUserDefinedId ) {
    	SynchronousMachineUserDefined entity = null;

    	try {  
    		entity = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().getSynchronousMachineUserDefined( new SynchronousMachineUserDefinedFetchOneSummary( synchronousMachineUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachineUserDefined using Id " + synchronousMachineUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachineUserDefined business objects
     * @return		Set<SynchronousMachineUserDefined>
     */
    @GetMapping("/")
    public List<SynchronousMachineUserDefined> loadAll() {                
    	List<SynchronousMachineUserDefined> synchronousMachineUserDefinedList = null;
        
    	try {
            // load the SynchronousMachineUserDefined
            synchronousMachineUserDefinedList = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().getAllSynchronousMachineUserDefined();
            
            if ( synchronousMachineUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachineUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachineUserDefineds ", exc );
        	return null;
        }

        return synchronousMachineUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineUserDefined synchronousMachineUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineUserDefinedQueryRestController.class.getName());
    
}
