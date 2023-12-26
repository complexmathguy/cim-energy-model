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
 * Implements Spring Controller query CQRS processing for entity OverexcLimX2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimX2")
public class OverexcLimX2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a OverexcLimX2 using a UUID
     * @param		UUID overexcLimX2Id
     * @return		OverexcLimX2
     */    
    @GetMapping("/load")
    public OverexcLimX2 load( @RequestParam(required=true) UUID overexcLimX2Id ) {
    	OverexcLimX2 entity = null;

    	try {  
    		entity = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().getOverexcLimX2( new OverexcLimX2FetchOneSummary( overexcLimX2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load OverexcLimX2 using Id " + overexcLimX2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all OverexcLimX2 business objects
     * @return		Set<OverexcLimX2>
     */
    @GetMapping("/")
    public List<OverexcLimX2> loadAll() {                
    	List<OverexcLimX2> overexcLimX2List = null;
        
    	try {
            // load the OverexcLimX2
            overexcLimX2List = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().getAllOverexcLimX2();
            
            if ( overexcLimX2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all OverexcLimX2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all OverexcLimX2s ", exc );
        	return null;
        }

        return overexcLimX2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcLimX2 overexcLimX2 = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcLimX2QueryRestController.class.getName());
    
}
