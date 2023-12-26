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
 * Implements Spring Controller query CQRS processing for entity Accumulator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Accumulator")
public class AccumulatorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Accumulator using a UUID
     * @param		UUID accumulatorId
     * @return		Accumulator
     */    
    @GetMapping("/load")
    public Accumulator load( @RequestParam(required=true) UUID accumulatorId ) {
    	Accumulator entity = null;

    	try {  
    		entity = AccumulatorBusinessDelegate.getAccumulatorInstance().getAccumulator( new AccumulatorFetchOneSummary( accumulatorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Accumulator using Id " + accumulatorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Accumulator business objects
     * @return		Set<Accumulator>
     */
    @GetMapping("/")
    public List<Accumulator> loadAll() {                
    	List<Accumulator> accumulatorList = null;
        
    	try {
            // load the Accumulator
            accumulatorList = AccumulatorBusinessDelegate.getAccumulatorInstance().getAllAccumulator();
            
            if ( accumulatorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Accumulators" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Accumulators ", exc );
        	return null;
        }

        return accumulatorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Accumulator accumulator = null;
    private static final Logger LOGGER = Logger.getLogger(AccumulatorQueryRestController.class.getName());
    
}
