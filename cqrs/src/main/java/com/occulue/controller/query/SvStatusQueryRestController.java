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
 * Implements Spring Controller query CQRS processing for entity SvStatus.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvStatus")
public class SvStatusQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SvStatus using a UUID
     * @param		UUID svStatusId
     * @return		SvStatus
     */    
    @GetMapping("/load")
    public SvStatus load( @RequestParam(required=true) UUID svStatusId ) {
    	SvStatus entity = null;

    	try {  
    		entity = SvStatusBusinessDelegate.getSvStatusInstance().getSvStatus( new SvStatusFetchOneSummary( svStatusId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SvStatus using Id " + svStatusId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SvStatus business objects
     * @return		Set<SvStatus>
     */
    @GetMapping("/")
    public List<SvStatus> loadAll() {                
    	List<SvStatus> svStatusList = null;
        
    	try {
            // load the SvStatus
            svStatusList = SvStatusBusinessDelegate.getSvStatusInstance().getAllSvStatus();
            
            if ( svStatusList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SvStatuss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SvStatuss ", exc );
        	return null;
        }

        return svStatusList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SvStatus svStatus = null;
    private static final Logger LOGGER = Logger.getLogger(SvStatusQueryRestController.class.getName());
    
}
