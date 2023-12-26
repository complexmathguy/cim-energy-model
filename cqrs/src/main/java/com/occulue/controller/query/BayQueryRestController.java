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
 * Implements Spring Controller query CQRS processing for entity Bay.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Bay")
public class BayQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Bay using a UUID
     * @param		UUID bayId
     * @return		Bay
     */    
    @GetMapping("/load")
    public Bay load( @RequestParam(required=true) UUID bayId ) {
    	Bay entity = null;

    	try {  
    		entity = BayBusinessDelegate.getBayInstance().getBay( new BayFetchOneSummary( bayId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Bay using Id " + bayId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Bay business objects
     * @return		Set<Bay>
     */
    @GetMapping("/")
    public List<Bay> loadAll() {                
    	List<Bay> bayList = null;
        
    	try {
            // load the Bay
            bayList = BayBusinessDelegate.getBayInstance().getAllBay();
            
            if ( bayList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Bays" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Bays ", exc );
        	return null;
        }

        return bayList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Bay bay = null;
    private static final Logger LOGGER = Logger.getLogger(BayQueryRestController.class.getName());
    
}
