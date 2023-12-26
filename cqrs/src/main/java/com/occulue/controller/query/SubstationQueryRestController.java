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
 * Implements Spring Controller query CQRS processing for entity Substation.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Substation")
public class SubstationQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Substation using a UUID
     * @param		UUID substationId
     * @return		Substation
     */    
    @GetMapping("/load")
    public Substation load( @RequestParam(required=true) UUID substationId ) {
    	Substation entity = null;

    	try {  
    		entity = SubstationBusinessDelegate.getSubstationInstance().getSubstation( new SubstationFetchOneSummary( substationId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Substation using Id " + substationId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Substation business objects
     * @return		Set<Substation>
     */
    @GetMapping("/")
    public List<Substation> loadAll() {                
    	List<Substation> substationList = null;
        
    	try {
            // load the Substation
            substationList = SubstationBusinessDelegate.getSubstationInstance().getAllSubstation();
            
            if ( substationList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Substations" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Substations ", exc );
        	return null;
        }

        return substationList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Substation substation = null;
    private static final Logger LOGGER = Logger.getLogger(SubstationQueryRestController.class.getName());
    
}
