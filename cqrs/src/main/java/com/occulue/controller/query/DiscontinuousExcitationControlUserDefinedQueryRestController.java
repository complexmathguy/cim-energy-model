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
 * Implements Spring Controller query CQRS processing for entity DiscontinuousExcitationControlUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscontinuousExcitationControlUserDefined")
public class DiscontinuousExcitationControlUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiscontinuousExcitationControlUserDefined using a UUID
     * @param		UUID discontinuousExcitationControlUserDefinedId
     * @return		DiscontinuousExcitationControlUserDefined
     */    
    @GetMapping("/load")
    public DiscontinuousExcitationControlUserDefined load( @RequestParam(required=true) UUID discontinuousExcitationControlUserDefinedId ) {
    	DiscontinuousExcitationControlUserDefined entity = null;

    	try {  
    		entity = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().getDiscontinuousExcitationControlUserDefined( new DiscontinuousExcitationControlUserDefinedFetchOneSummary( discontinuousExcitationControlUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiscontinuousExcitationControlUserDefined using Id " + discontinuousExcitationControlUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiscontinuousExcitationControlUserDefined business objects
     * @return		Set<DiscontinuousExcitationControlUserDefined>
     */
    @GetMapping("/")
    public List<DiscontinuousExcitationControlUserDefined> loadAll() {                
    	List<DiscontinuousExcitationControlUserDefined> discontinuousExcitationControlUserDefinedList = null;
        
    	try {
            // load the DiscontinuousExcitationControlUserDefined
            discontinuousExcitationControlUserDefinedList = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().getAllDiscontinuousExcitationControlUserDefined();
            
            if ( discontinuousExcitationControlUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiscontinuousExcitationControlUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiscontinuousExcitationControlUserDefineds ", exc );
        	return null;
        }

        return discontinuousExcitationControlUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscontinuousExcitationControlUserDefined discontinuousExcitationControlUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(DiscontinuousExcitationControlUserDefinedQueryRestController.class.getName());
    
}
