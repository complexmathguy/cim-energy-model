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
 * Implements Spring Controller query CQRS processing for entity UnderexcLimIEEE1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimIEEE1")
public class UnderexcLimIEEE1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a UnderexcLimIEEE1 using a UUID
     * @param		UUID underexcLimIEEE1Id
     * @return		UnderexcLimIEEE1
     */    
    @GetMapping("/load")
    public UnderexcLimIEEE1 load( @RequestParam(required=true) UUID underexcLimIEEE1Id ) {
    	UnderexcLimIEEE1 entity = null;

    	try {  
    		entity = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().getUnderexcLimIEEE1( new UnderexcLimIEEE1FetchOneSummary( underexcLimIEEE1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load UnderexcLimIEEE1 using Id " + underexcLimIEEE1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all UnderexcLimIEEE1 business objects
     * @return		Set<UnderexcLimIEEE1>
     */
    @GetMapping("/")
    public List<UnderexcLimIEEE1> loadAll() {                
    	List<UnderexcLimIEEE1> underexcLimIEEE1List = null;
        
    	try {
            // load the UnderexcLimIEEE1
            underexcLimIEEE1List = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().getAllUnderexcLimIEEE1();
            
            if ( underexcLimIEEE1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all UnderexcLimIEEE1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all UnderexcLimIEEE1s ", exc );
        	return null;
        }

        return underexcLimIEEE1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected UnderexcLimIEEE1 underexcLimIEEE1 = null;
    private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE1QueryRestController.class.getName());
    
}
