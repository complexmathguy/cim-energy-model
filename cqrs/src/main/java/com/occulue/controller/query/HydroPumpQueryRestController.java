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
 * Implements Spring Controller query CQRS processing for entity HydroPump.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/HydroPump")
public class HydroPumpQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a HydroPump using a UUID
     * @param		UUID hydroPumpId
     * @return		HydroPump
     */    
    @GetMapping("/load")
    public HydroPump load( @RequestParam(required=true) UUID hydroPumpId ) {
    	HydroPump entity = null;

    	try {  
    		entity = HydroPumpBusinessDelegate.getHydroPumpInstance().getHydroPump( new HydroPumpFetchOneSummary( hydroPumpId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load HydroPump using Id " + hydroPumpId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all HydroPump business objects
     * @return		Set<HydroPump>
     */
    @GetMapping("/")
    public List<HydroPump> loadAll() {                
    	List<HydroPump> hydroPumpList = null;
        
    	try {
            // load the HydroPump
            hydroPumpList = HydroPumpBusinessDelegate.getHydroPumpInstance().getAllHydroPump();
            
            if ( hydroPumpList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all HydroPumps" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all HydroPumps ", exc );
        	return null;
        }

        return hydroPumpList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected HydroPump hydroPump = null;
    private static final Logger LOGGER = Logger.getLogger(HydroPumpQueryRestController.class.getName());
    
}
