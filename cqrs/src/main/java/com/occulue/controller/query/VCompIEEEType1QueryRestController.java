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
 * Implements Spring Controller query CQRS processing for entity VCompIEEEType1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VCompIEEEType1")
public class VCompIEEEType1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VCompIEEEType1 using a UUID
     * @param		UUID vCompIEEEType1Id
     * @return		VCompIEEEType1
     */    
    @GetMapping("/load")
    public VCompIEEEType1 load( @RequestParam(required=true) UUID vCompIEEEType1Id ) {
    	VCompIEEEType1 entity = null;

    	try {  
    		entity = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().getVCompIEEEType1( new VCompIEEEType1FetchOneSummary( vCompIEEEType1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VCompIEEEType1 using Id " + vCompIEEEType1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VCompIEEEType1 business objects
     * @return		Set<VCompIEEEType1>
     */
    @GetMapping("/")
    public List<VCompIEEEType1> loadAll() {                
    	List<VCompIEEEType1> vCompIEEEType1List = null;
        
    	try {
            // load the VCompIEEEType1
            vCompIEEEType1List = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().getAllVCompIEEEType1();
            
            if ( vCompIEEEType1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VCompIEEEType1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VCompIEEEType1s ", exc );
        	return null;
        }

        return vCompIEEEType1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VCompIEEEType1 vCompIEEEType1 = null;
    private static final Logger LOGGER = Logger.getLogger(VCompIEEEType1QueryRestController.class.getName());
    
}
