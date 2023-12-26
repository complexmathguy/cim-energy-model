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
 * Subscriber for TopologicalIsland related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("topologicalIsland-subscriber")
public class TopologicalIslandSubscriber extends BaseSubscriber {

	public TopologicalIslandSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TopologicalIsland>, TopologicalIsland> topologicalIslandSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTopologicalIslandQuery(), 
                		ResponseTypes.multipleInstancesOf(TopologicalIsland.class),
                		ResponseTypes.instanceOf(TopologicalIsland.class));
    }

    public SubscriptionQueryResult<TopologicalIsland, TopologicalIsland> topologicalIslandSubscribe(@DestinationVariable UUID topologicalIslandId) {
        return queryGateway
                .subscriptionQuery(new FindTopologicalIslandQuery(new LoadTopologicalIslandFilter(topologicalIslandId)), 
                		ResponseTypes.instanceOf(TopologicalIsland.class),
                		ResponseTypes.instanceOf(TopologicalIsland.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

