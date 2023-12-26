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
 * Implements Spring Controller query CQRS processing for entity ValueToAlias.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ValueToAlias")
public class ValueToAliasQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ValueToAlias using a UUID
     * @param		UUID valueToAliasId
     * @return		ValueToAlias
     */    
    @GetMapping("/load")
    public ValueToAlias load( @RequestParam(required=true) UUID valueToAliasId ) {
    	ValueToAlias entity = null;

    	try {  
    		entity = ValueToAliasBusinessDelegate.getValueToAliasInstance().getValueToAlias( new ValueToAliasFetchOneSummary( valueToAliasId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ValueToAlias using Id " + valueToAliasId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ValueToAlias business objects
     * @return		Set<ValueToAlias>
     */
    @GetMapping("/")
    public List<ValueToAlias> loadAll() {                
    	List<ValueToAlias> valueToAliasList = null;
        
    	try {
            // load the ValueToAlias
            valueToAliasList = ValueToAliasBusinessDelegate.getValueToAliasInstance().getAllValueToAlias();
            
            if ( valueToAliasList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ValueToAliass" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ValueToAliass ", exc );
        	return null;
        }

        return valueToAliasList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ValueToAlias valueToAlias = null;
    private static final Logger LOGGER = Logger.getLogger(ValueToAliasQueryRestController.class.getName());
    
}
