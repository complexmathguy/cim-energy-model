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
 * Subscriber for TopologicalNode related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("topologicalNode-subscriber")
public class TopologicalNodeSubscriber extends BaseSubscriber {

	public TopologicalNodeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TopologicalNode>, TopologicalNode> topologicalNodeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTopologicalNodeQuery(), 
                		ResponseTypes.multipleInstancesOf(TopologicalNode.class),
                		ResponseTypes.instanceOf(TopologicalNode.class));
    }

    public SubscriptionQueryResult<TopologicalNode, TopologicalNode> topologicalNodeSubscribe(@DestinationVariable UUID topologicalNodeId) {
        return queryGateway
                .subscriptionQuery(new FindTopologicalNodeQuery(new LoadTopologicalNodeFilter(topologicalNodeId)), 
                		ResponseTypes.instanceOf(TopologicalNode.class),
                		ResponseTypes.instanceOf(TopologicalNode.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

