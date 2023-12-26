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
 * Subscriber for UnderexcitationLimiterDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("underexcitationLimiterDynamics-subscriber")
public class UnderexcitationLimiterDynamicsSubscriber extends BaseSubscriber {

	public UnderexcitationLimiterDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<UnderexcitationLimiterDynamics>, UnderexcitationLimiterDynamics> underexcitationLimiterDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllUnderexcitationLimiterDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(UnderexcitationLimiterDynamics.class),
                		ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class));
    }

    public SubscriptionQueryResult<UnderexcitationLimiterDynamics, UnderexcitationLimiterDynamics> underexcitationLimiterDynamicsSubscribe(@DestinationVariable UUID underexcitationLimiterDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindUnderexcitationLimiterDynamicsQuery(new LoadUnderexcitationLimiterDynamicsFilter(underexcitationLimiterDynamicsId)), 
                		ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class),
                		ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

