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
 * Implements Spring Controller query CQRS processing for entity ExcAC4A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC4A")
public class ExcAC4AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC4A using a UUID
     * @param		UUID excAC4AId
     * @return		ExcAC4A
     */    
    @GetMapping("/load")
    public ExcAC4A load( @RequestParam(required=true) UUID excAC4AId ) {
    	ExcAC4A entity = null;

    	try {  
    		entity = ExcAC4ABusinessDelegate.getExcAC4AInstance().getExcAC4A( new ExcAC4AFetchOneSummary( excAC4AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC4A using Id " + excAC4AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC4A business objects
     * @return		Set<ExcAC4A>
     */
    @GetMapping("/")
    public List<ExcAC4A> loadAll() {                
    	List<ExcAC4A> excAC4AList = null;
        
    	try {
            // load the ExcAC4A
            excAC4AList = ExcAC4ABusinessDelegate.getExcAC4AInstance().getAllExcAC4A();
            
            if ( excAC4AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC4As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC4As ", exc );
        	return null;
        }

        return excAC4AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC4A excAC4A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC4AQueryRestController.class.getName());
    
}
