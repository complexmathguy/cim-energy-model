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
 * Implements Spring Controller query CQRS processing for entity FossilFuel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/FossilFuel")
public class FossilFuelQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a FossilFuel using a UUID
     * @param		UUID fossilFuelId
     * @return		FossilFuel
     */    
    @GetMapping("/load")
    public FossilFuel load( @RequestParam(required=true) UUID fossilFuelId ) {
    	FossilFuel entity = null;

    	try {  
    		entity = FossilFuelBusinessDelegate.getFossilFuelInstance().getFossilFuel( new FossilFuelFetchOneSummary( fossilFuelId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load FossilFuel using Id " + fossilFuelId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all FossilFuel business objects
     * @return		Set<FossilFuel>
     */
    @GetMapping("/")
    public List<FossilFuel> loadAll() {                
    	List<FossilFuel> fossilFuelList = null;
        
    	try {
            // load the FossilFuel
            fossilFuelList = FossilFuelBusinessDelegate.getFossilFuelInstance().getAllFossilFuel();
            
            if ( fossilFuelList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all FossilFuels" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all FossilFuels ", exc );
        	return null;
        }

        return fossilFuelList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected FossilFuel fossilFuel = null;
    private static final Logger LOGGER = Logger.getLogger(FossilFuelQueryRestController.class.getName());
    
}
