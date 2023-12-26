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
 * Implements Spring Controller query CQRS processing for entity Inductance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Inductance")
public class InductanceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Inductance using a UUID
     * @param		UUID inductanceId
     * @return		Inductance
     */    
    @GetMapping("/load")
    public Inductance load( @RequestParam(required=true) UUID inductanceId ) {
    	Inductance entity = null;

    	try {  
    		entity = InductanceBusinessDelegate.getInductanceInstance().getInductance( new InductanceFetchOneSummary( inductanceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Inductance using Id " + inductanceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Inductance business objects
     * @return		Set<Inductance>
     */
    @GetMapping("/")
    public List<Inductance> loadAll() {                
    	List<Inductance> inductanceList = null;
        
    	try {
            // load the Inductance
            inductanceList = InductanceBusinessDelegate.getInductanceInstance().getAllInductance();
            
            if ( inductanceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Inductances" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Inductances ", exc );
        	return null;
        }

        return inductanceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Inductance inductance = null;
    private static final Logger LOGGER = Logger.getLogger(InductanceQueryRestController.class.getName());
    
}
