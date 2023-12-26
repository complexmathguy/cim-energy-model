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
 * Subscriber for OverexcitationLimiterDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("overexcitationLimiterDynamics-subscriber")
public class OverexcitationLimiterDynamicsSubscriber extends BaseSubscriber {

	public OverexcitationLimiterDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<OverexcitationLimiterDynamics>, OverexcitationLimiterDynamics> overexcitationLimiterDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllOverexcitationLimiterDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(OverexcitationLimiterDynamics.class),
                		ResponseTypes.instanceOf(OverexcitationLimiterDynamics.class));
    }

    public SubscriptionQueryResult<OverexcitationLimiterDynamics, OverexcitationLimiterDynamics> overexcitationLimiterDynamicsSubscribe(@DestinationVariable UUID overexcitationLimiterDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindOverexcitationLimiterDynamicsQuery(new LoadOverexcitationLimiterDynamicsFilter(overexcitationLimiterDynamicsId)), 
                		ResponseTypes.instanceOf(OverexcitationLimiterDynamics.class),
                		ResponseTypes.instanceOf(OverexcitationLimiterDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

