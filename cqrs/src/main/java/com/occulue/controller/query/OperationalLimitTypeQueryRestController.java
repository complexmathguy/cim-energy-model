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
 * Implements Spring Controller query CQRS processing for entity OperationalLimitType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OperationalLimitType")
public class OperationalLimitTypeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a OperationalLimitType using a UUID
     * @param		UUID operationalLimitTypeId
     * @return		OperationalLimitType
     */    
    @GetMapping("/load")
    public OperationalLimitType load( @RequestParam(required=true) UUID operationalLimitTypeId ) {
    	OperationalLimitType entity = null;

    	try {  
    		entity = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().getOperationalLimitType( new OperationalLimitTypeFetchOneSummary( operationalLimitTypeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load OperationalLimitType using Id " + operationalLimitTypeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all OperationalLimitType business objects
     * @return		Set<OperationalLimitType>
     */
    @GetMapping("/")
    public List<OperationalLimitType> loadAll() {                
    	List<OperationalLimitType> operationalLimitTypeList = null;
        
    	try {
            // load the OperationalLimitType
            operationalLimitTypeList = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().getAllOperationalLimitType();
            
            if ( operationalLimitTypeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all OperationalLimitTypes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all OperationalLimitTypes ", exc );
        	return null;
        }

        return operationalLimitTypeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected OperationalLimitType operationalLimitType = null;
    private static final Logger LOGGER = Logger.getLogger(OperationalLimitTypeQueryRestController.class.getName());
    
}
