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
 * Implements Spring Controller query CQRS processing for entity PFVArType1IEEEPFController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType1IEEEPFController")
public class PFVArType1IEEEPFControllerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArType1IEEEPFController using a UUID
     * @param		UUID pFVArType1IEEEPFControllerId
     * @return		PFVArType1IEEEPFController
     */    
    @GetMapping("/load")
    public PFVArType1IEEEPFController load( @RequestParam(required=true) UUID pFVArType1IEEEPFControllerId ) {
    	PFVArType1IEEEPFController entity = null;

    	try {  
    		entity = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().getPFVArType1IEEEPFController( new PFVArType1IEEEPFControllerFetchOneSummary( pFVArType1IEEEPFControllerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArType1IEEEPFController using Id " + pFVArType1IEEEPFControllerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArType1IEEEPFController business objects
     * @return		Set<PFVArType1IEEEPFController>
     */
    @GetMapping("/")
    public List<PFVArType1IEEEPFController> loadAll() {                
    	List<PFVArType1IEEEPFController> pFVArType1IEEEPFControllerList = null;
        
    	try {
            // load the PFVArType1IEEEPFController
            pFVArType1IEEEPFControllerList = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().getAllPFVArType1IEEEPFController();
            
            if ( pFVArType1IEEEPFControllerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArType1IEEEPFControllers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArType1IEEEPFControllers ", exc );
        	return null;
        }

        return pFVArType1IEEEPFControllerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType1IEEEPFController pFVArType1IEEEPFController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType1IEEEPFControllerQueryRestController.class.getName());
    
}
