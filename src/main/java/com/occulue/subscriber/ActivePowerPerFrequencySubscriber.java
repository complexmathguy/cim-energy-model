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
 * Subscriber for ActivePowerPerFrequency related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("activePowerPerFrequency-subscriber")
public class ActivePowerPerFrequencySubscriber extends BaseSubscriber {

	public ActivePowerPerFrequencySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ActivePowerPerFrequency>, ActivePowerPerFrequency> activePowerPerFrequencySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllActivePowerPerFrequencyQuery(), 
                		ResponseTypes.multipleInstancesOf(ActivePowerPerFrequency.class),
                		ResponseTypes.instanceOf(ActivePowerPerFrequency.class));
    }

    public SubscriptionQueryResult<ActivePowerPerFrequency, ActivePowerPerFrequency> activePowerPerFrequencySubscribe(@DestinationVariable UUID activePowerPerFrequencyId) {
        return queryGateway
                .subscriptionQuery(new FindActivePowerPerFrequencyQuery(new LoadActivePowerPerFrequencyFilter(activePowerPerFrequencyId)), 
                		ResponseTypes.instanceOf(ActivePowerPerFrequency.class),
                		ResponseTypes.instanceOf(ActivePowerPerFrequency.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

