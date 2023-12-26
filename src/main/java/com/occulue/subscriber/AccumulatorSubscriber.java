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
 * Subscriber for Accumulator related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("accumulator-subscriber")
public class AccumulatorSubscriber extends BaseSubscriber {

	public AccumulatorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Accumulator>, Accumulator> accumulatorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAccumulatorQuery(), 
                		ResponseTypes.multipleInstancesOf(Accumulator.class),
                		ResponseTypes.instanceOf(Accumulator.class));
    }

    public SubscriptionQueryResult<Accumulator, Accumulator> accumulatorSubscribe(@DestinationVariable UUID accumulatorId) {
        return queryGateway
                .subscriptionQuery(new FindAccumulatorQuery(new LoadAccumulatorFilter(accumulatorId)), 
                		ResponseTypes.instanceOf(Accumulator.class),
                		ResponseTypes.instanceOf(Accumulator.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

