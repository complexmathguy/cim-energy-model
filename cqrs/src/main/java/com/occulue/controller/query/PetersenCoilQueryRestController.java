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
 * Implements Spring Controller query CQRS processing for entity PetersenCoil.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PetersenCoil")
public class PetersenCoilQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PetersenCoil using a UUID
     * @param		UUID petersenCoilId
     * @return		PetersenCoil
     */    
    @GetMapping("/load")
    public PetersenCoil load( @RequestParam(required=true) UUID petersenCoilId ) {
    	PetersenCoil entity = null;

    	try {  
    		entity = PetersenCoilBusinessDelegate.getPetersenCoilInstance().getPetersenCoil( new PetersenCoilFetchOneSummary( petersenCoilId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PetersenCoil using Id " + petersenCoilId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PetersenCoil business objects
     * @return		Set<PetersenCoil>
     */
    @GetMapping("/")
    public List<PetersenCoil> loadAll() {                
    	List<PetersenCoil> petersenCoilList = null;
        
    	try {
            // load the PetersenCoil
            petersenCoilList = PetersenCoilBusinessDelegate.getPetersenCoilInstance().getAllPetersenCoil();
            
            if ( petersenCoilList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PetersenCoils" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PetersenCoils ", exc );
        	return null;
        }

        return petersenCoilList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PetersenCoil petersenCoil = null;
    private static final Logger LOGGER = Logger.getLogger(PetersenCoilQueryRestController.class.getName());
    
}
