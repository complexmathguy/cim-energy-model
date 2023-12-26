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
 * Implements Spring Controller query CQRS processing for entity PFVArControllerType2UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType2UserDefined")
public class PFVArControllerType2UserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArControllerType2UserDefined using a UUID
     * @param		UUID pFVArControllerType2UserDefinedId
     * @return		PFVArControllerType2UserDefined
     */    
    @GetMapping("/load")
    public PFVArControllerType2UserDefined load( @RequestParam(required=true) UUID pFVArControllerType2UserDefinedId ) {
    	PFVArControllerType2UserDefined entity = null;

    	try {  
    		entity = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().getPFVArControllerType2UserDefined( new PFVArControllerType2UserDefinedFetchOneSummary( pFVArControllerType2UserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArControllerType2UserDefined using Id " + pFVArControllerType2UserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArControllerType2UserDefined business objects
     * @return		Set<PFVArControllerType2UserDefined>
     */
    @GetMapping("/")
    public List<PFVArControllerType2UserDefined> loadAll() {                
    	List<PFVArControllerType2UserDefined> pFVArControllerType2UserDefinedList = null;
        
    	try {
            // load the PFVArControllerType2UserDefined
            pFVArControllerType2UserDefinedList = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().getAllPFVArControllerType2UserDefined();
            
            if ( pFVArControllerType2UserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArControllerType2UserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArControllerType2UserDefineds ", exc );
        	return null;
        }

        return pFVArControllerType2UserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType2UserDefined pFVArControllerType2UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType2UserDefinedQueryRestController.class.getName());
    
}
