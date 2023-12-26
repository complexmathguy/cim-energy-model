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
 * Implements Spring Controller query CQRS processing for entity GovSteam1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam1")
public class GovSteam1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteam1 using a UUID
     * @param		UUID govSteam1Id
     * @return		GovSteam1
     */    
    @GetMapping("/load")
    public GovSteam1 load( @RequestParam(required=true) UUID govSteam1Id ) {
    	GovSteam1 entity = null;

    	try {  
    		entity = GovSteam1BusinessDelegate.getGovSteam1Instance().getGovSteam1( new GovSteam1FetchOneSummary( govSteam1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteam1 using Id " + govSteam1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteam1 business objects
     * @return		Set<GovSteam1>
     */
    @GetMapping("/")
    public List<GovSteam1> loadAll() {                
    	List<GovSteam1> govSteam1List = null;
        
    	try {
            // load the GovSteam1
            govSteam1List = GovSteam1BusinessDelegate.getGovSteam1Instance().getAllGovSteam1();
            
            if ( govSteam1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteam1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteam1s ", exc );
        	return null;
        }

        return govSteam1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteam1 govSteam1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteam1QueryRestController.class.getName());
    
}
