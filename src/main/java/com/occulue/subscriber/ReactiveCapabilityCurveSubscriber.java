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
 * Subscriber for ReactiveCapabilityCurve related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("reactiveCapabilityCurve-subscriber")
public class ReactiveCapabilityCurveSubscriber extends BaseSubscriber {

	public ReactiveCapabilityCurveSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ReactiveCapabilityCurve>, ReactiveCapabilityCurve> reactiveCapabilityCurveSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllReactiveCapabilityCurveQuery(), 
                		ResponseTypes.multipleInstancesOf(ReactiveCapabilityCurve.class),
                		ResponseTypes.instanceOf(ReactiveCapabilityCurve.class));
    }

    public SubscriptionQueryResult<ReactiveCapabilityCurve, ReactiveCapabilityCurve> reactiveCapabilityCurveSubscribe(@DestinationVariable UUID reactiveCapabilityCurveId) {
        return queryGateway
                .subscriptionQuery(new FindReactiveCapabilityCurveQuery(new LoadReactiveCapabilityCurveFilter(reactiveCapabilityCurveId)), 
                		ResponseTypes.instanceOf(ReactiveCapabilityCurve.class),
                		ResponseTypes.instanceOf(ReactiveCapabilityCurve.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

