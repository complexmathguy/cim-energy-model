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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC1A")
public class ExcIEEEAC1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC1A using a UUID
     * @param		UUID excIEEEAC1AId
     * @return		ExcIEEEAC1A
     */    
    @GetMapping("/load")
    public ExcIEEEAC1A load( @RequestParam(required=true) UUID excIEEEAC1AId ) {
    	ExcIEEEAC1A entity = null;

    	try {  
    		entity = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().getExcIEEEAC1A( new ExcIEEEAC1AFetchOneSummary( excIEEEAC1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC1A using Id " + excIEEEAC1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC1A business objects
     * @return		Set<ExcIEEEAC1A>
     */
    @GetMapping("/")
    public List<ExcIEEEAC1A> loadAll() {                
    	List<ExcIEEEAC1A> excIEEEAC1AList = null;
        
    	try {
            // load the ExcIEEEAC1A
            excIEEEAC1AList = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().getAllExcIEEEAC1A();
            
            if ( excIEEEAC1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC1As ", exc );
        	return null;
        }

        return excIEEEAC1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC1A excIEEEAC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC1AQueryRestController.class.getName());
    
}
