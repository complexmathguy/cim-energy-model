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
 * Implements Spring Controller query CQRS processing for entity GovHydro2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro2")
public class GovHydro2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydro2 using a UUID
     * @param		UUID govHydro2Id
     * @return		GovHydro2
     */    
    @GetMapping("/load")
    public GovHydro2 load( @RequestParam(required=true) UUID govHydro2Id ) {
    	GovHydro2 entity = null;

    	try {  
    		entity = GovHydro2BusinessDelegate.getGovHydro2Instance().getGovHydro2( new GovHydro2FetchOneSummary( govHydro2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydro2 using Id " + govHydro2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydro2 business objects
     * @return		Set<GovHydro2>
     */
    @GetMapping("/")
    public List<GovHydro2> loadAll() {                
    	List<GovHydro2> govHydro2List = null;
        
    	try {
            // load the GovHydro2
            govHydro2List = GovHydro2BusinessDelegate.getGovHydro2Instance().getAllGovHydro2();
            
            if ( govHydro2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydro2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydro2s ", exc );
        	return null;
        }

        return govHydro2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydro2 govHydro2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydro2QueryRestController.class.getName());
    
}
