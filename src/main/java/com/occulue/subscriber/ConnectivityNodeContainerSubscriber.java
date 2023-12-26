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
 * Subscriber for ConnectivityNodeContainer related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("connectivityNodeContainer-subscriber")
public class ConnectivityNodeContainerSubscriber extends BaseSubscriber {

	public ConnectivityNodeContainerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ConnectivityNodeContainer>, ConnectivityNodeContainer> connectivityNodeContainerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConnectivityNodeContainerQuery(), 
                		ResponseTypes.multipleInstancesOf(ConnectivityNodeContainer.class),
                		ResponseTypes.instanceOf(ConnectivityNodeContainer.class));
    }

    public SubscriptionQueryResult<ConnectivityNodeContainer, ConnectivityNodeContainer> connectivityNodeContainerSubscribe(@DestinationVariable UUID connectivityNodeContainerId) {
        return queryGateway
                .subscriptionQuery(new FindConnectivityNodeContainerQuery(new LoadConnectivityNodeContainerFilter(connectivityNodeContainerId)), 
                		ResponseTypes.instanceOf(ConnectivityNodeContainer.class),
                		ResponseTypes.instanceOf(ConnectivityNodeContainer.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

