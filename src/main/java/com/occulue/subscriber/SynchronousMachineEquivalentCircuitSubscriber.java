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
 * Subscriber for SynchronousMachineEquivalentCircuit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineEquivalentCircuit-subscriber")
public class SynchronousMachineEquivalentCircuitSubscriber extends BaseSubscriber {

	public SynchronousMachineEquivalentCircuitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SynchronousMachineEquivalentCircuit>, SynchronousMachineEquivalentCircuit> synchronousMachineEquivalentCircuitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSynchronousMachineEquivalentCircuitQuery(), 
                		ResponseTypes.multipleInstancesOf(SynchronousMachineEquivalentCircuit.class),
                		ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class));
    }

    public SubscriptionQueryResult<SynchronousMachineEquivalentCircuit, SynchronousMachineEquivalentCircuit> synchronousMachineEquivalentCircuitSubscribe(@DestinationVariable UUID synchronousMachineEquivalentCircuitId) {
        return queryGateway
                .subscriptionQuery(new FindSynchronousMachineEquivalentCircuitQuery(new LoadSynchronousMachineEquivalentCircuitFilter(synchronousMachineEquivalentCircuitId)), 
                		ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class),
                		ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

