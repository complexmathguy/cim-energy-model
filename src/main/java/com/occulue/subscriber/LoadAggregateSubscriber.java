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
 * Subscriber for LoadAggregate related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadAggregate-subscriber")
public class LoadAggregateSubscriber extends BaseSubscriber {

	public LoadAggregateSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadAggregate>, LoadAggregate> loadAggregateSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadAggregateQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadAggregate.class),
                		ResponseTypes.instanceOf(LoadAggregate.class));
    }

    public SubscriptionQueryResult<LoadAggregate, LoadAggregate> loadAggregateSubscribe(@DestinationVariable UUID loadAggregateId) {
        return queryGateway
                .subscriptionQuery(new FindLoadAggregateQuery(new LoadLoadAggregateFilter(loadAggregateId)), 
                		ResponseTypes.instanceOf(LoadAggregate.class),
                		ResponseTypes.instanceOf(LoadAggregate.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

