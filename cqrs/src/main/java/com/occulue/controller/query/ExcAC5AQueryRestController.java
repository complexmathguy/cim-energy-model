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
 * Implements Spring Controller query CQRS processing for entity ExcAC5A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC5A")
public class ExcAC5AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC5A using a UUID
     * @param		UUID excAC5AId
     * @return		ExcAC5A
     */    
    @GetMapping("/load")
    public ExcAC5A load( @RequestParam(required=true) UUID excAC5AId ) {
    	ExcAC5A entity = null;

    	try {  
    		entity = ExcAC5ABusinessDelegate.getExcAC5AInstance().getExcAC5A( new ExcAC5AFetchOneSummary( excAC5AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC5A using Id " + excAC5AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC5A business objects
     * @return		Set<ExcAC5A>
     */
    @GetMapping("/")
    public List<ExcAC5A> loadAll() {                
    	List<ExcAC5A> excAC5AList = null;
        
    	try {
            // load the ExcAC5A
            excAC5AList = ExcAC5ABusinessDelegate.getExcAC5AInstance().getAllExcAC5A();
            
            if ( excAC5AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC5As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC5As ", exc );
        	return null;
        }

        return excAC5AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC5A excAC5A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC5AQueryRestController.class.getName());
    
}
