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
 * Implements Spring Controller query CQRS processing for entity DecimalProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DecimalProxy")
public class DecimalProxyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DecimalProxy using a UUID
     * @param		UUID decimalProxyId
     * @return		DecimalProxy
     */    
    @GetMapping("/load")
    public DecimalProxy load( @RequestParam(required=true) UUID decimalProxyId ) {
    	DecimalProxy entity = null;

    	try {  
    		entity = DecimalProxyBusinessDelegate.getDecimalProxyInstance().getDecimalProxy( new DecimalProxyFetchOneSummary( decimalProxyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DecimalProxy using Id " + decimalProxyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DecimalProxy business objects
     * @return		Set<DecimalProxy>
     */
    @GetMapping("/")
    public List<DecimalProxy> loadAll() {                
    	List<DecimalProxy> decimalProxyList = null;
        
    	try {
            // load the DecimalProxy
            decimalProxyList = DecimalProxyBusinessDelegate.getDecimalProxyInstance().getAllDecimalProxy();
            
            if ( decimalProxyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DecimalProxys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DecimalProxys ", exc );
        	return null;
        }

        return decimalProxyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DecimalProxy decimalProxy = null;
    private static final Logger LOGGER = Logger.getLogger(DecimalProxyQueryRestController.class.getName());
    
}
