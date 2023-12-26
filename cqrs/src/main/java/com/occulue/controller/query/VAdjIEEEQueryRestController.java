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
 * Implements Spring Controller query CQRS processing for entity VAdjIEEE.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VAdjIEEE")
public class VAdjIEEEQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VAdjIEEE using a UUID
     * @param		UUID vAdjIEEEId
     * @return		VAdjIEEE
     */    
    @GetMapping("/load")
    public VAdjIEEE load( @RequestParam(required=true) UUID vAdjIEEEId ) {
    	VAdjIEEE entity = null;

    	try {  
    		entity = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().getVAdjIEEE( new VAdjIEEEFetchOneSummary( vAdjIEEEId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VAdjIEEE using Id " + vAdjIEEEId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VAdjIEEE business objects
     * @return		Set<VAdjIEEE>
     */
    @GetMapping("/")
    public List<VAdjIEEE> loadAll() {                
    	List<VAdjIEEE> vAdjIEEEList = null;
        
    	try {
            // load the VAdjIEEE
            vAdjIEEEList = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().getAllVAdjIEEE();
            
            if ( vAdjIEEEList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VAdjIEEEs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VAdjIEEEs ", exc );
        	return null;
        }

        return vAdjIEEEList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VAdjIEEE vAdjIEEE = null;
    private static final Logger LOGGER = Logger.getLogger(VAdjIEEEQueryRestController.class.getName());
    
}
