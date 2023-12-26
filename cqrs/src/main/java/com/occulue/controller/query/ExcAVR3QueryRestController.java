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
 * Implements Spring Controller query CQRS processing for entity ExcAVR3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR3")
public class ExcAVR3QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAVR3 using a UUID
     * @param		UUID excAVR3Id
     * @return		ExcAVR3
     */    
    @GetMapping("/load")
    public ExcAVR3 load( @RequestParam(required=true) UUID excAVR3Id ) {
    	ExcAVR3 entity = null;

    	try {  
    		entity = ExcAVR3BusinessDelegate.getExcAVR3Instance().getExcAVR3( new ExcAVR3FetchOneSummary( excAVR3Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAVR3 using Id " + excAVR3Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAVR3 business objects
     * @return		Set<ExcAVR3>
     */
    @GetMapping("/")
    public List<ExcAVR3> loadAll() {                
    	List<ExcAVR3> excAVR3List = null;
        
    	try {
            // load the ExcAVR3
            excAVR3List = ExcAVR3BusinessDelegate.getExcAVR3Instance().getAllExcAVR3();
            
            if ( excAVR3List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAVR3s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAVR3s ", exc );
        	return null;
        }

        return excAVR3List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR3 excAVR3 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR3QueryRestController.class.getName());
    
}
