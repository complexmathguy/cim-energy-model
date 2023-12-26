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
 * Implements Spring Controller query CQRS processing for entity DCChopper.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCChopper")
public class DCChopperQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCChopper using a UUID
     * @param		UUID dCChopperId
     * @return		DCChopper
     */    
    @GetMapping("/load")
    public DCChopper load( @RequestParam(required=true) UUID dCChopperId ) {
    	DCChopper entity = null;

    	try {  
    		entity = DCChopperBusinessDelegate.getDCChopperInstance().getDCChopper( new DCChopperFetchOneSummary( dCChopperId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCChopper using Id " + dCChopperId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCChopper business objects
     * @return		Set<DCChopper>
     */
    @GetMapping("/")
    public List<DCChopper> loadAll() {                
    	List<DCChopper> dCChopperList = null;
        
    	try {
            // load the DCChopper
            dCChopperList = DCChopperBusinessDelegate.getDCChopperInstance().getAllDCChopper();
            
            if ( dCChopperList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCChoppers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCChoppers ", exc );
        	return null;
        }

        return dCChopperList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCChopper dCChopper = null;
    private static final Logger LOGGER = Logger.getLogger(DCChopperQueryRestController.class.getName());
    
}
