/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.subscriber;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

/**
 * Subscriber for ThermalGeneratingUnit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("thermalGeneratingUnit-subscriber")
public class ThermalGeneratingUnitSubscriber extends BaseSubscriber {

	public ThermalGeneratingUnitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ThermalGeneratingUnit>, ThermalGeneratingUnit> thermalGeneratingUnitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllThermalGeneratingUnitQuery(), 
                		ResponseTypes.multipleInstancesOf(ThermalGeneratingUnit.class),
                		ResponseTypes.instanceOf(ThermalGeneratingUnit.class));
    }

    public SubscriptionQueryResult<ThermalGeneratingUnit, ThermalGeneratingUnit> thermalGeneratingUnitSubscribe(@DestinationVariable UUID thermalGeneratingUnitId) {
        return queryGateway
                .subscriptionQuery(new FindThermalGeneratingUnitQuery(new LoadThermalGeneratingUnitFilter(thermalGeneratingUnitId)), 
                		ResponseTypes.instanceOf(ThermalGeneratingUnit.class),
                		ResponseTypes.instanceOf(ThermalGeneratingUnit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

