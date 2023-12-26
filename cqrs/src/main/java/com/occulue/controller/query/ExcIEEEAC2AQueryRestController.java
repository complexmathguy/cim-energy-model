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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC2A")
public class ExcIEEEAC2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC2A using a UUID
     * @param		UUID excIEEEAC2AId
     * @return		ExcIEEEAC2A
     */    
    @GetMapping("/load")
    public ExcIEEEAC2A load( @RequestParam(required=true) UUID excIEEEAC2AId ) {
    	ExcIEEEAC2A entity = null;

    	try {  
    		entity = ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().getExcIEEEAC2A( new ExcIEEEAC2AFetchOneSummary( excIEEEAC2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC2A using Id " + excIEEEAC2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC2A business objects
     * @return		Set<ExcIEEEAC2A>
     */
    @GetMapping("/")
    public List<ExcIEEEAC2A> loadAll() {                
    	List<ExcIEEEAC2A> excIEEEAC2AList = null;
        
    	try {
            // load the ExcIEEEAC2A
            excIEEEAC2AList = ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().getAllExcIEEEAC2A();
            
            if ( excIEEEAC2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC2As ", exc );
        	return null;
        }

        return excIEEEAC2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC2A excIEEEAC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC2AQueryRestController.class.getName());
    
}
