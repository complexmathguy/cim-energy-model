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
 * Implements Spring Controller query CQRS processing for entity Unresolvedname.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Unresolvedname")
public class UnresolvednameQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Unresolvedname using a UUID
     * @param		UUID unresolvednameId
     * @return		Unresolvedname
     */    
    @GetMapping("/load")
    public Unresolvedname load( @RequestParam(required=true) UUID unresolvednameId ) {
    	Unresolvedname entity = null;

    	try {  
    		entity = UnresolvednameBusinessDelegate.getUnresolvednameInstance().getUnresolvedname( new UnresolvednameFetchOneSummary( unresolvednameId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Unresolvedname using Id " + unresolvednameId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Unresolvedname business objects
     * @return		Set<Unresolvedname>
     */
    @GetMapping("/")
    public List<Unresolvedname> loadAll() {                
    	List<Unresolvedname> unresolvednameList = null;
        
    	try {
            // load the Unresolvedname
            unresolvednameList = UnresolvednameBusinessDelegate.getUnresolvednameInstance().getAllUnresolvedname();
            
            if ( unresolvednameList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Unresolvednames" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Unresolvednames ", exc );
        	return null;
        }

        return unresolvednameList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Unresolvedname unresolvedname = null;
    private static final Logger LOGGER = Logger.getLogger(UnresolvednameQueryRestController.class.getName());
    
}
