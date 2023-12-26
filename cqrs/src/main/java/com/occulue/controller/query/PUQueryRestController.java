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
 * Implements Spring Controller query CQRS processing for entity PU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PU")
public class PUQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PU using a UUID
     * @param		UUID pUId
     * @return		PU
     */    
    @GetMapping("/load")
    public PU load( @RequestParam(required=true) UUID pUId ) {
    	PU entity = null;

    	try {  
    		entity = PUBusinessDelegate.getPUInstance().getPU( new PUFetchOneSummary( pUId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PU using Id " + pUId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PU business objects
     * @return		Set<PU>
     */
    @GetMapping("/")
    public List<PU> loadAll() {                
    	List<PU> pUList = null;
        
    	try {
            // load the PU
            pUList = PUBusinessDelegate.getPUInstance().getAllPU();
            
            if ( pUList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PUs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PUs ", exc );
        	return null;
        }

        return pUList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PU pU = null;
    private static final Logger LOGGER = Logger.getLogger(PUQueryRestController.class.getName());
    
}
