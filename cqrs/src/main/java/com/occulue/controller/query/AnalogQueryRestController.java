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
 * Implements Spring Controller query CQRS processing for entity Analog.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Analog")
public class AnalogQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Analog using a UUID
     * @param		UUID analogId
     * @return		Analog
     */    
    @GetMapping("/load")
    public Analog load( @RequestParam(required=true) UUID analogId ) {
    	Analog entity = null;

    	try {  
    		entity = AnalogBusinessDelegate.getAnalogInstance().getAnalog( new AnalogFetchOneSummary( analogId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Analog using Id " + analogId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Analog business objects
     * @return		Set<Analog>
     */
    @GetMapping("/")
    public List<Analog> loadAll() {                
    	List<Analog> analogList = null;
        
    	try {
            // load the Analog
            analogList = AnalogBusinessDelegate.getAnalogInstance().getAllAnalog();
            
            if ( analogList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Analogs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Analogs ", exc );
        	return null;
        }

        return analogList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Analog analog = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogQueryRestController.class.getName());
    
}
