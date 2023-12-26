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
 * Implements Spring Controller query CQRS processing for entity PowerTransformerEnd.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerTransformerEnd")
public class PowerTransformerEndQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PowerTransformerEnd using a UUID
     * @param		UUID powerTransformerEndId
     * @return		PowerTransformerEnd
     */    
    @GetMapping("/load")
    public PowerTransformerEnd load( @RequestParam(required=true) UUID powerTransformerEndId ) {
    	PowerTransformerEnd entity = null;

    	try {  
    		entity = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().getPowerTransformerEnd( new PowerTransformerEndFetchOneSummary( powerTransformerEndId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PowerTransformerEnd using Id " + powerTransformerEndId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PowerTransformerEnd business objects
     * @return		Set<PowerTransformerEnd>
     */
    @GetMapping("/")
    public List<PowerTransformerEnd> loadAll() {                
    	List<PowerTransformerEnd> powerTransformerEndList = null;
        
    	try {
            // load the PowerTransformerEnd
            powerTransformerEndList = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().getAllPowerTransformerEnd();
            
            if ( powerTransformerEndList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PowerTransformerEnds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PowerTransformerEnds ", exc );
        	return null;
        }

        return powerTransformerEndList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PowerTransformerEnd powerTransformerEnd = null;
    private static final Logger LOGGER = Logger.getLogger(PowerTransformerEndQueryRestController.class.getName());
    
}
