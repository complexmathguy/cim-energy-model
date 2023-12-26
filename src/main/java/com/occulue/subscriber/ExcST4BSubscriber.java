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
 * Subscriber for ExcST4B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excST4B-subscriber")
public class ExcST4BSubscriber extends BaseSubscriber {

	public ExcST4BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcST4B>, ExcST4B> excST4BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcST4BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcST4B.class),
                		ResponseTypes.instanceOf(ExcST4B.class));
    }

    public SubscriptionQueryResult<ExcST4B, ExcST4B> excST4BSubscribe(@DestinationVariable UUID excST4BId) {
        return queryGateway
                .subscriptionQuery(new FindExcST4BQuery(new LoadExcST4BFilter(excST4BId)), 
                		ResponseTypes.instanceOf(ExcST4B.class),
                		ResponseTypes.instanceOf(ExcST4B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

