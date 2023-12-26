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
 * Subscriber for AnalogLimit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("analogLimit-subscriber")
public class AnalogLimitSubscriber extends BaseSubscriber {

	public AnalogLimitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AnalogLimit>, AnalogLimit> analogLimitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAnalogLimitQuery(), 
                		ResponseTypes.multipleInstancesOf(AnalogLimit.class),
                		ResponseTypes.instanceOf(AnalogLimit.class));
    }

    public SubscriptionQueryResult<AnalogLimit, AnalogLimit> analogLimitSubscribe(@DestinationVariable UUID analogLimitId) {
        return queryGateway
                .subscriptionQuery(new FindAnalogLimitQuery(new LoadAnalogLimitFilter(analogLimitId)), 
                		ResponseTypes.instanceOf(AnalogLimit.class),
                		ResponseTypes.instanceOf(AnalogLimit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

