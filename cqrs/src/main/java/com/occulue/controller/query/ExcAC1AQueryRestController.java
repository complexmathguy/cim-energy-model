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
 * Implements Spring Controller query CQRS processing for entity ExcAC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC1A")
public class ExcAC1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC1A using a UUID
     * @param		UUID excAC1AId
     * @return		ExcAC1A
     */    
    @GetMapping("/load")
    public ExcAC1A load( @RequestParam(required=true) UUID excAC1AId ) {
    	ExcAC1A entity = null;

    	try {  
    		entity = ExcAC1ABusinessDelegate.getExcAC1AInstance().getExcAC1A( new ExcAC1AFetchOneSummary( excAC1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC1A using Id " + excAC1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC1A business objects
     * @return		Set<ExcAC1A>
     */
    @GetMapping("/")
    public List<ExcAC1A> loadAll() {                
    	List<ExcAC1A> excAC1AList = null;
        
    	try {
            // load the ExcAC1A
            excAC1AList = ExcAC1ABusinessDelegate.getExcAC1AInstance().getAllExcAC1A();
            
            if ( excAC1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC1As ", exc );
        	return null;
        }

        return excAC1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC1A excAC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC1AQueryRestController.class.getName());
    
}
