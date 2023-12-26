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
 * Implements Spring Controller query CQRS processing for entity DCShunt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCShunt")
public class DCShuntQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCShunt using a UUID
     * @param		UUID dCShuntId
     * @return		DCShunt
     */    
    @GetMapping("/load")
    public DCShunt load( @RequestParam(required=true) UUID dCShuntId ) {
    	DCShunt entity = null;

    	try {  
    		entity = DCShuntBusinessDelegate.getDCShuntInstance().getDCShunt( new DCShuntFetchOneSummary( dCShuntId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCShunt using Id " + dCShuntId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCShunt business objects
     * @return		Set<DCShunt>
     */
    @GetMapping("/")
    public List<DCShunt> loadAll() {                
    	List<DCShunt> dCShuntList = null;
        
    	try {
            // load the DCShunt
            dCShuntList = DCShuntBusinessDelegate.getDCShuntInstance().getAllDCShunt();
            
            if ( dCShuntList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCShunts" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCShunts ", exc );
        	return null;
        }

        return dCShuntList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCShunt dCShunt = null;
    private static final Logger LOGGER = Logger.getLogger(DCShuntQueryRestController.class.getName());
    
}
