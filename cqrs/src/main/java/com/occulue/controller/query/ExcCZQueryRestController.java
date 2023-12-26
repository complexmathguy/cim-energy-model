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
 * Implements Spring Controller query CQRS processing for entity ExcCZ.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcCZ")
public class ExcCZQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcCZ using a UUID
     * @param		UUID excCZId
     * @return		ExcCZ
     */    
    @GetMapping("/load")
    public ExcCZ load( @RequestParam(required=true) UUID excCZId ) {
    	ExcCZ entity = null;

    	try {  
    		entity = ExcCZBusinessDelegate.getExcCZInstance().getExcCZ( new ExcCZFetchOneSummary( excCZId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcCZ using Id " + excCZId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcCZ business objects
     * @return		Set<ExcCZ>
     */
    @GetMapping("/")
    public List<ExcCZ> loadAll() {                
    	List<ExcCZ> excCZList = null;
        
    	try {
            // load the ExcCZ
            excCZList = ExcCZBusinessDelegate.getExcCZInstance().getAllExcCZ();
            
            if ( excCZList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcCZs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcCZs ", exc );
        	return null;
        }

        return excCZList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcCZ excCZ = null;
    private static final Logger LOGGER = Logger.getLogger(ExcCZQueryRestController.class.getName());
    
}
