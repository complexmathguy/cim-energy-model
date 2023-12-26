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
 * Subscriber for ExcAC8B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAC8B-subscriber")
public class ExcAC8BSubscriber extends BaseSubscriber {

	public ExcAC8BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAC8B>, ExcAC8B> excAC8BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAC8BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcAC8B.class),
                		ResponseTypes.instanceOf(ExcAC8B.class));
    }

    public SubscriptionQueryResult<ExcAC8B, ExcAC8B> excAC8BSubscribe(@DestinationVariable UUID excAC8BId) {
        return queryGateway
                .subscriptionQuery(new FindExcAC8BQuery(new LoadExcAC8BFilter(excAC8BId)), 
                		ResponseTypes.instanceOf(ExcAC8B.class),
                		ResponseTypes.instanceOf(ExcAC8B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

