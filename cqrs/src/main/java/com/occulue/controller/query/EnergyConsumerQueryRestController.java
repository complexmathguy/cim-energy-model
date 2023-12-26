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
 * Implements Spring Controller query CQRS processing for entity EnergyConsumer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergyConsumer")
public class EnergyConsumerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EnergyConsumer using a UUID
     * @param		UUID energyConsumerId
     * @return		EnergyConsumer
     */    
    @GetMapping("/load")
    public EnergyConsumer load( @RequestParam(required=true) UUID energyConsumerId ) {
    	EnergyConsumer entity = null;

    	try {  
    		entity = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().getEnergyConsumer( new EnergyConsumerFetchOneSummary( energyConsumerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EnergyConsumer using Id " + energyConsumerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EnergyConsumer business objects
     * @return		Set<EnergyConsumer>
     */
    @GetMapping("/")
    public List<EnergyConsumer> loadAll() {                
    	List<EnergyConsumer> energyConsumerList = null;
        
    	try {
            // load the EnergyConsumer
            energyConsumerList = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().getAllEnergyConsumer();
            
            if ( energyConsumerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EnergyConsumers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EnergyConsumers ", exc );
        	return null;
        }

        return energyConsumerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EnergyConsumer energyConsumer = null;
    private static final Logger LOGGER = Logger.getLogger(EnergyConsumerQueryRestController.class.getName());
    
}
