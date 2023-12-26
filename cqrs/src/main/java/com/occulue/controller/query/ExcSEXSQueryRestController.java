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
 * Implements Spring Controller query CQRS processing for entity ExcSEXS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSEXS")
public class ExcSEXSQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcSEXS using a UUID
     * @param		UUID excSEXSId
     * @return		ExcSEXS
     */    
    @GetMapping("/load")
    public ExcSEXS load( @RequestParam(required=true) UUID excSEXSId ) {
    	ExcSEXS entity = null;

    	try {  
    		entity = ExcSEXSBusinessDelegate.getExcSEXSInstance().getExcSEXS( new ExcSEXSFetchOneSummary( excSEXSId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcSEXS using Id " + excSEXSId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcSEXS business objects
     * @return		Set<ExcSEXS>
     */
    @GetMapping("/")
    public List<ExcSEXS> loadAll() {                
    	List<ExcSEXS> excSEXSList = null;
        
    	try {
            // load the ExcSEXS
            excSEXSList = ExcSEXSBusinessDelegate.getExcSEXSInstance().getAllExcSEXS();
            
            if ( excSEXSList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcSEXSs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcSEXSs ", exc );
        	return null;
        }

        return excSEXSList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcSEXS excSEXS = null;
    private static final Logger LOGGER = Logger.getLogger(ExcSEXSQueryRestController.class.getName());
    
}
