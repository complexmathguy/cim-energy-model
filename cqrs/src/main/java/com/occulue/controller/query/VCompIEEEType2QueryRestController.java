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
 * Implements Spring Controller query CQRS processing for entity VCompIEEEType2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VCompIEEEType2")
public class VCompIEEEType2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VCompIEEEType2 using a UUID
     * @param		UUID vCompIEEEType2Id
     * @return		VCompIEEEType2
     */    
    @GetMapping("/load")
    public VCompIEEEType2 load( @RequestParam(required=true) UUID vCompIEEEType2Id ) {
    	VCompIEEEType2 entity = null;

    	try {  
    		entity = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().getVCompIEEEType2( new VCompIEEEType2FetchOneSummary( vCompIEEEType2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VCompIEEEType2 using Id " + vCompIEEEType2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VCompIEEEType2 business objects
     * @return		Set<VCompIEEEType2>
     */
    @GetMapping("/")
    public List<VCompIEEEType2> loadAll() {                
    	List<VCompIEEEType2> vCompIEEEType2List = null;
        
    	try {
            // load the VCompIEEEType2
            vCompIEEEType2List = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().getAllVCompIEEEType2();
            
            if ( vCompIEEEType2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VCompIEEEType2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VCompIEEEType2s ", exc );
        	return null;
        }

        return vCompIEEEType2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VCompIEEEType2 vCompIEEEType2 = null;
    private static final Logger LOGGER = Logger.getLogger(VCompIEEEType2QueryRestController.class.getName());
    
}
