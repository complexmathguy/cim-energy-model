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
 * Implements Spring Controller query CQRS processing for entity IntegerProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/IntegerProxy")
public class IntegerProxyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a IntegerProxy using a UUID
     * @param		UUID integerProxyId
     * @return		IntegerProxy
     */    
    @GetMapping("/load")
    public IntegerProxy load( @RequestParam(required=true) UUID integerProxyId ) {
    	IntegerProxy entity = null;

    	try {  
    		entity = IntegerProxyBusinessDelegate.getIntegerProxyInstance().getIntegerProxy( new IntegerProxyFetchOneSummary( integerProxyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load IntegerProxy using Id " + integerProxyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all IntegerProxy business objects
     * @return		Set<IntegerProxy>
     */
    @GetMapping("/")
    public List<IntegerProxy> loadAll() {                
    	List<IntegerProxy> integerProxyList = null;
        
    	try {
            // load the IntegerProxy
            integerProxyList = IntegerProxyBusinessDelegate.getIntegerProxyInstance().getAllIntegerProxy();
            
            if ( integerProxyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all IntegerProxys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all IntegerProxys ", exc );
        	return null;
        }

        return integerProxyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected IntegerProxy integerProxy = null;
    private static final Logger LOGGER = Logger.getLogger(IntegerProxyQueryRestController.class.getName());
    
}
