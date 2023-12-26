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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST3A")
public class ExcIEEEST3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST3A using a UUID
     * @param		UUID excIEEEST3AId
     * @return		ExcIEEEST3A
     */    
    @GetMapping("/load")
    public ExcIEEEST3A load( @RequestParam(required=true) UUID excIEEEST3AId ) {
    	ExcIEEEST3A entity = null;

    	try {  
    		entity = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().getExcIEEEST3A( new ExcIEEEST3AFetchOneSummary( excIEEEST3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST3A using Id " + excIEEEST3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST3A business objects
     * @return		Set<ExcIEEEST3A>
     */
    @GetMapping("/")
    public List<ExcIEEEST3A> loadAll() {                
    	List<ExcIEEEST3A> excIEEEST3AList = null;
        
    	try {
            // load the ExcIEEEST3A
            excIEEEST3AList = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().getAllExcIEEEST3A();
            
            if ( excIEEEST3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST3As ", exc );
        	return null;
        }

        return excIEEEST3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST3A excIEEEST3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST3AQueryRestController.class.getName());
    
}
