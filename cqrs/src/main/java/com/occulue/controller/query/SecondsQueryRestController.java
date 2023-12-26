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
 * Implements Spring Controller query CQRS processing for entity Seconds.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Seconds")
public class SecondsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Seconds using a UUID
     * @param		UUID secondsId
     * @return		Seconds
     */    
    @GetMapping("/load")
    public Seconds load( @RequestParam(required=true) UUID secondsId ) {
    	Seconds entity = null;

    	try {  
    		entity = SecondsBusinessDelegate.getSecondsInstance().getSeconds( new SecondsFetchOneSummary( secondsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Seconds using Id " + secondsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Seconds business objects
     * @return		Set<Seconds>
     */
    @GetMapping("/")
    public List<Seconds> loadAll() {                
    	List<Seconds> secondsList = null;
        
    	try {
            // load the Seconds
            secondsList = SecondsBusinessDelegate.getSecondsInstance().getAllSeconds();
            
            if ( secondsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Secondss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Secondss ", exc );
        	return null;
        }

        return secondsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Seconds seconds = null;
    private static final Logger LOGGER = Logger.getLogger(SecondsQueryRestController.class.getName());
    
}
