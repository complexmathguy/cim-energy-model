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
 * Implements Spring Controller query CQRS processing for entity ExcAVR1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR1")
public class ExcAVR1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAVR1 using a UUID
     * @param		UUID excAVR1Id
     * @return		ExcAVR1
     */    
    @GetMapping("/load")
    public ExcAVR1 load( @RequestParam(required=true) UUID excAVR1Id ) {
    	ExcAVR1 entity = null;

    	try {  
    		entity = ExcAVR1BusinessDelegate.getExcAVR1Instance().getExcAVR1( new ExcAVR1FetchOneSummary( excAVR1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAVR1 using Id " + excAVR1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAVR1 business objects
     * @return		Set<ExcAVR1>
     */
    @GetMapping("/")
    public List<ExcAVR1> loadAll() {                
    	List<ExcAVR1> excAVR1List = null;
        
    	try {
            // load the ExcAVR1
            excAVR1List = ExcAVR1BusinessDelegate.getExcAVR1Instance().getAllExcAVR1();
            
            if ( excAVR1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAVR1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAVR1s ", exc );
        	return null;
        }

        return excAVR1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR1 excAVR1 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR1QueryRestController.class.getName());
    
}
