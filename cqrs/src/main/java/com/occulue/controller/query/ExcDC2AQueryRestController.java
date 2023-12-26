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
 * Implements Spring Controller query CQRS processing for entity ExcDC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC2A")
public class ExcDC2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcDC2A using a UUID
     * @param		UUID excDC2AId
     * @return		ExcDC2A
     */    
    @GetMapping("/load")
    public ExcDC2A load( @RequestParam(required=true) UUID excDC2AId ) {
    	ExcDC2A entity = null;

    	try {  
    		entity = ExcDC2ABusinessDelegate.getExcDC2AInstance().getExcDC2A( new ExcDC2AFetchOneSummary( excDC2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcDC2A using Id " + excDC2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcDC2A business objects
     * @return		Set<ExcDC2A>
     */
    @GetMapping("/")
    public List<ExcDC2A> loadAll() {                
    	List<ExcDC2A> excDC2AList = null;
        
    	try {
            // load the ExcDC2A
            excDC2AList = ExcDC2ABusinessDelegate.getExcDC2AInstance().getAllExcDC2A();
            
            if ( excDC2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcDC2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcDC2As ", exc );
        	return null;
        }

        return excDC2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC2A excDC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC2AQueryRestController.class.getName());
    
}
