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
 * Implements Spring Controller query CQRS processing for entity Conductor.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Conductor")
public class ConductorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Conductor using a UUID
     * @param		UUID conductorId
     * @return		Conductor
     */    
    @GetMapping("/load")
    public Conductor load( @RequestParam(required=true) UUID conductorId ) {
    	Conductor entity = null;

    	try {  
    		entity = ConductorBusinessDelegate.getConductorInstance().getConductor( new ConductorFetchOneSummary( conductorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Conductor using Id " + conductorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Conductor business objects
     * @return		Set<Conductor>
     */
    @GetMapping("/")
    public List<Conductor> loadAll() {                
    	List<Conductor> conductorList = null;
        
    	try {
            // load the Conductor
            conductorList = ConductorBusinessDelegate.getConductorInstance().getAllConductor();
            
            if ( conductorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Conductors" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Conductors ", exc );
        	return null;
        }

        return conductorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Conductor conductor = null;
    private static final Logger LOGGER = Logger.getLogger(ConductorQueryRestController.class.getName());
    
}
