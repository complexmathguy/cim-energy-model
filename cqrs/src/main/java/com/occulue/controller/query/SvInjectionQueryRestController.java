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
 * Implements Spring Controller query CQRS processing for entity SvInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvInjection")
public class SvInjectionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SvInjection using a UUID
     * @param		UUID svInjectionId
     * @return		SvInjection
     */    
    @GetMapping("/load")
    public SvInjection load( @RequestParam(required=true) UUID svInjectionId ) {
    	SvInjection entity = null;

    	try {  
    		entity = SvInjectionBusinessDelegate.getSvInjectionInstance().getSvInjection( new SvInjectionFetchOneSummary( svInjectionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SvInjection using Id " + svInjectionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SvInjection business objects
     * @return		Set<SvInjection>
     */
    @GetMapping("/")
    public List<SvInjection> loadAll() {                
    	List<SvInjection> svInjectionList = null;
        
    	try {
            // load the SvInjection
            svInjectionList = SvInjectionBusinessDelegate.getSvInjectionInstance().getAllSvInjection();
            
            if ( svInjectionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SvInjections" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SvInjections ", exc );
        	return null;
        }

        return svInjectionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SvInjection svInjection = null;
    private static final Logger LOGGER = Logger.getLogger(SvInjectionQueryRestController.class.getName());
    
}
