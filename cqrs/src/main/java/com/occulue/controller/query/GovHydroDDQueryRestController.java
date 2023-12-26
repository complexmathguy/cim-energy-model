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
 * Implements Spring Controller query CQRS processing for entity GovHydroDD.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroDD")
public class GovHydroDDQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroDD using a UUID
     * @param		UUID govHydroDDId
     * @return		GovHydroDD
     */    
    @GetMapping("/load")
    public GovHydroDD load( @RequestParam(required=true) UUID govHydroDDId ) {
    	GovHydroDD entity = null;

    	try {  
    		entity = GovHydroDDBusinessDelegate.getGovHydroDDInstance().getGovHydroDD( new GovHydroDDFetchOneSummary( govHydroDDId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroDD using Id " + govHydroDDId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroDD business objects
     * @return		Set<GovHydroDD>
     */
    @GetMapping("/")
    public List<GovHydroDD> loadAll() {                
    	List<GovHydroDD> govHydroDDList = null;
        
    	try {
            // load the GovHydroDD
            govHydroDDList = GovHydroDDBusinessDelegate.getGovHydroDDInstance().getAllGovHydroDD();
            
            if ( govHydroDDList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroDDs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroDDs ", exc );
        	return null;
        }

        return govHydroDDList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroDD govHydroDD = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroDDQueryRestController.class.getName());
    
}
