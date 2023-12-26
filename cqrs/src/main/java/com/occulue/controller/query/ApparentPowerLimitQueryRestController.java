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
 * Implements Spring Controller query CQRS processing for entity ApparentPowerLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ApparentPowerLimit")
public class ApparentPowerLimitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ApparentPowerLimit using a UUID
     * @param		UUID apparentPowerLimitId
     * @return		ApparentPowerLimit
     */    
    @GetMapping("/load")
    public ApparentPowerLimit load( @RequestParam(required=true) UUID apparentPowerLimitId ) {
    	ApparentPowerLimit entity = null;

    	try {  
    		entity = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance().getApparentPowerLimit( new ApparentPowerLimitFetchOneSummary( apparentPowerLimitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ApparentPowerLimit using Id " + apparentPowerLimitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ApparentPowerLimit business objects
     * @return		Set<ApparentPowerLimit>
     */
    @GetMapping("/")
    public List<ApparentPowerLimit> loadAll() {                
    	List<ApparentPowerLimit> apparentPowerLimitList = null;
        
    	try {
            // load the ApparentPowerLimit
            apparentPowerLimitList = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance().getAllApparentPowerLimit();
            
            if ( apparentPowerLimitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ApparentPowerLimits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ApparentPowerLimits ", exc );
        	return null;
        }

        return apparentPowerLimitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ApparentPowerLimit apparentPowerLimit = null;
    private static final Logger LOGGER = Logger.getLogger(ApparentPowerLimitQueryRestController.class.getName());
    
}
