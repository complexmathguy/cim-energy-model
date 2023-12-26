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
 * Subscriber for SynchronousMachine related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachine-subscriber")
public class SynchronousMachineSubscriber extends BaseSubscriber {

	public SynchronousMachineSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SynchronousMachine>, SynchronousMachine> synchronousMachineSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSynchronousMachineQuery(), 
                		ResponseTypes.multipleInstancesOf(SynchronousMachine.class),
                		ResponseTypes.instanceOf(SynchronousMachine.class));
    }

    public SubscriptionQueryResult<SynchronousMachine, SynchronousMachine> synchronousMachineSubscribe(@DestinationVariable UUID synchronousMachineId) {
        return queryGateway
                .subscriptionQuery(new FindSynchronousMachineQuery(new LoadSynchronousMachineFilter(synchronousMachineId)), 
                		ResponseTypes.instanceOf(SynchronousMachine.class),
                		ResponseTypes.instanceOf(SynchronousMachine.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

