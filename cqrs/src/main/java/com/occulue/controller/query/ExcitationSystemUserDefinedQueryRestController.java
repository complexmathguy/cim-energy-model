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
 * Implements Spring Controller query CQRS processing for entity ExcitationSystemUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcitationSystemUserDefined")
public class ExcitationSystemUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcitationSystemUserDefined using a UUID
     * @param		UUID excitationSystemUserDefinedId
     * @return		ExcitationSystemUserDefined
     */    
    @GetMapping("/load")
    public ExcitationSystemUserDefined load( @RequestParam(required=true) UUID excitationSystemUserDefinedId ) {
    	ExcitationSystemUserDefined entity = null;

    	try {  
    		entity = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().getExcitationSystemUserDefined( new ExcitationSystemUserDefinedFetchOneSummary( excitationSystemUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcitationSystemUserDefined using Id " + excitationSystemUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcitationSystemUserDefined business objects
     * @return		Set<ExcitationSystemUserDefined>
     */
    @GetMapping("/")
    public List<ExcitationSystemUserDefined> loadAll() {                
    	List<ExcitationSystemUserDefined> excitationSystemUserDefinedList = null;
        
    	try {
            // load the ExcitationSystemUserDefined
            excitationSystemUserDefinedList = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().getAllExcitationSystemUserDefined();
            
            if ( excitationSystemUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcitationSystemUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcitationSystemUserDefineds ", exc );
        	return null;
        }

        return excitationSystemUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcitationSystemUserDefined excitationSystemUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(ExcitationSystemUserDefinedQueryRestController.class.getName());
    
}
