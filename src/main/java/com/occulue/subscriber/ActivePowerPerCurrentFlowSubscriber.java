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
 * Subscriber for ActivePowerPerCurrentFlow related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("activePowerPerCurrentFlow-subscriber")
public class ActivePowerPerCurrentFlowSubscriber extends BaseSubscriber {

	public ActivePowerPerCurrentFlowSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ActivePowerPerCurrentFlow>, ActivePowerPerCurrentFlow> activePowerPerCurrentFlowSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllActivePowerPerCurrentFlowQuery(), 
                		ResponseTypes.multipleInstancesOf(ActivePowerPerCurrentFlow.class),
                		ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class));
    }

    public SubscriptionQueryResult<ActivePowerPerCurrentFlow, ActivePowerPerCurrentFlow> activePowerPerCurrentFlowSubscribe(@DestinationVariable UUID activePowerPerCurrentFlowId) {
        return queryGateway
                .subscriptionQuery(new FindActivePowerPerCurrentFlowQuery(new LoadActivePowerPerCurrentFlowFilter(activePowerPerCurrentFlowId)), 
                		ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class),
                		ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

