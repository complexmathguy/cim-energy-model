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
 * Subscriber for ConnectivityNode related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("connectivityNode-subscriber")
public class ConnectivityNodeSubscriber extends BaseSubscriber {

	public ConnectivityNodeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ConnectivityNode>, ConnectivityNode> connectivityNodeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConnectivityNodeQuery(), 
                		ResponseTypes.multipleInstancesOf(ConnectivityNode.class),
                		ResponseTypes.instanceOf(ConnectivityNode.class));
    }

    public SubscriptionQueryResult<ConnectivityNode, ConnectivityNode> connectivityNodeSubscribe(@DestinationVariable UUID connectivityNodeId) {
        return queryGateway
                .subscriptionQuery(new FindConnectivityNodeQuery(new LoadConnectivityNodeFilter(connectivityNodeId)), 
                		ResponseTypes.instanceOf(ConnectivityNode.class),
                		ResponseTypes.instanceOf(ConnectivityNode.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

