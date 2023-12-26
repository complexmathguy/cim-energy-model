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
 * Implements Spring Controller query CQRS processing for entity ExternalNetworkInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExternalNetworkInjection")
public class ExternalNetworkInjectionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExternalNetworkInjection using a UUID
     * @param		UUID externalNetworkInjectionId
     * @return		ExternalNetworkInjection
     */    
    @GetMapping("/load")
    public ExternalNetworkInjection load( @RequestParam(required=true) UUID externalNetworkInjectionId ) {
    	ExternalNetworkInjection entity = null;

    	try {  
    		entity = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().getExternalNetworkInjection( new ExternalNetworkInjectionFetchOneSummary( externalNetworkInjectionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExternalNetworkInjection using Id " + externalNetworkInjectionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExternalNetworkInjection business objects
     * @return		Set<ExternalNetworkInjection>
     */
    @GetMapping("/")
    public List<ExternalNetworkInjection> loadAll() {                
    	List<ExternalNetworkInjection> externalNetworkInjectionList = null;
        
    	try {
            // load the ExternalNetworkInjection
            externalNetworkInjectionList = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().getAllExternalNetworkInjection();
            
            if ( externalNetworkInjectionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExternalNetworkInjections" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExternalNetworkInjections ", exc );
        	return null;
        }

        return externalNetworkInjectionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExternalNetworkInjection externalNetworkInjection = null;
    private static final Logger LOGGER = Logger.getLogger(ExternalNetworkInjectionQueryRestController.class.getName());
    
}
