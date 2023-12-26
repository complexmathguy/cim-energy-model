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
 * Implements Spring Controller query CQRS processing for entity ExcAVR2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR2")
public class ExcAVR2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAVR2 using a UUID
     * @param		UUID excAVR2Id
     * @return		ExcAVR2
     */    
    @GetMapping("/load")
    public ExcAVR2 load( @RequestParam(required=true) UUID excAVR2Id ) {
    	ExcAVR2 entity = null;

    	try {  
    		entity = ExcAVR2BusinessDelegate.getExcAVR2Instance().getExcAVR2( new ExcAVR2FetchOneSummary( excAVR2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAVR2 using Id " + excAVR2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAVR2 business objects
     * @return		Set<ExcAVR2>
     */
    @GetMapping("/")
    public List<ExcAVR2> loadAll() {                
    	List<ExcAVR2> excAVR2List = null;
        
    	try {
            // load the ExcAVR2
            excAVR2List = ExcAVR2BusinessDelegate.getExcAVR2Instance().getAllExcAVR2();
            
            if ( excAVR2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAVR2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAVR2s ", exc );
        	return null;
        }

        return excAVR2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR2 excAVR2 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR2QueryRestController.class.getName());
    
}
