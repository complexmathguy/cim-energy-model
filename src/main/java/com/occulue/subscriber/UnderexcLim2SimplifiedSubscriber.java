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
 * Subscriber for UnderexcLim2Simplified related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("underexcLim2Simplified-subscriber")
public class UnderexcLim2SimplifiedSubscriber extends BaseSubscriber {

	public UnderexcLim2SimplifiedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<UnderexcLim2Simplified>, UnderexcLim2Simplified> underexcLim2SimplifiedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllUnderexcLim2SimplifiedQuery(), 
                		ResponseTypes.multipleInstancesOf(UnderexcLim2Simplified.class),
                		ResponseTypes.instanceOf(UnderexcLim2Simplified.class));
    }

    public SubscriptionQueryResult<UnderexcLim2Simplified, UnderexcLim2Simplified> underexcLim2SimplifiedSubscribe(@DestinationVariable UUID underexcLim2SimplifiedId) {
        return queryGateway
                .subscriptionQuery(new FindUnderexcLim2SimplifiedQuery(new LoadUnderexcLim2SimplifiedFilter(underexcLim2SimplifiedId)), 
                		ResponseTypes.instanceOf(UnderexcLim2Simplified.class),
                		ResponseTypes.instanceOf(UnderexcLim2Simplified.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

