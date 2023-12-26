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
 * Implements Spring Controller query CQRS processing for entity StringProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringProxy")
public class StringProxyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a StringProxy using a UUID
     * @param		UUID stringProxyId
     * @return		StringProxy
     */    
    @GetMapping("/load")
    public StringProxy load( @RequestParam(required=true) UUID stringProxyId ) {
    	StringProxy entity = null;

    	try {  
    		entity = StringProxyBusinessDelegate.getStringProxyInstance().getStringProxy( new StringProxyFetchOneSummary( stringProxyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load StringProxy using Id " + stringProxyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all StringProxy business objects
     * @return		Set<StringProxy>
     */
    @GetMapping("/")
    public List<StringProxy> loadAll() {                
    	List<StringProxy> stringProxyList = null;
        
    	try {
            // load the StringProxy
            stringProxyList = StringProxyBusinessDelegate.getStringProxyInstance().getAllStringProxy();
            
            if ( stringProxyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all StringProxys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all StringProxys ", exc );
        	return null;
        }

        return stringProxyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected StringProxy stringProxy = null;
    private static final Logger LOGGER = Logger.getLogger(StringProxyQueryRestController.class.getName());
    
}
