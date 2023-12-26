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
 * Implements Spring Controller query CQRS processing for entity GovHydroFrancis.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroFrancis")
public class GovHydroFrancisQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroFrancis using a UUID
     * @param		UUID govHydroFrancisId
     * @return		GovHydroFrancis
     */    
    @GetMapping("/load")
    public GovHydroFrancis load( @RequestParam(required=true) UUID govHydroFrancisId ) {
    	GovHydroFrancis entity = null;

    	try {  
    		entity = GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().getGovHydroFrancis( new GovHydroFrancisFetchOneSummary( govHydroFrancisId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroFrancis using Id " + govHydroFrancisId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroFrancis business objects
     * @return		Set<GovHydroFrancis>
     */
    @GetMapping("/")
    public List<GovHydroFrancis> loadAll() {                
    	List<GovHydroFrancis> govHydroFrancisList = null;
        
    	try {
            // load the GovHydroFrancis
            govHydroFrancisList = GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().getAllGovHydroFrancis();
            
            if ( govHydroFrancisList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroFranciss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroFranciss ", exc );
        	return null;
        }

        return govHydroFrancisList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroFrancis govHydroFrancis = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroFrancisQueryRestController.class.getName());
    
}
