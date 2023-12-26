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
 * Subscriber for ExcIEEEST7B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST7B-subscriber")
public class ExcIEEEST7BSubscriber extends BaseSubscriber {

	public ExcIEEEST7BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEST7B>, ExcIEEEST7B> excIEEEST7BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEST7BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEST7B.class),
                		ResponseTypes.instanceOf(ExcIEEEST7B.class));
    }

    public SubscriptionQueryResult<ExcIEEEST7B, ExcIEEEST7B> excIEEEST7BSubscribe(@DestinationVariable UUID excIEEEST7BId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEST7BQuery(new LoadExcIEEEST7BFilter(excIEEEST7BId)), 
                		ResponseTypes.instanceOf(ExcIEEEST7B.class),
                		ResponseTypes.instanceOf(ExcIEEEST7B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

