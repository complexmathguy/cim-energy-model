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
 * Implements Spring Controller query CQRS processing for entity Pss2ST.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss2ST")
public class Pss2STQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Pss2ST using a UUID
     * @param		UUID pss2STId
     * @return		Pss2ST
     */    
    @GetMapping("/load")
    public Pss2ST load( @RequestParam(required=true) UUID pss2STId ) {
    	Pss2ST entity = null;

    	try {  
    		entity = Pss2STBusinessDelegate.getPss2STInstance().getPss2ST( new Pss2STFetchOneSummary( pss2STId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Pss2ST using Id " + pss2STId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Pss2ST business objects
     * @return		Set<Pss2ST>
     */
    @GetMapping("/")
    public List<Pss2ST> loadAll() {                
    	List<Pss2ST> pss2STList = null;
        
    	try {
            // load the Pss2ST
            pss2STList = Pss2STBusinessDelegate.getPss2STInstance().getAllPss2ST();
            
            if ( pss2STList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Pss2STs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Pss2STs ", exc );
        	return null;
        }

        return pss2STList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss2ST pss2ST = null;
    private static final Logger LOGGER = Logger.getLogger(Pss2STQueryRestController.class.getName());
    
}
