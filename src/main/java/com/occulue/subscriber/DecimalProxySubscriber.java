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
 * Subscriber for DecimalProxy related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("decimalProxy-subscriber")
public class DecimalProxySubscriber extends BaseSubscriber {

	public DecimalProxySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DecimalProxy>, DecimalProxy> decimalProxySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDecimalProxyQuery(), 
                		ResponseTypes.multipleInstancesOf(DecimalProxy.class),
                		ResponseTypes.instanceOf(DecimalProxy.class));
    }

    public SubscriptionQueryResult<DecimalProxy, DecimalProxy> decimalProxySubscribe(@DestinationVariable UUID decimalProxyId) {
        return queryGateway
                .subscriptionQuery(new FindDecimalProxyQuery(new LoadDecimalProxyFilter(decimalProxyId)), 
                		ResponseTypes.instanceOf(DecimalProxy.class),
                		ResponseTypes.instanceOf(DecimalProxy.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

