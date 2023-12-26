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
 * Implements Spring Controller query CQRS processing for entity ExcDC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC3A")
public class ExcDC3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcDC3A using a UUID
     * @param		UUID excDC3AId
     * @return		ExcDC3A
     */    
    @GetMapping("/load")
    public ExcDC3A load( @RequestParam(required=true) UUID excDC3AId ) {
    	ExcDC3A entity = null;

    	try {  
    		entity = ExcDC3ABusinessDelegate.getExcDC3AInstance().getExcDC3A( new ExcDC3AFetchOneSummary( excDC3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcDC3A using Id " + excDC3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcDC3A business objects
     * @return		Set<ExcDC3A>
     */
    @GetMapping("/")
    public List<ExcDC3A> loadAll() {                
    	List<ExcDC3A> excDC3AList = null;
        
    	try {
            // load the ExcDC3A
            excDC3AList = ExcDC3ABusinessDelegate.getExcDC3AInstance().getAllExcDC3A();
            
            if ( excDC3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcDC3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcDC3As ", exc );
        	return null;
        }

        return excDC3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC3A excDC3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC3AQueryRestController.class.getName());
    
}
