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
 * Subscriber for ExcIEEEAC7B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC7B-subscriber")
public class ExcIEEEAC7BSubscriber extends BaseSubscriber {

	public ExcIEEEAC7BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEAC7B>, ExcIEEEAC7B> excIEEEAC7BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEAC7BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEAC7B.class),
                		ResponseTypes.instanceOf(ExcIEEEAC7B.class));
    }

    public SubscriptionQueryResult<ExcIEEEAC7B, ExcIEEEAC7B> excIEEEAC7BSubscribe(@DestinationVariable UUID excIEEEAC7BId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEAC7BQuery(new LoadExcIEEEAC7BFilter(excIEEEAC7BId)), 
                		ResponseTypes.instanceOf(ExcIEEEAC7B.class),
                		ResponseTypes.instanceOf(ExcIEEEAC7B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

