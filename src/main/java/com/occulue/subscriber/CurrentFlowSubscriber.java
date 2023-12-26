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
 * Subscriber for CurrentFlow related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("currentFlow-subscriber")
public class CurrentFlowSubscriber extends BaseSubscriber {

	public CurrentFlowSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<CurrentFlow>, CurrentFlow> currentFlowSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllCurrentFlowQuery(), 
                		ResponseTypes.multipleInstancesOf(CurrentFlow.class),
                		ResponseTypes.instanceOf(CurrentFlow.class));
    }

    public SubscriptionQueryResult<CurrentFlow, CurrentFlow> currentFlowSubscribe(@DestinationVariable UUID currentFlowId) {
        return queryGateway
                .subscriptionQuery(new FindCurrentFlowQuery(new LoadCurrentFlowFilter(currentFlowId)), 
                		ResponseTypes.instanceOf(CurrentFlow.class),
                		ResponseTypes.instanceOf(CurrentFlow.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

