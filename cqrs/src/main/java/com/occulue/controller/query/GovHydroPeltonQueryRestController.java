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
 * Implements Spring Controller query CQRS processing for entity GovHydroPelton.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPelton")
public class GovHydroPeltonQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroPelton using a UUID
     * @param		UUID govHydroPeltonId
     * @return		GovHydroPelton
     */    
    @GetMapping("/load")
    public GovHydroPelton load( @RequestParam(required=true) UUID govHydroPeltonId ) {
    	GovHydroPelton entity = null;

    	try {  
    		entity = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().getGovHydroPelton( new GovHydroPeltonFetchOneSummary( govHydroPeltonId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroPelton using Id " + govHydroPeltonId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroPelton business objects
     * @return		Set<GovHydroPelton>
     */
    @GetMapping("/")
    public List<GovHydroPelton> loadAll() {                
    	List<GovHydroPelton> govHydroPeltonList = null;
        
    	try {
            // load the GovHydroPelton
            govHydroPeltonList = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().getAllGovHydroPelton();
            
            if ( govHydroPeltonList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroPeltons" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroPeltons ", exc );
        	return null;
        }

        return govHydroPeltonList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroPelton govHydroPelton = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroPeltonQueryRestController.class.getName());
    
}
