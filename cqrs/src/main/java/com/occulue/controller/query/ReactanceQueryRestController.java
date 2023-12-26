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
 * Implements Spring Controller query CQRS processing for entity Reactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Reactance")
public class ReactanceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Reactance using a UUID
     * @param		UUID reactanceId
     * @return		Reactance
     */    
    @GetMapping("/load")
    public Reactance load( @RequestParam(required=true) UUID reactanceId ) {
    	Reactance entity = null;

    	try {  
    		entity = ReactanceBusinessDelegate.getReactanceInstance().getReactance( new ReactanceFetchOneSummary( reactanceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Reactance using Id " + reactanceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Reactance business objects
     * @return		Set<Reactance>
     */
    @GetMapping("/")
    public List<Reactance> loadAll() {                
    	List<Reactance> reactanceList = null;
        
    	try {
            // load the Reactance
            reactanceList = ReactanceBusinessDelegate.getReactanceInstance().getAllReactance();
            
            if ( reactanceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Reactances" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Reactances ", exc );
        	return null;
        }

        return reactanceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Reactance reactance = null;
    private static final Logger LOGGER = Logger.getLogger(ReactanceQueryRestController.class.getName());
    
}
