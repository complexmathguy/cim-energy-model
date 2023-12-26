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
 * Subscriber for EquivalentNetwork related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("equivalentNetwork-subscriber")
public class EquivalentNetworkSubscriber extends BaseSubscriber {

	public EquivalentNetworkSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EquivalentNetwork>, EquivalentNetwork> equivalentNetworkSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEquivalentNetworkQuery(), 
                		ResponseTypes.multipleInstancesOf(EquivalentNetwork.class),
                		ResponseTypes.instanceOf(EquivalentNetwork.class));
    }

    public SubscriptionQueryResult<EquivalentNetwork, EquivalentNetwork> equivalentNetworkSubscribe(@DestinationVariable UUID equivalentNetworkId) {
        return queryGateway
                .subscriptionQuery(new FindEquivalentNetworkQuery(new LoadEquivalentNetworkFilter(equivalentNetworkId)), 
                		ResponseTypes.instanceOf(EquivalentNetwork.class),
                		ResponseTypes.instanceOf(EquivalentNetwork.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

