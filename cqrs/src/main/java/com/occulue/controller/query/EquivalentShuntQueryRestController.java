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
 * Implements Spring Controller query CQRS processing for entity EquivalentShunt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentShunt")
public class EquivalentShuntQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquivalentShunt using a UUID
     * @param		UUID equivalentShuntId
     * @return		EquivalentShunt
     */    
    @GetMapping("/load")
    public EquivalentShunt load( @RequestParam(required=true) UUID equivalentShuntId ) {
    	EquivalentShunt entity = null;

    	try {  
    		entity = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().getEquivalentShunt( new EquivalentShuntFetchOneSummary( equivalentShuntId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquivalentShunt using Id " + equivalentShuntId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquivalentShunt business objects
     * @return		Set<EquivalentShunt>
     */
    @GetMapping("/")
    public List<EquivalentShunt> loadAll() {                
    	List<EquivalentShunt> equivalentShuntList = null;
        
    	try {
            // load the EquivalentShunt
            equivalentShuntList = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().getAllEquivalentShunt();
            
            if ( equivalentShuntList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquivalentShunts" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquivalentShunts ", exc );
        	return null;
        }

        return equivalentShuntList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentShunt equivalentShunt = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentShuntQueryRestController.class.getName());
    
}
