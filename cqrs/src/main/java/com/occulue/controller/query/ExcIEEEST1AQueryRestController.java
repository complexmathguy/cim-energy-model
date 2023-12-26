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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST1A")
public class ExcIEEEST1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST1A using a UUID
     * @param		UUID excIEEEST1AId
     * @return		ExcIEEEST1A
     */    
    @GetMapping("/load")
    public ExcIEEEST1A load( @RequestParam(required=true) UUID excIEEEST1AId ) {
    	ExcIEEEST1A entity = null;

    	try {  
    		entity = ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().getExcIEEEST1A( new ExcIEEEST1AFetchOneSummary( excIEEEST1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST1A using Id " + excIEEEST1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST1A business objects
     * @return		Set<ExcIEEEST1A>
     */
    @GetMapping("/")
    public List<ExcIEEEST1A> loadAll() {                
    	List<ExcIEEEST1A> excIEEEST1AList = null;
        
    	try {
            // load the ExcIEEEST1A
            excIEEEST1AList = ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().getAllExcIEEEST1A();
            
            if ( excIEEEST1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST1As ", exc );
        	return null;
        }

        return excIEEEST1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST1A excIEEEST1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST1AQueryRestController.class.getName());
    
}
