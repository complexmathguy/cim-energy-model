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
 * Subscriber for AnalogValue related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("analogValue-subscriber")
public class AnalogValueSubscriber extends BaseSubscriber {

	public AnalogValueSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AnalogValue>, AnalogValue> analogValueSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAnalogValueQuery(), 
                		ResponseTypes.multipleInstancesOf(AnalogValue.class),
                		ResponseTypes.instanceOf(AnalogValue.class));
    }

    public SubscriptionQueryResult<AnalogValue, AnalogValue> analogValueSubscribe(@DestinationVariable UUID analogValueId) {
        return queryGateway
                .subscriptionQuery(new FindAnalogValueQuery(new LoadAnalogValueFilter(analogValueId)), 
                		ResponseTypes.instanceOf(AnalogValue.class),
                		ResponseTypes.instanceOf(AnalogValue.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

