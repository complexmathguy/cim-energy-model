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
 * Implements Spring Controller query CQRS processing for entity ExcAVR5.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR5")
public class ExcAVR5QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAVR5 using a UUID
     * @param		UUID excAVR5Id
     * @return		ExcAVR5
     */    
    @GetMapping("/load")
    public ExcAVR5 load( @RequestParam(required=true) UUID excAVR5Id ) {
    	ExcAVR5 entity = null;

    	try {  
    		entity = ExcAVR5BusinessDelegate.getExcAVR5Instance().getExcAVR5( new ExcAVR5FetchOneSummary( excAVR5Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAVR5 using Id " + excAVR5Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAVR5 business objects
     * @return		Set<ExcAVR5>
     */
    @GetMapping("/")
    public List<ExcAVR5> loadAll() {                
    	List<ExcAVR5> excAVR5List = null;
        
    	try {
            // load the ExcAVR5
            excAVR5List = ExcAVR5BusinessDelegate.getExcAVR5Instance().getAllExcAVR5();
            
            if ( excAVR5List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAVR5s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAVR5s ", exc );
        	return null;
        }

        return excAVR5List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR5 excAVR5 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR5QueryRestController.class.getName());
    
}
