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
 * Implements Spring Controller query CQRS processing for entity WindPitchContEmulIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPitchContEmulIEC")
public class WindPitchContEmulIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindPitchContEmulIEC using a UUID
     * @param		UUID windPitchContEmulIECId
     * @return		WindPitchContEmulIEC
     */    
    @GetMapping("/load")
    public WindPitchContEmulIEC load( @RequestParam(required=true) UUID windPitchContEmulIECId ) {
    	WindPitchContEmulIEC entity = null;

    	try {  
    		entity = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().getWindPitchContEmulIEC( new WindPitchContEmulIECFetchOneSummary( windPitchContEmulIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindPitchContEmulIEC using Id " + windPitchContEmulIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindPitchContEmulIEC business objects
     * @return		Set<WindPitchContEmulIEC>
     */
    @GetMapping("/")
    public List<WindPitchContEmulIEC> loadAll() {                
    	List<WindPitchContEmulIEC> windPitchContEmulIECList = null;
        
    	try {
            // load the WindPitchContEmulIEC
            windPitchContEmulIECList = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().getAllWindPitchContEmulIEC();
            
            if ( windPitchContEmulIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindPitchContEmulIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindPitchContEmulIECs ", exc );
        	return null;
        }

        return windPitchContEmulIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPitchContEmulIEC windPitchContEmulIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPitchContEmulIECQueryRestController.class.getName());
    
}
