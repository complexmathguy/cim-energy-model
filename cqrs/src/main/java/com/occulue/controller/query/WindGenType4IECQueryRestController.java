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
 * Implements Spring Controller query CQRS processing for entity WindGenType4IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenType4IEC")
public class WindGenType4IECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindGenType4IEC using a UUID
     * @param		UUID windGenType4IECId
     * @return		WindGenType4IEC
     */    
    @GetMapping("/load")
    public WindGenType4IEC load( @RequestParam(required=true) UUID windGenType4IECId ) {
    	WindGenType4IEC entity = null;

    	try {  
    		entity = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().getWindGenType4IEC( new WindGenType4IECFetchOneSummary( windGenType4IECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindGenType4IEC using Id " + windGenType4IECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindGenType4IEC business objects
     * @return		Set<WindGenType4IEC>
     */
    @GetMapping("/")
    public List<WindGenType4IEC> loadAll() {                
    	List<WindGenType4IEC> windGenType4IECList = null;
        
    	try {
            // load the WindGenType4IEC
            windGenType4IECList = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().getAllWindGenType4IEC();
            
            if ( windGenType4IECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindGenType4IECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindGenType4IECs ", exc );
        	return null;
        }

        return windGenType4IECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGenType4IEC windGenType4IEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindGenType4IECQueryRestController.class.getName());
    
}
