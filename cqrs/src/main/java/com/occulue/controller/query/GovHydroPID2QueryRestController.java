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
 * Implements Spring Controller query CQRS processing for entity GovHydroPID2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPID2")
public class GovHydroPID2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroPID2 using a UUID
     * @param		UUID govHydroPID2Id
     * @return		GovHydroPID2
     */    
    @GetMapping("/load")
    public GovHydroPID2 load( @RequestParam(required=true) UUID govHydroPID2Id ) {
    	GovHydroPID2 entity = null;

    	try {  
    		entity = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().getGovHydroPID2( new GovHydroPID2FetchOneSummary( govHydroPID2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroPID2 using Id " + govHydroPID2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroPID2 business objects
     * @return		Set<GovHydroPID2>
     */
    @GetMapping("/")
    public List<GovHydroPID2> loadAll() {                
    	List<GovHydroPID2> govHydroPID2List = null;
        
    	try {
            // load the GovHydroPID2
            govHydroPID2List = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().getAllGovHydroPID2();
            
            if ( govHydroPID2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroPID2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroPID2s ", exc );
        	return null;
        }

        return govHydroPID2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroPID2 govHydroPID2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroPID2QueryRestController.class.getName());
    
}
