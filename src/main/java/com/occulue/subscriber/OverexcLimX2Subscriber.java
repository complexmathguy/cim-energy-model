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
 * Subscriber for OverexcLimX2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("overexcLimX2-subscriber")
public class OverexcLimX2Subscriber extends BaseSubscriber {

	public OverexcLimX2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<OverexcLimX2>, OverexcLimX2> overexcLimX2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllOverexcLimX2Query(), 
                		ResponseTypes.multipleInstancesOf(OverexcLimX2.class),
                		ResponseTypes.instanceOf(OverexcLimX2.class));
    }

    public SubscriptionQueryResult<OverexcLimX2, OverexcLimX2> overexcLimX2Subscribe(@DestinationVariable UUID overexcLimX2Id) {
        return queryGateway
                .subscriptionQuery(new FindOverexcLimX2Query(new LoadOverexcLimX2Filter(overexcLimX2Id)), 
                		ResponseTypes.instanceOf(OverexcLimX2.class),
                		ResponseTypes.instanceOf(OverexcLimX2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

