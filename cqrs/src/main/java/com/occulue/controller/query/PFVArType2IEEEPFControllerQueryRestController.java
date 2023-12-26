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
 * Implements Spring Controller query CQRS processing for entity PFVArType2IEEEPFController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2IEEEPFController")
public class PFVArType2IEEEPFControllerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArType2IEEEPFController using a UUID
     * @param		UUID pFVArType2IEEEPFControllerId
     * @return		PFVArType2IEEEPFController
     */    
    @GetMapping("/load")
    public PFVArType2IEEEPFController load( @RequestParam(required=true) UUID pFVArType2IEEEPFControllerId ) {
    	PFVArType2IEEEPFController entity = null;

    	try {  
    		entity = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().getPFVArType2IEEEPFController( new PFVArType2IEEEPFControllerFetchOneSummary( pFVArType2IEEEPFControllerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArType2IEEEPFController using Id " + pFVArType2IEEEPFControllerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArType2IEEEPFController business objects
     * @return		Set<PFVArType2IEEEPFController>
     */
    @GetMapping("/")
    public List<PFVArType2IEEEPFController> loadAll() {                
    	List<PFVArType2IEEEPFController> pFVArType2IEEEPFControllerList = null;
        
    	try {
            // load the PFVArType2IEEEPFController
            pFVArType2IEEEPFControllerList = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().getAllPFVArType2IEEEPFController();
            
            if ( pFVArType2IEEEPFControllerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArType2IEEEPFControllers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArType2IEEEPFControllers ", exc );
        	return null;
        }

        return pFVArType2IEEEPFControllerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType2IEEEPFController pFVArType2IEEEPFController = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType2IEEEPFControllerQueryRestController.class.getName());
    
}
