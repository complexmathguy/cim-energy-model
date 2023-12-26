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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEDC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC1A")
public class ExcIEEEDC1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEDC1A using a UUID
     * @param		UUID excIEEEDC1AId
     * @return		ExcIEEEDC1A
     */    
    @GetMapping("/load")
    public ExcIEEEDC1A load( @RequestParam(required=true) UUID excIEEEDC1AId ) {
    	ExcIEEEDC1A entity = null;

    	try {  
    		entity = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().getExcIEEEDC1A( new ExcIEEEDC1AFetchOneSummary( excIEEEDC1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEDC1A using Id " + excIEEEDC1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEDC1A business objects
     * @return		Set<ExcIEEEDC1A>
     */
    @GetMapping("/")
    public List<ExcIEEEDC1A> loadAll() {                
    	List<ExcIEEEDC1A> excIEEEDC1AList = null;
        
    	try {
            // load the ExcIEEEDC1A
            excIEEEDC1AList = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().getAllExcIEEEDC1A();
            
            if ( excIEEEDC1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEDC1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEDC1As ", exc );
        	return null;
        }

        return excIEEEDC1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC1A excIEEEDC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC1AQueryRestController.class.getName());
    
}
