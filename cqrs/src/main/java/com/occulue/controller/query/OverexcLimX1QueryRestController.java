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
 * Implements Spring Controller query CQRS processing for entity OverexcLimX1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimX1")
public class OverexcLimX1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a OverexcLimX1 using a UUID
     * @param		UUID overexcLimX1Id
     * @return		OverexcLimX1
     */    
    @GetMapping("/load")
    public OverexcLimX1 load( @RequestParam(required=true) UUID overexcLimX1Id ) {
    	OverexcLimX1 entity = null;

    	try {  
    		entity = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().getOverexcLimX1( new OverexcLimX1FetchOneSummary( overexcLimX1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load OverexcLimX1 using Id " + overexcLimX1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all OverexcLimX1 business objects
     * @return		Set<OverexcLimX1>
     */
    @GetMapping("/")
    public List<OverexcLimX1> loadAll() {                
    	List<OverexcLimX1> overexcLimX1List = null;
        
    	try {
            // load the OverexcLimX1
            overexcLimX1List = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().getAllOverexcLimX1();
            
            if ( overexcLimX1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all OverexcLimX1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all OverexcLimX1s ", exc );
        	return null;
        }

        return overexcLimX1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcLimX1 overexcLimX1 = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcLimX1QueryRestController.class.getName());
    
}
