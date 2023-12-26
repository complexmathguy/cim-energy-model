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
 * Subscriber for SynchronousMachineDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineDynamics-subscriber")
public class SynchronousMachineDynamicsSubscriber extends BaseSubscriber {

	public SynchronousMachineDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SynchronousMachineDynamics>, SynchronousMachineDynamics> synchronousMachineDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSynchronousMachineDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(SynchronousMachineDynamics.class),
                		ResponseTypes.instanceOf(SynchronousMachineDynamics.class));
    }

    public SubscriptionQueryResult<SynchronousMachineDynamics, SynchronousMachineDynamics> synchronousMachineDynamicsSubscribe(@DestinationVariable UUID synchronousMachineDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindSynchronousMachineDynamicsQuery(new LoadSynchronousMachineDynamicsFilter(synchronousMachineDynamicsId)), 
                		ResponseTypes.instanceOf(SynchronousMachineDynamics.class),
                		ResponseTypes.instanceOf(SynchronousMachineDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

