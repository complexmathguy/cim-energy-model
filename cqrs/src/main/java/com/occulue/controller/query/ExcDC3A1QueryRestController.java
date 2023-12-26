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
 * Implements Spring Controller query CQRS processing for entity ExcDC3A1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC3A1")
public class ExcDC3A1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcDC3A1 using a UUID
     * @param		UUID excDC3A1Id
     * @return		ExcDC3A1
     */    
    @GetMapping("/load")
    public ExcDC3A1 load( @RequestParam(required=true) UUID excDC3A1Id ) {
    	ExcDC3A1 entity = null;

    	try {  
    		entity = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().getExcDC3A1( new ExcDC3A1FetchOneSummary( excDC3A1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcDC3A1 using Id " + excDC3A1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcDC3A1 business objects
     * @return		Set<ExcDC3A1>
     */
    @GetMapping("/")
    public List<ExcDC3A1> loadAll() {                
    	List<ExcDC3A1> excDC3A1List = null;
        
    	try {
            // load the ExcDC3A1
            excDC3A1List = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().getAllExcDC3A1();
            
            if ( excDC3A1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcDC3A1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcDC3A1s ", exc );
        	return null;
        }

        return excDC3A1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC3A1 excDC3A1 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC3A1QueryRestController.class.getName());
    
}
