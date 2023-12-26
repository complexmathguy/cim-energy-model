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
 * Implements Spring Controller query CQRS processing for entity WindMechIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindMechIEC")
public class WindMechIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindMechIEC using a UUID
     * @param		UUID windMechIECId
     * @return		WindMechIEC
     */    
    @GetMapping("/load")
    public WindMechIEC load( @RequestParam(required=true) UUID windMechIECId ) {
    	WindMechIEC entity = null;

    	try {  
    		entity = WindMechIECBusinessDelegate.getWindMechIECInstance().getWindMechIEC( new WindMechIECFetchOneSummary( windMechIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindMechIEC using Id " + windMechIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindMechIEC business objects
     * @return		Set<WindMechIEC>
     */
    @GetMapping("/")
    public List<WindMechIEC> loadAll() {                
    	List<WindMechIEC> windMechIECList = null;
        
    	try {
            // load the WindMechIEC
            windMechIECList = WindMechIECBusinessDelegate.getWindMechIECInstance().getAllWindMechIEC();
            
            if ( windMechIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindMechIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindMechIECs ", exc );
        	return null;
        }

        return windMechIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindMechIEC windMechIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindMechIECQueryRestController.class.getName());
    
}
