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
 * Subscriber for AccumulatorLimitSet related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("accumulatorLimitSet-subscriber")
public class AccumulatorLimitSetSubscriber extends BaseSubscriber {

	public AccumulatorLimitSetSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AccumulatorLimitSet>, AccumulatorLimitSet> accumulatorLimitSetSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAccumulatorLimitSetQuery(), 
                		ResponseTypes.multipleInstancesOf(AccumulatorLimitSet.class),
                		ResponseTypes.instanceOf(AccumulatorLimitSet.class));
    }

    public SubscriptionQueryResult<AccumulatorLimitSet, AccumulatorLimitSet> accumulatorLimitSetSubscribe(@DestinationVariable UUID accumulatorLimitSetId) {
        return queryGateway
                .subscriptionQuery(new FindAccumulatorLimitSetQuery(new LoadAccumulatorLimitSetFilter(accumulatorLimitSetId)), 
                		ResponseTypes.instanceOf(AccumulatorLimitSet.class),
                		ResponseTypes.instanceOf(AccumulatorLimitSet.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

