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
 * Implements Spring Controller query CQRS processing for entity ExcST2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST2A")
public class ExcST2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcST2A using a UUID
     * @param		UUID excST2AId
     * @return		ExcST2A
     */    
    @GetMapping("/load")
    public ExcST2A load( @RequestParam(required=true) UUID excST2AId ) {
    	ExcST2A entity = null;

    	try {  
    		entity = ExcST2ABusinessDelegate.getExcST2AInstance().getExcST2A( new ExcST2AFetchOneSummary( excST2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcST2A using Id " + excST2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcST2A business objects
     * @return		Set<ExcST2A>
     */
    @GetMapping("/")
    public List<ExcST2A> loadAll() {                
    	List<ExcST2A> excST2AList = null;
        
    	try {
            // load the ExcST2A
            excST2AList = ExcST2ABusinessDelegate.getExcST2AInstance().getAllExcST2A();
            
            if ( excST2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcST2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcST2As ", exc );
        	return null;
        }

        return excST2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST2A excST2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST2AQueryRestController.class.getName());
    
}
