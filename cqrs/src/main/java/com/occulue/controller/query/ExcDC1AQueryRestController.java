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
 * Implements Spring Controller query CQRS processing for entity ExcDC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC1A")
public class ExcDC1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcDC1A using a UUID
     * @param		UUID excDC1AId
     * @return		ExcDC1A
     */    
    @GetMapping("/load")
    public ExcDC1A load( @RequestParam(required=true) UUID excDC1AId ) {
    	ExcDC1A entity = null;

    	try {  
    		entity = ExcDC1ABusinessDelegate.getExcDC1AInstance().getExcDC1A( new ExcDC1AFetchOneSummary( excDC1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcDC1A using Id " + excDC1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcDC1A business objects
     * @return		Set<ExcDC1A>
     */
    @GetMapping("/")
    public List<ExcDC1A> loadAll() {                
    	List<ExcDC1A> excDC1AList = null;
        
    	try {
            // load the ExcDC1A
            excDC1AList = ExcDC1ABusinessDelegate.getExcDC1AInstance().getAllExcDC1A();
            
            if ( excDC1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcDC1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcDC1As ", exc );
        	return null;
        }

        return excDC1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC1A excDC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC1AQueryRestController.class.getName());
    
}
