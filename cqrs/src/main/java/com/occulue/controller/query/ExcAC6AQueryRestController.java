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
 * Implements Spring Controller query CQRS processing for entity ExcAC6A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC6A")
public class ExcAC6AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC6A using a UUID
     * @param		UUID excAC6AId
     * @return		ExcAC6A
     */    
    @GetMapping("/load")
    public ExcAC6A load( @RequestParam(required=true) UUID excAC6AId ) {
    	ExcAC6A entity = null;

    	try {  
    		entity = ExcAC6ABusinessDelegate.getExcAC6AInstance().getExcAC6A( new ExcAC6AFetchOneSummary( excAC6AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC6A using Id " + excAC6AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC6A business objects
     * @return		Set<ExcAC6A>
     */
    @GetMapping("/")
    public List<ExcAC6A> loadAll() {                
    	List<ExcAC6A> excAC6AList = null;
        
    	try {
            // load the ExcAC6A
            excAC6AList = ExcAC6ABusinessDelegate.getExcAC6AInstance().getAllExcAC6A();
            
            if ( excAC6AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC6As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC6As ", exc );
        	return null;
        }

        return excAC6AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC6A excAC6A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC6AQueryRestController.class.getName());
    
}
