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
 * Implements Spring Controller query CQRS processing for entity WindContPType4aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType4aIEC")
public class WindContPType4aIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindContPType4aIEC using a UUID
     * @param		UUID windContPType4aIECId
     * @return		WindContPType4aIEC
     */    
    @GetMapping("/load")
    public WindContPType4aIEC load( @RequestParam(required=true) UUID windContPType4aIECId ) {
    	WindContPType4aIEC entity = null;

    	try {  
    		entity = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().getWindContPType4aIEC( new WindContPType4aIECFetchOneSummary( windContPType4aIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindContPType4aIEC using Id " + windContPType4aIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindContPType4aIEC business objects
     * @return		Set<WindContPType4aIEC>
     */
    @GetMapping("/")
    public List<WindContPType4aIEC> loadAll() {                
    	List<WindContPType4aIEC> windContPType4aIECList = null;
        
    	try {
            // load the WindContPType4aIEC
            windContPType4aIECList = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().getAllWindContPType4aIEC();
            
            if ( windContPType4aIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindContPType4aIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindContPType4aIECs ", exc );
        	return null;
        }

        return windContPType4aIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPType4aIEC windContPType4aIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPType4aIECQueryRestController.class.getName());
    
}
