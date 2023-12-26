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
 * Implements Spring Controller query CQRS processing for entity NonConformLoadGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonConformLoadGroup")
public class NonConformLoadGroupQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a NonConformLoadGroup using a UUID
     * @param		UUID nonConformLoadGroupId
     * @return		NonConformLoadGroup
     */    
    @GetMapping("/load")
    public NonConformLoadGroup load( @RequestParam(required=true) UUID nonConformLoadGroupId ) {
    	NonConformLoadGroup entity = null;

    	try {  
    		entity = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().getNonConformLoadGroup( new NonConformLoadGroupFetchOneSummary( nonConformLoadGroupId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load NonConformLoadGroup using Id " + nonConformLoadGroupId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all NonConformLoadGroup business objects
     * @return		Set<NonConformLoadGroup>
     */
    @GetMapping("/")
    public List<NonConformLoadGroup> loadAll() {                
    	List<NonConformLoadGroup> nonConformLoadGroupList = null;
        
    	try {
            // load the NonConformLoadGroup
            nonConformLoadGroupList = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().getAllNonConformLoadGroup();
            
            if ( nonConformLoadGroupList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all NonConformLoadGroups" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all NonConformLoadGroups ", exc );
        	return null;
        }

        return nonConformLoadGroupList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected NonConformLoadGroup nonConformLoadGroup = null;
    private static final Logger LOGGER = Logger.getLogger(NonConformLoadGroupQueryRestController.class.getName());
    
}
