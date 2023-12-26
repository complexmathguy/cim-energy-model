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
 * Implements Spring Controller query CQRS processing for entity ExcAVR7.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR7")
public class ExcAVR7QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAVR7 using a UUID
     * @param		UUID excAVR7Id
     * @return		ExcAVR7
     */    
    @GetMapping("/load")
    public ExcAVR7 load( @RequestParam(required=true) UUID excAVR7Id ) {
    	ExcAVR7 entity = null;

    	try {  
    		entity = ExcAVR7BusinessDelegate.getExcAVR7Instance().getExcAVR7( new ExcAVR7FetchOneSummary( excAVR7Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAVR7 using Id " + excAVR7Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAVR7 business objects
     * @return		Set<ExcAVR7>
     */
    @GetMapping("/")
    public List<ExcAVR7> loadAll() {                
    	List<ExcAVR7> excAVR7List = null;
        
    	try {
            // load the ExcAVR7
            excAVR7List = ExcAVR7BusinessDelegate.getExcAVR7Instance().getAllExcAVR7();
            
            if ( excAVR7List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAVR7s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAVR7s ", exc );
        	return null;
        }

        return excAVR7List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR7 excAVR7 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR7QueryRestController.class.getName());
    
}
