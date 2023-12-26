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
 * Implements Spring Controller query CQRS processing for entity WindContCurrLimIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContCurrLimIEC")
public class WindContCurrLimIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindContCurrLimIEC using a UUID
     * @param		UUID windContCurrLimIECId
     * @return		WindContCurrLimIEC
     */    
    @GetMapping("/load")
    public WindContCurrLimIEC load( @RequestParam(required=true) UUID windContCurrLimIECId ) {
    	WindContCurrLimIEC entity = null;

    	try {  
    		entity = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().getWindContCurrLimIEC( new WindContCurrLimIECFetchOneSummary( windContCurrLimIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindContCurrLimIEC using Id " + windContCurrLimIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindContCurrLimIEC business objects
     * @return		Set<WindContCurrLimIEC>
     */
    @GetMapping("/")
    public List<WindContCurrLimIEC> loadAll() {                
    	List<WindContCurrLimIEC> windContCurrLimIECList = null;
        
    	try {
            // load the WindContCurrLimIEC
            windContCurrLimIECList = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().getAllWindContCurrLimIEC();
            
            if ( windContCurrLimIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindContCurrLimIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindContCurrLimIECs ", exc );
        	return null;
        }

        return windContCurrLimIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContCurrLimIEC windContCurrLimIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContCurrLimIECQueryRestController.class.getName());
    
}
