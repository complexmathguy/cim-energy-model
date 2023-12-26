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
 * Implements Spring Controller query CQRS processing for entity Capacitance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Capacitance")
public class CapacitanceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Capacitance using a UUID
     * @param		UUID capacitanceId
     * @return		Capacitance
     */    
    @GetMapping("/load")
    public Capacitance load( @RequestParam(required=true) UUID capacitanceId ) {
    	Capacitance entity = null;

    	try {  
    		entity = CapacitanceBusinessDelegate.getCapacitanceInstance().getCapacitance( new CapacitanceFetchOneSummary( capacitanceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Capacitance using Id " + capacitanceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Capacitance business objects
     * @return		Set<Capacitance>
     */
    @GetMapping("/")
    public List<Capacitance> loadAll() {                
    	List<Capacitance> capacitanceList = null;
        
    	try {
            // load the Capacitance
            capacitanceList = CapacitanceBusinessDelegate.getCapacitanceInstance().getAllCapacitance();
            
            if ( capacitanceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Capacitances" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Capacitances ", exc );
        	return null;
        }

        return capacitanceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Capacitance capacitance = null;
    private static final Logger LOGGER = Logger.getLogger(CapacitanceQueryRestController.class.getName());
    
}
