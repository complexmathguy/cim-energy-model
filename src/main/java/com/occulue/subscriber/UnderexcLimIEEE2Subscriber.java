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
 * Subscriber for UnderexcLimIEEE2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimIEEE2-subscriber")
public class UnderexcLimIEEE2Subscriber extends BaseSubscriber {

	public UnderexcLimIEEE2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<UnderexcLimIEEE2>, UnderexcLimIEEE2> underexcLimIEEE2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllUnderexcLimIEEE2Query(), 
                		ResponseTypes.multipleInstancesOf(UnderexcLimIEEE2.class),
                		ResponseTypes.instanceOf(UnderexcLimIEEE2.class));
    }

    public SubscriptionQueryResult<UnderexcLimIEEE2, UnderexcLimIEEE2> underexcLimIEEE2Subscribe(@DestinationVariable UUID underexcLimIEEE2Id) {
        return queryGateway
                .subscriptionQuery(new FindUnderexcLimIEEE2Query(new LoadUnderexcLimIEEE2Filter(underexcLimIEEE2Id)), 
                		ResponseTypes.instanceOf(UnderexcLimIEEE2.class),
                		ResponseTypes.instanceOf(UnderexcLimIEEE2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

