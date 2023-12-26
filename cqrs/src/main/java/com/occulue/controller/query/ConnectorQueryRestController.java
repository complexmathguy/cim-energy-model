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
 * Implements Spring Controller query CQRS processing for entity Connector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Connector")
public class ConnectorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Connector using a UUID
     * @param		UUID connectorId
     * @return		Connector
     */    
    @GetMapping("/load")
    public Connector load( @RequestParam(required=true) UUID connectorId ) {
    	Connector entity = null;

    	try {  
    		entity = ConnectorBusinessDelegate.getConnectorInstance().getConnector( new ConnectorFetchOneSummary( connectorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Connector using Id " + connectorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Connector business objects
     * @return		Set<Connector>
     */
    @GetMapping("/")
    public List<Connector> loadAll() {                
    	List<Connector> connectorList = null;
        
    	try {
            // load the Connector
            connectorList = ConnectorBusinessDelegate.getConnectorInstance().getAllConnector();
            
            if ( connectorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Connectors" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Connectors ", exc );
        	return null;
        }

        return connectorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Connector connector = null;
    private static final Logger LOGGER = Logger.getLogger(ConnectorQueryRestController.class.getName());
    
}
