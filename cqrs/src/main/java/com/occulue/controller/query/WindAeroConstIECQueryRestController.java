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
 * Implements Spring Controller query CQRS processing for entity WindAeroConstIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindAeroConstIEC")
public class WindAeroConstIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindAeroConstIEC using a UUID
     * @param		UUID windAeroConstIECId
     * @return		WindAeroConstIEC
     */    
    @GetMapping("/load")
    public WindAeroConstIEC load( @RequestParam(required=true) UUID windAeroConstIECId ) {
    	WindAeroConstIEC entity = null;

    	try {  
    		entity = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().getWindAeroConstIEC( new WindAeroConstIECFetchOneSummary( windAeroConstIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindAeroConstIEC using Id " + windAeroConstIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindAeroConstIEC business objects
     * @return		Set<WindAeroConstIEC>
     */
    @GetMapping("/")
    public List<WindAeroConstIEC> loadAll() {                
    	List<WindAeroConstIEC> windAeroConstIECList = null;
        
    	try {
            // load the WindAeroConstIEC
            windAeroConstIECList = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().getAllWindAeroConstIEC();
            
            if ( windAeroConstIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindAeroConstIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindAeroConstIECs ", exc );
        	return null;
        }

        return windAeroConstIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindAeroConstIEC windAeroConstIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindAeroConstIECQueryRestController.class.getName());
    
}
