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
 * Implements Spring Controller query CQRS processing for entity WindContPType4bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPType4bIEC")
public class WindContPType4bIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindContPType4bIEC using a UUID
     * @param		UUID windContPType4bIECId
     * @return		WindContPType4bIEC
     */    
    @GetMapping("/load")
    public WindContPType4bIEC load( @RequestParam(required=true) UUID windContPType4bIECId ) {
    	WindContPType4bIEC entity = null;

    	try {  
    		entity = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().getWindContPType4bIEC( new WindContPType4bIECFetchOneSummary( windContPType4bIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindContPType4bIEC using Id " + windContPType4bIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindContPType4bIEC business objects
     * @return		Set<WindContPType4bIEC>
     */
    @GetMapping("/")
    public List<WindContPType4bIEC> loadAll() {                
    	List<WindContPType4bIEC> windContPType4bIECList = null;
        
    	try {
            // load the WindContPType4bIEC
            windContPType4bIECList = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().getAllWindContPType4bIEC();
            
            if ( windContPType4bIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindContPType4bIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindContPType4bIECs ", exc );
        	return null;
        }

        return windContPType4bIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindContPType4bIEC windContPType4bIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindContPType4bIECQueryRestController.class.getName());
    
}
