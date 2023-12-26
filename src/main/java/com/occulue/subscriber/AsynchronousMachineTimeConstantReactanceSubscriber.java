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
 * Subscriber for AsynchronousMachineTimeConstantReactance related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineTimeConstantReactance-subscriber")
public class AsynchronousMachineTimeConstantReactanceSubscriber extends BaseSubscriber {

	public AsynchronousMachineTimeConstantReactanceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AsynchronousMachineTimeConstantReactance>, AsynchronousMachineTimeConstantReactance> asynchronousMachineTimeConstantReactanceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAsynchronousMachineTimeConstantReactanceQuery(), 
                		ResponseTypes.multipleInstancesOf(AsynchronousMachineTimeConstantReactance.class),
                		ResponseTypes.instanceOf(AsynchronousMachineTimeConstantReactance.class));
    }

    public SubscriptionQueryResult<AsynchronousMachineTimeConstantReactance, AsynchronousMachineTimeConstantReactance> asynchronousMachineTimeConstantReactanceSubscribe(@DestinationVariable UUID asynchronousMachineTimeConstantReactanceId) {
        return queryGateway
                .subscriptionQuery(new FindAsynchronousMachineTimeConstantReactanceQuery(new LoadAsynchronousMachineTimeConstantReactanceFilter(asynchronousMachineTimeConstantReactanceId)), 
                		ResponseTypes.instanceOf(AsynchronousMachineTimeConstantReactance.class),
                		ResponseTypes.instanceOf(AsynchronousMachineTimeConstantReactance.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

