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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC6A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC6A")
public class ExcIEEEAC6AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC6A using a UUID
     * @param		UUID excIEEEAC6AId
     * @return		ExcIEEEAC6A
     */    
    @GetMapping("/load")
    public ExcIEEEAC6A load( @RequestParam(required=true) UUID excIEEEAC6AId ) {
    	ExcIEEEAC6A entity = null;

    	try {  
    		entity = ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().getExcIEEEAC6A( new ExcIEEEAC6AFetchOneSummary( excIEEEAC6AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC6A using Id " + excIEEEAC6AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC6A business objects
     * @return		Set<ExcIEEEAC6A>
     */
    @GetMapping("/")
    public List<ExcIEEEAC6A> loadAll() {                
    	List<ExcIEEEAC6A> excIEEEAC6AList = null;
        
    	try {
            // load the ExcIEEEAC6A
            excIEEEAC6AList = ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().getAllExcIEEEAC6A();
            
            if ( excIEEEAC6AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC6As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC6As ", exc );
        	return null;
        }

        return excIEEEAC6AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC6A excIEEEAC6A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC6AQueryRestController.class.getName());
    
}
