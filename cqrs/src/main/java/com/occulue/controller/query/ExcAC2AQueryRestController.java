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
 * Implements Spring Controller query CQRS processing for entity ExcAC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC2A")
public class ExcAC2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC2A using a UUID
     * @param		UUID excAC2AId
     * @return		ExcAC2A
     */    
    @GetMapping("/load")
    public ExcAC2A load( @RequestParam(required=true) UUID excAC2AId ) {
    	ExcAC2A entity = null;

    	try {  
    		entity = ExcAC2ABusinessDelegate.getExcAC2AInstance().getExcAC2A( new ExcAC2AFetchOneSummary( excAC2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC2A using Id " + excAC2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC2A business objects
     * @return		Set<ExcAC2A>
     */
    @GetMapping("/")
    public List<ExcAC2A> loadAll() {                
    	List<ExcAC2A> excAC2AList = null;
        
    	try {
            // load the ExcAC2A
            excAC2AList = ExcAC2ABusinessDelegate.getExcAC2AInstance().getAllExcAC2A();
            
            if ( excAC2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC2As ", exc );
        	return null;
        }

        return excAC2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC2A excAC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC2AQueryRestController.class.getName());
    
}
