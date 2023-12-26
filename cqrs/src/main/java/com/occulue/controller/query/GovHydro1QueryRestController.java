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
 * Implements Spring Controller query CQRS processing for entity GovHydro1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro1")
public class GovHydro1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydro1 using a UUID
     * @param		UUID govHydro1Id
     * @return		GovHydro1
     */    
    @GetMapping("/load")
    public GovHydro1 load( @RequestParam(required=true) UUID govHydro1Id ) {
    	GovHydro1 entity = null;

    	try {  
    		entity = GovHydro1BusinessDelegate.getGovHydro1Instance().getGovHydro1( new GovHydro1FetchOneSummary( govHydro1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydro1 using Id " + govHydro1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydro1 business objects
     * @return		Set<GovHydro1>
     */
    @GetMapping("/")
    public List<GovHydro1> loadAll() {                
    	List<GovHydro1> govHydro1List = null;
        
    	try {
            // load the GovHydro1
            govHydro1List = GovHydro1BusinessDelegate.getGovHydro1Instance().getAllGovHydro1();
            
            if ( govHydro1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydro1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydro1s ", exc );
        	return null;
        }

        return govHydro1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydro1 govHydro1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydro1QueryRestController.class.getName());
    
}
