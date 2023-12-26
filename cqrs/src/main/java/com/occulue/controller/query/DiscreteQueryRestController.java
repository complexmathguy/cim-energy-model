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
 * Implements Spring Controller query CQRS processing for entity Discrete.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Discrete")
public class DiscreteQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Discrete using a UUID
     * @param		UUID discreteId
     * @return		Discrete
     */    
    @GetMapping("/load")
    public Discrete load( @RequestParam(required=true) UUID discreteId ) {
    	Discrete entity = null;

    	try {  
    		entity = DiscreteBusinessDelegate.getDiscreteInstance().getDiscrete( new DiscreteFetchOneSummary( discreteId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Discrete using Id " + discreteId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Discrete business objects
     * @return		Set<Discrete>
     */
    @GetMapping("/")
    public List<Discrete> loadAll() {                
    	List<Discrete> discreteList = null;
        
    	try {
            // load the Discrete
            discreteList = DiscreteBusinessDelegate.getDiscreteInstance().getAllDiscrete();
            
            if ( discreteList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Discretes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Discretes ", exc );
        	return null;
        }

        return discreteList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Discrete discrete = null;
    private static final Logger LOGGER = Logger.getLogger(DiscreteQueryRestController.class.getName());
    
}
