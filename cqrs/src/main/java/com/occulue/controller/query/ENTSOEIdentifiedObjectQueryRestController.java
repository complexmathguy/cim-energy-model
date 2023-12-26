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
 * Implements Spring Controller query CQRS processing for entity ENTSOEIdentifiedObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEIdentifiedObject")
public class ENTSOEIdentifiedObjectQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ENTSOEIdentifiedObject using a UUID
     * @param		UUID eNTSOEIdentifiedObjectId
     * @return		ENTSOEIdentifiedObject
     */    
    @GetMapping("/load")
    public ENTSOEIdentifiedObject load( @RequestParam(required=true) UUID eNTSOEIdentifiedObjectId ) {
    	ENTSOEIdentifiedObject entity = null;

    	try {  
    		entity = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().getENTSOEIdentifiedObject( new ENTSOEIdentifiedObjectFetchOneSummary( eNTSOEIdentifiedObjectId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ENTSOEIdentifiedObject using Id " + eNTSOEIdentifiedObjectId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ENTSOEIdentifiedObject business objects
     * @return		Set<ENTSOEIdentifiedObject>
     */
    @GetMapping("/")
    public List<ENTSOEIdentifiedObject> loadAll() {                
    	List<ENTSOEIdentifiedObject> eNTSOEIdentifiedObjectList = null;
        
    	try {
            // load the ENTSOEIdentifiedObject
            eNTSOEIdentifiedObjectList = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().getAllENTSOEIdentifiedObject();
            
            if ( eNTSOEIdentifiedObjectList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ENTSOEIdentifiedObjects" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ENTSOEIdentifiedObjects ", exc );
        	return null;
        }

        return eNTSOEIdentifiedObjectList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEIdentifiedObject eNTSOEIdentifiedObject = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEIdentifiedObjectQueryRestController.class.getName());
    
}
