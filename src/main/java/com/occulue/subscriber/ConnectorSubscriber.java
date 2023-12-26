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
 * Subscriber for Connector related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("connector-subscriber")
public class ConnectorSubscriber extends BaseSubscriber {

	public ConnectorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Connector>, Connector> connectorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConnectorQuery(), 
                		ResponseTypes.multipleInstancesOf(Connector.class),
                		ResponseTypes.instanceOf(Connector.class));
    }

    public SubscriptionQueryResult<Connector, Connector> connectorSubscribe(@DestinationVariable UUID connectorId) {
        return queryGateway
                .subscriptionQuery(new FindConnectorQuery(new LoadConnectorFilter(connectorId)), 
                		ResponseTypes.instanceOf(Connector.class),
                		ResponseTypes.instanceOf(Connector.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

