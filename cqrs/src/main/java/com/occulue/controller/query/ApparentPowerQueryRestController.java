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
 * Implements Spring Controller query CQRS processing for entity ApparentPower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ApparentPower")
public class ApparentPowerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ApparentPower using a UUID
     * @param		UUID apparentPowerId
     * @return		ApparentPower
     */    
    @GetMapping("/load")
    public ApparentPower load( @RequestParam(required=true) UUID apparentPowerId ) {
    	ApparentPower entity = null;

    	try {  
    		entity = ApparentPowerBusinessDelegate.getApparentPowerInstance().getApparentPower( new ApparentPowerFetchOneSummary( apparentPowerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ApparentPower using Id " + apparentPowerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ApparentPower business objects
     * @return		Set<ApparentPower>
     */
    @GetMapping("/")
    public List<ApparentPower> loadAll() {                
    	List<ApparentPower> apparentPowerList = null;
        
    	try {
            // load the ApparentPower
            apparentPowerList = ApparentPowerBusinessDelegate.getApparentPowerInstance().getAllApparentPower();
            
            if ( apparentPowerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ApparentPowers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ApparentPowers ", exc );
        	return null;
        }

        return apparentPowerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ApparentPower apparentPower = null;
    private static final Logger LOGGER = Logger.getLogger(ApparentPowerQueryRestController.class.getName());
    
}
