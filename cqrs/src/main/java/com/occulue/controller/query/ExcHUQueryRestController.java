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
 * Implements Spring Controller query CQRS processing for entity ExcHU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcHU")
public class ExcHUQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcHU using a UUID
     * @param		UUID excHUId
     * @return		ExcHU
     */    
    @GetMapping("/load")
    public ExcHU load( @RequestParam(required=true) UUID excHUId ) {
    	ExcHU entity = null;

    	try {  
    		entity = ExcHUBusinessDelegate.getExcHUInstance().getExcHU( new ExcHUFetchOneSummary( excHUId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcHU using Id " + excHUId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcHU business objects
     * @return		Set<ExcHU>
     */
    @GetMapping("/")
    public List<ExcHU> loadAll() {                
    	List<ExcHU> excHUList = null;
        
    	try {
            // load the ExcHU
            excHUList = ExcHUBusinessDelegate.getExcHUInstance().getAllExcHU();
            
            if ( excHUList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcHUs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcHUs ", exc );
        	return null;
        }

        return excHUList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcHU excHU = null;
    private static final Logger LOGGER = Logger.getLogger(ExcHUQueryRestController.class.getName());
    
}
