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
 * Implements Spring Controller query CQRS processing for entity ConformLoadGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoadGroup")
public class ConformLoadGroupQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ConformLoadGroup using a UUID
     * @param		UUID conformLoadGroupId
     * @return		ConformLoadGroup
     */    
    @GetMapping("/load")
    public ConformLoadGroup load( @RequestParam(required=true) UUID conformLoadGroupId ) {
    	ConformLoadGroup entity = null;

    	try {  
    		entity = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().getConformLoadGroup( new ConformLoadGroupFetchOneSummary( conformLoadGroupId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ConformLoadGroup using Id " + conformLoadGroupId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ConformLoadGroup business objects
     * @return		Set<ConformLoadGroup>
     */
    @GetMapping("/")
    public List<ConformLoadGroup> loadAll() {                
    	List<ConformLoadGroup> conformLoadGroupList = null;
        
    	try {
            // load the ConformLoadGroup
            conformLoadGroupList = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().getAllConformLoadGroup();
            
            if ( conformLoadGroupList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ConformLoadGroups" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ConformLoadGroups ", exc );
        	return null;
        }

        return conformLoadGroupList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ConformLoadGroup conformLoadGroup = null;
    private static final Logger LOGGER = Logger.getLogger(ConformLoadGroupQueryRestController.class.getName());
    
}
