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
 * Implements Spring Controller query CQRS processing for entity ExcELIN2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcELIN2")
public class ExcELIN2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcELIN2 using a UUID
     * @param		UUID excELIN2Id
     * @return		ExcELIN2
     */    
    @GetMapping("/load")
    public ExcELIN2 load( @RequestParam(required=true) UUID excELIN2Id ) {
    	ExcELIN2 entity = null;

    	try {  
    		entity = ExcELIN2BusinessDelegate.getExcELIN2Instance().getExcELIN2( new ExcELIN2FetchOneSummary( excELIN2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcELIN2 using Id " + excELIN2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcELIN2 business objects
     * @return		Set<ExcELIN2>
     */
    @GetMapping("/")
    public List<ExcELIN2> loadAll() {                
    	List<ExcELIN2> excELIN2List = null;
        
    	try {
            // load the ExcELIN2
            excELIN2List = ExcELIN2BusinessDelegate.getExcELIN2Instance().getAllExcELIN2();
            
            if ( excELIN2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcELIN2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcELIN2s ", exc );
        	return null;
        }

        return excELIN2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcELIN2 excELIN2 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcELIN2QueryRestController.class.getName());
    
}
