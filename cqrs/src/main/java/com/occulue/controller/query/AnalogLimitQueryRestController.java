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
 * Implements Spring Controller query CQRS processing for entity AnalogLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogLimit")
public class AnalogLimitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AnalogLimit using a UUID
     * @param		UUID analogLimitId
     * @return		AnalogLimit
     */    
    @GetMapping("/load")
    public AnalogLimit load( @RequestParam(required=true) UUID analogLimitId ) {
    	AnalogLimit entity = null;

    	try {  
    		entity = AnalogLimitBusinessDelegate.getAnalogLimitInstance().getAnalogLimit( new AnalogLimitFetchOneSummary( analogLimitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AnalogLimit using Id " + analogLimitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AnalogLimit business objects
     * @return		Set<AnalogLimit>
     */
    @GetMapping("/")
    public List<AnalogLimit> loadAll() {                
    	List<AnalogLimit> analogLimitList = null;
        
    	try {
            // load the AnalogLimit
            analogLimitList = AnalogLimitBusinessDelegate.getAnalogLimitInstance().getAllAnalogLimit();
            
            if ( analogLimitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AnalogLimits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AnalogLimits ", exc );
        	return null;
        }

        return analogLimitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AnalogLimit analogLimit = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogLimitQueryRestController.class.getName());
    
}
