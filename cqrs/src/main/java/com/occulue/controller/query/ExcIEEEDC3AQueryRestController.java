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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEDC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC3A")
public class ExcIEEEDC3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEDC3A using a UUID
     * @param		UUID excIEEEDC3AId
     * @return		ExcIEEEDC3A
     */    
    @GetMapping("/load")
    public ExcIEEEDC3A load( @RequestParam(required=true) UUID excIEEEDC3AId ) {
    	ExcIEEEDC3A entity = null;

    	try {  
    		entity = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().getExcIEEEDC3A( new ExcIEEEDC3AFetchOneSummary( excIEEEDC3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEDC3A using Id " + excIEEEDC3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEDC3A business objects
     * @return		Set<ExcIEEEDC3A>
     */
    @GetMapping("/")
    public List<ExcIEEEDC3A> loadAll() {                
    	List<ExcIEEEDC3A> excIEEEDC3AList = null;
        
    	try {
            // load the ExcIEEEDC3A
            excIEEEDC3AList = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().getAllExcIEEEDC3A();
            
            if ( excIEEEDC3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEDC3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEDC3As ", exc );
        	return null;
        }

        return excIEEEDC3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC3A excIEEEDC3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC3AQueryRestController.class.getName());
    
}
