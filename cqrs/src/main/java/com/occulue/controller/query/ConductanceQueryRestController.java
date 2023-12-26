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
 * Implements Spring Controller query CQRS processing for entity Conductance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Conductance")
public class ConductanceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Conductance using a UUID
     * @param		UUID conductanceId
     * @return		Conductance
     */    
    @GetMapping("/load")
    public Conductance load( @RequestParam(required=true) UUID conductanceId ) {
    	Conductance entity = null;

    	try {  
    		entity = ConductanceBusinessDelegate.getConductanceInstance().getConductance( new ConductanceFetchOneSummary( conductanceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Conductance using Id " + conductanceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Conductance business objects
     * @return		Set<Conductance>
     */
    @GetMapping("/")
    public List<Conductance> loadAll() {                
    	List<Conductance> conductanceList = null;
        
    	try {
            // load the Conductance
            conductanceList = ConductanceBusinessDelegate.getConductanceInstance().getAllConductance();
            
            if ( conductanceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Conductances" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Conductances ", exc );
        	return null;
        }

        return conductanceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Conductance conductance = null;
    private static final Logger LOGGER = Logger.getLogger(ConductanceQueryRestController.class.getName());
    
}
