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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC3A")
public class ExcIEEEAC3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC3A using a UUID
     * @param		UUID excIEEEAC3AId
     * @return		ExcIEEEAC3A
     */    
    @GetMapping("/load")
    public ExcIEEEAC3A load( @RequestParam(required=true) UUID excIEEEAC3AId ) {
    	ExcIEEEAC3A entity = null;

    	try {  
    		entity = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().getExcIEEEAC3A( new ExcIEEEAC3AFetchOneSummary( excIEEEAC3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC3A using Id " + excIEEEAC3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC3A business objects
     * @return		Set<ExcIEEEAC3A>
     */
    @GetMapping("/")
    public List<ExcIEEEAC3A> loadAll() {                
    	List<ExcIEEEAC3A> excIEEEAC3AList = null;
        
    	try {
            // load the ExcIEEEAC3A
            excIEEEAC3AList = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().getAllExcIEEEAC3A();
            
            if ( excIEEEAC3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC3As ", exc );
        	return null;
        }

        return excIEEEAC3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC3A excIEEEAC3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC3AQueryRestController.class.getName());
    
}
