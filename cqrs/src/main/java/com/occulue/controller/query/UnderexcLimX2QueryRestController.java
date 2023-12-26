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
 * Implements Spring Controller query CQRS processing for entity UnderexcLimX2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimX2")
public class UnderexcLimX2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a UnderexcLimX2 using a UUID
     * @param		UUID underexcLimX2Id
     * @return		UnderexcLimX2
     */    
    @GetMapping("/load")
    public UnderexcLimX2 load( @RequestParam(required=true) UUID underexcLimX2Id ) {
    	UnderexcLimX2 entity = null;

    	try {  
    		entity = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().getUnderexcLimX2( new UnderexcLimX2FetchOneSummary( underexcLimX2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load UnderexcLimX2 using Id " + underexcLimX2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all UnderexcLimX2 business objects
     * @return		Set<UnderexcLimX2>
     */
    @GetMapping("/")
    public List<UnderexcLimX2> loadAll() {                
    	List<UnderexcLimX2> underexcLimX2List = null;
        
    	try {
            // load the UnderexcLimX2
            underexcLimX2List = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().getAllUnderexcLimX2();
            
            if ( underexcLimX2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all UnderexcLimX2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all UnderexcLimX2s ", exc );
        	return null;
        }

        return underexcLimX2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimX2 underexcLimX2 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimX2QueryRestController.class.getName());
    
}
