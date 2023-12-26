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
 * Subscriber for AnalogControl related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("analogControl-subscriber")
public class AnalogControlSubscriber extends BaseSubscriber {

	public AnalogControlSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AnalogControl>, AnalogControl> analogControlSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAnalogControlQuery(), 
                		ResponseTypes.multipleInstancesOf(AnalogControl.class),
                		ResponseTypes.instanceOf(AnalogControl.class));
    }

    public SubscriptionQueryResult<AnalogControl, AnalogControl> analogControlSubscribe(@DestinationVariable UUID analogControlId) {
        return queryGateway
                .subscriptionQuery(new FindAnalogControlQuery(new LoadAnalogControlFilter(analogControlId)), 
                		ResponseTypes.instanceOf(AnalogControl.class),
                		ResponseTypes.instanceOf(AnalogControl.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

