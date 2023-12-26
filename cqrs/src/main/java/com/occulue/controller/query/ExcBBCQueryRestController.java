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
 * Implements Spring Controller query CQRS processing for entity ExcBBC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcBBC")
public class ExcBBCQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcBBC using a UUID
     * @param		UUID excBBCId
     * @return		ExcBBC
     */    
    @GetMapping("/load")
    public ExcBBC load( @RequestParam(required=true) UUID excBBCId ) {
    	ExcBBC entity = null;

    	try {  
    		entity = ExcBBCBusinessDelegate.getExcBBCInstance().getExcBBC( new ExcBBCFetchOneSummary( excBBCId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcBBC using Id " + excBBCId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcBBC business objects
     * @return		Set<ExcBBC>
     */
    @GetMapping("/")
    public List<ExcBBC> loadAll() {                
    	List<ExcBBC> excBBCList = null;
        
    	try {
            // load the ExcBBC
            excBBCList = ExcBBCBusinessDelegate.getExcBBCInstance().getAllExcBBC();
            
            if ( excBBCList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcBBCs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcBBCs ", exc );
        	return null;
        }

        return excBBCList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcBBC excBBC = null;
    private static final Logger LOGGER = Logger.getLogger(ExcBBCQueryRestController.class.getName());
    
}
