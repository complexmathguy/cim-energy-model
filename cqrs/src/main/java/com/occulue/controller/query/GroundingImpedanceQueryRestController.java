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
 * Implements Spring Controller query CQRS processing for entity GroundingImpedance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GroundingImpedance")
public class GroundingImpedanceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GroundingImpedance using a UUID
     * @param		UUID groundingImpedanceId
     * @return		GroundingImpedance
     */    
    @GetMapping("/load")
    public GroundingImpedance load( @RequestParam(required=true) UUID groundingImpedanceId ) {
    	GroundingImpedance entity = null;

    	try {  
    		entity = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().getGroundingImpedance( new GroundingImpedanceFetchOneSummary( groundingImpedanceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GroundingImpedance using Id " + groundingImpedanceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GroundingImpedance business objects
     * @return		Set<GroundingImpedance>
     */
    @GetMapping("/")
    public List<GroundingImpedance> loadAll() {                
    	List<GroundingImpedance> groundingImpedanceList = null;
        
    	try {
            // load the GroundingImpedance
            groundingImpedanceList = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().getAllGroundingImpedance();
            
            if ( groundingImpedanceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GroundingImpedances" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GroundingImpedances ", exc );
        	return null;
        }

        return groundingImpedanceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GroundingImpedance groundingImpedance = null;
    private static final Logger LOGGER = Logger.getLogger(GroundingImpedanceQueryRestController.class.getName());
    
}
