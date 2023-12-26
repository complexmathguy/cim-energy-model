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
 * Subscriber for RemoteInputSignal related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("remoteInputSignal-subscriber")
public class RemoteInputSignalSubscriber extends BaseSubscriber {

	public RemoteInputSignalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<RemoteInputSignal>, RemoteInputSignal> remoteInputSignalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllRemoteInputSignalQuery(), 
                		ResponseTypes.multipleInstancesOf(RemoteInputSignal.class),
                		ResponseTypes.instanceOf(RemoteInputSignal.class));
    }

    public SubscriptionQueryResult<RemoteInputSignal, RemoteInputSignal> remoteInputSignalSubscribe(@DestinationVariable UUID remoteInputSignalId) {
        return queryGateway
                .subscriptionQuery(new FindRemoteInputSignalQuery(new LoadRemoteInputSignalFilter(remoteInputSignalId)), 
                		ResponseTypes.instanceOf(RemoteInputSignal.class),
                		ResponseTypes.instanceOf(RemoteInputSignal.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

