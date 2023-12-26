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
 * Subscriber for AsynchronousMachine related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachine-subscriber")
public class AsynchronousMachineSubscriber extends BaseSubscriber {

	public AsynchronousMachineSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AsynchronousMachine>, AsynchronousMachine> asynchronousMachineSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAsynchronousMachineQuery(), 
                		ResponseTypes.multipleInstancesOf(AsynchronousMachine.class),
                		ResponseTypes.instanceOf(AsynchronousMachine.class));
    }

    public SubscriptionQueryResult<AsynchronousMachine, AsynchronousMachine> asynchronousMachineSubscribe(@DestinationVariable UUID asynchronousMachineId) {
        return queryGateway
                .subscriptionQuery(new FindAsynchronousMachineQuery(new LoadAsynchronousMachineFilter(asynchronousMachineId)), 
                		ResponseTypes.instanceOf(AsynchronousMachine.class),
                		ResponseTypes.instanceOf(AsynchronousMachine.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

