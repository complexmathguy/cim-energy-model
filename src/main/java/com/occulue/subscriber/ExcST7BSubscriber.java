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
 * Subscriber for ExcST7B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excST7B-subscriber")
public class ExcST7BSubscriber extends BaseSubscriber {

	public ExcST7BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcST7B>, ExcST7B> excST7BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcST7BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcST7B.class),
                		ResponseTypes.instanceOf(ExcST7B.class));
    }

    public SubscriptionQueryResult<ExcST7B, ExcST7B> excST7BSubscribe(@DestinationVariable UUID excST7BId) {
        return queryGateway
                .subscriptionQuery(new FindExcST7BQuery(new LoadExcST7BFilter(excST7BId)), 
                		ResponseTypes.instanceOf(ExcST7B.class),
                		ResponseTypes.instanceOf(ExcST7B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

