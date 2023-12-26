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
 * Implements Spring Controller query CQRS processing for entity PssIEEE4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE4B")
public class PssIEEE4BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssIEEE4B using a UUID
     * @param		UUID pssIEEE4BId
     * @return		PssIEEE4B
     */    
    @GetMapping("/load")
    public PssIEEE4B load( @RequestParam(required=true) UUID pssIEEE4BId ) {
    	PssIEEE4B entity = null;

    	try {  
    		entity = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().getPssIEEE4B( new PssIEEE4BFetchOneSummary( pssIEEE4BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssIEEE4B using Id " + pssIEEE4BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssIEEE4B business objects
     * @return		Set<PssIEEE4B>
     */
    @GetMapping("/")
    public List<PssIEEE4B> loadAll() {                
    	List<PssIEEE4B> pssIEEE4BList = null;
        
    	try {
            // load the PssIEEE4B
            pssIEEE4BList = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().getAllPssIEEE4B();
            
            if ( pssIEEE4BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssIEEE4Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssIEEE4Bs ", exc );
        	return null;
        }

        return pssIEEE4BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE4B pssIEEE4B = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE4BQueryRestController.class.getName());
    
}
