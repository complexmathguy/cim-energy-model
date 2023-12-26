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
 * Implements Spring Controller query CQRS processing for entity UnderexcLimIEEE2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimIEEE2")
public class UnderexcLimIEEE2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a UnderexcLimIEEE2 using a UUID
     * @param		UUID underexcLimIEEE2Id
     * @return		UnderexcLimIEEE2
     */    
    @GetMapping("/load")
    public UnderexcLimIEEE2 load( @RequestParam(required=true) UUID underexcLimIEEE2Id ) {
    	UnderexcLimIEEE2 entity = null;

    	try {  
    		entity = UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().getUnderexcLimIEEE2( new UnderexcLimIEEE2FetchOneSummary( underexcLimIEEE2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load UnderexcLimIEEE2 using Id " + underexcLimIEEE2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all UnderexcLimIEEE2 business objects
     * @return		Set<UnderexcLimIEEE2>
     */
    @GetMapping("/")
    public List<UnderexcLimIEEE2> loadAll() {                
    	List<UnderexcLimIEEE2> underexcLimIEEE2List = null;
        
    	try {
            // load the UnderexcLimIEEE2
            underexcLimIEEE2List = UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().getAllUnderexcLimIEEE2();
            
            if ( underexcLimIEEE2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all UnderexcLimIEEE2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all UnderexcLimIEEE2s ", exc );
        	return null;
        }

        return underexcLimIEEE2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimIEEE2 underexcLimIEEE2 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE2QueryRestController.class.getName());
    
}
