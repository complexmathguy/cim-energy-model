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
 * Implements Spring Controller query CQRS processing for entity PssIEEE3B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE3B")
public class PssIEEE3BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssIEEE3B using a UUID
     * @param		UUID pssIEEE3BId
     * @return		PssIEEE3B
     */    
    @GetMapping("/load")
    public PssIEEE3B load( @RequestParam(required=true) UUID pssIEEE3BId ) {
    	PssIEEE3B entity = null;

    	try {  
    		entity = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().getPssIEEE3B( new PssIEEE3BFetchOneSummary( pssIEEE3BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssIEEE3B using Id " + pssIEEE3BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssIEEE3B business objects
     * @return		Set<PssIEEE3B>
     */
    @GetMapping("/")
    public List<PssIEEE3B> loadAll() {                
    	List<PssIEEE3B> pssIEEE3BList = null;
        
    	try {
            // load the PssIEEE3B
            pssIEEE3BList = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().getAllPssIEEE3B();
            
            if ( pssIEEE3BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssIEEE3Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssIEEE3Bs ", exc );
        	return null;
        }

        return pssIEEE3BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE3B pssIEEE3B = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE3BQueryRestController.class.getName());
    
}
