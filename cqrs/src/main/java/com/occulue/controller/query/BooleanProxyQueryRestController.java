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
 * Implements Spring Controller query CQRS processing for entity BooleanProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BooleanProxy")
public class BooleanProxyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a BooleanProxy using a UUID
     * @param		UUID booleanProxyId
     * @return		BooleanProxy
     */    
    @GetMapping("/load")
    public BooleanProxy load( @RequestParam(required=true) UUID booleanProxyId ) {
    	BooleanProxy entity = null;

    	try {  
    		entity = BooleanProxyBusinessDelegate.getBooleanProxyInstance().getBooleanProxy( new BooleanProxyFetchOneSummary( booleanProxyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load BooleanProxy using Id " + booleanProxyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all BooleanProxy business objects
     * @return		Set<BooleanProxy>
     */
    @GetMapping("/")
    public List<BooleanProxy> loadAll() {                
    	List<BooleanProxy> booleanProxyList = null;
        
    	try {
            // load the BooleanProxy
            booleanProxyList = BooleanProxyBusinessDelegate.getBooleanProxyInstance().getAllBooleanProxy();
            
            if ( booleanProxyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all BooleanProxys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all BooleanProxys ", exc );
        	return null;
        }

        return booleanProxyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected BooleanProxy booleanProxy = null;
    private static final Logger LOGGER = Logger.getLogger(BooleanProxyQueryRestController.class.getName());
    
}
