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
 * Implements Spring Controller query CQRS processing for entity Limit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Limit")
public class LimitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Limit using a UUID
     * @param		UUID limitId
     * @return		Limit
     */    
    @GetMapping("/load")
    public Limit load( @RequestParam(required=true) UUID limitId ) {
    	Limit entity = null;

    	try {  
    		entity = LimitBusinessDelegate.getLimitInstance().getLimit( new LimitFetchOneSummary( limitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Limit using Id " + limitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Limit business objects
     * @return		Set<Limit>
     */
    @GetMapping("/")
    public List<Limit> loadAll() {                
    	List<Limit> limitList = null;
        
    	try {
            // load the Limit
            limitList = LimitBusinessDelegate.getLimitInstance().getAllLimit();
            
            if ( limitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Limits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Limits ", exc );
        	return null;
        }

        return limitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Limit limit = null;
    private static final Logger LOGGER = Logger.getLogger(LimitQueryRestController.class.getName());
    
}
