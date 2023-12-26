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
 * Subscriber for AsynchronousMachineEquivalentCircuit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineEquivalentCircuit-subscriber")
public class AsynchronousMachineEquivalentCircuitSubscriber extends BaseSubscriber {

	public AsynchronousMachineEquivalentCircuitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AsynchronousMachineEquivalentCircuit>, AsynchronousMachineEquivalentCircuit> asynchronousMachineEquivalentCircuitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAsynchronousMachineEquivalentCircuitQuery(), 
                		ResponseTypes.multipleInstancesOf(AsynchronousMachineEquivalentCircuit.class),
                		ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class));
    }

    public SubscriptionQueryResult<AsynchronousMachineEquivalentCircuit, AsynchronousMachineEquivalentCircuit> asynchronousMachineEquivalentCircuitSubscribe(@DestinationVariable UUID asynchronousMachineEquivalentCircuitId) {
        return queryGateway
                .subscriptionQuery(new FindAsynchronousMachineEquivalentCircuitQuery(new LoadAsynchronousMachineEquivalentCircuitFilter(asynchronousMachineEquivalentCircuitId)), 
                		ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class),
                		ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

