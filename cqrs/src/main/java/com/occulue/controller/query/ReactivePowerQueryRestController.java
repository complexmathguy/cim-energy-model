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
 * Implements Spring Controller query CQRS processing for entity ReactivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ReactivePower")
public class ReactivePowerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ReactivePower using a UUID
     * @param		UUID reactivePowerId
     * @return		ReactivePower
     */    
    @GetMapping("/load")
    public ReactivePower load( @RequestParam(required=true) UUID reactivePowerId ) {
    	ReactivePower entity = null;

    	try {  
    		entity = ReactivePowerBusinessDelegate.getReactivePowerInstance().getReactivePower( new ReactivePowerFetchOneSummary( reactivePowerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ReactivePower using Id " + reactivePowerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ReactivePower business objects
     * @return		Set<ReactivePower>
     */
    @GetMapping("/")
    public List<ReactivePower> loadAll() {                
    	List<ReactivePower> reactivePowerList = null;
        
    	try {
            // load the ReactivePower
            reactivePowerList = ReactivePowerBusinessDelegate.getReactivePowerInstance().getAllReactivePower();
            
            if ( reactivePowerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ReactivePowers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ReactivePowers ", exc );
        	return null;
        }

        return reactivePowerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ReactivePower reactivePower = null;
    private static final Logger LOGGER = Logger.getLogger(ReactivePowerQueryRestController.class.getName());
    
}
