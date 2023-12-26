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
 * Implements Spring Controller query CQRS processing for entity DCBreaker.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCBreaker")
public class DCBreakerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCBreaker using a UUID
     * @param		UUID dCBreakerId
     * @return		DCBreaker
     */    
    @GetMapping("/load")
    public DCBreaker load( @RequestParam(required=true) UUID dCBreakerId ) {
    	DCBreaker entity = null;

    	try {  
    		entity = DCBreakerBusinessDelegate.getDCBreakerInstance().getDCBreaker( new DCBreakerFetchOneSummary( dCBreakerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCBreaker using Id " + dCBreakerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCBreaker business objects
     * @return		Set<DCBreaker>
     */
    @GetMapping("/")
    public List<DCBreaker> loadAll() {                
    	List<DCBreaker> dCBreakerList = null;
        
    	try {
            // load the DCBreaker
            dCBreakerList = DCBreakerBusinessDelegate.getDCBreakerInstance().getAllDCBreaker();
            
            if ( dCBreakerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCBreakers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCBreakers ", exc );
        	return null;
        }

        return dCBreakerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCBreaker dCBreaker = null;
    private static final Logger LOGGER = Logger.getLogger(DCBreakerQueryRestController.class.getName());
    
}
