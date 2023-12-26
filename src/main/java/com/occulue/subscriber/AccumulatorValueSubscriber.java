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
 * Subscriber for AccumulatorValue related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("accumulatorValue-subscriber")
public class AccumulatorValueSubscriber extends BaseSubscriber {

	public AccumulatorValueSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AccumulatorValue>, AccumulatorValue> accumulatorValueSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAccumulatorValueQuery(), 
                		ResponseTypes.multipleInstancesOf(AccumulatorValue.class),
                		ResponseTypes.instanceOf(AccumulatorValue.class));
    }

    public SubscriptionQueryResult<AccumulatorValue, AccumulatorValue> accumulatorValueSubscribe(@DestinationVariable UUID accumulatorValueId) {
        return queryGateway
                .subscriptionQuery(new FindAccumulatorValueQuery(new LoadAccumulatorValueFilter(accumulatorValueId)), 
                		ResponseTypes.instanceOf(AccumulatorValue.class),
                		ResponseTypes.instanceOf(AccumulatorValue.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

