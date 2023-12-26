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
 * Subscriber for OverexcitationLimiterUserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("overexcitationLimiterUserDefined-subscriber")
public class OverexcitationLimiterUserDefinedSubscriber extends BaseSubscriber {

	public OverexcitationLimiterUserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<OverexcitationLimiterUserDefined>, OverexcitationLimiterUserDefined> overexcitationLimiterUserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllOverexcitationLimiterUserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(OverexcitationLimiterUserDefined.class),
                		ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class));
    }

    public SubscriptionQueryResult<OverexcitationLimiterUserDefined, OverexcitationLimiterUserDefined> overexcitationLimiterUserDefinedSubscribe(@DestinationVariable UUID overexcitationLimiterUserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindOverexcitationLimiterUserDefinedQuery(new LoadOverexcitationLimiterUserDefinedFilter(overexcitationLimiterUserDefinedId)), 
                		ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class),
                		ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

