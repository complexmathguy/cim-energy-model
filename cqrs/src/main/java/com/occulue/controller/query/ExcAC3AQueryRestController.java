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
 * Implements Spring Controller query CQRS processing for entity ExcAC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC3A")
public class ExcAC3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC3A using a UUID
     * @param		UUID excAC3AId
     * @return		ExcAC3A
     */    
    @GetMapping("/load")
    public ExcAC3A load( @RequestParam(required=true) UUID excAC3AId ) {
    	ExcAC3A entity = null;

    	try {  
    		entity = ExcAC3ABusinessDelegate.getExcAC3AInstance().getExcAC3A( new ExcAC3AFetchOneSummary( excAC3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC3A using Id " + excAC3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC3A business objects
     * @return		Set<ExcAC3A>
     */
    @GetMapping("/")
    public List<ExcAC3A> loadAll() {                
    	List<ExcAC3A> excAC3AList = null;
        
    	try {
            // load the ExcAC3A
            excAC3AList = ExcAC3ABusinessDelegate.getExcAC3AInstance().getAllExcAC3A();
            
            if ( excAC3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC3As ", exc );
        	return null;
        }

        return excAC3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC3A excAC3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC3AQueryRestController.class.getName());
    
}
