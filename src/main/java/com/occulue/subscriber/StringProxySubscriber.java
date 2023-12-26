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
 * Subscriber for StringProxy related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("stringProxy-subscriber")
public class StringProxySubscriber extends BaseSubscriber {

	public StringProxySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<StringProxy>, StringProxy> stringProxySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllStringProxyQuery(), 
                		ResponseTypes.multipleInstancesOf(StringProxy.class),
                		ResponseTypes.instanceOf(StringProxy.class));
    }

    public SubscriptionQueryResult<StringProxy, StringProxy> stringProxySubscribe(@DestinationVariable UUID stringProxyId) {
        return queryGateway
                .subscriptionQuery(new FindStringProxyQuery(new LoadStringProxyFilter(stringProxyId)), 
                		ResponseTypes.instanceOf(StringProxy.class),
                		ResponseTypes.instanceOf(StringProxy.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

