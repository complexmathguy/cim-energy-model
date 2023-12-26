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
 * Implements Spring Controller query CQRS processing for entity ValueAliasSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ValueAliasSet")
public class ValueAliasSetQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ValueAliasSet using a UUID
     * @param		UUID valueAliasSetId
     * @return		ValueAliasSet
     */    
    @GetMapping("/load")
    public ValueAliasSet load( @RequestParam(required=true) UUID valueAliasSetId ) {
    	ValueAliasSet entity = null;

    	try {  
    		entity = ValueAliasSetBusinessDelegate.getValueAliasSetInstance().getValueAliasSet( new ValueAliasSetFetchOneSummary( valueAliasSetId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ValueAliasSet using Id " + valueAliasSetId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ValueAliasSet business objects
     * @return		Set<ValueAliasSet>
     */
    @GetMapping("/")
    public List<ValueAliasSet> loadAll() {                
    	List<ValueAliasSet> valueAliasSetList = null;
        
    	try {
            // load the ValueAliasSet
            valueAliasSetList = ValueAliasSetBusinessDelegate.getValueAliasSetInstance().getAllValueAliasSet();
            
            if ( valueAliasSetList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ValueAliasSets" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ValueAliasSets ", exc );
        	return null;
        }

        return valueAliasSetList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ValueAliasSet valueAliasSet = null;
    private static final Logger LOGGER = Logger.getLogger(ValueAliasSetQueryRestController.class.getName());
    
}
