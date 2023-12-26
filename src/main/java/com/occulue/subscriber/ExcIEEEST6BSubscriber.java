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
 * Subscriber for ExcIEEEST6B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST6B-subscriber")
public class ExcIEEEST6BSubscriber extends BaseSubscriber {

	public ExcIEEEST6BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEST6B>, ExcIEEEST6B> excIEEEST6BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEST6BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEST6B.class),
                		ResponseTypes.instanceOf(ExcIEEEST6B.class));
    }

    public SubscriptionQueryResult<ExcIEEEST6B, ExcIEEEST6B> excIEEEST6BSubscribe(@DestinationVariable UUID excIEEEST6BId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEST6BQuery(new LoadExcIEEEST6BFilter(excIEEEST6BId)), 
                		ResponseTypes.instanceOf(ExcIEEEST6B.class),
                		ResponseTypes.instanceOf(ExcIEEEST6B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

