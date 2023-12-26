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
 * Subscriber for SynchronousMachineTimeConstantReactance related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineTimeConstantReactance-subscriber")
public class SynchronousMachineTimeConstantReactanceSubscriber extends BaseSubscriber {

	public SynchronousMachineTimeConstantReactanceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SynchronousMachineTimeConstantReactance>, SynchronousMachineTimeConstantReactance> synchronousMachineTimeConstantReactanceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSynchronousMachineTimeConstantReactanceQuery(), 
                		ResponseTypes.multipleInstancesOf(SynchronousMachineTimeConstantReactance.class),
                		ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class));
    }

    public SubscriptionQueryResult<SynchronousMachineTimeConstantReactance, SynchronousMachineTimeConstantReactance> synchronousMachineTimeConstantReactanceSubscribe(@DestinationVariable UUID synchronousMachineTimeConstantReactanceId) {
        return queryGateway
                .subscriptionQuery(new FindSynchronousMachineTimeConstantReactanceQuery(new LoadSynchronousMachineTimeConstantReactanceFilter(synchronousMachineTimeConstantReactanceId)), 
                		ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class),
                		ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

