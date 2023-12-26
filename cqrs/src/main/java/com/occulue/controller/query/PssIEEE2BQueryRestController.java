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
 * Implements Spring Controller query CQRS processing for entity PssIEEE2B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE2B")
public class PssIEEE2BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssIEEE2B using a UUID
     * @param		UUID pssIEEE2BId
     * @return		PssIEEE2B
     */    
    @GetMapping("/load")
    public PssIEEE2B load( @RequestParam(required=true) UUID pssIEEE2BId ) {
    	PssIEEE2B entity = null;

    	try {  
    		entity = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().getPssIEEE2B( new PssIEEE2BFetchOneSummary( pssIEEE2BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssIEEE2B using Id " + pssIEEE2BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssIEEE2B business objects
     * @return		Set<PssIEEE2B>
     */
    @GetMapping("/")
    public List<PssIEEE2B> loadAll() {                
    	List<PssIEEE2B> pssIEEE2BList = null;
        
    	try {
            // load the PssIEEE2B
            pssIEEE2BList = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().getAllPssIEEE2B();
            
            if ( pssIEEE2BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssIEEE2Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssIEEE2Bs ", exc );
        	return null;
        }

        return pssIEEE2BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE2B pssIEEE2B = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE2BQueryRestController.class.getName());
    
}
