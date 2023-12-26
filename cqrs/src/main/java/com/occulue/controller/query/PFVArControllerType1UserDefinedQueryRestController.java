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
 * Implements Spring Controller query CQRS processing for entity PFVArControllerType1UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType1UserDefined")
public class PFVArControllerType1UserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArControllerType1UserDefined using a UUID
     * @param		UUID pFVArControllerType1UserDefinedId
     * @return		PFVArControllerType1UserDefined
     */    
    @GetMapping("/load")
    public PFVArControllerType1UserDefined load( @RequestParam(required=true) UUID pFVArControllerType1UserDefinedId ) {
    	PFVArControllerType1UserDefined entity = null;

    	try {  
    		entity = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().getPFVArControllerType1UserDefined( new PFVArControllerType1UserDefinedFetchOneSummary( pFVArControllerType1UserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArControllerType1UserDefined using Id " + pFVArControllerType1UserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArControllerType1UserDefined business objects
     * @return		Set<PFVArControllerType1UserDefined>
     */
    @GetMapping("/")
    public List<PFVArControllerType1UserDefined> loadAll() {                
    	List<PFVArControllerType1UserDefined> pFVArControllerType1UserDefinedList = null;
        
    	try {
            // load the PFVArControllerType1UserDefined
            pFVArControllerType1UserDefinedList = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().getAllPFVArControllerType1UserDefined();
            
            if ( pFVArControllerType1UserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArControllerType1UserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArControllerType1UserDefineds ", exc );
        	return null;
        }

        return pFVArControllerType1UserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType1UserDefined pFVArControllerType1UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType1UserDefinedQueryRestController.class.getName());
    
}
