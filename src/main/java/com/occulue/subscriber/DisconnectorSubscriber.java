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
 * Subscriber for Disconnector related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("disconnector-subscriber")
public class DisconnectorSubscriber extends BaseSubscriber {

	public DisconnectorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Disconnector>, Disconnector> disconnectorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDisconnectorQuery(), 
                		ResponseTypes.multipleInstancesOf(Disconnector.class),
                		ResponseTypes.instanceOf(Disconnector.class));
    }

    public SubscriptionQueryResult<Disconnector, Disconnector> disconnectorSubscribe(@DestinationVariable UUID disconnectorId) {
        return queryGateway
                .subscriptionQuery(new FindDisconnectorQuery(new LoadDisconnectorFilter(disconnectorId)), 
                		ResponseTypes.instanceOf(Disconnector.class),
                		ResponseTypes.instanceOf(Disconnector.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

