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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEDC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC2A")
public class ExcIEEEDC2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEDC2A using a UUID
     * @param		UUID excIEEEDC2AId
     * @return		ExcIEEEDC2A
     */    
    @GetMapping("/load")
    public ExcIEEEDC2A load( @RequestParam(required=true) UUID excIEEEDC2AId ) {
    	ExcIEEEDC2A entity = null;

    	try {  
    		entity = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().getExcIEEEDC2A( new ExcIEEEDC2AFetchOneSummary( excIEEEDC2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEDC2A using Id " + excIEEEDC2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEDC2A business objects
     * @return		Set<ExcIEEEDC2A>
     */
    @GetMapping("/")
    public List<ExcIEEEDC2A> loadAll() {                
    	List<ExcIEEEDC2A> excIEEEDC2AList = null;
        
    	try {
            // load the ExcIEEEDC2A
            excIEEEDC2AList = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().getAllExcIEEEDC2A();
            
            if ( excIEEEDC2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEDC2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEDC2As ", exc );
        	return null;
        }

        return excIEEEDC2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC2A excIEEEDC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC2AQueryRestController.class.getName());
    
}
