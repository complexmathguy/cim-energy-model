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
 * Subscriber for UnderexcLimX2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimX2-subscriber")
public class UnderexcLimX2Subscriber extends BaseSubscriber {

	public UnderexcLimX2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<UnderexcLimX2>, UnderexcLimX2> underexcLimX2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllUnderexcLimX2Query(), 
                		ResponseTypes.multipleInstancesOf(UnderexcLimX2.class),
                		ResponseTypes.instanceOf(UnderexcLimX2.class));
    }

    public SubscriptionQueryResult<UnderexcLimX2, UnderexcLimX2> underexcLimX2Subscribe(@DestinationVariable UUID underexcLimX2Id) {
        return queryGateway
                .subscriptionQuery(new FindUnderexcLimX2Query(new LoadUnderexcLimX2Filter(underexcLimX2Id)), 
                		ResponseTypes.instanceOf(UnderexcLimX2.class),
                		ResponseTypes.instanceOf(UnderexcLimX2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

