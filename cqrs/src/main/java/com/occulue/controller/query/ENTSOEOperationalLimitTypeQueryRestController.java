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
 * Implements Spring Controller query CQRS processing for entity ENTSOEOperationalLimitType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEOperationalLimitType")
public class ENTSOEOperationalLimitTypeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ENTSOEOperationalLimitType using a UUID
     * @param		UUID eNTSOEOperationalLimitTypeId
     * @return		ENTSOEOperationalLimitType
     */    
    @GetMapping("/load")
    public ENTSOEOperationalLimitType load( @RequestParam(required=true) UUID eNTSOEOperationalLimitTypeId ) {
    	ENTSOEOperationalLimitType entity = null;

    	try {  
    		entity = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().getENTSOEOperationalLimitType( new ENTSOEOperationalLimitTypeFetchOneSummary( eNTSOEOperationalLimitTypeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ENTSOEOperationalLimitType using Id " + eNTSOEOperationalLimitTypeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ENTSOEOperationalLimitType business objects
     * @return		Set<ENTSOEOperationalLimitType>
     */
    @GetMapping("/")
    public List<ENTSOEOperationalLimitType> loadAll() {                
    	List<ENTSOEOperationalLimitType> eNTSOEOperationalLimitTypeList = null;
        
    	try {
            // load the ENTSOEOperationalLimitType
            eNTSOEOperationalLimitTypeList = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().getAllENTSOEOperationalLimitType();
            
            if ( eNTSOEOperationalLimitTypeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ENTSOEOperationalLimitTypes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ENTSOEOperationalLimitTypes ", exc );
        	return null;
        }

        return eNTSOEOperationalLimitTypeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEOperationalLimitType eNTSOEOperationalLimitType = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEOperationalLimitTypeQueryRestController.class.getName());
    
}
