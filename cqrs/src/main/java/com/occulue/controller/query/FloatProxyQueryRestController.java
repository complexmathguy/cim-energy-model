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
 * Implements Spring Controller query CQRS processing for entity FloatProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/FloatProxy")
public class FloatProxyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a FloatProxy using a UUID
     * @param		UUID floatProxyId
     * @return		FloatProxy
     */    
    @GetMapping("/load")
    public FloatProxy load( @RequestParam(required=true) UUID floatProxyId ) {
    	FloatProxy entity = null;

    	try {  
    		entity = FloatProxyBusinessDelegate.getFloatProxyInstance().getFloatProxy( new FloatProxyFetchOneSummary( floatProxyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load FloatProxy using Id " + floatProxyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all FloatProxy business objects
     * @return		Set<FloatProxy>
     */
    @GetMapping("/")
    public List<FloatProxy> loadAll() {                
    	List<FloatProxy> floatProxyList = null;
        
    	try {
            // load the FloatProxy
            floatProxyList = FloatProxyBusinessDelegate.getFloatProxyInstance().getAllFloatProxy();
            
            if ( floatProxyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all FloatProxys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all FloatProxys ", exc );
        	return null;
        }

        return floatProxyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected FloatProxy floatProxy = null;
    private static final Logger LOGGER = Logger.getLogger(FloatProxyQueryRestController.class.getName());
    
}
