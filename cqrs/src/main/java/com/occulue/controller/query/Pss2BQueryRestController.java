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
 * Implements Spring Controller query CQRS processing for entity Pss2B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss2B")
public class Pss2BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Pss2B using a UUID
     * @param		UUID pss2BId
     * @return		Pss2B
     */    
    @GetMapping("/load")
    public Pss2B load( @RequestParam(required=true) UUID pss2BId ) {
    	Pss2B entity = null;

    	try {  
    		entity = Pss2BBusinessDelegate.getPss2BInstance().getPss2B( new Pss2BFetchOneSummary( pss2BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Pss2B using Id " + pss2BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Pss2B business objects
     * @return		Set<Pss2B>
     */
    @GetMapping("/")
    public List<Pss2B> loadAll() {                
    	List<Pss2B> pss2BList = null;
        
    	try {
            // load the Pss2B
            pss2BList = Pss2BBusinessDelegate.getPss2BInstance().getAllPss2B();
            
            if ( pss2BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Pss2Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Pss2Bs ", exc );
        	return null;
        }

        return pss2BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss2B pss2B = null;
    private static final Logger LOGGER = Logger.getLogger(Pss2BQueryRestController.class.getName());
    
}
