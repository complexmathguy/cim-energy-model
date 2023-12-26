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
 * Implements Spring Controller query CQRS processing for entity WindPlantFreqPcontrolIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantFreqPcontrolIEC")
public class WindPlantFreqPcontrolIECQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindPlantFreqPcontrolIEC using a UUID
     * @param		UUID windPlantFreqPcontrolIECId
     * @return		WindPlantFreqPcontrolIEC
     */    
    @GetMapping("/load")
    public WindPlantFreqPcontrolIEC load( @RequestParam(required=true) UUID windPlantFreqPcontrolIECId ) {
    	WindPlantFreqPcontrolIEC entity = null;

    	try {  
    		entity = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().getWindPlantFreqPcontrolIEC( new WindPlantFreqPcontrolIECFetchOneSummary( windPlantFreqPcontrolIECId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindPlantFreqPcontrolIEC using Id " + windPlantFreqPcontrolIECId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindPlantFreqPcontrolIEC business objects
     * @return		Set<WindPlantFreqPcontrolIEC>
     */
    @GetMapping("/")
    public List<WindPlantFreqPcontrolIEC> loadAll() {                
    	List<WindPlantFreqPcontrolIEC> windPlantFreqPcontrolIECList = null;
        
    	try {
            // load the WindPlantFreqPcontrolIEC
            windPlantFreqPcontrolIECList = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().getAllWindPlantFreqPcontrolIEC();
            
            if ( windPlantFreqPcontrolIECList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindPlantFreqPcontrolIECs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindPlantFreqPcontrolIECs ", exc );
        	return null;
        }

        return windPlantFreqPcontrolIECList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantFreqPcontrolIECQueryRestController.class.getName());
    
}
