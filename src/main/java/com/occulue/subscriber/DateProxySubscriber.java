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
 * Subscriber for DateProxy related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dateProxy-subscriber")
public class DateProxySubscriber extends BaseSubscriber {

	public DateProxySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DateProxy>, DateProxy> dateProxySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDateProxyQuery(), 
                		ResponseTypes.multipleInstancesOf(DateProxy.class),
                		ResponseTypes.instanceOf(DateProxy.class));
    }

    public SubscriptionQueryResult<DateProxy, DateProxy> dateProxySubscribe(@DestinationVariable UUID dateProxyId) {
        return queryGateway
                .subscriptionQuery(new FindDateProxyQuery(new LoadDateProxyFilter(dateProxyId)), 
                		ResponseTypes.instanceOf(DateProxy.class),
                		ResponseTypes.instanceOf(DateProxy.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

