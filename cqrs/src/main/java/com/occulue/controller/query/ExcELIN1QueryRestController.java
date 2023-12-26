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
 * Implements Spring Controller query CQRS processing for entity ExcELIN1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcELIN1")
public class ExcELIN1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcELIN1 using a UUID
     * @param		UUID excELIN1Id
     * @return		ExcELIN1
     */    
    @GetMapping("/load")
    public ExcELIN1 load( @RequestParam(required=true) UUID excELIN1Id ) {
    	ExcELIN1 entity = null;

    	try {  
    		entity = ExcELIN1BusinessDelegate.getExcELIN1Instance().getExcELIN1( new ExcELIN1FetchOneSummary( excELIN1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcELIN1 using Id " + excELIN1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcELIN1 business objects
     * @return		Set<ExcELIN1>
     */
    @GetMapping("/")
    public List<ExcELIN1> loadAll() {                
    	List<ExcELIN1> excELIN1List = null;
        
    	try {
            // load the ExcELIN1
            excELIN1List = ExcELIN1BusinessDelegate.getExcELIN1Instance().getAllExcELIN1();
            
            if ( excELIN1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcELIN1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcELIN1s ", exc );
        	return null;
        }

        return excELIN1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcELIN1 excELIN1 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcELIN1QueryRestController.class.getName());
    
}
