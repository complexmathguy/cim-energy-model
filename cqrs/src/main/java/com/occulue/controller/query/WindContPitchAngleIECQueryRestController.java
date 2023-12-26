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
 * Implements Spring Controller query CQRS processing for entity WindContPitchAngleIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPitchAngleIEC")
public class WindContPitchAngleIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindContPitchAngleIEC using a UUID
     * @param		UUID windContPitchAngleIECId
     * @return		WindContPitchAngleIEC
     */    
    @GetMapping("/load")
    public WindContPitchAngleIEC load( @RequestParam(required=true) UUID windContPitchAngleIECId ) {
    	WindContPitchAngleIEC entity = null;

    	try {  
    		entity = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().getWindContPitchAngleIEC( new WindContPitchAngleIECFetchOneSummary( windContPitchAngleIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindContPitchAngleIEC using Id " + windContPitchAngleIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindContPitchAngleIEC business objects
     * @return		Set<WindContPitchAngleIEC>
     */
    @GetMapping("/")
    public List<WindContPitchAngleIEC> loadAll() {                
    	List<WindContPitchAngleIEC> windContPitchAngleIECList = null;
        
    	try {
            // load the WindContPitchAngleIEC
            windContPitchAngleIECList = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().getAllWindContPitchAngleIEC();
            
            if ( windContPitchAngleIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindContPitchAngleIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindContPitchAngleIECs ", exc );
        	return null;
        }

        return windContPitchAngleIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPitchAngleIEC windContPitchAngleIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPitchAngleIECQueryRestController.class.getName());
    
}
