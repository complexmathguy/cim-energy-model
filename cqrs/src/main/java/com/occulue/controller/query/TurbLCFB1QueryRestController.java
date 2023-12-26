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
 * Implements Spring Controller query CQRS processing for entity TurbLCFB1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbLCFB1")
public class TurbLCFB1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TurbLCFB1 using a UUID
     * @param		UUID turbLCFB1Id
     * @return		TurbLCFB1
     */    
    @GetMapping("/load")
    public TurbLCFB1 load( @RequestParam(required=true) UUID turbLCFB1Id ) {
    	TurbLCFB1 entity = null;

    	try {  
    		entity = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().getTurbLCFB1( new TurbLCFB1FetchOneSummary( turbLCFB1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TurbLCFB1 using Id " + turbLCFB1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TurbLCFB1 business objects
     * @return		Set<TurbLCFB1>
     */
    @GetMapping("/")
    public List<TurbLCFB1> loadAll() {                
    	List<TurbLCFB1> turbLCFB1List = null;
        
    	try {
            // load the TurbLCFB1
            turbLCFB1List = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().getAllTurbLCFB1();
            
            if ( turbLCFB1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TurbLCFB1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TurbLCFB1s ", exc );
        	return null;
        }

        return turbLCFB1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbLCFB1 turbLCFB1 = null;
    private static final Logger LOGGER = Logger.getLogger(TurbLCFB1QueryRestController.class.getName());
    
}
