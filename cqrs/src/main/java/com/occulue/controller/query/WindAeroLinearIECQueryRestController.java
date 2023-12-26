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
 * Implements Spring Controller query CQRS processing for entity WindAeroLinearIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindAeroLinearIEC")
public class WindAeroLinearIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindAeroLinearIEC using a UUID
     * @param		UUID windAeroLinearIECId
     * @return		WindAeroLinearIEC
     */    
    @GetMapping("/load")
    public WindAeroLinearIEC load( @RequestParam(required=true) UUID windAeroLinearIECId ) {
    	WindAeroLinearIEC entity = null;

    	try {  
    		entity = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().getWindAeroLinearIEC( new WindAeroLinearIECFetchOneSummary( windAeroLinearIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindAeroLinearIEC using Id " + windAeroLinearIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindAeroLinearIEC business objects
     * @return		Set<WindAeroLinearIEC>
     */
    @GetMapping("/")
    public List<WindAeroLinearIEC> loadAll() {                
    	List<WindAeroLinearIEC> windAeroLinearIECList = null;
        
    	try {
            // load the WindAeroLinearIEC
            windAeroLinearIECList = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().getAllWindAeroLinearIEC();
            
            if ( windAeroLinearIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindAeroLinearIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindAeroLinearIECs ", exc );
        	return null;
        }

        return windAeroLinearIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindAeroLinearIEC windAeroLinearIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindAeroLinearIECQueryRestController.class.getName());
    
}
