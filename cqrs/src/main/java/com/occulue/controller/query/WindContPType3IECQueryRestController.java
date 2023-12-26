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
 * Implements Spring Controller query CQRS processing for entity WindContPType3IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType3IEC")
public class WindContPType3IECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindContPType3IEC using a UUID
     * @param		UUID windContPType3IECId
     * @return		WindContPType3IEC
     */    
    @GetMapping("/load")
    public WindContPType3IEC load( @RequestParam(required=true) UUID windContPType3IECId ) {
    	WindContPType3IEC entity = null;

    	try {  
    		entity = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().getWindContPType3IEC( new WindContPType3IECFetchOneSummary( windContPType3IECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindContPType3IEC using Id " + windContPType3IECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindContPType3IEC business objects
     * @return		Set<WindContPType3IEC>
     */
    @GetMapping("/")
    public List<WindContPType3IEC> loadAll() {                
    	List<WindContPType3IEC> windContPType3IECList = null;
        
    	try {
            // load the WindContPType3IEC
            windContPType3IECList = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().getAllWindContPType3IEC();
            
            if ( windContPType3IECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindContPType3IECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindContPType3IECs ", exc );
        	return null;
        }

        return windContPType3IECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPType3IEC windContPType3IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPType3IECQueryRestController.class.getName());
    
}
