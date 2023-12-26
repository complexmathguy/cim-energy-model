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
 * Implements Spring Controller query CQRS processing for entity ExcST1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST1A")
public class ExcST1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcST1A using a UUID
     * @param		UUID excST1AId
     * @return		ExcST1A
     */    
    @GetMapping("/load")
    public ExcST1A load( @RequestParam(required=true) UUID excST1AId ) {
    	ExcST1A entity = null;

    	try {  
    		entity = ExcST1ABusinessDelegate.getExcST1AInstance().getExcST1A( new ExcST1AFetchOneSummary( excST1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcST1A using Id " + excST1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcST1A business objects
     * @return		Set<ExcST1A>
     */
    @GetMapping("/")
    public List<ExcST1A> loadAll() {                
    	List<ExcST1A> excST1AList = null;
        
    	try {
            // load the ExcST1A
            excST1AList = ExcST1ABusinessDelegate.getExcST1AInstance().getAllExcST1A();
            
            if ( excST1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcST1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcST1As ", exc );
        	return null;
        }

        return excST1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST1A excST1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST1AQueryRestController.class.getName());
    
}
