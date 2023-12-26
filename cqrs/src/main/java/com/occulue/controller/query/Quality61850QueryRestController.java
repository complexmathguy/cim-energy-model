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
 * Implements Spring Controller query CQRS processing for entity Quality61850.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Quality61850")
public class Quality61850QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Quality61850 using a UUID
     * @param		UUID quality61850Id
     * @return		Quality61850
     */    
    @GetMapping("/load")
    public Quality61850 load( @RequestParam(required=true) UUID quality61850Id ) {
    	Quality61850 entity = null;

    	try {  
    		entity = Quality61850BusinessDelegate.getQuality61850Instance().getQuality61850( new Quality61850FetchOneSummary( quality61850Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Quality61850 using Id " + quality61850Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Quality61850 business objects
     * @return		Set<Quality61850>
     */
    @GetMapping("/")
    public List<Quality61850> loadAll() {                
    	List<Quality61850> quality61850List = null;
        
    	try {
            // load the Quality61850
            quality61850List = Quality61850BusinessDelegate.getQuality61850Instance().getAllQuality61850();
            
            if ( quality61850List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Quality61850s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Quality61850s ", exc );
        	return null;
        }

        return quality61850List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Quality61850 quality61850 = null;
    private static final Logger LOGGER = Logger.getLogger(Quality61850QueryRestController.class.getName());
    
}
