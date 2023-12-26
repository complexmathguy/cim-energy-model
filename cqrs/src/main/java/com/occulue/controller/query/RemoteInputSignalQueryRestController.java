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
 * Implements Spring Controller query CQRS processing for entity RemoteInputSignal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RemoteInputSignal")
public class RemoteInputSignalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RemoteInputSignal using a UUID
     * @param		UUID remoteInputSignalId
     * @return		RemoteInputSignal
     */    
    @GetMapping("/load")
    public RemoteInputSignal load( @RequestParam(required=true) UUID remoteInputSignalId ) {
    	RemoteInputSignal entity = null;

    	try {  
    		entity = RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance().getRemoteInputSignal( new RemoteInputSignalFetchOneSummary( remoteInputSignalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RemoteInputSignal using Id " + remoteInputSignalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RemoteInputSignal business objects
     * @return		Set<RemoteInputSignal>
     */
    @GetMapping("/")
    public List<RemoteInputSignal> loadAll() {                
    	List<RemoteInputSignal> remoteInputSignalList = null;
        
    	try {
            // load the RemoteInputSignal
            remoteInputSignalList = RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance().getAllRemoteInputSignal();
            
            if ( remoteInputSignalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RemoteInputSignals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RemoteInputSignals ", exc );
        	return null;
        }

        return remoteInputSignalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RemoteInputSignal remoteInputSignal = null;
    private static final Logger LOGGER = Logger.getLogger(RemoteInputSignalQueryRestController.class.getName());
    
}
