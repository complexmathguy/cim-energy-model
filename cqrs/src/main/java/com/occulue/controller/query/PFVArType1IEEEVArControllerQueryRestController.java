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
 * Implements Spring Controller query CQRS processing for entity PFVArType1IEEEVArController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType1IEEEVArController")
public class PFVArType1IEEEVArControllerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArType1IEEEVArController using a UUID
     * @param		UUID pFVArType1IEEEVArControllerId
     * @return		PFVArType1IEEEVArController
     */    
    @GetMapping("/load")
    public PFVArType1IEEEVArController load( @RequestParam(required=true) UUID pFVArType1IEEEVArControllerId ) {
    	PFVArType1IEEEVArController entity = null;

    	try {  
    		entity = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().getPFVArType1IEEEVArController( new PFVArType1IEEEVArControllerFetchOneSummary( pFVArType1IEEEVArControllerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArType1IEEEVArController using Id " + pFVArType1IEEEVArControllerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArType1IEEEVArController business objects
     * @return		Set<PFVArType1IEEEVArController>
     */
    @GetMapping("/")
    public List<PFVArType1IEEEVArController> loadAll() {                
    	List<PFVArType1IEEEVArController> pFVArType1IEEEVArControllerList = null;
        
    	try {
            // load the PFVArType1IEEEVArController
            pFVArType1IEEEVArControllerList = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().getAllPFVArType1IEEEVArController();
            
            if ( pFVArType1IEEEVArControllerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArType1IEEEVArControllers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArType1IEEEVArControllers ", exc );
        	return null;
        }

        return pFVArType1IEEEVArControllerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType1IEEEVArController pFVArType1IEEEVArController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType1IEEEVArControllerQueryRestController.class.getName());
    
}
