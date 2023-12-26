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
 * Implements Spring Controller query CQRS processing for entity AsynchronousMachineUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineUserDefined")
public class AsynchronousMachineUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AsynchronousMachineUserDefined using a UUID
     * @param		UUID asynchronousMachineUserDefinedId
     * @return		AsynchronousMachineUserDefined
     */    
    @GetMapping("/load")
    public AsynchronousMachineUserDefined load( @RequestParam(required=true) UUID asynchronousMachineUserDefinedId ) {
    	AsynchronousMachineUserDefined entity = null;

    	try {  
    		entity = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().getAsynchronousMachineUserDefined( new AsynchronousMachineUserDefinedFetchOneSummary( asynchronousMachineUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AsynchronousMachineUserDefined using Id " + asynchronousMachineUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AsynchronousMachineUserDefined business objects
     * @return		Set<AsynchronousMachineUserDefined>
     */
    @GetMapping("/")
    public List<AsynchronousMachineUserDefined> loadAll() {                
    	List<AsynchronousMachineUserDefined> asynchronousMachineUserDefinedList = null;
        
    	try {
            // load the AsynchronousMachineUserDefined
            asynchronousMachineUserDefinedList = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().getAllAsynchronousMachineUserDefined();
            
            if ( asynchronousMachineUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AsynchronousMachineUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AsynchronousMachineUserDefineds ", exc );
        	return null;
        }

        return asynchronousMachineUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AsynchronousMachineUserDefined asynchronousMachineUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(AsynchronousMachineUserDefinedQueryRestController.class.getName());
    
}
