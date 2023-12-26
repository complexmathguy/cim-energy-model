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
 * Subscriber for SolarGeneratingUnit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("solarGeneratingUnit-subscriber")
public class SolarGeneratingUnitSubscriber extends BaseSubscriber {

	public SolarGeneratingUnitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SolarGeneratingUnit>, SolarGeneratingUnit> solarGeneratingUnitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSolarGeneratingUnitQuery(), 
                		ResponseTypes.multipleInstancesOf(SolarGeneratingUnit.class),
                		ResponseTypes.instanceOf(SolarGeneratingUnit.class));
    }

    public SubscriptionQueryResult<SolarGeneratingUnit, SolarGeneratingUnit> solarGeneratingUnitSubscribe(@DestinationVariable UUID solarGeneratingUnitId) {
        return queryGateway
                .subscriptionQuery(new FindSolarGeneratingUnitQuery(new LoadSolarGeneratingUnitFilter(solarGeneratingUnitId)), 
                		ResponseTypes.instanceOf(SolarGeneratingUnit.class),
                		ResponseTypes.instanceOf(SolarGeneratingUnit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

