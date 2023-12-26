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
 * Subscriber for HydroPowerPlant related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("hydroPowerPlant-subscriber")
public class HydroPowerPlantSubscriber extends BaseSubscriber {

	public HydroPowerPlantSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<HydroPowerPlant>, HydroPowerPlant> hydroPowerPlantSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllHydroPowerPlantQuery(), 
                		ResponseTypes.multipleInstancesOf(HydroPowerPlant.class),
                		ResponseTypes.instanceOf(HydroPowerPlant.class));
    }

    public SubscriptionQueryResult<HydroPowerPlant, HydroPowerPlant> hydroPowerPlantSubscribe(@DestinationVariable UUID hydroPowerPlantId) {
        return queryGateway
                .subscriptionQuery(new FindHydroPowerPlantQuery(new LoadHydroPowerPlantFilter(hydroPowerPlantId)), 
                		ResponseTypes.instanceOf(HydroPowerPlant.class),
                		ResponseTypes.instanceOf(HydroPowerPlant.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

