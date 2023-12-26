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
 * Implements Spring Controller query CQRS processing for entity ExcREXS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcREXS")
public class ExcREXSQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcREXS using a UUID
     * @param		UUID excREXSId
     * @return		ExcREXS
     */    
    @GetMapping("/load")
    public ExcREXS load( @RequestParam(required=true) UUID excREXSId ) {
    	ExcREXS entity = null;

    	try {  
    		entity = ExcREXSBusinessDelegate.getExcREXSInstance().getExcREXS( new ExcREXSFetchOneSummary( excREXSId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcREXS using Id " + excREXSId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcREXS business objects
     * @return		Set<ExcREXS>
     */
    @GetMapping("/")
    public List<ExcREXS> loadAll() {                
    	List<ExcREXS> excREXSList = null;
        
    	try {
            // load the ExcREXS
            excREXSList = ExcREXSBusinessDelegate.getExcREXSInstance().getAllExcREXS();
            
            if ( excREXSList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcREXSs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcREXSs ", exc );
        	return null;
        }

        return excREXSList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcREXS excREXS = null;
    private static final Logger LOGGER = Logger.getLogger(ExcREXSQueryRestController.class.getName());
    
}
