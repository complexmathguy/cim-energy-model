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
 * Implements Spring Controller query CQRS processing for entity IdentifiedObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/IdentifiedObject")
public class IdentifiedObjectQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a IdentifiedObject using a UUID
     * @param		UUID identifiedObjectId
     * @return		IdentifiedObject
     */    
    @GetMapping("/load")
    public IdentifiedObject load( @RequestParam(required=true) UUID identifiedObjectId ) {
    	IdentifiedObject entity = null;

    	try {  
    		entity = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().getIdentifiedObject( new IdentifiedObjectFetchOneSummary( identifiedObjectId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load IdentifiedObject using Id " + identifiedObjectId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all IdentifiedObject business objects
     * @return		Set<IdentifiedObject>
     */
    @GetMapping("/")
    public List<IdentifiedObject> loadAll() {                
    	List<IdentifiedObject> identifiedObjectList = null;
        
    	try {
            // load the IdentifiedObject
            identifiedObjectList = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().getAllIdentifiedObject();
            
            if ( identifiedObjectList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all IdentifiedObjects" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all IdentifiedObjects ", exc );
        	return null;
        }

        return identifiedObjectList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected IdentifiedObject identifiedObject = null;
    private static final Logger LOGGER = Logger.getLogger(IdentifiedObjectQueryRestController.class.getName());
    
}
