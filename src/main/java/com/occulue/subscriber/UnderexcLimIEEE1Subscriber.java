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
 * Subscriber for UnderexcLimIEEE1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimIEEE1-subscriber")
public class UnderexcLimIEEE1Subscriber extends BaseSubscriber {

	public UnderexcLimIEEE1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<UnderexcLimIEEE1>, UnderexcLimIEEE1> underexcLimIEEE1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllUnderexcLimIEEE1Query(), 
                		ResponseTypes.multipleInstancesOf(UnderexcLimIEEE1.class),
                		ResponseTypes.instanceOf(UnderexcLimIEEE1.class));
    }

    public SubscriptionQueryResult<UnderexcLimIEEE1, UnderexcLimIEEE1> underexcLimIEEE1Subscribe(@DestinationVariable UUID underexcLimIEEE1Id) {
        return queryGateway
                .subscriptionQuery(new FindUnderexcLimIEEE1Query(new LoadUnderexcLimIEEE1Filter(underexcLimIEEE1Id)), 
                		ResponseTypes.instanceOf(UnderexcLimIEEE1.class),
                		ResponseTypes.instanceOf(UnderexcLimIEEE1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

