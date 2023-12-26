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
 * Subscriber for AsynchronousMachineUserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineUserDefined-subscriber")
public class AsynchronousMachineUserDefinedSubscriber extends BaseSubscriber {

	public AsynchronousMachineUserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AsynchronousMachineUserDefined>, AsynchronousMachineUserDefined> asynchronousMachineUserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAsynchronousMachineUserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(AsynchronousMachineUserDefined.class),
                		ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class));
    }

    public SubscriptionQueryResult<AsynchronousMachineUserDefined, AsynchronousMachineUserDefined> asynchronousMachineUserDefinedSubscribe(@DestinationVariable UUID asynchronousMachineUserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindAsynchronousMachineUserDefinedQuery(new LoadAsynchronousMachineUserDefinedFilter(asynchronousMachineUserDefinedId)), 
                		ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class),
                		ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

