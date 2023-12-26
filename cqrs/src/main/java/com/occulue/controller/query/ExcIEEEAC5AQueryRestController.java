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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC5A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC5A")
public class ExcIEEEAC5AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC5A using a UUID
     * @param		UUID excIEEEAC5AId
     * @return		ExcIEEEAC5A
     */    
    @GetMapping("/load")
    public ExcIEEEAC5A load( @RequestParam(required=true) UUID excIEEEAC5AId ) {
    	ExcIEEEAC5A entity = null;

    	try {  
    		entity = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().getExcIEEEAC5A( new ExcIEEEAC5AFetchOneSummary( excIEEEAC5AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC5A using Id " + excIEEEAC5AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC5A business objects
     * @return		Set<ExcIEEEAC5A>
     */
    @GetMapping("/")
    public List<ExcIEEEAC5A> loadAll() {                
    	List<ExcIEEEAC5A> excIEEEAC5AList = null;
        
    	try {
            // load the ExcIEEEAC5A
            excIEEEAC5AList = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().getAllExcIEEEAC5A();
            
            if ( excIEEEAC5AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC5As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC5As ", exc );
        	return null;
        }

        return excIEEEAC5AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC5A excIEEEAC5A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC5AQueryRestController.class.getName());
    
}
