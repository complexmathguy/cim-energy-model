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
 * Subscriber for Discrete related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("discrete-subscriber")
public class DiscreteSubscriber extends BaseSubscriber {

	public DiscreteSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Discrete>, Discrete> discreteSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiscreteQuery(), 
                		ResponseTypes.multipleInstancesOf(Discrete.class),
                		ResponseTypes.instanceOf(Discrete.class));
    }

    public SubscriptionQueryResult<Discrete, Discrete> discreteSubscribe(@DestinationVariable UUID discreteId) {
        return queryGateway
                .subscriptionQuery(new FindDiscreteQuery(new LoadDiscreteFilter(discreteId)), 
                		ResponseTypes.instanceOf(Discrete.class),
                		ResponseTypes.instanceOf(Discrete.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

