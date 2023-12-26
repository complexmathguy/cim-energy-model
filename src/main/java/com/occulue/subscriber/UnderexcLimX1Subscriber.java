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
 * Subscriber for UnderexcLimX1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimX1-subscriber")
public class UnderexcLimX1Subscriber extends BaseSubscriber {

	public UnderexcLimX1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<UnderexcLimX1>, UnderexcLimX1> underexcLimX1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllUnderexcLimX1Query(), 
                		ResponseTypes.multipleInstancesOf(UnderexcLimX1.class),
                		ResponseTypes.instanceOf(UnderexcLimX1.class));
    }

    public SubscriptionQueryResult<UnderexcLimX1, UnderexcLimX1> underexcLimX1Subscribe(@DestinationVariable UUID underexcLimX1Id) {
        return queryGateway
                .subscriptionQuery(new FindUnderexcLimX1Query(new LoadUnderexcLimX1Filter(underexcLimX1Id)), 
                		ResponseTypes.instanceOf(UnderexcLimX1.class),
                		ResponseTypes.instanceOf(UnderexcLimX1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

