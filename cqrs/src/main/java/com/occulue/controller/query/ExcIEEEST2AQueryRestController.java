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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST2A")
public class ExcIEEEST2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST2A using a UUID
     * @param		UUID excIEEEST2AId
     * @return		ExcIEEEST2A
     */    
    @GetMapping("/load")
    public ExcIEEEST2A load( @RequestParam(required=true) UUID excIEEEST2AId ) {
    	ExcIEEEST2A entity = null;

    	try {  
    		entity = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().getExcIEEEST2A( new ExcIEEEST2AFetchOneSummary( excIEEEST2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST2A using Id " + excIEEEST2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST2A business objects
     * @return		Set<ExcIEEEST2A>
     */
    @GetMapping("/")
    public List<ExcIEEEST2A> loadAll() {                
    	List<ExcIEEEST2A> excIEEEST2AList = null;
        
    	try {
            // load the ExcIEEEST2A
            excIEEEST2AList = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().getAllExcIEEEST2A();
            
            if ( excIEEEST2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST2As ", exc );
        	return null;
        }

        return excIEEEST2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST2A excIEEEST2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST2AQueryRestController.class.getName());
    
}
