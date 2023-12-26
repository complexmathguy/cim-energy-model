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
 * Implements Spring Controller query CQRS processing for entity ENTSOEJunction.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEJunction")
public class ENTSOEJunctionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ENTSOEJunction using a UUID
     * @param		UUID eNTSOEJunctionId
     * @return		ENTSOEJunction
     */    
    @GetMapping("/load")
    public ENTSOEJunction load( @RequestParam(required=true) UUID eNTSOEJunctionId ) {
    	ENTSOEJunction entity = null;

    	try {  
    		entity = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().getENTSOEJunction( new ENTSOEJunctionFetchOneSummary( eNTSOEJunctionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ENTSOEJunction using Id " + eNTSOEJunctionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ENTSOEJunction business objects
     * @return		Set<ENTSOEJunction>
     */
    @GetMapping("/")
    public List<ENTSOEJunction> loadAll() {                
    	List<ENTSOEJunction> eNTSOEJunctionList = null;
        
    	try {
            // load the ENTSOEJunction
            eNTSOEJunctionList = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().getAllENTSOEJunction();
            
            if ( eNTSOEJunctionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ENTSOEJunctions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ENTSOEJunctions ", exc );
        	return null;
        }

        return eNTSOEJunctionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEJunction eNTSOEJunction = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEJunctionQueryRestController.class.getName());
    
}
