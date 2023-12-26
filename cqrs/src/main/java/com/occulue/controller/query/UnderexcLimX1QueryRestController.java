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
 * Implements Spring Controller query CQRS processing for entity UnderexcLimX1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimX1")
public class UnderexcLimX1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a UnderexcLimX1 using a UUID
     * @param		UUID underexcLimX1Id
     * @return		UnderexcLimX1
     */    
    @GetMapping("/load")
    public UnderexcLimX1 load( @RequestParam(required=true) UUID underexcLimX1Id ) {
    	UnderexcLimX1 entity = null;

    	try {  
    		entity = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().getUnderexcLimX1( new UnderexcLimX1FetchOneSummary( underexcLimX1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load UnderexcLimX1 using Id " + underexcLimX1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all UnderexcLimX1 business objects
     * @return		Set<UnderexcLimX1>
     */
    @GetMapping("/")
    public List<UnderexcLimX1> loadAll() {                
    	List<UnderexcLimX1> underexcLimX1List = null;
        
    	try {
            // load the UnderexcLimX1
            underexcLimX1List = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().getAllUnderexcLimX1();
            
            if ( underexcLimX1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all UnderexcLimX1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all UnderexcLimX1s ", exc );
        	return null;
        }

        return underexcLimX1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimX1 underexcLimX1 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimX1QueryRestController.class.getName());
    
}
