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
 * Implements Spring Controller query CQRS processing for entity ExcST3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST3A")
public class ExcST3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcST3A using a UUID
     * @param		UUID excST3AId
     * @return		ExcST3A
     */    
    @GetMapping("/load")
    public ExcST3A load( @RequestParam(required=true) UUID excST3AId ) {
    	ExcST3A entity = null;

    	try {  
    		entity = ExcST3ABusinessDelegate.getExcST3AInstance().getExcST3A( new ExcST3AFetchOneSummary( excST3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcST3A using Id " + excST3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcST3A business objects
     * @return		Set<ExcST3A>
     */
    @GetMapping("/")
    public List<ExcST3A> loadAll() {                
    	List<ExcST3A> excST3AList = null;
        
    	try {
            // load the ExcST3A
            excST3AList = ExcST3ABusinessDelegate.getExcST3AInstance().getAllExcST3A();
            
            if ( excST3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcST3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcST3As ", exc );
        	return null;
        }

        return excST3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST3A excST3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST3AQueryRestController.class.getName());
    
}
