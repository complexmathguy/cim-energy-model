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
 * Implements Spring Controller query CQRS processing for entity UnderexcLim2Simplified.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLim2Simplified")
public class UnderexcLim2SimplifiedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a UnderexcLim2Simplified using a UUID
     * @param		UUID underexcLim2SimplifiedId
     * @return		UnderexcLim2Simplified
     */    
    @GetMapping("/load")
    public UnderexcLim2Simplified load( @RequestParam(required=true) UUID underexcLim2SimplifiedId ) {
    	UnderexcLim2Simplified entity = null;

    	try {  
    		entity = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().getUnderexcLim2Simplified( new UnderexcLim2SimplifiedFetchOneSummary( underexcLim2SimplifiedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load UnderexcLim2Simplified using Id " + underexcLim2SimplifiedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all UnderexcLim2Simplified business objects
     * @return		Set<UnderexcLim2Simplified>
     */
    @GetMapping("/")
    public List<UnderexcLim2Simplified> loadAll() {                
    	List<UnderexcLim2Simplified> underexcLim2SimplifiedList = null;
        
    	try {
            // load the UnderexcLim2Simplified
            underexcLim2SimplifiedList = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().getAllUnderexcLim2Simplified();
            
            if ( underexcLim2SimplifiedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all UnderexcLim2Simplifieds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all UnderexcLim2Simplifieds ", exc );
        	return null;
        }

        return underexcLim2SimplifiedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLim2Simplified underexcLim2Simplified = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLim2SimplifiedQueryRestController.class.getName());
    
}
