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
 * Subscriber for AnalogLimitSet related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("analogLimitSet-subscriber")
public class AnalogLimitSetSubscriber extends BaseSubscriber {

	public AnalogLimitSetSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AnalogLimitSet>, AnalogLimitSet> analogLimitSetSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAnalogLimitSetQuery(), 
                		ResponseTypes.multipleInstancesOf(AnalogLimitSet.class),
                		ResponseTypes.instanceOf(AnalogLimitSet.class));
    }

    public SubscriptionQueryResult<AnalogLimitSet, AnalogLimitSet> analogLimitSetSubscribe(@DestinationVariable UUID analogLimitSetId) {
        return queryGateway
                .subscriptionQuery(new FindAnalogLimitSetQuery(new LoadAnalogLimitSetFilter(analogLimitSetId)), 
                		ResponseTypes.instanceOf(AnalogLimitSet.class),
                		ResponseTypes.instanceOf(AnalogLimitSet.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

