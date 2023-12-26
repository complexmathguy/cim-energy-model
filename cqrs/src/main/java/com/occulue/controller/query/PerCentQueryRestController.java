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
 * Implements Spring Controller query CQRS processing for entity PerCent.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PerCent")
public class PerCentQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PerCent using a UUID
     * @param		UUID perCentId
     * @return		PerCent
     */    
    @GetMapping("/load")
    public PerCent load( @RequestParam(required=true) UUID perCentId ) {
    	PerCent entity = null;

    	try {  
    		entity = PerCentBusinessDelegate.getPerCentInstance().getPerCent( new PerCentFetchOneSummary( perCentId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PerCent using Id " + perCentId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PerCent business objects
     * @return		Set<PerCent>
     */
    @GetMapping("/")
    public List<PerCent> loadAll() {                
    	List<PerCent> perCentList = null;
        
    	try {
            // load the PerCent
            perCentList = PerCentBusinessDelegate.getPerCentInstance().getAllPerCent();
            
            if ( perCentList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PerCents" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PerCents ", exc );
        	return null;
        }

        return perCentList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PerCent perCent = null;
    private static final Logger LOGGER = Logger.getLogger(PerCentQueryRestController.class.getName());
    
}
