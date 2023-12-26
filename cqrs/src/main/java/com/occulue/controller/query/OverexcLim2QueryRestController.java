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
 * Implements Spring Controller query CQRS processing for entity OverexcLim2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLim2")
public class OverexcLim2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a OverexcLim2 using a UUID
     * @param		UUID overexcLim2Id
     * @return		OverexcLim2
     */    
    @GetMapping("/load")
    public OverexcLim2 load( @RequestParam(required=true) UUID overexcLim2Id ) {
    	OverexcLim2 entity = null;

    	try {  
    		entity = OverexcLim2BusinessDelegate.getOverexcLim2Instance().getOverexcLim2( new OverexcLim2FetchOneSummary( overexcLim2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load OverexcLim2 using Id " + overexcLim2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all OverexcLim2 business objects
     * @return		Set<OverexcLim2>
     */
    @GetMapping("/")
    public List<OverexcLim2> loadAll() {                
    	List<OverexcLim2> overexcLim2List = null;
        
    	try {
            // load the OverexcLim2
            overexcLim2List = OverexcLim2BusinessDelegate.getOverexcLim2Instance().getAllOverexcLim2();
            
            if ( overexcLim2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all OverexcLim2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all OverexcLim2s ", exc );
        	return null;
        }

        return overexcLim2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcLim2 overexcLim2 = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcLim2QueryRestController.class.getName());
    
}
