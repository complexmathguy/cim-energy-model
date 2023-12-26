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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC4A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC4A")
public class ExcIEEEAC4AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC4A using a UUID
     * @param		UUID excIEEEAC4AId
     * @return		ExcIEEEAC4A
     */    
    @GetMapping("/load")
    public ExcIEEEAC4A load( @RequestParam(required=true) UUID excIEEEAC4AId ) {
    	ExcIEEEAC4A entity = null;

    	try {  
    		entity = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().getExcIEEEAC4A( new ExcIEEEAC4AFetchOneSummary( excIEEEAC4AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC4A using Id " + excIEEEAC4AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC4A business objects
     * @return		Set<ExcIEEEAC4A>
     */
    @GetMapping("/")
    public List<ExcIEEEAC4A> loadAll() {                
    	List<ExcIEEEAC4A> excIEEEAC4AList = null;
        
    	try {
            // load the ExcIEEEAC4A
            excIEEEAC4AList = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().getAllExcIEEEAC4A();
            
            if ( excIEEEAC4AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC4As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC4As ", exc );
        	return null;
        }

        return excIEEEAC4AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC4A excIEEEAC4A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC4AQueryRestController.class.getName());
    
}
