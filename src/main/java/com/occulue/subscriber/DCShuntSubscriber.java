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
 * Subscriber for DCShunt related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCShunt-subscriber")
public class DCShuntSubscriber extends BaseSubscriber {

	public DCShuntSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCShunt>, DCShunt> dCShuntSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCShuntQuery(), 
                		ResponseTypes.multipleInstancesOf(DCShunt.class),
                		ResponseTypes.instanceOf(DCShunt.class));
    }

    public SubscriptionQueryResult<DCShunt, DCShunt> dCShuntSubscribe(@DestinationVariable UUID dCShuntId) {
        return queryGateway
                .subscriptionQuery(new FindDCShuntQuery(new LoadDCShuntFilter(dCShuntId)), 
                		ResponseTypes.instanceOf(DCShunt.class),
                		ResponseTypes.instanceOf(DCShunt.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

