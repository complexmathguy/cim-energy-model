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
 * Subscriber for AsynchronousMachineDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineDynamics-subscriber")
public class AsynchronousMachineDynamicsSubscriber extends BaseSubscriber {

	public AsynchronousMachineDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AsynchronousMachineDynamics>, AsynchronousMachineDynamics> asynchronousMachineDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAsynchronousMachineDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(AsynchronousMachineDynamics.class),
                		ResponseTypes.instanceOf(AsynchronousMachineDynamics.class));
    }

    public SubscriptionQueryResult<AsynchronousMachineDynamics, AsynchronousMachineDynamics> asynchronousMachineDynamicsSubscribe(@DestinationVariable UUID asynchronousMachineDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindAsynchronousMachineDynamicsQuery(new LoadAsynchronousMachineDynamicsFilter(asynchronousMachineDynamicsId)), 
                		ResponseTypes.instanceOf(AsynchronousMachineDynamics.class),
                		ResponseTypes.instanceOf(AsynchronousMachineDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

