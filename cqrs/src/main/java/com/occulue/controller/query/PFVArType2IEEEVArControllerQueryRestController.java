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
 * Implements Spring Controller query CQRS processing for entity PFVArType2IEEEVArController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2IEEEVArController")
public class PFVArType2IEEEVArControllerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArType2IEEEVArController using a UUID
     * @param		UUID pFVArType2IEEEVArControllerId
     * @return		PFVArType2IEEEVArController
     */    
    @GetMapping("/load")
    public PFVArType2IEEEVArController load( @RequestParam(required=true) UUID pFVArType2IEEEVArControllerId ) {
    	PFVArType2IEEEVArController entity = null;

    	try {  
    		entity = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().getPFVArType2IEEEVArController( new PFVArType2IEEEVArControllerFetchOneSummary( pFVArType2IEEEVArControllerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArType2IEEEVArController using Id " + pFVArType2IEEEVArControllerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArType2IEEEVArController business objects
     * @return		Set<PFVArType2IEEEVArController>
     */
    @GetMapping("/")
    public List<PFVArType2IEEEVArController> loadAll() {                
    	List<PFVArType2IEEEVArController> pFVArType2IEEEVArControllerList = null;
        
    	try {
            // load the PFVArType2IEEEVArController
            pFVArType2IEEEVArControllerList = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().getAllPFVArType2IEEEVArController();
            
            if ( pFVArType2IEEEVArControllerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArType2IEEEVArControllers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArType2IEEEVArControllers ", exc );
        	return null;
        }

        return pFVArType2IEEEVArControllerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType2IEEEVArController pFVArType2IEEEVArController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType2IEEEVArControllerQueryRestController.class.getName());
    
}
