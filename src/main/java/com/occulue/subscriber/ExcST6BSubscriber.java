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
 * Subscriber for ExcST6B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excST6B-subscriber")
public class ExcST6BSubscriber extends BaseSubscriber {

	public ExcST6BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcST6B>, ExcST6B> excST6BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcST6BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcST6B.class),
                		ResponseTypes.instanceOf(ExcST6B.class));
    }

    public SubscriptionQueryResult<ExcST6B, ExcST6B> excST6BSubscribe(@DestinationVariable UUID excST6BId) {
        return queryGateway
                .subscriptionQuery(new FindExcST6BQuery(new LoadExcST6BFilter(excST6BId)), 
                		ResponseTypes.instanceOf(ExcST6B.class),
                		ResponseTypes.instanceOf(ExcST6B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

