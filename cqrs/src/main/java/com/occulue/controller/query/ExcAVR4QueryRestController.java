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
 * Implements Spring Controller query CQRS processing for entity ExcAVR4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR4")
public class ExcAVR4QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAVR4 using a UUID
     * @param		UUID excAVR4Id
     * @return		ExcAVR4
     */    
    @GetMapping("/load")
    public ExcAVR4 load( @RequestParam(required=true) UUID excAVR4Id ) {
    	ExcAVR4 entity = null;

    	try {  
    		entity = ExcAVR4BusinessDelegate.getExcAVR4Instance().getExcAVR4( new ExcAVR4FetchOneSummary( excAVR4Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAVR4 using Id " + excAVR4Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAVR4 business objects
     * @return		Set<ExcAVR4>
     */
    @GetMapping("/")
    public List<ExcAVR4> loadAll() {                
    	List<ExcAVR4> excAVR4List = null;
        
    	try {
            // load the ExcAVR4
            excAVR4List = ExcAVR4BusinessDelegate.getExcAVR4Instance().getAllExcAVR4();
            
            if ( excAVR4List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAVR4s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAVR4s ", exc );
        	return null;
        }

        return excAVR4List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR4 excAVR4 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR4QueryRestController.class.getName());
    
}
